package com.leesc.voicetimer.ui.main.stopwatch;

import android.content.Context;
import android.util.Log;


import com.leesc.voicetimer.R;
import com.leesc.voicetimer.data.DataManager;
import com.leesc.voicetimer.di.ResourceProvider;
import com.leesc.voicetimer.ui.base.BaseViewModel;
import com.leesc.voicetimer.utils.rx.SchedulerProvider;
import com.tedpark.tedpermission.rx2.TedRx2Permission;


import static android.Manifest.permission.RECORD_AUDIO;

public class StopwatchViewModel extends BaseViewModel<StopwatchNavigator> {

    public StopwatchViewModel(DataManager dataManager, SchedulerProvider schedulerProvider, Context context, ResourceProvider resourceProvider) {
        super(dataManager, schedulerProvider);

        getCompositeDisposable().add(TedRx2Permission.with(context)
                .setPermissions(RECORD_AUDIO)
                .setDeniedMessage(resourceProvider.getString(R.string.stopwatch_msg_denied))
                .setGotoSettingButton(true)
                .setGotoSettingButtonText(resourceProvider.getString(R.string.stopwatch_msg_goto_setting))
                .request()
                .subscribe(permissionResult -> {
                    Log.d("lsc", "permissionResult " + permissionResult.isGranted());
                    if (permissionResult.isGranted()) {

                    }

                })

        );


    }

    public void onTestClick() {
        Log.d("lsc", "onTestClick v ");
    }

    public void onPlayClick() {
        Log.d("lsc", "onPlayClick v ");

    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
