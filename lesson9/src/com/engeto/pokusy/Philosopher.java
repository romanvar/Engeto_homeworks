package com.engeto.pokusy;

import java.util.concurrent.locks.ReentrantLock;

public class Philosopher extends Thread {

    String namePhilosopher;
    Fork leftHandFork;
    Fork rightHandFork;
    Integer portionsEated;


    public Philosopher(String namePhilosopher, Fork leftHandFork, Fork rightHandFork) {
        this.namePhilosopher = namePhilosopher;
        this.leftHandFork = leftHandFork;
        this.rightHandFork = rightHandFork;
        this.portionsEated =0;
    }


    @Override
    public void  run() {



//        for (int i = 1; i < 10000; i++) {
//        int i = 1;
//        while (i < 10001) {
        while (this.portionsEated <10001){

            synchronized(this){
                if (leftHandFork.pickUp()) {

                    if (rightHandFork.pickUp()) {
                        System.out.println(namePhilosopher + " has held " + leftHandFork.number + " in his left hand and "
                                + rightHandFork.number + " in his right hand in cycle " + this.portionsEated);

                        this.portionsEated++;
                    }
                }
            }
            leftHandFork.putDown();
            rightHandFork.putDown();


        }


    }



}

