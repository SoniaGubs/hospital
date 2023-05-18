package com.academy.hospital.service;

import com.academy.hospital.dto.DiagnosisDto;
import com.academy.hospital.model.entity.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiagnosisService  {

    List <DiagnosisDto> findAll();




}
