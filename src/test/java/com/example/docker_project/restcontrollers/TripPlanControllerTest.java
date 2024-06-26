package com.example.docker_project.restcontrollers;

import com.example.docker_project.dtos.HolidayDto;
import com.example.docker_project.dtos.TripPlanDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
@Sql("/databases/create_trip_plan.sql")
class TripPlanControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void createTripPlan() throws Exception {
        TripPlanDto tripPlanDto = new TripPlanDto();
        tripPlanDto.setDescription("description");

        mockMvc.perform(post("/trip/plan/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(tripPlanDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "testUser", roles = {"USER"})
    void createTripPlanWithHoliday() throws Exception {
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

        TripPlanDto tripPlanDto = new TripPlanDto();
        tripPlanDto.setDescription("description");
        tripPlanDto.setHolidayId(1L);

        mockMvc.perform(post("/trip/plan/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(tripPlanDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("description"));

    }
}