package com.jamesball.cockpit.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CockpitRestControllerIntegrationTests {

    @LocalServerPort
    private Integer port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAllMetrics() throws Exception {
        ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:" + port + "/cockpit/metric", List.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void getAllObjectives() throws Exception {
        ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:" + port + "/cockpit/objective", List.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void getAllProjects() throws Exception {
        ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:" + port + "/cockpit/project", List.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

}
