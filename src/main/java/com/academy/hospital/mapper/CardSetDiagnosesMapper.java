package com.academy.hospital.mapper;

import com.academy.hospital.dto.CardDto;
import com.academy.hospital.dto.CardSetDiagnosesDto;
import com.academy.hospital.model.entity.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardSetDiagnosesMapper {

    CardSetDiagnosesDto toDto (Card model);

    Card toModel (CardSetDiagnosesDto cardSetDiagnosesDto);

}
