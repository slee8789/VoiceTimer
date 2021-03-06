package com.leesc.voicetimer.ui.main;

import com.leesc.voicetimer.data.DataManager;
import com.leesc.voicetimer.ui.base.BaseViewModel;
import com.leesc.voicetimer.utils.rx.SchedulerProvider;

public class MainViewModel extends BaseViewModel<MainNavigator> {

    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
