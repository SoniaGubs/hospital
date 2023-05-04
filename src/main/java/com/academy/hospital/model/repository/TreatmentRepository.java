package com.academy.hospital.model.repository;

import com.academy.hospital.model.entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository <Treatment, Integer> {
}
