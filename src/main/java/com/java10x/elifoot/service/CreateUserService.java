package com.java10x.elifoot.service;

import com.java10x.elifoot.controller.request.CreateUserRequest;
import com.java10x.elifoot.controller.response.UserResponse;
import com.java10x.elifoot.entity.Scope;
import com.java10x.elifoot.entity.User;
import com.java10x.elifoot.exception.ResourceAlreadyExistException;
import com.java10x.elifoot.mapper.UserMapper;
import com.java10x.elifoot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateUserService {

    private final UserRepository userRepository;
    private final FindScopeService findScopeService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;



    public UserResponse execute(CreateUserRequest request){
        if (userRepository.existsByEmail(request.getEmail())){
            throw new ResourceAlreadyExistException("Email already in use" + request.getEmail());
        };

        List<Scope> scopes = request.getScopes().stream()
                .map(findScopeService::findById)
                .toList();

        User newUser = userMapper.toEntity(request);
        newUser.setScopes(scopes);
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        User savedUser = userRepository.save(newUser);
        return userMapper.toResponse(savedUser);


    }


}
