package com.rhcloud.gmn.tm.impl;

import com.rhcloud.gmn.tm.timer.BackGroundTimer;
import com.rhcloud.gmn.tm.timer.Timer;
import com.rhcloud.gmn.tm.timer.Updater;

import java.util.Calendar;

/**
 * Created by niaz on 09.07.2014.
 */
public class DefaultTimer implements Timer {

    private Calendar startTime;

    private Updater updater;

    private Thread backGroundTimerThread = null;

    BackGroundTimer timer;

    public DefaultTimer(Updater updater) {
        this.updater = updater;
    }

    @Override
    public void start() {
        if (isRun()) {
            throw new RuntimeException("Timer already running!");
        }
        startTime = Calendar.getInstance();
        timer = new BackGroundTimer(updater);
        backGroundTimerThread = new Thread(timer);
        backGroundTimerThread.start();
    }

    @Override
    public long stop() {
        if (!isRun()) {
            throw new RuntimeException("Timer is not running!");
        }
        long res = getDiffInMillis(startTime, timer.cancel());
        backGroundTimerThread = null;
        return res;
    }

    @Override
    public void cancel() {
        if (!isRun()) {
            throw new RuntimeException("Timer is not running!");
        }
        startTime = null;
        timer.cancel();
    }

    private boolean isRun() {
        return backGroundTimerThread != null;
    }

    private long getDiffInMillis(Calendar cal, Calendar cal1) {
        long time1 = cal.getTimeInMillis() + cal.getTimeZone().getOffset(cal.getTimeInMillis());
        long time2 = cal1.getTimeInMillis() + cal1.getTimeZone().getOffset(cal1.getTimeInMillis());
        return Math.abs(time1 - time2);
    }
}
