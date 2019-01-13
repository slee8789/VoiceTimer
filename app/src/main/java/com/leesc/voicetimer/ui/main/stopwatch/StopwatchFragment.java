package com.leesc.voicetimer.ui.main.stopwatch;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.leesc.voicetimer.BR;
import com.leesc.voicetimer.R;
import com.leesc.voicetimer.databinding.FragmentStopwatchBinding;
import com.leesc.voicetimer.ui.base.BaseFragment;
import com.leesc.voicetimer.ui.main.alarm.AlarmViewModel;

import javax.inject.Inject;

public class StopwatchFragment extends BaseFragment<FragmentStopwatchBinding,StopwatchViewModel> implements StopwatchNavigator {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    StopwatchViewModel stopwatchViewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_stopwatch;
    }

    @Override
    public StopwatchViewModel getViewModel() {
        stopwatchViewModel = ViewModelProviders.of(this, viewModelFactory).get(StopwatchViewModel.class);
        return stopwatchViewModel;
    }

    public static StopwatchFragment newInstance() {
        Bundle args = new Bundle();
        StopwatchFragment fragment = new StopwatchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stopwatchViewModel.setNavigator(this);
    }

    @Override
    public void test(String test) {
//        getViewDataBinding().stopwatch.setTitleText(test);
    }

    @Override
    public void handleError(Throwable throwable) {

    }
}