package com.example.docker_project.restcontrollers;

import com.example.docker_project.dtos.PackItemDto;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
@Sql("/databases/create_pack_item.sql")
class PackItemControllerTest {
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
    @WithMockUser(username = "testUser")
    public void save() throws Exception {
        PackItemDto packItemDto = new PackItemDto();
        packItemDto.setItem("test item");
        packItemDto.setDescription("test description");
        packItemDto.setItem_count(1);
        packItemDto.setId(7L);

        mockMvc.perform(post("/pack/item/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(packItemDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.item").value("test item"));
    }

    @Test
    @WithMockUser(username = "testUser")
    public void showPackItemsByHolidayId() throws Exception {
        mockMvc.perform(get("/pack/item//showByHolidayId/6"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].item").value("car"));

    }
}