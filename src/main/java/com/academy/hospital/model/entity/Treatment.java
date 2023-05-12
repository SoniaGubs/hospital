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
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@ManyToOne
    //private Card card;
    @Column(name = "treatment_type")
    @Enumerated(EnumType.STRING)
    private TreatmentType treatmentType;
    private String drug;
    private String operation;
    @Column(name = "procedures")
    private String procedure;

    @ManyToOne
    private Staff staff;

    @Enumerated(EnumType.STRING)
    private Status status;


}
