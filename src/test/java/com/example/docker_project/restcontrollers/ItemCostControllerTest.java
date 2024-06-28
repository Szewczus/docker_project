package com.example.docker_project.restcontrollers;

import com.example.docker_project.dtos.ItemCostDto;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
@Sql("/databases/create_item_cost.sql")
class ItemCostControllerTest {
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
    @WithMockUser(username = "testUser", roles = {"USER"})
    void save() throws Exception {

        ItemCostDto itemCostDto = new ItemCostDto();
        itemCostDto.setCost(1000.0);
        itemCostDto.setItem("car");
        itemCostDto.setId(5L);

        mockMvc.perform(post("/item/cost/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(itemCostDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    @WithMockUser(username = "testUser", roles = {"USER"})
    void showItemsCosts() throws Exception {
        mockMvc.perform(get("/item/cost/showAllItemCostsByHolidayId/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}