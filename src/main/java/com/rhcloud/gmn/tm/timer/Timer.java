package com.rhcloud.gmn.tm.timer;

import java.util.Calendar;

/**
 * @author GMNProjects
 */
public interface Timer {
    /**
     * Начать отчет
     */
    public Calendar start();

    /**
     * Закончить отчет
     *
     * @return
     */
    public long stop();

    /**
     * Сбросить таймер. Подчитанное время удалится
     */
    public void cancel();


}
