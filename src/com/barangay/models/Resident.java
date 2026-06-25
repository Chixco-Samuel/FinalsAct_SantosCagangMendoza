package com.barangay.models;

import java.util.Objects;

public class Resident {

    private String residentId;
    private String firstName;
    private String lastName;
    private int age;

    public Resident(String residentId, String firstName, String lastName, int age) {
        setResidentId(residentId);
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

    public String getResidentId() {
        return residentId;
    }

    public void setResidentId(String residentId) {
        if (residentId == null || residentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Resident ID cannot be empty.");
        }
        this.residentId = residentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty.");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty.");
        }
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "residentId='" + residentId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Resident)) return false;

        Resident resident = (Resident) obj;
        return Objects.equals(residentId, resident.residentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(residentId);
    }
}   