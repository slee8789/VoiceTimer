package com.leesc.voicetimer.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.leesc.voicetimer.BR;
import com.leesc.voicetimer.R;
import com.leesc.voicetimer.databinding.ActivityMainBinding;
import com.leesc.voicetimer.ui.base.BaseActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    MainPagerAdapter mainPagerAdapter;

    @Inject
    MainViewModel mainViewModel;

    private ActivityMainBinding activityMainBinding;

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
        return mainViewModel;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    public static void start(Context context) {
        final Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = getViewDataBinding();
        mainViewModel.setNavigator(this);
        initViews();

    }

    @Override
    public void handleError(Throwable throwable) {

    }

    private void initViews() {
        mainPagerAdapter.setCount(3);
        activityMainBinding.mainViewPager.setAdapter(mainPagerAdapter);
//        activityMainBinding.mainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                Log.d("lsc", "MainActivity onPageSelected " + position);
//                activityMainBinding.mainViewPager.setCurrentItem(position);
//                activityMainBinding.mainNav.getMenu().getItem(position).setChecked(true);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
        activityMainBinding.mainNav.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.nav_alarm:
                    activityMainBinding.mainViewPager.setCurrentItem(0);
                    break;
                case R.id.nav_stopwatch:
                    activityMainBinding.mainViewPager.setCurrentItem(1);
                    break;
                case R.id.nav_timer:
                    activityMainBinding.mainViewPager.setCurrentItem(2);
                    break;
            }

            return true;
        });
    }
}