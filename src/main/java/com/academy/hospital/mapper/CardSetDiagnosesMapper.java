package com.academy.hospital.mapper;

import com.academy.hospital.dto.CardSetDiagnosesDto;
import com.academy.hospital.model.entity.Card;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper( uses = {DiagnosisMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface CardSetDiagnosesMapper {

    CardSetDiagnosesDto toDto(Card model);

    Card toModel(CardSetDiagnosesDto cardSetDiagnosesDto);


}
