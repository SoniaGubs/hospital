package com.academy.hospital.service.impl;

import com.academy.hospital.dto.PatientDto;
import com.academy.hospital.mapper.PatientMapper;
import com.academy.hospital.model.entity.Patient;
import com.academy.hospital.model.repository.PatientRepository;
import org.junit.jupiter.api.Test;
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
class PatientServiceTest {

    @InjectMocks
    private PatientServiceImpl patientService;
    @Mock
    private PatientMapper patientMapper;
    @Mock
    private PatientRepository patientRepository;

    @Test
    void testFind() {
        Patient patient = new Patient();
        patient.setId(2);
        when(patientRepository.getReferenceById(2)).thenReturn(patient);

        PatientDto patientDto = new PatientDto();
        patientDto.setId(2);
        when(patientMapper.toDto(patient)).thenReturn(patientDto);

        PatientDto lucky = patientService.find(2);
        verify(patientRepository).getReferenceById(2);
        verify(patientMapper).toDto(patient);
        assertEquals(2, lucky.getId());
    }

    @Test
    void testFindAll() {
        PatientDto firstDto = new PatientDto();
        PatientDto secondDto = new PatientDto();
        List<PatientDto> patientDtoList = new ArrayList<>(Arrays.asList(firstDto, secondDto));

        Patient first = new Patient();
        Patient second = new Patient();
        List<Patient> patients = new ArrayList<>(Arrays.asList(first, second));

        when(patientRepository.findAll()).thenReturn(patients);
        when(patientMapper.modelsToDto(patients)).thenReturn(patientDtoList);

        List<PatientDto> realList = patientService.findAll();
        verify(patientRepository).findAll();
        verify(patientMapper).modelsToDto(patients);
        assertEquals(patientDtoList, realList);

    }

}



