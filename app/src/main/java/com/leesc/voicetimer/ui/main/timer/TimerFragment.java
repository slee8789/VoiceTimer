package com.leesc.voicetimer.ui.main.timer;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.leesc.voicetimer.BR;
import com.leesc.voicetimer.R;
import com.leesc.voicetimer.databinding.FragmentTimerBinding;
import com.leesc.voicetimer.ui.base.BaseFragment;
import com.leesc.voicetimer.ui.main.stopwatch.StopwatchViewModel;

import javax.inject.Inject;

public class TimerFragment extends BaseFragment<FragmentTimerBinding,TimerViewModel> implements TimerNavigator {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    TimerViewModel timerViewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_timer;
    }

    @Override
    public TimerViewModel getViewModel() {
        timerViewModel = ViewModelProviders.of(this, viewModelFactory).get(TimerViewModel.class);
        return timerViewModel;
    }

    public static TimerFragment newInstance() {
        Bundle args = new Bundle();
        TimerFragment fragment = new TimerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void handleError(Throwable throwable) {

    }
}
