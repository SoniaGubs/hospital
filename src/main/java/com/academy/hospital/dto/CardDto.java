package com.academy.hospital.dto;

import com.academy.hospital.model.entity.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CardDto {

    private Integer id;
    private Patient patient;

    private Staff staff;

    private LocalDate dateOfAdmission;
    private LocalDate dateOfDischarge;

    private List<Diagnosis> startDiagnoses;

    private String descriptionStartDiagnosis;

    private String descriptionFinalDiagnosis;

    private List<Diagnosis> finalDiagnosis;

    private List<Treatment> treatments;

}
