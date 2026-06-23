package com.barangay.models;

public class Resident{
    private String residentId;
    private String firstName;
    private String lastName;
    private int age;

    public Resident(String residentId, String firstName, String lastName, int age) {
        this.residentId = residentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void setResidentId(String residentId) {
        this.residentId = residentId;
    }

    public String getResidentId() {
        return residentId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}