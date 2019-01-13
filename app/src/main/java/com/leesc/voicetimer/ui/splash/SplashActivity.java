package com.leesc.voicetimer.ui.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.leesc.voicetimer.BR;
import com.leesc.voicetimer.R;
import com.leesc.voicetimer.databinding.ActivitySplashBinding;
import com.leesc.voicetimer.ui.base.BaseActivity;
import com.leesc.voicetimer.ui.main.MainActivity;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {

    @Inject
    SplashViewModel splashViewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public SplashViewModel getViewModel() {
        return splashViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashViewModel.setNavigator(this);
        Log.d("lsc","SplashActivity onCreate");
    }

    @Override
    public void startMainActivity() {
        MainActivity.start(this);
        overridePendingTransition(R.anim.fade_out,R.anim.fade_in);
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }

    @Override
    public void handleError(Throwable throwable) {

    }
}