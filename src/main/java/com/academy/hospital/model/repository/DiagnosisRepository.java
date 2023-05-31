package com.academy.hospital.model.repository;

import com.academy.hospital.model.entity.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DiagnosisRepository extends JpaRepository <Diagnosis, Integer> {

}
