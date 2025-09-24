package com.java10x.elifoot.service;

import com.java10x.elifoot.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteStadiumService {

    private final StadiumRepository stadiumRepository;

    public void execute(Long id) {
        stadiumRepository.deleteById(id);
    }


}
