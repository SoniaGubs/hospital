package com.academy.hospital.model.repository;

import com.academy.hospital.model.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Integer> {

    List<Card> findByDateOfDischargeIsNull ();

    List<Card> findByPatient_IdAndDateOfDischargeIsNotNull(Integer id);

}
