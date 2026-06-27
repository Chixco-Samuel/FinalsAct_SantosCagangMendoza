package com.barangay.services;
import com.barangay.models.Resident;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class ResidentService {
    private List<Resident> residents;

    public ResidentService() {
        residents = new ArrayList<>();
    }

    public void registerResident(Resident resident) {
        residents.add(resident);
    }

    public Resident findResidentById(String id) {
        for (Resident resident : residents) {
            if (resident.getId().equals(id)) {
                return resident;
            }
        }
        return null;
    }

    public void sortResidentsByLastName() {
        residents.sort(Comparator.comparing(Resident::getLastName));
    }
}