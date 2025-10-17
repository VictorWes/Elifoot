package com.java10x.elifoot.mapper;

import com.java10x.elifoot.controller.request.CreateUserRequest;
import com.java10x.elifoot.controller.response.UserResponse;
import com.java10x.elifoot.entity.Scope;
import com.java10x.elifoot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "scopes", source = "scopes", qualifiedByName = "mapScopesIdsToScopeEntities")
    User toEntity(CreateUserRequest request);

    @Mapping(target = "scopes", source = "scopes", qualifiedByName = "mapScopeEntitiesToStringScopes")
    UserResponse toResponse(User user);

    @Named("mapScopeEntitiesToStringScopes")
    default List<String> mapScopeEntitiesToStringScopes(List<Scope> scopes) {
        if (scopes == null) return List.of();

        return scopes.stream()
                .map(Scope::getName)
                .toList();
    }


    @Named("mapScopesIdsToScopeEntities")
    default List<Scope> mapScopesIdsToScopeEntities(List<Long> scopeIds) {
        if (scopeIds == null) return List.of();

        return scopeIds.stream()
                .map(id -> Scope.builder().id(id).build())
                .toList();
    }


}
