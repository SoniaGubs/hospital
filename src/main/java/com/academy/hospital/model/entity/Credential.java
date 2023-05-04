package com.academy.hospital.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Credential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    private String login;
    private String password;

}
