package com.academy.hospital.service.impl;

import com.academy.hospital.model.entity.Card;
import com.academy.hospital.model.repository.CardRepository;
import com.academy.hospital.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public Card findReception(Integer id) {
        return cardRepository.getReferenceById(id);
    }

    @Override
    public List<Card> findSick() {
        return cardRepository.findByDateOfDischargeIsNull();
    }

 /*   @Override
    public void setDiagnosis(Diagnosis diagnosis, Integer receptionId) {
        Card card = receptionRepository.getReferenceById(receptionId);
        card.setStartDiagnosis(diagnosis);

        receptionRepository.save(card);
    }*/
}
