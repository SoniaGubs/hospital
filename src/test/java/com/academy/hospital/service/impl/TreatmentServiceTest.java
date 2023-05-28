package com.academy.hospital.service.impl;

import com.academy.hospital.dto.TreatmentDto;
import com.academy.hospital.exceptions.TreatmentException;
import com.academy.hospital.mapper.PatientMapper;
import com.academy.hospital.mapper.TreatmentMapper;
import com.academy.hospital.model.entity.Role;
import com.academy.hospital.model.entity.Staff;
import com.academy.hospital.model.entity.Treatment;
import com.academy.hospital.model.entity.TreatmentType;
import com.academy.hospital.model.repository.PatientRepository;
import com.academy.hospital.model.repository.TreatmentRepository;
import com.academy.hospital.service.TreatmentService;
import com.academy.hospital.service.impl.PatientServiceImpl;
import com.academy.hospital.service.impl.TreatmentServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
@ExtendWith(MockitoExtension.class)
public class TreatmentServiceTest {

    @InjectMocks
    private TreatmentService treatmentService;

    @Mock
    private TreatmentMapper treatmentMapper;

    @Mock
    private TreatmentRepository treatmentRepository;



/*
    @Override
    public TreatmentDto findById(Integer id) {
        return treatmentMapper.toDto(treatmentRepository.getReferenceById(id));
    }

    @Override
    public void save(TreatmentDto treatmentDto) {
        treatmentDto.setDateOfPrescription(LocalDate.now());
        Treatment treatment = treatmentMapper.toModel(treatmentDto);
        treatmentRepository.save(treatment);
    }


    @Override
    public List<TreatmentDto> findByCardId(Integer id) {
        return treatmentMapper.modelsToDto(treatmentRepository.findByCard_Id(id));
    }

    @Override
    public List<TreatmentDto> findCompletedTreatment(Integer id) {
        return treatmentMapper.modelsToDto(treatmentRepository.findByCard_IdAndDateOfCompletionIsNotNull(id));
    }

    @Override
    public List<TreatmentDto> findNotCompletedTreatment(Integer id) {
        return treatmentMapper.modelsToDto(treatmentRepository.findByCard_IdAndDateOfCompletionIsNull(id));
    }

    @Override
    public void deleteTreatment(Integer id) {
        treatmentRepository.deleteById(id);
    }

    @Override
    public void doTreatment(Integer id, Integer userId) throws TreatmentException {
        Treatment treatment = treatmentRepository.getReferenceById(id);
        Staff staff = staffRepository.getReferenceById(userId);
        if ((staff.getUser().getRoles().get(0) == Role.ROLE_NURSE) && (treatment.getTreatmentType() == TreatmentType.OPERATION)) {
            throw new TreatmentException("Nurse can not do operations");
        }
        treatment.setDateOfCompletion(LocalDate.now());
        treatment.setStaff(staff);
        treatmentRepository.save(treatment);
    }*/



}
