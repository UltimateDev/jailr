package com.tyzoid.jailr.util;

public class Time {
    public static int getTime() {
        return (int) (System.currentTimeMillis() / 1000L);
    }
}
