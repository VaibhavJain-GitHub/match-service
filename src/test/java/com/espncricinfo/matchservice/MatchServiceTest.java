package com.espncricinfo.matchservice;

import com.espncricinfo.matchservice.model.Match;
import com.espncricinfo.matchservice.service.MatchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MatchServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MatchService matchService;

    @Test
    public void testCreateMatch() throws Exception {
        String matchJson = "{\"team1\":\"Team A\",\"team2\":\"Team B\",\"venue\":\"Stadium\",\"date\":\"2024-06-01\",\"status\":\"Scheduled\"}";
        mockMvc.perform(post("/api/matches/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(matchJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.team1").value("Team A"))
                .andExpect(jsonPath("$.team2").value("Team B"));
    }
}
