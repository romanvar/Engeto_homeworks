package com.engeto.lesson3.homework;

public class Main {

    public static void main(String[] args) {
	for (int i = 1; i <= 100; i++){
        if (i%3 == 0) System.out.print("FIZZ");
        if (i%5 == 0) System.out.print("BUZZ");
        if(i%3 !=0 && i%5 !=0) System.out.print(i);
        System.out.println("");
    }}
}
