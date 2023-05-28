package com.academy.hospital.service.impl;

import com.academy.hospital.dto.CardDto;
import com.academy.hospital.dto.CardSetDiagnosesDto;
import com.academy.hospital.dto.PatientDto;
import com.academy.hospital.dto.StaffDto;
import com.academy.hospital.exceptions.CardException;
import com.academy.hospital.mapper.*;
import com.academy.hospital.model.entity.Card;
import com.academy.hospital.model.entity.Diagnosis;
import com.academy.hospital.model.entity.Patient;
import com.academy.hospital.model.repository.CardRepository;
import com.academy.hospital.service.CardService;
import com.academy.hospital.service.impl.CardServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CardServiceTest {

    @InjectMocks
    private CardService cardService;

    @Mock
    private CardMapper cardMapper;

    @Mock
    private CardRepository cardRepository;


    @Test
    public void testFindCardById() {
        Card card = new Card();
        card.setId(1);
        when(cardRepository.getReferenceById(1)).thenReturn(card);

        CardDto cardDto = new CardDto();
        cardDto.setId(card.getId());
        when(cardMapper.toDto(card)).thenReturn(cardDto);

        CardDto lucky = cardService.findCard(1);
        verify(cardRepository).getReferenceById(1);
        verify(cardMapper).toDto(card);
        assertEquals(1, lucky.getId());
    }

    @Test
    public void testFindSick() {
        Card first = new Card();
        first.setId(1);
        Card second = new Card();
        second.setId(2);
        List<Card> cards = new ArrayList<>(Arrays.asList(first, second));

        when(cardRepository.findByDateOfDischargeIsNull()).thenReturn(cards);

        CardDto firstDto = new CardDto();
        firstDto.setId(1);
        CardDto secondDto = new CardDto();
        secondDto.setId(2);
        List<CardDto> cardsDto = new ArrayList<>(Arrays.asList(firstDto, secondDto));

        when(cardMapper.modelsToDto(cards)).thenReturn(cardsDto);

        List<CardDto> realList = cardService.findSick();
        verify(cardRepository).findByDateOfDischargeIsNull();
        verify(cardMapper).modelsToDto(cards);
        assertEquals(cardsDto, realList);
    }


    @Test
    public void testSave() {
        PatientDto patientDto = new PatientDto();
        patientDto.setId(1);
        Patient patient = new Patient();
        patient.setId(1);

        CardDto cardDto = new CardDto();
        cardDto.setDateOfAdmission(LocalDate.now());
        cardDto.setPatient(patientDto);

        Card card = new Card();
        card.setPatient(patient);
        card.setDateOfAdmission(LocalDate.now());

        when(cardMapper.toModel(cardDto)).thenReturn(card);

        CardDto newCard = cardService.save(patientDto);
        verify(cardRepository).save(card);
        verify(cardMapper).toModel(cardDto);
        assertEquals(cardDto, newCard);

    }

    @Test
    public void testFindAllCardByPatient() {

        PatientDto patientDto = new PatientDto();
        patientDto.setId(5);
        Patient patient = new Patient();
        patient.setId(5);

        Card first = new Card();
        Card second = new Card();
        first.setPatient(patient);
        second.setPatient(patient);
        List<Card> cards = new ArrayList<>(Arrays.asList(first,second));
        when(cardRepository.findByPatient_Id(5)).thenReturn(cards);

        CardDto firstDto = new CardDto();
        CardDto secondDto = new CardDto();
        firstDto.setPatient(patientDto);
        secondDto.setPatient(patientDto);
        List<CardDto> cardDtos = new ArrayList<>(Arrays.asList(firstDto,secondDto));
        when(cardMapper.modelsToDto(cards)).thenReturn(cardDtos);

        List<CardDto> actualList = cardService.findAllCardByPatient(5);

        verify(cardRepository).findByPatient_Id(5);
        verify(cardMapper).modelsToDto(cards);
        assertEquals(actualList,cardDtos);


    }


   /*



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
        return cardMapper.toDto(card);
    }



    @Override
    public void setDoctor(CardDto cardDto, Integer doctorId) {
        StaffDto staffDto = staffService.findById(doctorId);
        cardDto.setStaff(staffDto);
        cardRepository.save(cardMapper.toModel(cardDto));
    }


    @Override
    public void discharge(Integer id) throws CardException {
        CardDto cardDto = findCard(id);
        if (cardDto.getStaff()==null || cardDto.getDiagnoses().isEmpty()){
            throw new CardException("Enter doctor and diagnosis");
        }
        cardDto.setDateOfDischarge(LocalDate.now());
        cardRepository.save(cardMapper.toModel(cardDto));
    }*/


}
