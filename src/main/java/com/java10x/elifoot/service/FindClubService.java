package com.java10x.elifoot.service;

import com.java10x.elifoot.controller.request.ClubRequest;
import com.java10x.elifoot.controller.response.ClubResponse;
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


}
