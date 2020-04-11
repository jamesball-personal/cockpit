package com.jamesball.cockpit.resolver;

import com.jamesball.cockpit.entity.Objective;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ObjectiveQueryResolverIntegrationTests {

    @MockBean
    private ObjectiveQueryResolver objectiveQueryResolver;

    @Test
    public void getAllObjectives() throws IOException {
        Iterable<Objective> result = objectiveQueryResolver.findAllObjectives();
        assertNotNull(result);
    }

}
