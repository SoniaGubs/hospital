package com.academy.hospital.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Reception {

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

    @Column(name = "date_of_admission")
    private LocalDateTime dateOfAdmission;
    @Column(name = "date_of_discharge")
    private LocalDateTime dateOfDischarge;

    @OneToMany
    @JoinColumn(name = "reception_id")
    private List<ReceptionDiagnosis> diagnoses;

    @OneToMany
    @JoinColumn(name = "reception_id")
    private List<Treatment> treatments;


}
