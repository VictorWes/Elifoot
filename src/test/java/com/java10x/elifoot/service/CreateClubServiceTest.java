package com.java10x.elifoot.service;

import com.java10x.elifoot.controller.request.CreateClubRequest;
import com.java10x.elifoot.controller.response.ClubDetailResponse;
import com.java10x.elifoot.entity.Club;
import com.java10x.elifoot.entity.Stadium;
import com.java10x.elifoot.mapper.ClubMapper;
import com.java10x.elifoot.repository.ClubRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateClubServiceTest {

    @InjectMocks
    CreateClubService createClubService;

    @Mock
    ClubRepository clubRepository;
    @Mock
    ClubMapper clubMapper;
    @Mock
    FindAllStadiumService findAllStadiumService;
    @Mock
    FindStadiumIdService findStadiumIdService;
    @Captor
    ArgumentCaptor<Club> clubArgumentCaptor;

    @Test
    void execute() {

        //Arrange
        CreateClubRequest request = CreateClubRequest.builder()
                .name("Club A")
                .founded(LocalDate.of(2000, 1, 1))
                .urlImg("TEST URL")
                .stadiumId(1L)
                .build();

        Club testeClub = Club.builder()
                .id(1L)
                .name("Club A")
                .founded(LocalDate.of(2000, 1, 1))
                .urlImg("TEST URL")
                .stadium(Stadium.builder().id(10L).build())
                .build();

        Stadium stadium = Stadium.builder()
                .id(10L)
                .name("Stadium A")
                .city("test city")
                .capacity(50000)
                .urlImg("TEST URL")
                .build();

        Mockito.when(clubMapper.toEntity(request)).thenReturn(testeClub);
        Mockito.when(findStadiumIdService.findById(stadium.getId())).thenReturn(stadium);

        //Action
        ClubDetailResponse execute = createClubService.execute(request);

        //Assert
        Mockito.verify(clubMapper).toEntity(request);
        Mockito.verify(findStadiumIdService).findById(stadium.getId());
        Mockito.verify(clubRepository).save(Mockito.any(Club.class));


        Mockito.verify(clubRepository).save(clubArgumentCaptor.capture());
        Club savedClub = clubArgumentCaptor.getValue();

        assertNotNull(savedClub);
        assertEquals(testeClub.getName(), savedClub.getName());
        assertEquals(testeClub.getFounded(), savedClub.getFounded());
        assertEquals(testeClub.getUrlImg(), savedClub.getUrlImg());
        assertNotNull(savedClub.getStadium());
        assertEquals(stadium.getId(), savedClub.getStadium().getId());
        assertEquals(stadium.getName(), savedClub.getStadium().getName());
        assertEquals(stadium.getCity(), savedClub.getStadium().getCity());
        assertEquals(stadium.getCapacity(), savedClub.getStadium().getCapacity());
        assertEquals(stadium.getUrlImg(), savedClub.getStadium().getUrlImg());

    }
}