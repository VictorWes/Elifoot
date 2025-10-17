package com.java10x.elifoot.controller.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.java10x.elifoot.controller.response.ClubResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePlayerRequest {

    @NotBlank
    private String name;

    @NotNull
    private String position;

    @NotNull
    private int shirtNumber;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String urlImg;

    @NotNull
    private Long clubId;
}
