package com.java10x.elifoot.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginResponse {

    private String acessToken;
    private Long expiresIn;


}
