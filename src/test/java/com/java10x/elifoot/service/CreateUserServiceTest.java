package com.java10x.elifoot.service;

import com.java10x.elifoot.controller.request.CreateUserRequest;
import com.java10x.elifoot.exception.ResourceAlreadyExistException;
import com.java10x.elifoot.exception.ResourceNotFoundException;
import com.java10x.elifoot.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateUserServiceTest {

    @InjectMocks
    CreateUserService createUserService;

    @Mock
    UserRepository userRepository;


    @Test
    void execute() {

        CreateUserRequest request = CreateUserRequest.builder()
                .name("User Test")
                .email("teste")
                .password("123456")
                .scopes(List.of(1L, 2L, 3L))
                .build();

        Mockito.when(userRepository.existsByEmail(request.getEmail())).thenReturn(true);

        ResourceAlreadyExistException exception = assertThrows(ResourceAlreadyExistException.class, () ->{
            createUserService.execute(request);
        });

        Assertions.assertEquals(exception.getMessage(), "Email already in use" + request.getEmail());


    }
}