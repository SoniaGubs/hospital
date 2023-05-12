package com.academy.hospital.dto;

import com.academy.hospital.model.entity.Diagnosis;
import lombok.Data;

import java.util.List;

@Data
public class CardSetDiagnosesDto {
    private Integer id;
    private List<Diagnosis> startDiagnoses;
    private List<Diagnosis> allRemainingDiagnoses;
    private String descriptionStartDiagnosis;



}
