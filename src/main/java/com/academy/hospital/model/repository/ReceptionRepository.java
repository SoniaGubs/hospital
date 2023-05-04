package com.academy.hospital.model.repository;

import com.academy.hospital.model.entity.Reception;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceptionRepository extends JpaRepository<Reception, Integer> {

    List<Reception> findByDateOfDischargeIsNull ();

}
