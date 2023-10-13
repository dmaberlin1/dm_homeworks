package com.dmadev.java.part15;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskRunner {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        // Раз в 2 минуты запускаем обработку жалоб
        executorService.scheduleAtFixedRate(dispatcher::processComplaints, 0, 2, TimeUnit.MINUTES);
    }
}
