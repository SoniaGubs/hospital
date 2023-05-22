package com.academy.hospital.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonIgnore
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    @Column(name = "date_of_admission")
    private LocalDate dateOfAdmission;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    @Column(name = "date_of_discharge")
    private LocalDate dateOfDischarge;

    @ManyToMany
    @JoinTable(
            name = "card_diagnosis",
            joinColumns = {@JoinColumn(name ="card_id")},
            inverseJoinColumns = {@JoinColumn(name = "diagnosis_id")}
    )
    private List<Diagnosis> diagnoses;

    @Column(name = "description_diagnosis")
    private String descriptionDiagnosis;

/*
    @Column(name = "description_final_diagnosis")
    private String descriptionFinalDiagnosis;
*/

/*
    @ManyToMany
    @JoinTable(
            name = "card_diagnosis",
            joinColumns = {@JoinColumn(name ="card_id")},
            inverseJoinColumns = {@JoinColumn(name = "diagnosis_id")}
    ) private List<Diagnosis> finalDiagnosis;


   *//* @OneToMany
    @JoinColumn(name = "card_id")
    private List<Treatment> treatments;*/

}
