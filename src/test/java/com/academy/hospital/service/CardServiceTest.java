package com.academy.hospital.service;


import com.academy.hospital.dto.CardDto;
import com.academy.hospital.dto.PatientDto;
import com.academy.hospital.mapper.*;
import com.academy.hospital.model.entity.Card;
import com.academy.hospital.model.repository.CardRepository;
import com.academy.hospital.service.impl.CardServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CardServiceTest {

    @InjectMocks
    private CardServiceImpl cardService;

    @Mock
    private CardMapper cardMapper ;

    @Mock
    private CardRepository cardRepository;


    @Test
    public void testFindCardById() {
        Card card = new Card();
        card.setId(1);
        when(cardRepository.getReferenceById(1)).thenReturn(card);
        CardDto cardDto = new CardDto();
        cardDto.setId(1);
        when(cardMapper.toDto(card)).thenReturn(cardDto);
        CardDto lucky = cardService.findCard(1);
        verify(cardRepository).getReferenceById(1);
        verify(cardMapper).toDto(card);
        assertEquals(1, lucky.getId());
    }


}
