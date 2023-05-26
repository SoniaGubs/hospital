package com.academy.hospital.service;

import com.academy.hospital.dto.PatientDto;

import java.util.List;

public interface PatientService {

    PatientDto find(Integer id);
    List<PatientDto> findAll();

  // List<PatientDto> findAllBySurnameAndNameAndPatronymic(String surname, String name, String patronymic);
   List<PatientDto> findByParametersAndOrderByName(String surname, String name, String patronymic);

    PatientDto save (PatientDto patientDto);
}
