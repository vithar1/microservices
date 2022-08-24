package com.example.demo.rest;

import com.example.demo.BaseIntegrationTest;
import com.example.demo.service.OrganizationFeignClient;
import com.netflix.discovery.EurekaClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testcontainers.shaded.org.awaitility.Awaitility.await;

class OrganizationControllerTest extends BaseIntegrationTest {
    @Autowired
    private OrganizationFeignClient organizationFeignClient;

    @Lazy
    @Autowired
    private EurekaClient eurekaClient;


    @BeforeEach
    void setUp() {
        await().atMost(60, SECONDS).until(() -> eurekaClient.getApplications().size() > 0);
    }


    @Test
    void getOrgId() {
        assertThat(organizationFeignClient.getOrgId("fdsf").getBody()).isEqualTo("org-idd-fdsf");
    }
}