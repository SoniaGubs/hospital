package com.academy.hospital.service;

import com.academy.hospital.dto.TreatmentDto;
import com.academy.hospital.exceptions.TreatmentException;

import java.util.List;

public interface TreatmentService {

    TreatmentDto findById(Integer id);

    void save(TreatmentDto treatmentDto);

    List<TreatmentDto> findByCardId(Integer id);

    List<TreatmentDto> findCompletedTreatment(Integer id);

    List<TreatmentDto> findNotCompletedTreatment(Integer id);

    void deleteTreatment(Integer id);

    void doTreatment(Integer id, Integer userId) throws TreatmentException;


}
