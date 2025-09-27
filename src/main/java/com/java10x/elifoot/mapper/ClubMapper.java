package com.java10x.elifoot.mapper;

import com.java10x.elifoot.controller.request.CreateClubRequest;
import com.java10x.elifoot.controller.response.ClubDetailResponse;
import com.java10x.elifoot.controller.response.ClubResponse;
import com.java10x.elifoot.entity.Club;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClubMapper {

    ClubResponse toClubResponse(Club club);

    ClubDetailResponse toClubDetailResponse(Club club);

    @Mapping(target = "stadium.id", source = "stadiumId")
    Club toEntity(CreateClubRequest clubRequest);
}
