package com.academy.hospital.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    @Enumerated(EnumType.STRING)
   private Gender gender;
    private String passport;

    @Column(name = "date_of_birth")
    private LocalDate dob;
    private String phone;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "patient")
    private List<Reception> receptions;

/*    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", passport='" + passport + '\'' +
                ", dob=" + dob +
                ", phone='" + phone + '\'' +
                '}';
    }*/
}


