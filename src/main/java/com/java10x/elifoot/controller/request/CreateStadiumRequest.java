package com.java10x.elifoot.controller.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateStadiumRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String city;
    private Integer capacity;

    private String urlImg;
}
