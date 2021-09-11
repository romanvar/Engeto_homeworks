package com.engeto.pokusy;

import java.util.concurrent.locks.ReentrantLock;

public class Fork extends ReentrantLock {
    int number;

    public Fork(int number) {
        super(true);
        this.number = number;

    }
}
