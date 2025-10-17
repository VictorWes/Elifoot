package com.java10x.elifoot.service;

import com.java10x.elifoot.controller.request.CreatePlayerRequest;
import com.java10x.elifoot.controller.response.PlayerResponse;
import com.java10x.elifoot.entity.Player;
import com.java10x.elifoot.mapper.PlayerMapper;
import com.java10x.elifoot.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;
    private final FindClubService findClubService;

    public PlayerResponse execute(CreatePlayerRequest request){
        Player newPlayer = playerMapper.toEntity(request);
        newPlayer.setClub(findClubService.findById(request.getClubId()));
        Player savedPlayer = playerRepository.save(newPlayer);
        return playerMapper.toPlayerResponse(savedPlayer);
    }

}
