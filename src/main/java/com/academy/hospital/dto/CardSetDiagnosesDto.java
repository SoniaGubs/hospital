package com.academy.hospital.dto;

import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CardSetDiagnosesDto {

    private Integer id;
    private List<DiagnosisDto> diagnoses;
    private String descriptionDiagnosis;

}
