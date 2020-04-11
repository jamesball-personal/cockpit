package com.jamesball.cockpit.resolver;

import com.jamesball.cockpit.entity.Project;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProjectQueryResolverIntegrationTests {

    @MockBean
    private ProjectQueryResolver projectQueryResolver;

    @Test
    public void getAllProjects() throws IOException {
        Iterable<Project> result = projectQueryResolver.findAllProjects();
        assertNotNull(result);
    }

}
