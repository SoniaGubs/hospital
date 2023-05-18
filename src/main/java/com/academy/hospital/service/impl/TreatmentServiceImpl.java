package com.academy.hospital.service.impl;

import com.academy.hospital.dto.CardDto;
import com.academy.hospital.dto.TreatmentDto;
import com.academy.hospital.mapper.CardMapper;
import com.academy.hospital.mapper.TreatmentMapper;
import com.academy.hospital.model.entity.Card;
import com.academy.hospital.model.entity.Treatment;
import com.academy.hospital.model.repository.CardRepository;
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

    @Override
    public TreatmentDto findById(Integer id) {
        return treatmentMapper.toDto(treatmentRepository.getReferenceById(id));
    }

    @Override
    public void save(TreatmentDto treatmentDto) {
        treatmentDto.setDateOfPrescription(LocalDate.now());
        Treatment treatment = treatmentMapper.toModel(treatmentDto);
       treatmentRepository.save(treatment) ;
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

}
