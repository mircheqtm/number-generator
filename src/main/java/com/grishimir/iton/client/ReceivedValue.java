package com.grishimir.iton.client;

public class ReceivedValue {
    private int value = 0;

    private boolean used = true;

    public synchronized void updateValue(int number) {
        value = number;
        used = false;
    }

    public synchronized int getValue() {
        if (used) {
            return 0;
        }
        used = true;
        return value;

    }
}