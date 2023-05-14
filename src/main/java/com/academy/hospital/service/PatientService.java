package com.academy.hospital.service;

import com.academy.hospital.dto.PatientDto;
import com.academy.hospital.model.entity.Patient;

import java.util.List;

public interface PatientService {

    PatientDto find(Integer id);
    List<PatientDto> findAll();

  // List<PatientDto> findAllBySurnameAndNameAndPatronymic(String surname, String name, String patronymic);
   List<PatientDto> findByParameters(String surname, String name, String patronymic);

    void save (PatientDto patientDto);
}
