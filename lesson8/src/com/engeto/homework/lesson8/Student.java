package com.engeto.homework.lesson8;

import java.time.LocalDate;

public class Student extends  Person{

    private LocalDate birthday;
    private int studentID;

    public Student(String name, String surname, LocalDate birthday, int studentID) {
super(name,surname);
        this.birthday = birthday;
        this.studentID = studentID;
    }



}
