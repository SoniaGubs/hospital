package com.academy.hospital.service.impl;

import com.academy.hospital.dto.DiagnosisDto;
import com.academy.hospital.mapper.DiagnosisMapper;
import com.academy.hospital.model.repository.DiagnosisRepository;
import com.academy.hospital.service.DiagnosisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DiagnosisServiceImpl implements DiagnosisService {
    private final DiagnosisRepository diagnosisRepository;
    private final DiagnosisMapper diagnosisMapper;

    @Override
    public List<DiagnosisDto> findAll() {
        return diagnosisMapper.modelsToDto(diagnosisRepository.findAll());
    }

}
