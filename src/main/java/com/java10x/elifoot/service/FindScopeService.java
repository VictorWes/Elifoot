package com.java10x.elifoot.service;

import com.java10x.elifoot.entity.Scope;
import com.java10x.elifoot.repository.ScopeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindScopeService {

    private final ScopeRepository scopeRepository;

    public Scope findById(Long id){
        return scopeRepository.findById(id).orElseThrow(() -> new RuntimeException("Scope not found"));
    }



}
