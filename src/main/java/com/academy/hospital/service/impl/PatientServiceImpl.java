package com.academy.hospital.service.impl;

import com.academy.hospital.model.entity.Patient;
import com.academy.hospital.model.repository.PatientRepository;
import com.academy.hospital.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }
}
