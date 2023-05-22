package com.academy.hospital.dto;

import com.academy.hospital.model.entity.Role;
import com.academy.hospital.model.entity.User;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class StaffDto {
    private Integer id;
    private String name;
    private String surname;
    private String patronymic;
    private User user;

/*
    @Enumerated(EnumType.STRING)
    private Role role;*/
    private String email;
    private String phone;

}
