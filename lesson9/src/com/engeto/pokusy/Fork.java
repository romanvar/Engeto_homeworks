package com.engeto.pokusy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class Fork extends ReentrantLock {
    int number;
    ReentrantLock lock = new ReentrantLock();

    public Fork(int number) {
        super(true);
        this.number = number;

    }

    public boolean pickUp() {

        try {
//            sleep(1);
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
