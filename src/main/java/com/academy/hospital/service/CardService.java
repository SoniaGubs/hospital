package com.academy.hospital.service;

import com.academy.hospital.dto.CardDto;
import com.academy.hospital.model.entity.Card;

import java.util.List;

public interface CardService {
    List<Card> findAll();

    CardDto findCard(Integer id);

    List<CardDto> findSick();

    //void setDiagnosis(Diagnosis diagnosis, Integer receptionId);
}
