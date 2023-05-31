package com.academy.hospital.service.impl;

import com.academy.hospital.dto.*;
import com.academy.hospital.exceptions.CardException;
import com.academy.hospital.mapper.CardMapper;
import com.academy.hospital.mapper.CardSetDiagnosesMapper;
import com.academy.hospital.mapper.DiagnosisMapper;
import com.academy.hospital.model.entity.Card;
import com.academy.hospital.model.entity.Diagnosis;
import com.academy.hospital.model.repository.CardRepository;
import com.academy.hospital.service.CardService;
import com.academy.hospital.service.DiagnosisService;
import com.academy.hospital.service.StaffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;
    private final CardSetDiagnosesMapper cardSetDiagnosesMapper;
    private final DiagnosisMapper diagnosisMapper;
    private final StaffService staffService;


    @Override
    public List<CardDto> findAllCardByPatient(Integer patientId) {
        return cardMapper.modelsToDto(cardRepository.findByPatient_IdAndDateOfDischargeIsNotNull(patientId));
    }

    @Override
    public CardDto findCard(Integer id) {
        return cardMapper.toDto(cardRepository.getReferenceById(id));
    }

    @Override
    public List<CardDto> findSick() {
        return cardMapper.modelsToDto(cardRepository.findByDateOfDischargeIsNull());
    }

    public CardSetDiagnosesDto createCardSetDiagnosesDto(Integer id) {
        Card card = cardRepository.getReferenceById(id);
        return cardSetDiagnosesMapper.toDto(card);
    }

    @Override
    public CardDto updateDiagnosis(CardSetDiagnosesDto cardSetDiagnosesDto) {
        Card card = cardRepository.getReferenceById(cardSetDiagnosesDto.getId());
        List<Diagnosis> startDiagnoses = diagnosisMapper.dtoToModels(cardSetDiagnosesDto.getDiagnoses());
        card.setDiagnoses(startDiagnoses);
        card.setDescriptionDiagnosis(cardSetDiagnosesDto.getDescriptionDiagnosis());
        cardRepository.save(card);
        log.info("update diagnoses for card");
        return cardMapper.toDto(card);
    }

    @Override
    public CardDto save(PatientDto patientDto) {
        CardDto cardDto = new CardDto();
        cardDto.setDateOfAdmission(LocalDate.now());
        cardDto.setPatient(patientDto);
        cardRepository.save(cardMapper.toModel(cardDto));
        log.info("save new card");
        return cardDto;
    }

    @Override
    public void setDoctor(CardDto cardDto, Integer doctorId) {
        StaffDto staffDto = staffService.findById(doctorId);
        cardDto.setStaff(staffDto);
        cardRepository.save(cardMapper.toModel(cardDto));
        log.info("set doctor in the card");
    }

    @Override
    public void discharge(Integer id) throws CardException {
        CardDto cardDto = findCard(id);
        if (cardDto.getStaff()==null || cardDto.getDiagnoses().isEmpty()){
            log.error("Card doesn't have doctor or diagnoses for discharge");
            throw new CardException("Enter doctor and diagnosis");
        }
        cardDto.setDateOfDischarge(LocalDate.now());
        cardRepository.save(cardMapper.toModel(cardDto));
        log.info("patient discharges/ card close");
    }

}