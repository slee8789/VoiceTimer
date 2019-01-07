package com.leesc.voicetimer.ui.main;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.leesc.voicetimer.BR;
import com.leesc.voicetimer.R;
import com.leesc.voicetimer.databinding.ActivityMainBinding;
import com.leesc.voicetimer.ui.base.BaseActivity;

import javax.inject.Inject;

import static com.leesc.voicetimer.core.AppConstant.PAGE_ALARM;
import static com.leesc.voicetimer.core.AppConstant.PAGE_STOP_WATCH;
import static com.leesc.voicetimer.core.AppConstant.PAGE_TIMER;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private MainViewModel mainViewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
        return mainViewModel;
    }

    @Override
    public void handleError(Throwable throwable) {

    }
}