package com.leesc.voicetimer.di;

import com.leesc.voicetimer.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity bindIntroActivity();



}
