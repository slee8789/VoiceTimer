package com.leesc.voicetimer.ui.main.stopwatch;

import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.annimon.stream.Optional;
import com.leesc.voicetimer.data.DataManager;
import com.leesc.voicetimer.ui.base.BaseViewModel;
import com.leesc.voicetimer.utils.rx.SchedulerProvider;

import javax.inject.Inject;

public class StopwatchViewModel extends BaseViewModel<StopwatchNavigator> {



    public StopwatchViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onTestClick() {
        Log.d("lsc","onTestClick v ");
    }

    public void onPlayClick() {
        Log.d("lsc","onPlayClick v ");

    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
