package com.academy.hospital.dto;


import com.academy.hospital.model.entity.Staff;
import com.academy.hospital.model.entity.TreatmentType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Data
public class TreatmentDto {

    private Integer id;
    private TreatmentType treatmentType;
    private String prescription;
    private StaffDto staff;
    private CardDto card;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfPrescription;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfCompletion;

}
