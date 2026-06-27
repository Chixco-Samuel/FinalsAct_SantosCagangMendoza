package com.barangay.services;

import com.barangay.models.BarangayService;
import com.barangay.models.Resident;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ResidentService extends BarangayService{
    private List<Resident> residents;

    public ResidentService() {
        super("RS001", "Resident Registration", "Service for registering new residents");
        residents = new ArrayList<>();
    }

    public void registerResident(Resident resident) {
        residents.add(resident);
    }

    public Resident findResidentByResidentId(String id) {
        for (Resident resident : residents) {
            if (resident.getResidentId().equals(id)) {
                return resident;
            }
        }
        return null;
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