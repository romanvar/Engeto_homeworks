package com.engeto.lesson2.homework;

import java.time.LocalDate;

public class Client {
    private String name;
    private String surname;
    private LocalDate birthday;

    public Client( String name , String surname , LocalDate birthday ) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname( String surname ) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday( LocalDate birthday ) {
        this.birthday = birthday;
    }

    public void getDescription() {

        System.out.println("Name of client : " + name + " " + surname);
        System.out.println("Birthday of the client : " + birthday);
    }
}
