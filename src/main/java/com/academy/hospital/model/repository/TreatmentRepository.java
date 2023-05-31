package com.academy.hospital.model.repository;

import com.academy.hospital.model.entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreatmentRepository extends JpaRepository <Treatment, Integer> {

    List<Treatment> findByCard_Id(Integer id);

    List<Treatment> findByCard_IdAndDateOfCompletionIsNull(Integer id);
    List<Treatment> findByCard_IdAndDateOfCompletionIsNotNull(Integer id);



}
