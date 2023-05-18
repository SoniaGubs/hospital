package com.academy.hospital.model.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
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
    private String patronymic;

    @Enumerated(EnumType.STRING)
   private Gender gender;
    private String passport;

    @Column(name = "date_of_birth")
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private LocalDate dob;
    private String phone;

/*    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "patient")
    private List<Card> cards;*/

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


