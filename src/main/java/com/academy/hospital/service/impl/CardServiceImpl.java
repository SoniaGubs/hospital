package com.academy.hospital.service.impl;

import com.academy.hospital.dto.CardDto;
import com.academy.hospital.dto.CardSetDiagnosesDto;
import com.academy.hospital.mapper.CardMapper;
import com.academy.hospital.mapper.CardSetDiagnosesMapper;
import com.academy.hospital.model.entity.Card;
import com.academy.hospital.model.entity.Diagnosis;
import com.academy.hospital.model.repository.CardRepository;
import com.academy.hospital.model.repository.DiagnosisRepository;
import com.academy.hospital.service.CardService;
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

 /*   @Override
    public CardDto setDiagnosis(List<Diagnosis> diagnoses, Integer id) {
        Card card = cardRepository.getReferenceById(id);
        card.setStartDiagnoses(diagnoses);
       return cardMapper.toDto(cardRepository.save(card));
    }*/

    public CardSetDiagnosesDto createCardSetDiagnosesDto (Integer id){
        Card card = cardRepository.getReferenceById(id);
        CardSetDiagnosesDto cardSetDiagnosesDto = cardSetDiagnosesMapper.toDto(card);
        List<Diagnosis> startDiagnoses = card.getStartDiagnoses();
        List<Diagnosis> allRemainingDiagnoses = new ArrayList<>(diagnosisRepository.findAll());
        allRemainingDiagnoses.removeAll(startDiagnoses);
        allRemainingDiagnoses.sort(Comparator.comparing(Diagnosis::getCode));
        cardSetDiagnosesDto.setAllRemainingDiagnoses(allRemainingDiagnoses);
        return cardSetDiagnosesDto;
    }

    @Override
    public CardDto save(CardSetDiagnosesDto cardSetDiagnosesDto) {
        Card card = cardRepository.getReferenceById(cardSetDiagnosesDto.getId());
        card.setStartDiagnoses(cardSetDiagnosesDto.getStartDiagnoses());
        card.setDescriptionStartDiagnosis(cardSetDiagnosesDto.getDescriptionStartDiagnosis());
       return cardMapper.toDto(cardRepository.save(card));
    }


 /*   @Override
    public void setDiagnosis(Diagnosis diagnosis, Integer receptionId) {
        Card card = receptionRepository.getReferenceById(receptionId);
        card.setStartDiagnosis(diagnosis);

        receptionRepository.save(card);
    }*/
}
