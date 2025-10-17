package com.java10x.elifoot.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.java10x.elifoot.entity.Stadium;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateClubRequest {

    @NotBlank
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotNull
    private LocalDate founded;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String urlImg;

    private Long stadiumId;
}
