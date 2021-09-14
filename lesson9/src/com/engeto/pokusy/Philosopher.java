package com.engeto.pokusy;

import java.util.concurrent.locks.ReentrantLock;

public class Philosopher extends Thread {

    String namePhilosopher;
    Fork leftHandFork;
    Fork rightHandFork;


    public Philosopher(String namePhilosopher, Fork leftHandFork, Fork rightHandFork) {
        this.namePhilosopher = namePhilosopher;
        this.leftHandFork = leftHandFork;
        this.rightHandFork = rightHandFork;
    }


    @Override
    public void run() {


        for (int i = 1; i < 10000; i++) {


            if (leftHandFork.pickUp()) {

                if (rightHandFork.pickUp()) {
                    System.out.println(namePhilosopher + " has held " + leftHandFork.number + " in his left hand and "
                            + rightHandFork.number + " in his right hand in cycle " + i);
                }
            }
            leftHandFork.putDown();
            rightHandFork.putDown();

        }

    }
}

