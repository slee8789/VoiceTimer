package com.leesc.voicetimer.di;

import com.leesc.voicetimer.core.VoiceTimerApplication;
import com.leesc.voicetimer.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent extends AndroidInjector<VoiceTimerApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<VoiceTimerApplication> {
    }

}
