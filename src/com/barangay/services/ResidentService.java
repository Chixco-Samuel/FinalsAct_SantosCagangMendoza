package com.barangay.services;
import com.barangay.exception.ExceptionHandling;
import com.barangay.models.BarangayService;
import com.barangay.models.Resident;
import com.barangay.util.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ResidentService extends BarangayService{
    private Repository<Resident> residentRepo = new Repository<>();

    public List<Resident> getAllResidents() {
        return residentRepo.getAll();
    }

    public ResidentService() {
        super("RS001", "Resident Registration", "Service for registering new residents");
    }

    public void registerResident(Resident resident) throws ExceptionHandling {
    for (Resident r : residentRepo.getAll()) {
        if (r.getResidentId().equals(resident.getResidentId())) {
            throw new ExceptionHandling("Resident ID " + resident.getResidentId() + " already exists.");
        }
    }
    residentRepo.add(resident);
    }

    public void registerResident(String id, String firstName, String lastName, int age) {
    Resident resident =
        new Resident(id, firstName, lastName, age);

    registerResident(resident);
    }

    public Resident findResidentByResidentId(String id) throws ExceptionHandling {
        for (Resident resident : residentRepo.getAll()) {
            if (resident.getResidentId().equals(id)) {
                return resident;
            }
        }
        throw new ExceptionHandling("Resident ID not found.");
    }

    public void sortResidentsByLastName() {
        residentRepo.getAll().sort(Comparator.comparing(Resident::getLastName));
    }

    public List<Resident> searchByLastName(String keyword) {
    return residentRepo.getAll().stream()
            .filter(r -> r.getLastName().toLowerCase().contains(keyword.toLowerCase()))
            .collect(java.util.stream.Collectors.toList());
    }

    public void displayResidents() {
        for (Resident resident : residentRepo.getAll()) {
            System.out.println(resident);
        }
    }
}