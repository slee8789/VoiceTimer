package com.leesc.voicetimer.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.leesc.voicetimer.ui.main.alarm.AlarmFragment;
import com.leesc.voicetimer.ui.main.stopwatch.StopwatchFragment;
import com.leesc.voicetimer.ui.main.timer.TimerFragment;

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    public enum EnumFragmentType {
        ALARM("ALARM"), STOPWATCH("STOPWATCH"), TIMER("TIMER");

        EnumFragmentType(String fragment) {
        }
    }

    private int pageCount;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
        this.pageCount = 0;
    }

    public void setCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return AlarmFragment.newInstance();
            case 1:
                return StopwatchFragment.newInstance();
            case 2:
                return TimerFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return pageCount;
    }
}
