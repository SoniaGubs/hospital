package com.academy.hospital.mapper;

import com.academy.hospital.dto.StaffDto;
import com.academy.hospital.model.entity.Staff;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)

public interface StaffMapper {

    StaffDto toDto (Staff model);
    Staff toModel (StaffDto dto);

    List<StaffDto> modelsToDto (List<Staff> staff);
    List<Staff> dtoToModels (List<StaffDto> staffDtos);


}
