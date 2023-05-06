package com.academy.hospital.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @Enumerated(EnumType.STRING)
    private Role role;
    private String email;
    private String phone;

    @OneToOne
    private Credential credential;


/*
    //  @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "staff")
    @JsonIgnoreProperties("staff")
    // @JoinColumn(name = "staff_id")
    private List<Card> cards;
}
*/
}