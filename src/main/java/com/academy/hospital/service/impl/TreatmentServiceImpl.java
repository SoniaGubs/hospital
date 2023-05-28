package com.academy.hospital.service.impl;

import com.academy.hospital.dto.CardDto;
import com.academy.hospital.dto.TreatmentDto;
import com.academy.hospital.exceptions.TreatmentException;
import com.academy.hospital.mapper.CardMapper;
import com.academy.hospital.mapper.StaffMapper;
import com.academy.hospital.mapper.TreatmentMapper;
import com.academy.hospital.model.entity.*;
import com.academy.hospital.model.repository.CardRepository;
import com.academy.hospital.model.repository.StaffRepository;
import com.academy.hospital.model.repository.TreatmentRepository;
import com.academy.hospital.service.TreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TreatmentServiceImpl implements TreatmentService {

    private final TreatmentRepository treatmentRepository;

    private final TreatmentMapper treatmentMapper;
    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;

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
        //TreatmentDto treatmentDto = findById(id);

        Treatment treatment = treatmentRepository.getReferenceById(id);

        Staff staff = staffRepository.findByUser_Id(userId);
        if ((staff.getUser().getRoles().get(0) == Role.ROLE_NURSE) && (treatment.getTreatmentType() == TreatmentType.OPERATION)) {
            throw new TreatmentException("Nurse can not do operations");
        }
        treatment.setDateOfCompletion(LocalDate.now());
        treatment.setStaff(staff);
        treatmentRepository.save(treatment);
    }

}
