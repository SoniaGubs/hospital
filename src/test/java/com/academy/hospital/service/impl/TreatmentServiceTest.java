package com.academy.hospital.service.impl;

import com.academy.hospital.dto.TreatmentDto;
import com.academy.hospital.mapper.TreatmentMapper;
import com.academy.hospital.model.entity.Treatment;
import com.academy.hospital.model.repository.TreatmentRepository;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TreatmentServiceTest {

    @InjectMocks
    private TreatmentServiceImpl treatmentService;
    @Mock
    private TreatmentMapper treatmentMapper;
    @Mock
    private TreatmentRepository treatmentRepository;

    @Test
    void testFindTreatmentById() {
        Treatment treatment = new Treatment();
        treatment.setId(8);
        when(treatmentRepository.getReferenceById(8)).thenReturn(treatment);

        TreatmentDto treatmentDto = new TreatmentDto();
        treatmentDto.setId(8);

        when(treatmentMapper.toDto(treatment)).thenReturn(treatmentDto);

        TreatmentDto lucky = treatmentService.findById(8);
        verify(treatmentRepository).getReferenceById(8);
        verify(treatmentMapper).toDto(treatment);
        assertEquals(8, lucky.getId());

    }

    @Test
    void testDeleteById() {
        Integer id = 1;
        treatmentService.deleteTreatment(id);
        verify(treatmentRepository, times(1)).deleteById(id);
    }

}
