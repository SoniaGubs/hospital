package com.academy.hospital.dto;

import com.academy.hospital.model.entity.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.List;

@Data

public class CardDto {

    private Integer id;

    private PatientDto patient;

    private StaffDto staff;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private LocalDate dateOfAdmission;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private LocalDate dateOfDischarge;

    private List<DiagnosisDto> diagnoses;

    private String descriptionDiagnosis;

   /* private String descriptionFinalDiagnosis;

    private List<DiagnosisDto> finalDiagnosis;
*/
}
