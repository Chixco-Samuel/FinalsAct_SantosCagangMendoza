package com.barangay.services;
import com.barangay.exception.ExceptionHandling;
import com.barangay.models.BarangayService;
import com.barangay.models.Resident;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ResidentService extends BarangayService{
    private List<Resident> residents;

    public List<Resident> getAllResidents() {
        return new ArrayList<>(residents);
    }

    public ResidentService() {
        super("RS001", "Resident Registration", "Service for registering new residents");
        residents = new ArrayList<>();
    }

    public void registerResident(Resident resident) {
    residents.add(resident);
    }

    public void registerResident(String id, String firstName, String lastName, int age) {
    Resident resident =
        new Resident(id, firstName, lastName, age);

    registerResident(resident);
    }

    public Resident findResidentByResidentId(String id) throws ExceptionHandling {
        for (Resident resident : residents) {
            if (resident.getResidentId().equals(id)) {
                return resident;
            }
        }
        throw new ExceptionHandling("Resident ID not found.");
    }

    public void sortResidentsByLastName() {
        residents.sort(Comparator.comparing(Resident::getLastName));
    }

    public void displayResidents() {
        for (Resident resident : residents) {
            System.out.println(resident);
        }
    }
}