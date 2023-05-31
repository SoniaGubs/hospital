package com.academy.hospital.model.entity;


import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;
    private String patronymic;
    private String email;
    private String phone;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}