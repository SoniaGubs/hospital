package com.academy.hospital.service.impl;

import com.academy.hospital.model.entity.Reception;
import com.academy.hospital.model.repository.ReceptionRepository;
import com.academy.hospital.service.ReceptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceptionServiceImpl implements ReceptionService {

    private final ReceptionRepository receptionRepository;

    @Override
    public List<Reception> findAll() {
        return receptionRepository.findAll();
    }

    @Override
    public Reception findReception (Integer id) {
        return receptionRepository.getReferenceById(id);
    }

    @Override
    public List<Reception> findSick() {
        return receptionRepository.findByDateOfDischargeIsNull();
    }
}
