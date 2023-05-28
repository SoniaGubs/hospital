package com.academy.hospital.service.impl;

import com.academy.hospital.dto.DiagnosisDto;
import com.academy.hospital.mapper.DiagnosisMapper;
import com.academy.hospital.model.entity.Diagnosis;
import com.academy.hospital.model.repository.DiagnosisRepository;
import com.academy.hospital.service.DiagnosisService;
import com.academy.hospital.service.impl.DiagnosisServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DiagnosisServiceTest {

    @InjectMocks
    private DiagnosisService diagnosisService;

    @Mock
    private DiagnosisMapper diagnosisMapper;

    @Mock
    private DiagnosisRepository diagnosisRepository;


    @Test
    public void testFindAll() {
        Diagnosis first = new Diagnosis();
        first.setId(1);
        Diagnosis second = new Diagnosis();
        second.setId(2);
        List<Diagnosis> diagnoses = new ArrayList<>(Arrays.asList(first, second));

        when(diagnosisRepository.findAll()).thenReturn(diagnoses);

        DiagnosisDto firstDiagnosisDto = new DiagnosisDto();
        DiagnosisDto secondDiagnosisDto = new DiagnosisDto();
        firstDiagnosisDto.setId(1);
        secondDiagnosisDto.setId(2);
        List<DiagnosisDto> diagnosisDtos = new ArrayList<>(Arrays.asList(firstDiagnosisDto, secondDiagnosisDto));

        when(diagnosisMapper.modelsToDto(diagnoses)).thenReturn(diagnosisDtos);

        List<DiagnosisDto> realList = diagnosisService.findAll();
        verify(diagnosisRepository).findAll();
        verify(diagnosisMapper).modelsToDto(diagnoses);
        assertEquals(diagnosisDtos, realList);

    }


}
