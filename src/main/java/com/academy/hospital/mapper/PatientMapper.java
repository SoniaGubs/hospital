package com.academy.hospital.mapper;

import com.academy.hospital.dto.PatientDto;
import com.academy.hospital.model.entity.Patient;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PatientMapper {

    PatientDto toDto (Patient model);
    Patient toModel (PatientDto dto);

    List<PatientDto> modelsToDto (List<Patient> patients);
    List<Patient> dtoToModels (List<PatientDto> patients);

}
