package com.academy.hospital.service.impl;

import com.academy.hospital.model.entity.Treatment;
import com.academy.hospital.model.repository.TreatmentRepository;
import com.academy.hospital.service.TreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TreatmentServiceImpl implements TreatmentService {

    private final TreatmentRepository treatmentRepository;

    @Override
    public List<Treatment> findAll() {
        return treatmentRepository.findAll();
    }
}
