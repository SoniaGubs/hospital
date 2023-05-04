package com.academy.hospital.service;

import com.academy.hospital.model.entity.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> findAll();
}
