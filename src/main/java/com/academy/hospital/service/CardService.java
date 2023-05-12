package com.academy.hospital.service;

import com.academy.hospital.dto.CardDto;
import com.academy.hospital.dto.CardSetDiagnosesDto;
import com.academy.hospital.model.entity.Card;
import com.academy.hospital.model.entity.Diagnosis;

import java.util.List;

public interface CardService {
    List<CardDto> findAll();

    CardDto findCard(Integer id);

    List<CardDto> findSick();

   // CardDto setDiagnosis(List<Diagnosis> diagnoses, Integer id);

    CardSetDiagnosesDto createCardSetDiagnosesDto (Integer id);

    CardDto save (CardSetDiagnosesDto cardSetDiagnosesDto);
    void save (CardDto cardDto);
}
