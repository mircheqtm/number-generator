package com.grishimir.iton.client;

import java.util.concurrent.atomic.AtomicInteger;

public class ReceivedValue {
    private final AtomicInteger value = new AtomicInteger(0);

    public void updateValue(int number) {
        value.set(number);
    }

    public int getValue() {
        return value.getAndSet(0);
    }
}