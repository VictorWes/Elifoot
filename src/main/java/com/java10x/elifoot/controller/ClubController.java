package com.java10x.elifoot.controller;

import com.java10x.elifoot.controller.request.CreateClubRequest;
import com.java10x.elifoot.controller.response.ClubDetailResponse;
import com.java10x.elifoot.controller.response.ClubResponse;
import com.java10x.elifoot.entity.Club;
import com.java10x.elifoot.mapper.ClubMapper;
import com.java10x.elifoot.service.CreateClubService;
import com.java10x.elifoot.service.FindClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clubs")
@RequiredArgsConstructor
public class ClubController {

    private final FindClubService findClubService;
    private final CreateClubService createClubService;
    private final ClubMapper clubMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ClubResponse> findAll(Pageable pageable){
        return findClubService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClubDetailResponse findById(@PathVariable Long id){
        Club byId = findClubService.findById(id);
        return clubMapper.toClubDetailResponse(byId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClubDetailResponse createClub(@RequestBody CreateClubRequest request){
        return createClubService.execute(request);
    }

}
