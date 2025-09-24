package com.java10x.elifoot.controller.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StadiumRequest {

    private Long id;
    private String name;
    private String city;
    private Integer capacity;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String urlImage;
}
