package com.academy.hospital.service.impl;

import com.academy.hospital.dto.DiagnosisDto;
import com.academy.hospital.mapper.DiagnosisMapper;
import com.academy.hospital.model.entity.Diagnosis;
import com.academy.hospital.model.repository.DiagnosisRepository;
import com.academy.hospital.service.DiagnosisService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiagnosisServiceImpl implements DiagnosisService {

    private final DiagnosisRepository diagnosisRepository;
    private final DiagnosisMapper diagnosisMapper;


    @Override
    public List<DiagnosisDto> findAll() {
        return diagnosisMapper.modelsToDto(diagnosisRepository.findAll());
    }



}
