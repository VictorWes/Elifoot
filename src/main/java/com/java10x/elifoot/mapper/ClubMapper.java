package com.java10x.elifoot.mapper;

import com.java10x.elifoot.controller.request.ClubRequest;
import com.java10x.elifoot.controller.response.ClubResponse;
import com.java10x.elifoot.entity.Club;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClubMapper {

    ClubResponse toClubResponse(Club club);

    Club toClub(ClubRequest clubRequest);
}
