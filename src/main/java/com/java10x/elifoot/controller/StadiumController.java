package com.java10x.elifoot.controller;

import com.java10x.elifoot.entity.Stadium;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stadiums")
public class StadiumController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Stadium> findAll(Pageable pageable) {

    }


}
