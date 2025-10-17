package com.java10x.elifoot.controller;

import com.java10x.elifoot.BaseIntegrationTest;
import com.java10x.elifoot.controller.request.CreateStadiumRequest;
import com.java10x.elifoot.entity.Stadium;
import com.java10x.elifoot.repository.StadiumRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.Matchers.greaterThan;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class StadiumControllerTest extends BaseIntegrationTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    StadiumRepository stadiumRepository;

    @BeforeEach
    void setUp() {
        stadiumRepository.deleteAll();
        stadiumRepository.save(
                Stadium.builder()
                        .name("Estádio Centenário")
                        .city("Montevidéu")
                        .capacity(60000)
                        .urlImg("http://img.com/centenario.jpg")
                        .build()
        );
    }

    @WithMockUser(authorities = {"SCOPE_stadium:write"})
    @Test
    void createStadium() throws Exception {

        CreateStadiumRequest request = CreateStadiumRequest.builder()
                .name("Stadium A")
                .city("City A")
                .capacity(50000)
                .urlImg("http://example.com/stadiumA.jpg")
                .build();

        mockMvc.perform(post("/stadiums")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
        .andExpect(jsonPath("$.name").value(request.getName()))
        .andExpect(jsonPath("$.city").value(request.getCity()))
        .andExpect(jsonPath("$.capacity").value(request.getCapacity()))
        .andExpect(jsonPath("$.urlImg").value(request.getUrlImg()))
                .andExpect(jsonPath("$.id").isNotEmpty());



    }

    @WithMockUser(authorities = {"SCOPE_stadium:read"})
    @Test
    void findAll() throws Exception {

        mockMvc.perform(get("/stadiums"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content").isNotEmpty())
                .andExpect(jsonPath("$.content.length()", greaterThan(0)));

    }

    @WithMockUser(authorities = {"SCOPE_stadium:read"})
    @Test
    @DisplayName("Should return 403 when user lacks write scope")
    void shouldReturnForbiddenWhenUserLacksWriteScope() throws Exception {
        CreateStadiumRequest request = new CreateStadiumRequest("Novo estadio", "Pelotas", 60000, "http://img.com/pelotas.jpg");

        mockMvc.perform(post("/stadiums")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isForbidden());
    }

    @WithMockUser(authorities = {"SCOPE_stadium:write"})
    @Test
    @DisplayName("Should return 400 when request is invalid")
    void shouldReturnBadRequestWhenRequestIsInvalid() throws Exception {
        CreateStadiumRequest request = new CreateStadiumRequest(
                null,
                null,
                40000,
                "http://img.com/centenario.jpg"
        );

        mockMvc.perform(post("/stadiums")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors.city").exists())
                .andExpect(jsonPath("$.errors.name").exists());
    }
    @Test
    void deleteStadium() {
    }

    @Test
    void findById() {
    }
}