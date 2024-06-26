package com.example.docker_project.restcontrollers;

import com.example.docker_project.dtos.HolidayDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.security.test.context.support.WithMockUser;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@Sql("/databases/create_holiday.sql")
class HolidayControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @WithMockUser(username = "testUser", roles = {"USER"})
    void addHoliday() throws Exception {
        HolidayDto holidayDto = new HolidayDto();
        holidayDto.setAccomodation_cost(2000.0);
        holidayDto.setArrive_date("27.06.2024");
        holidayDto.setDeparture_date("27.06.2024");
        holidayDto.setTravel_destination("Croatia");
        holidayDto.setDestination_address("Croatia 5");

        this.mockMvc.perform(post("/holiday/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(holidayDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }
}