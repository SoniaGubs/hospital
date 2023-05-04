package com.academy.hospital.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "reception_diagnosis")
public class ReceptionDiagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "diagnosis_id")
    private Diagnosis diagnosis;


}
