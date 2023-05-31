package com.academy.hospital.model.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String patronymic;

    @Enumerated(EnumType.STRING)
   private Gender gender;
    private String passport;

    @Column(name = "date_of_birth")
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private LocalDate dob;
    private String phone;

}


