package com.academy.hospital.mapper;

import com.academy.hospital.dto.DiagnosisDto;
import com.academy.hospital.model.entity.Diagnosis;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DiagnosisMapper {

    DiagnosisDto toDto (Diagnosis model);
    Diagnosis toModel (DiagnosisDto dto);

    List<DiagnosisDto> modelsToDto (List<Diagnosis> diagnoses);
    List<Diagnosis> dtoToModels (List<DiagnosisDto> diagnosesDtos);

}
