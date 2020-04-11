package com.jamesball.cockpit.controller;

import com.jamesball.cockpit.service.MetricService;
import com.jamesball.cockpit.service.ObjectiveService;
import com.jamesball.cockpit.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CockpitApplicationRestController.class)
public class CockpitRestControllerUnitTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MetricService metricService;

    @MockBean
    private ObjectiveService objectiveService;

    @MockBean
    private ProjectService projectService;

    @Test
    public void getAllMetrics() throws Exception {
        mockMvc.perform(get("/cockpit/metric"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));
        verify(metricService, times(1)).findAllMetrics();
    }

    @Test
    public void getAllObjectives() throws Exception {
        mockMvc.perform(get("/cockpit/objective"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));
        verify(objectiveService, times(1)).findAllObjectives();
    }

    @Test
    public void getAllProjects() throws Exception {
        mockMvc.perform(get("/cockpit/project"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));
        verify(projectService, times(1)).findAllProjects();
    }

}
