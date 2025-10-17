package com.java10x.elifoot.mapper;

import com.java10x.elifoot.controller.request.CreateStadiumRequest;
import com.java10x.elifoot.controller.response.StadiumResponse;
import com.java10x.elifoot.entity.Stadium;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class StadiumMapperTest {

    private final StadiumMapper mapper = Mappers.getMapper(StadiumMapper.class);

    @Test
    void toStadiumResponse() {

        Stadium stadium = Stadium.builder()
                .id(1L)
                .name("Stadium A")
                .city("test city")
                .capacity(50000)
                .urlImg("TEST URL")
                .build();

        StadiumResponse stadiumResponse = mapper.toStadiumResponse(stadium);

        assertNotNull(stadiumResponse);
        assertEquals(stadium.getId(), stadiumResponse.getId());
        assertEquals(stadium.getName(), stadiumResponse.getName());
        assertEquals(stadium.getCity(), stadiumResponse.getCity());
        assertEquals(stadium.getCapacity(), stadiumResponse.getCapacity());
        assertEquals(stadium.getUrlImg(), stadiumResponse.getUrlImg());
    }

    @Test
    void toStadium() {

        CreateStadiumRequest request = CreateStadiumRequest.builder()
                .name("Stadium A")
                .city("test city")
                .capacity(50000)
                .urlImg("TEST URL")
                .build();

        Stadium stadium = mapper.toStadium(request);

        assertNotNull(stadium);
        assertEquals(request.getName(), stadium.getName());
        assertEquals(request.getCity(), stadium.getCity());
        assertEquals(request.getCapacity(), stadium.getCapacity());
        assertEquals(request.getUrlImg(), stadium.getUrlImg());


    }
}