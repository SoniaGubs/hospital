package com.academy.hospital.model.entity;

public enum TreatmentType {
    DRUG("Лекарство"),
    PROCEDURE("Процедура"),
    OPERATION("Операция");

    private String label;

    TreatmentType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
