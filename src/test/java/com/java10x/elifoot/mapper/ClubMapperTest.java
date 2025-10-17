package com.java10x.elifoot.mapper;

import com.java10x.elifoot.controller.request.CreateClubRequest;
import com.java10x.elifoot.controller.response.ClubDetailResponse;
import com.java10x.elifoot.controller.response.ClubResponse;
import com.java10x.elifoot.entity.Club;
import com.java10x.elifoot.entity.Stadium;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class ClubMapperTest {

    private final ClubMapper mapper = Mappers.getMapper(ClubMapper.class);

    @Test
    void toClubResponse() {

        Club club = Club.builder()
                .id(1L)
                .name("Club A")
                .founded(null)
                .build();

        ClubResponse clubResponse = mapper.toClubResponse(club);

        assertNotNull(clubResponse);
        assertEquals(club.getId(), clubResponse.getId());
        assertEquals(club.getName(), clubResponse.getName());
        assertEquals(club.getFounded(), clubResponse.getFounded());

    }

    @Test
    void toClubDetailResponse() {

        Club club = Club.builder()
                .id(1L)
                .name("Club A")
                .founded(null)
                .urlImg("teste url")
                .stadium(Stadium.builder().id(2L).build())
                .build();

        ClubDetailResponse clubDetailResponse = mapper.toClubDetailResponse(club);

        assertNotNull(clubDetailResponse);
        assertEquals(club.getId(), clubDetailResponse.getId());
        assertEquals(club.getName(), clubDetailResponse.getName());
        assertEquals(club.getFounded(), clubDetailResponse.getFounded());
        assertEquals(club.getUrlImg(), clubDetailResponse.getUrlImg());
        assertEquals(club.getStadium(), clubDetailResponse.getStadium());



    }

    @Test
    void toEntity() {

        CreateClubRequest clubRequest = CreateClubRequest.builder()
                .name("Club A")
                .founded(null)
                .urlImg("teste url")
                .stadiumId(2L)
                .build();

        Club club = mapper.toEntity(clubRequest);

        assertNotNull(club);
        assertEquals(clubRequest.getName(), club.getName());
        assertEquals(clubRequest.getFounded(), club.getFounded());
        assertEquals(clubRequest.getUrlImg(), club.getUrlImg());
        assertNotNull(club.getStadium());
        assertEquals(clubRequest.getStadiumId(), club.getStadium().getId());
        

    }
}