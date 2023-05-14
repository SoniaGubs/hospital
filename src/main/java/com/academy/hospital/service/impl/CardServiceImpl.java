package com.academy.hospital.service.impl;

import com.academy.hospital.dto.CardDto;
import com.academy.hospital.dto.CardSetDiagnosesDto;
import com.academy.hospital.dto.DiagnosisDto;
import com.academy.hospital.mapper.CardMapper;
import com.academy.hospital.mapper.CardSetDiagnosesMapper;
import com.academy.hospital.mapper.DiagnosisMapper;
import com.academy.hospital.model.entity.Card;
import com.academy.hospital.model.entity.Diagnosis;
import com.academy.hospital.model.repository.CardRepository;
import com.academy.hospital.model.repository.DiagnosisRepository;
import com.academy.hospital.service.CardService;
import com.academy.hospital.service.DiagnosisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;
    private final CardSetDiagnosesMapper cardSetDiagnosesMapper;
    private final DiagnosisRepository diagnosisRepository;
    private final DiagnosisMapper diagnosisMapper;
    private final DiagnosisService diagnosisService;

    @Override
    public List<CardDto> findAll() {
        return cardMapper.modelsToDto(cardRepository.findAll());
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
        CardSetDiagnosesDto cardSetDiagnosesDto = cardSetDiagnosesMapper.toDto(card);

        List<Diagnosis> startDiagnoses = cardSetDiagnosesDto.getStartDiagnoses();
        List<Diagnosis> allRemainingDiagnoses =diagnosisService.findAll();
               // diagnosisMapper.modelsToDto(diagnosisRepository.findAll());
        allRemainingDiagnoses.removeAll(startDiagnoses);
        allRemainingDiagnoses.sort(Comparator.comparing(Diagnosis::getCode));
        cardSetDiagnosesDto.setAllRemainingDiagnoses(allRemainingDiagnoses);

        return cardSetDiagnosesDto;
    }


    @Override
    public CardDto updateDiagnosis(CardSetDiagnosesDto cardSetDiagnosesDto) {
        Card card = cardRepository.getReferenceById(cardSetDiagnosesDto.getId());
        card.setStartDiagnoses((cardSetDiagnosesDto.getStartDiagnoses()));
        card.setDescriptionStartDiagnosis(cardSetDiagnosesDto.getDescriptionStartDiagnosis());
        return cardMapper.toDto(cardRepository.save(card));
    }



    @Override
    public void save(CardDto cardDto) {
        Card card = cardMapper.toModel(cardDto);
        cardRepository.save(card);
    }


}
