package com.leesc.voicetimer.di.module;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.leesc.voicetimer.R;
import com.leesc.voicetimer.core.AppConstant;
import com.leesc.voicetimer.core.VoiceTimerApplication;
import com.leesc.voicetimer.data.AppDataManager;
import com.leesc.voicetimer.data.DataManager;
import com.leesc.voicetimer.data.local.db.AppDatabase;
import com.leesc.voicetimer.data.local.db.AppDbHelper;
import com.leesc.voicetimer.data.local.db.DbHelper;
import com.leesc.voicetimer.data.local.prefs.AppPreferencesHelper;
import com.leesc.voicetimer.data.local.prefs.PreferencesHelper;
import com.leesc.voicetimer.di.ResourceProvider;
import com.leesc.voicetimer.di.quailfier.DatabaseInfo;
import com.leesc.voicetimer.di.quailfier.PreferenceInfo;
import com.leesc.voicetimer.utils.rx.AppSchedulerProvider;
import com.leesc.voicetimer.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module(includes = {ViewModelModule.class})
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(VoiceTimerApplication application) {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    static SharedPreferences provideSharedPreferences(Context context) {
        return context.getSharedPreferences(context.getString(R.string.shared_preferences), Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    static ResourceProvider provideResourceProvider(Context context) {
        return new ResourceProvider(context);
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstant.DB_NAME;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstant.PREF_NAME;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}
