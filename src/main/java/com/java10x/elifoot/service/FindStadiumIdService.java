package com.java10x.elifoot.service;

import com.java10x.elifoot.controller.response.StadiumResponse;
import com.java10x.elifoot.mapper.StadiumMapper;
import com.java10x.elifoot.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindStadiumIdService {

    private final StadiumRepository stadiumRepository;
    private final StadiumMapper stadiumMapper;

    public Optional<StadiumResponse> findById(Long id) {
        return stadiumRepository.findById(id)
                .map(stadiumMapper::toStadiumResponse);
    }


}
