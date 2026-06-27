package com.barangay.services;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> {

    private List<T> records;

    public Repository() {
        records = new ArrayList<>();
    }

    public void add(T item) {
        records.add(item);
    }

    public void remove(T item) {
        records.remove(item);
    }

    public int count() {
        return records.size();
    }

    public List<T> getAll() {
        return records;
    }
}