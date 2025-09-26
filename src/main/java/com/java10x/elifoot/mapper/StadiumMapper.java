package com.java10x.elifoot.mapper;

import com.java10x.elifoot.controller.request.CreateStadiumRequest;
import com.java10x.elifoot.controller.response.StadiumResponse;
import com.java10x.elifoot.entity.Stadium;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StadiumMapper {

      StadiumResponse toStadiumResponse(Stadium stadium);

      Stadium toStadium(CreateStadiumRequest createStadiumRequest);


}
