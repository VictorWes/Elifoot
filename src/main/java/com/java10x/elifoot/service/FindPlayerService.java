package com.java10x.elifoot.service;


import com.java10x.elifoot.controller.response.PlayerDetailResponse;
import com.java10x.elifoot.controller.response.PlayerResponse;
import com.java10x.elifoot.exception.ResourceNotFoundException;
import com.java10x.elifoot.mapper.PlayerMapper;
import com.java10x.elifoot.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindPlayerService {

    private PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;


    public Page<PlayerResponse> findAll(Pageable pageable){
        return playerRepository.findAll(pageable)
                .map(playerMapper::toPlayerResponse);
    }

    public PlayerDetailResponse findById(Long id) {
        return playerRepository.findById(id)
                .map(playerMapper::toPlayerDetailResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with id: " + id));
    }

    public List<PlayerResponse> findByClubId(Long clubId) {
        return playerRepository.findById(clubId)
                .stream()
                .map(playerMapper::toPlayerResponse)
                .toList();
    }


}
