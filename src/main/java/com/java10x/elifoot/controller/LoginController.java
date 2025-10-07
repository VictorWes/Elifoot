package com.java10x.elifoot.controller;

import com.java10x.elifoot.controller.request.LoginRequest;
import com.java10x.elifoot.controller.response.LoginResponse;
import com.java10x.elifoot.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/login")
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@Valid @RequestBody LoginRequest request){
        return loginService.login(request);
    }


}
