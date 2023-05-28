package com.academy.hospital.model.entity;

public enum TreatmentType {
    DRUG("Drug"),
    PROCEDURE("Procedure"),
    OPERATION("Operation");

    private String label;

    TreatmentType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
