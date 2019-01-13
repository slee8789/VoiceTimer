package com.leesc.voicetimer.ui.splash;


import android.util.Log;

import com.leesc.voicetimer.data.DataManager;
import com.leesc.voicetimer.ui.base.BaseViewModel;
import com.leesc.voicetimer.utils.rx.SchedulerProvider;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class SplashViewModel extends BaseViewModel<SplashNavigator> {

    public SplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        Log.d("lsc", "SplashViewModel constructor");
        getCompositeDisposable()
                .add(Observable.timer(1, TimeUnit.SECONDS)
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(time -> getNavigator().startMainActivity()));


    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("lsc", "SplashViewModel onCleared");
    }
}
