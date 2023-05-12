package com.academy.hospital.dto;

import com.academy.hospital.model.entity.Card;
import com.academy.hospital.model.entity.Gender;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class PatientDto {
    private Integer id;
    private String name;
    private String surname;
    private String patronymic;
    private Gender gender;
    private String passport;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private LocalDate dob;
    private String phone;

    private List<CardDto> cards;
}
