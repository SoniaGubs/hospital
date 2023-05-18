package com.academy.hospital.mapper;

import com.academy.hospital.dto.TreatmentDto;
import com.academy.hospital.model.entity.Treatment;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(uses = {CardMapper.class}, componentModel = "spring")
public interface TreatmentMapper {

    TreatmentDto toDto(Treatment model);
    Treatment toModel(TreatmentDto dto);
    List<TreatmentDto> modelsToDto(List<Treatment> treatments);
    List<Treatment> dtoToModels(List<TreatmentDto> treatmentsDtos);


}
