package com.rhcloud.gmn.tm.timer;

import com.rhcloud.gmn.tm.impl.DefaultTimer;

/**
 * Created by niaz on 09.07.2014.
 */
public class TimerFactory {

    private Updater updater;

    private Timer timer;

    public TimerFactory(Updater updater) {
        this.updater = updater;
    }

    private Timer createTimer() {
        return new DefaultTimer(updater);
    }

    public Timer getTimer() {
        if (timer == null) timer = createTimer();
        return timer;
    }
}
