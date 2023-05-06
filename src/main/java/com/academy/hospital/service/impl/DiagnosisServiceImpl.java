package com.academy.hospital.service.impl;

import com.academy.hospital.model.entity.Diagnosis;
import com.academy.hospital.model.repository.DiagnosisRepository;
import com.academy.hospital.service.DiagnosisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiagnosisServiceImpl implements DiagnosisService {

    private final DiagnosisRepository diagnosisRepository;

    @Override
    public Diagnosis save(String name) {
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setDiagnosisName(name);
        diagnosisRepository.save(diagnosis);
        return diagnosis;
    }

    @Override
    public Diagnosis findDiagnosis(Integer id) {
        return diagnosisRepository.getReferenceById(id);
    }


}
