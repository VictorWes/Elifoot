package com.java10x.elifoot.service;

import com.java10x.elifoot.controller.response.StadiumResponse;
import com.java10x.elifoot.mapper.StadiumMapper;
import com.java10x.elifoot.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FindStadiumService {

    private final StadiumRepository stadiumRepository;

    public Page<StadiumResponse> findAll(Pageable pageable) {
        return stadiumRepository.findAll(pageable)
                .map(StadiumMapper::toStadiumResponse);
    }



}
