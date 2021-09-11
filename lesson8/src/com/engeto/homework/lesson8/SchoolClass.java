package com.engeto.homework.lesson8;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass {
    private String name;
    private String rocnik;
    private Teacher mainTeacher;
    private List<Student> studentList = new ArrayList<>();

    public SchoolClass(String name, String rocnik, Teacher mainTeacher, List<Student> studentList) {
        this.name = name;
        this.rocnik = rocnik;
        this.mainTeacher = mainTeacher;
        this.studentList = studentList;
    }

    public String getName() {
        return name;
    }

    public String getRocnik() {
        return rocnik;
    }

    public Teacher getMainTeacher() {
        return mainTeacher;
    }

    public SchoolClass(String name, String rocnik, Teacher mainTeacher) {
        this.name = name;
        this.rocnik = rocnik;
        this.mainTeacher = mainTeacher;
    }

    public void addStudent(Student s){
        this.studentList.add(s);

    }

    public void printSchollClass() {
        System.out.println("#####################");
        System.out.println("Trida: "+getRocnik());
        System.out.println("Tridni ucitel: "+getMainTeacher());
        System.out.println("Pocet studentu: "+this.studentList.size());
    }
}
