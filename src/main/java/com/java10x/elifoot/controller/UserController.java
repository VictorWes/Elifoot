package com.java10x.elifoot.controller;

import com.java10x.elifoot.controller.request.CreateUserRequest;
import com.java10x.elifoot.controller.response.UserResponse;
import com.java10x.elifoot.service.CreateUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserService createUserService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@Valid @RequestBody CreateUserRequest createUserRequest){
        return createUserService.execute(createUserRequest);
    }

}
