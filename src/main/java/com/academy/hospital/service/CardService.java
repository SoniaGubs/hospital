package com.academy.hospital.service;

import com.academy.hospital.dto.CardDto;
import com.academy.hospital.dto.CardSetDiagnosesDto;
import com.academy.hospital.dto.PatientDto;
import com.academy.hospital.exceptions.CardException;

import java.util.List;

public interface CardService {
    List<CardDto> findAllCardByPatient(Integer patientId);

    CardDto findCard(Integer id);

    List<CardDto> findSick();

    CardSetDiagnosesDto createCardSetDiagnosesDto (Integer id);

    CardDto updateDiagnosis (CardSetDiagnosesDto cardSetDiagnosesDto);
    CardDto save (PatientDto patientDto);

    void setDoctor (CardDto cardDto, Integer doctorId);

    void discharge(Integer cardId) throws CardException;

}
