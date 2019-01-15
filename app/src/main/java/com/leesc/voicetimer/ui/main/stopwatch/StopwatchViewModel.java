package com.leesc.voicetimer.ui.main.stopwatch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;


import com.leesc.voicetimer.R;
import com.leesc.voicetimer.data.DataManager;
import com.leesc.voicetimer.di.ResourceProvider;
import com.leesc.voicetimer.ui.base.BaseViewModel;
import com.leesc.voicetimer.utils.rx.SchedulerProvider;
import com.tedpark.tedpermission.rx2.TedRx2Permission;


import java.util.ArrayList;
import java.util.Locale;

import static android.Manifest.permission.RECORD_AUDIO;

public class StopwatchViewModel extends BaseViewModel<StopwatchNavigator> implements RecognitionListener {

    private SpeechRecognizer speech = null;
    private Intent recognizerIntent;
    private Context context;

    public StopwatchViewModel(DataManager dataManager, SchedulerProvider schedulerProvider, Context context, ResourceProvider resourceProvider) {
        super(dataManager, schedulerProvider);
        this.context = context;
        getCompositeDisposable().add(TedRx2Permission.with(context)
                .setPermissions(RECORD_AUDIO)
                .setDeniedMessage(resourceProvider.getString(R.string.stopwatch_msg_denied))
                .setGotoSettingButton(true)
                .setGotoSettingButtonText(resourceProvider.getString(R.string.stopwatch_msg_goto_setting))
                .request()
                .subscribe(permissionResult -> {
                    Log.d("lsc", "permissionResult " + permissionResult.isGranted());
                    if (permissionResult.isGranted()) {
                        resetSpeechRecognizer(context);
                        setRecogniserIntent();
                        speech.startListening(recognizerIntent);
                    }
                })
        );
    }

    public void onPlayClick() {
        Log.d("lsc", "onPlayClick v " + Locale.getDefault().getDisplayLanguage());

    }

    private void resetSpeechRecognizer(Context context) {

        if (speech != null) {
            speech.destroy();
        }
        speech = SpeechRecognizer.createSpeechRecognizer(context);
        Log.i("lsc", "isRecognitionAvailable: " + SpeechRecognizer.isRecognitionAvailable(context));
        if (SpeechRecognizer.isRecognitionAvailable(context))
            speech.setRecognitionListener(this);
        else
            Log.e("lsc", "no available");
    }

    private void setRecogniserIntent() {
        recognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.KOREAN.toString());
//        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, /*Locale.getDefault().getDisplayLanguage()*/"ko");
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3);
    }

    @Override
    public void onBeginningOfSpeech() {
        Log.i("lsc", "onBeginningOfSpeech");
    }

    @Override
    public void onBufferReceived(byte[] buffer) {
        Log.i("lsc", "onBufferReceived: " + buffer);
    }

    @Override
    public void onEndOfSpeech() {
        Log.i("lsc", "onEndOfSpeech");
        speech.stopListening();
    }

    @Override
    public void onResults(Bundle results) {
        ArrayList<String> matches = results
                .getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        String text = "";
        for (String result : matches)
            text += result + "\n";

        Log.i("lsc", "onResults " + text);
        speech.startListening(recognizerIntent);
    }

    @Override
    public void onError(int errorCode) {
        String errorMessage = getErrorText(errorCode);
        Log.i("lsc", "FAILED " + errorMessage);

        // rest voice recogniser
        resetSpeechRecognizer(context);
        speech.startListening(recognizerIntent);
    }

    @Override
    public void onEvent(int arg0, Bundle arg1) {
        Log.i("lsc", "onEvent");
    }

    @Override
    public void onPartialResults(Bundle arg0) {
        Log.i("lsc", "onPartialResults");
    }

    @Override
    public void onReadyForSpeech(Bundle arg0) {
        Log.i("lsc", "onReadyForSpeech");
    }

    @Override
    public void onRmsChanged(float rmsdB) {
//        Log.i("lsc", "onRmsChanged: " + rmsdB);
    }

    public String getErrorText(int errorCode) {
        String message;
        switch (errorCode) {
            case SpeechRecognizer.ERROR_AUDIO:
                message = "Audio recording error";
                break;
            case SpeechRecognizer.ERROR_CLIENT:
                message = "Client side error";
                break;
            case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                message = "Insufficient permissions";
                break;
            case SpeechRecognizer.ERROR_NETWORK:
                message = "Network error";
                break;
            case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                message = "Network timeout";
                break;
            case SpeechRecognizer.ERROR_NO_MATCH:
                message = "No match";
                break;
            case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                message = "RecognitionService busy";
                break;
            case SpeechRecognizer.ERROR_SERVER:
                message = "error from server";
                break;
            case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                message = "No speech input";
                break;
            default:
                message = "Didn't understand, please try again.";
                break;
        }
        return message;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
