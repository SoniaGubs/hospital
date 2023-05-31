package com.academy.hospital.dto;

import lombok.Data;


@Data
public class StaffDto {
    private Integer id;
    private String name;
    private String surname;
    private String patronymic;
    private String email;
    private String phone;

}
