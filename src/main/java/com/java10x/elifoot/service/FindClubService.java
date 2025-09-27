package com.java10x.elifoot.service;

import com.java10x.elifoot.controller.response.ClubResponse;
import com.java10x.elifoot.entity.Club;
import com.java10x.elifoot.exception.ResourceNotFoundException;
import com.java10x.elifoot.mapper.ClubMapper;
import com.java10x.elifoot.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindClubService {

    private final ClubRepository clubRepository;
    private final ClubMapper clubMapper;

    public Page<ClubResponse> findAll(Pageable pageable) {
        return clubRepository.findAll(pageable)
                .map(clubMapper::toClubResponse);
    }


    public Club findById(Long id) {
        return clubRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Club not found with id: " + id));
    }
}
