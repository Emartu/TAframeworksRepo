package com.epam.page_object.base;


public class TimeOut {
    public void Timeout() {
    }

    public static void sleep(int sec) {
        try {
            Thread.sleep((long) (sec * 1000));
        } catch (InterruptedException var2) {

        }

    }
}
