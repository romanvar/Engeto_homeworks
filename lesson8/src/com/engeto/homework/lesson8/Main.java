package com.engeto.homework.lesson8;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        System.out.println("zacatek programu");
        Teacher teacher = new Teacher("Josef","Dokonaly");
        Student pupil1 = new Student("Karel", "Moudry", LocalDate.of(2003,7,19), 1);
        Student pupil2 = new Student("Daniel", "Hloupy", LocalDate.of(2002,6,9), 2);
        Student pupil3 = new Student("Daniel", "Hloupy", LocalDate.of(2001,5,8), 3);
        SchoolClass trida = new SchoolClass("Prusvihari","4.A", teacher);
        trida.addStudent(pupil1);
        trida.addStudent(pupil2);
        trida.addStudent(pupil3);
        trida.printSchollClass();
    }
}
