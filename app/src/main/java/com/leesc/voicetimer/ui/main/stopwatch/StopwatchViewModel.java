package com.leesc.voicetimer.ui.main.stopwatch;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.annimon.stream.Optional;
import com.kakao.sdk.newtoneapi.SpeechRecognizeListener;
import com.kakao.sdk.newtoneapi.SpeechRecognizerClient;
import com.kakao.sdk.newtoneapi.SpeechRecognizerManager;
import com.leesc.voicetimer.R;
import com.leesc.voicetimer.data.DataManager;
import com.leesc.voicetimer.di.ResourceProvider;
import com.leesc.voicetimer.ui.base.BaseViewModel;
import com.leesc.voicetimer.utils.rx.SchedulerProvider;
import com.tedpark.tedpermission.rx2.TedRx2Permission;

import java.util.ArrayList;

import javax.inject.Inject;

import static android.Manifest.permission.RECORD_AUDIO;

public class StopwatchViewModel extends BaseViewModel<StopwatchNavigator> implements SpeechRecognizeListener {

    private SpeechRecognizerClient client;

    public StopwatchViewModel(DataManager dataManager, SchedulerProvider schedulerProvider, Context context, ResourceProvider resourceProvider) {
        super(dataManager, schedulerProvider);

        getCompositeDisposable().add(TedRx2Permission.with(context)
                .setPermissions(RECORD_AUDIO)
                .setDeniedMessage(resourceProvider.getString(R.string.stopwatch_msg_denied))
                .setGotoSettingButton(true)
                .setGotoSettingButtonText(resourceProvider.getString(R.string.stopwatch_msg_goto_setting))
                .request()
                .subscribe(permissionResult -> {
                    Log.d("lsc", "permissionResult " + permissionResult.isGranted());
                    if (permissionResult.isGranted()) {
                        SpeechRecognizerManager.getInstance().initializeLibrary(context);
                        SpeechRecognizerClient.Builder builder = new SpeechRecognizerClient.Builder().setServiceType(SpeechRecognizerClient.SERVICE_TYPE_DICTATION);

                        client = builder.build();

                        client.setSpeechRecognizeListener(this);
                        client.startRecording(true);
                    }

                })

        );


    }

    public void onTestClick() {
        Log.d("lsc", "onTestClick v ");
    }

    public void onPlayClick() {
        Log.d("lsc", "onPlayClick v ");

    }

    @Override
    public void onReady() {
        Log.d("lsc", "onReady");
    }

    @Override
    public void onBeginningOfSpeech() {
        Log.d("lsc", "onBeginningOfSpeech");
    }

    @Override
    public void onEndOfSpeech() {
        Log.d("lsc", "onEndOfSpeech");
    }

    @Override
    public void onError(int errorCode, String errorMsg) {
        Log.d("lsc", "onError " + errorCode + ", errorMsg " + errorMsg);
    }

    @Override
    public void onPartialResult(String partialResult) {
        Log.d("lsc", "onPartialResult " + partialResult);
    }

    @Override
    public void onResults(Bundle results) {
        final StringBuilder builder = new StringBuilder();

        ArrayList<String> texts = results.getStringArrayList(SpeechRecognizerClient.KEY_RECOGNITION_RESULTS);
        ArrayList<Integer> confs = results.getIntegerArrayList(SpeechRecognizerClient.KEY_CONFIDENCE_VALUES);

        for (int i = 0; i < texts.size(); i++) {
            builder.append(texts.get(i));
            builder.append(" (");
            builder.append(confs.get(i).intValue());
            builder.append(")\n");
        }
        Log.d("lsc", "onResults " + builder.toString());
        client = null;
    }

    @Override
    public void onAudioLevel(float audioLevel) {
        Log.d("lsc", "onAudioLevel " + audioLevel);
    }

    @Override
    public void onFinished() {
        Log.d("lsc", "onFinished");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
