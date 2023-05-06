package com.academy.hospital.service;

import com.academy.hospital.model.entity.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisService  {

    Diagnosis save (String name);


    Diagnosis findDiagnosis(Integer id);
}
