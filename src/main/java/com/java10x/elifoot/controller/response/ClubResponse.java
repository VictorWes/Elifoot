package com.java10x.elifoot.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;


public class ClubResponse {

    private Long id;
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate founded;

}
