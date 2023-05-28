package com.academy.hospital.service.impl;

import com.academy.hospital.dto.PatientDto;
import com.academy.hospital.mapper.PatientMapper;
import com.academy.hospital.model.entity.Patient;
import com.academy.hospital.model.repository.PatientRepository;
import com.academy.hospital.service.PatientService;
import com.academy.hospital.service.impl.PatientServiceImpl;
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
public class PatientServiceTest {

    @InjectMocks
    private PatientService patientService;

    @Mock
    private PatientMapper patientMapper;

    @Mock
    private PatientRepository patientRepository;

    @Test
    public void testFind() {
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
    public void testFindAll() {
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

   /* @Test
    public void testFindByParametersAndOrderByName() {



    }
*/

}


/*

    public List<PatientDto> findByParametersAndOrderByName(String surname, String name, String patronymic) {
        if (name.equals("")) {
            return patientMapper.modelsToDto(patientRepository.findBySurnameOrderByNameAsc(surname));
        } else if (patronymic.equals("")) {
            return patientMapper.modelsToDto(patientRepository.findBySurnameAndNameOrderByNameAsc(surname, name));
        } else {
            return patientMapper.modelsToDto(patientRepository.findBySurnameAndNameAndPatronymicOrderByNameAsc(surname, name, patronymic));
        }
    }



    @Override
    public PatientDto save(PatientDto patientDto) {
        Patient patient = patientMapper.toModel(patientDto);
        patientRepository.save(patient);
        return patientMapper.toDto(patient);
    }*/



