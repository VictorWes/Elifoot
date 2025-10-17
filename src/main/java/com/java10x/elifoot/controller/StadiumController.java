package com.java10x.elifoot.controller;

import com.java10x.elifoot.controller.request.CreateStadiumRequest;
import com.java10x.elifoot.controller.response.StadiumResponse;
import com.java10x.elifoot.entity.Stadium;
import com.java10x.elifoot.service.CreateStadiumService;
import com.java10x.elifoot.service.DeleteStadiumService;
import com.java10x.elifoot.service.FindAllStadiumService;
import com.java10x.elifoot.service.FindStadiumIdService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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



    @PreAuthorize("hasAnyAuthority('SCOPE_stadium:read','SCOPE_admin:all')")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<StadiumResponse> findAll(Pageable pageable) {
        return findStadiumService.findAll(pageable);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_stadium:write','SCOPE_admin:all')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StadiumResponse createStadium(@Valid @RequestBody CreateStadiumRequest stadium) {
        return createStadiumService.execute(stadium);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_stadium:write','SCOPE_admin:all')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStadium(@PathVariable Long id) {
        deleteStadiumService.execute(id);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_stadium:read','SCOPE_admin:all')")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Stadium findById(@PathVariable Long id) {
        return findStadiumIdService.findById(id);
    }
}
