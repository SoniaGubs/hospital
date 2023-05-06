package com.academy.hospital.service;

import com.academy.hospital.model.entity.Card;
import com.academy.hospital.model.entity.Diagnosis;

import java.util.List;

public interface CardService {
    List<Card> findAll();

    Card findReception(Integer id);

    List<Card> findSick();

    //void setDiagnosis(Diagnosis diagnosis, Integer receptionId);
}
