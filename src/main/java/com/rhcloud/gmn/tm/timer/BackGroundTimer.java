package com.rhcloud.gmn.tm.timer;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author GMNProjects
 */
public class BackGroundTimer implements Runnable {

    private static volatile Timer currentTimer;
    private Updater updater;

    public BackGroundTimer(Updater updater) {
        this.updater = updater;
        currentTimer = new Timer();
    }

    @Override
    public void run() {
        currentTimer.schedule(new TTask(), 0, 1000);
    }

    class TTask extends TimerTask {

        @Override
        public void run() {
            updater.update();
        }
    }

    public Calendar cancel() {
        currentTimer.cancel();
        return Calendar.getInstance();
    }

}
