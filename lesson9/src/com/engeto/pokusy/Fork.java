package com.engeto.pokusy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;


public class Fork {
    int number;
    ReentrantLock lock = new ReentrantLock(true);


    public Fork(int number) {
        this.number = number;

    }

    public boolean pickUp() {

        try {
            if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {

                return true;
            } else {
                return false;
            }
        } catch (InterruptedException e) {
            System.out.println(" To nejak zhavarovalo, nebo co.");
            e.printStackTrace();
            return false;
        }


    }

    public void putDown() {
//        if(lock.isLocked())
        if (lock.isHeldByCurrentThread())
            lock.unlock();
    }
}
