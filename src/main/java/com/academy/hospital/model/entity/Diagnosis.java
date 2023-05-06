package com.academy.hospital.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;


    @Column(name = "code_MKB10")
    private String code;

    @Column(name = "name")
    private String diagnosisName;
}