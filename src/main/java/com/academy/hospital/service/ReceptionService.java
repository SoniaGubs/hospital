package com.academy.hospital.service;

import com.academy.hospital.model.entity.Reception;

import java.util.List;

public interface ReceptionService {
    List<Reception> findAll();

    Reception findReception (Integer id);

    List<Reception> findSick();
}
