package com.leesc.voicetimer.di.builder;

import com.leesc.voicetimer.ui.main.MainActivity;
import com.leesc.voicetimer.ui.main.MainActivityModule;
import com.leesc.voicetimer.ui.main.alarm.AlarmFragmentProvider;
import com.leesc.voicetimer.ui.main.stopwatch.StopwatchFragmentProvider;
import com.leesc.voicetimer.ui.main.timer.TimerFragmentProvider;
import com.leesc.voicetimer.ui.splash.SplashActivity;
import com.leesc.voicetimer.ui.splash.SplashActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {
            MainActivityModule.class,
            AlarmFragmentProvider.class,
            StopwatchFragmentProvider.class,
            TimerFragmentProvider.class
    })
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity bindSplashActivity();

}
