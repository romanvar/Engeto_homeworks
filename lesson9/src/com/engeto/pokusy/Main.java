package com.engeto.pokusy;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i < 10; i++) {
//        Fork fork
        }
        Fork fork1 = new Fork(1);
        Fork fork2 = new Fork(2);
        Fork fork3 = new Fork(3);
        Fork fork4 = new Fork(4);
        Fork fork5 = new Fork(5);
        Fork fork6 = new Fork(6);
        Fork fork7 = new Fork(7);
        Fork fork8 = new Fork(8);
        Fork fork9 = new Fork(9);
        Fork fork10 = new Fork(10);

        Philosopher philosopher1 = new Philosopher("Philosopher1", fork1, fork2);
        Philosopher philosopher2 = new Philosopher("Philosopher2", fork2, fork3);
        Philosopher philosopher3 = new Philosopher("Philosopher3", fork3, fork4);
        Philosopher philosopher4 = new Philosopher("Philosopher4", fork4, fork5);
        Philosopher philosopher5 = new Philosopher("Philosopher5", fork5, fork6);
        Philosopher philosopher6 = new Philosopher("Philosopher6", fork6, fork7);
        Philosopher philosopher7 = new Philosopher("Philosopher7", fork7, fork8);
        Philosopher philosopher8 = new Philosopher("Philosopher8", fork8, fork9);
        Philosopher philosopher9 = new Philosopher("Philosopher9", fork9, fork10);
        Philosopher philosopher10 = new Philosopher("Philosopher10", fork10, fork1);


        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher6.start();
        philosopher4.start();
        philosopher5.start();
        philosopher7.start();
        philosopher8.start();
        philosopher9.start();
        philosopher10.start();

    }


}
