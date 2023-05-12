package com.academy.hospital.service.impl;

import com.academy.hospital.model.entity.Diagnosis;
import com.academy.hospital.model.repository.DiagnosisRepository;
import com.academy.hospital.service.DiagnosisService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiagnosisServiceImpl implements DiagnosisService {

    private final DiagnosisRepository diagnosisRepository;

    /*@Override
    public Diagnosis findDiagnosis(Integer id) {
        return diagnosisRepository.getReferenceById(id);
    }
*/
    @Override
    public List<Diagnosis> findAll() {
        return diagnosisRepository.findAll();
    }


   /* @Override
    public Diagnosis save(String name) {
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setDiagnosisName(name);
        diagnosisRepository.save(diagnosis);
        return diagnosis;
    }
*/




}
