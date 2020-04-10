package com.jamesball.cockpit.resolver;

import com.jamesball.cockpit.entity.Metric;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MetricQueryResolverIntegrationTests {

    @MockBean
    private MetricQueryResolver metricQueryResolver;

    @Test
    public void getAllMetrics() throws IOException {
        Iterable<Metric> result = metricQueryResolver.findAllMetrics();
        assertNotNull(result);
    }

}
