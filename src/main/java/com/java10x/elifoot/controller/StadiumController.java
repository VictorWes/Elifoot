package com.java10x.elifoot.controller;

import com.java10x.elifoot.controller.request.CreateStadiumRequest;
import com.java10x.elifoot.controller.response.StadiumResponse;
import com.java10x.elifoot.entity.Stadium;
import com.java10x.elifoot.service.CreateStadiumService;
import com.java10x.elifoot.service.DeleteStadiumService;
import com.java10x.elifoot.service.FindAllStadiumService;
import com.java10x.elifoot.service.FindStadiumIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/stadiums")
@RequiredArgsConstructor
public class StadiumController {

    private final FindAllStadiumService findStadiumService;
    private final CreateStadiumService createStadiumService;
    private final DeleteStadiumService deleteStadiumService;
    private final FindStadiumIdService findStadiumIdService;



    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<StadiumResponse> findAll(Pageable pageable) {
        return findStadiumService.findAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StadiumResponse createStadium(@RequestBody CreateStadiumRequest stadium) {
        return createStadiumService.execute(stadium);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStadium(@PathVariable Long id) {
        deleteStadiumService.execute(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Stadium findById(@PathVariable Long id) {
        return findStadiumIdService.findById(id);
    }
}
