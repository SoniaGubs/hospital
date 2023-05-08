package com.academy.hospital.mapper;

import com.academy.hospital.dto.CardDto;
import com.academy.hospital.model.entity.Card;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {
    CardDto toDto (Card model);
    Card toModel (CardDto cardDto);


    List<CardDto> modelsToDto (List<Card> cards);
}
