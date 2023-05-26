package com.academy.hospital.service.impl;

import com.academy.hospital.dto.PatientDto;
import com.academy.hospital.mapper.PatientMapper;
import com.academy.hospital.model.entity.Patient;
import com.academy.hospital.model.repository.PatientRepository;
import com.academy.hospital.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public PatientDto find(Integer id) {
        return patientMapper.toDto(patientRepository.getReferenceById(id));
    }

    @Override
    public List<PatientDto> findAll() {
        return patientMapper.modelsToDto(patientRepository.findAll());
    }

    @Override
    public List<PatientDto> findByParametersAndOrderByName(String surname, String name, String patronymic) {
        if (Objects.equals(name, "")) {
            return patientMapper.modelsToDto(patientRepository.findBySurnameOrderByNameAsc(surname));
        } else if (Objects.equals(patronymic, "")) {
            return patientMapper.modelsToDto(patientRepository.findBySurnameAndNameOrderByNameAsc(surname, name));
        } else {
            return patientMapper.modelsToDto(patientRepository.findBySurnameAndNameAndPatronymicOrderByNameAsc(surname, name, patronymic));
        }
    }


    @Override
    public PatientDto save(PatientDto patientDto) {
        Patient patient = patientMapper.toModel(patientDto);
        patientRepository.save(patient);
        return patientMapper.toDto(patient);
    }


}
