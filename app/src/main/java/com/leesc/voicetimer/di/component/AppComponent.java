package com.leesc.voicetimer.di.component;

import com.leesc.voicetimer.core.VoiceTimerApplication;
import com.leesc.voicetimer.di.builder.ActivityBuilder;
import com.leesc.voicetimer.di.module.AppModule;
import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent extends AndroidInjector<VoiceTimerApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<VoiceTimerApplication> {
    }

//    @Component.Builder
//    interface Builder {
//
//        @BindsInstance
//        Builder application(Application application);
//
//        AppComponent build();
//    }
}
