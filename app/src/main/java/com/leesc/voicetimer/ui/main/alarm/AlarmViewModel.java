package com.leesc.voicetimer.ui.main.alarm;

import com.leesc.voicetimer.data.DataManager;
import com.leesc.voicetimer.ui.base.BaseViewModel;
import com.leesc.voicetimer.utils.rx.SchedulerProvider;

import javax.inject.Inject;

public class AlarmViewModel extends BaseViewModel<AlarmNavigator> {

    public AlarmViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
