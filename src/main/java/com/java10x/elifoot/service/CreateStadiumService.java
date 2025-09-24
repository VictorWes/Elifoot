package com.java10x.elifoot.service;

import com.java10x.elifoot.controller.request.CreateStadiumRequest;
import com.java10x.elifoot.controller.response.StadiumResponse;
import com.java10x.elifoot.entity.Stadium;
import com.java10x.elifoot.mapper.StadiumMapper;
import com.java10x.elifoot.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateStadiumService {

    private final StadiumRepository stadiumRepository;

    public StadiumResponse execute(CreateStadiumRequest createStadiumRequest) {
        Stadium savedStadium = stadiumRepository.save(StadiumMapper.toStadium(createStadiumRequest));
        return StadiumMapper.toStadiumResponse(savedStadium);

    }

}
