package com.leesc.voicetimer.ui.main;

import android.arch.lifecycle.ViewModel;

import com.leesc.voicetimer.data.DataManager;
import com.leesc.voicetimer.ui.base.BaseViewModel;
import com.leesc.voicetimer.utils.rx.SchedulerProvider;

import javax.inject.Inject;

public class MainViewModel extends BaseViewModel<MainNavigator> {

    @Inject
    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
