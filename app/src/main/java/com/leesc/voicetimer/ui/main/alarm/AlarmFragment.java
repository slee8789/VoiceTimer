package com.leesc.voicetimer.ui.main.alarm;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.leesc.voicetimer.BR;
import com.leesc.voicetimer.R;
import com.leesc.voicetimer.databinding.FragmentAlarmBinding;
import com.leesc.voicetimer.ui.base.BaseFragment;

import javax.inject.Inject;

public class AlarmFragment extends BaseFragment<FragmentAlarmBinding, AlarmViewModel> implements AlarmNavigator {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    AlarmViewModel alarmViewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_alarm;
    }

    @Override
    public AlarmViewModel getViewModel() {
        alarmViewModel = ViewModelProviders.of(this, viewModelFactory).get(AlarmViewModel.class);
        return alarmViewModel;
    }

    public static AlarmFragment newInstance() {
        Bundle args = new Bundle();
        AlarmFragment fragment = new AlarmFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void handleError(Throwable throwable) {

    }
}