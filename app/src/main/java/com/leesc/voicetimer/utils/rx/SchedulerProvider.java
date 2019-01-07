package com.leesc.voicetimer.utils.rx;

import io.reactivex.Scheduler;

public interface SchedulerProvider {

    Scheduler ui();

    Scheduler io();

    Scheduler computation();

}
