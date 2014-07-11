package com.rhcloud.gmn.tm.timer;

import java.util.Date;

/**
 * @author GMNProjects
 */
public interface Timer {
    /**
     * Начать отчет
     */
    public void start() ;

    /**
     * Закончить отчет
     * @return
     */
    public long stop();

    /**
     * Сбросить таймер. Подчитанное время удалится
     */
    public void cancel();


}
