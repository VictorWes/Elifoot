package com.java10x.elifoot.service;

import com.java10x.elifoot.controller.request.CreateClubRequest;
import com.java10x.elifoot.controller.response.ClubDetailResponse;
import com.java10x.elifoot.entity.Club;
import com.java10x.elifoot.mapper.ClubMapper;
import com.java10x.elifoot.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CreateClubService {

    private final ClubRepository clubRepository;
    private final ClubMapper clubMapper;
    private final FindStadiumIdService findStadiumIdService;

    public ClubDetailResponse execute(CreateClubRequest name) {
        Club newClub = clubMapper.toEntity(name);
        if (Objects.nonNull(newClub.getStadium())){
           newClub.setStadium(findStadiumIdService.findById(newClub.getStadium().getId()));
        }

        Club savedClub = clubRepository.save(newClub);
        return clubMapper.toClubDetailResponse(savedClub);
    }



}
