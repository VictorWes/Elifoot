package com.java10x.elifoot.mapper;

import com.java10x.elifoot.controller.request.CreatePlayerRequest;
import com.java10x.elifoot.controller.response.PlayerDetailResponse;
import com.java10x.elifoot.controller.response.PlayerResponse;
import com.java10x.elifoot.entity.Player;
import com.java10x.elifoot.enums.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PlayerMapper {


    @Mapping(target = "position", source = "position", qualifiedByName = "enumToString")
    PlayerResponse toPlayerResponse(Player player);

    @Mapping(target = "position", source = "position", qualifiedByName = "enumToString")
    PlayerDetailResponse toPlayerDetailResponse(Player player);

    @Mapping(target = "club.id", source = "clubId")
    Player toEntity(CreatePlayerRequest request);

   @Named("enumToString")
    default String mapPositionToString(Position position) {
        return position != null ? position.getLabel() : null;
    }




}
