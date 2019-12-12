package com.bigbank;

import java.util.concurrent.TimeUnit;

public class WaitSteps {

    public static void safeWait(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException var3) {
            Thread.currentThread().interrupt();
        }
    }
}
