package com.engeto.pokusy;

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

            synchronized (this) {
                leftHandFork.lock();
                System.out.println(namePhilosopher + " has held " + leftHandFork.number + " in his left hand. in cycle " + i);


                rightHandFork.lock();
                System.out.println(namePhilosopher + " has held " + rightHandFork.number + " in his right hand. in cycle " + i);

            }
            leftHandFork.unlock();
            rightHandFork.unlock();

        }
    }
}
