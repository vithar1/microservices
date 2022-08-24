package com.example.demo.rest;

import com.example.demo.BaseIntegrationTest;
import com.example.demo.config.TestServiceInstanceListSupplier;
import com.example.demo.service.OrganizationFeignClient;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import com.netflix.discovery.EurekaClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testcontainers.shaded.org.awaitility.Awaitility.await;

//@SpringBootTest({"server.port:0", "eureka.client.enabled:false"})
class OrganizationControllerTest extends BaseIntegrationTest{
    @Autowired
    private OrganizationFeignClient organizationFeignClient;

    @Lazy
    @Autowired
    private EurekaClient eurekaClient;

//    @TestConfiguration
//    public static class TestConfig {
//        @Bean
//        public ServiceInstanceListSupplier serviceInstanceListSupplier() {
//            return new TestServiceInstanceListSupplier("organization-service", 8081);
//        }
//    }

//    @RegisterExtension
//    static WireMockExtension ORGANIZATION_SERVICE = WireMockExtension.newInstance()
//            .options(WireMockConfiguration.wireMockConfig().port(8081))
//            .build();

    @BeforeEach
    void setUp() {
        await().atMost(60, SECONDS).until(() -> eurekaClient.getApplications().size() > 0);
    }


    @Test
    void getOrgId() {
        String res =organizationFeignClient.getOrgId("fdsf").getBody();
        assertThat(res).isEqualTo("org-idd-fdsf");
    }
//
//    @Test
//    void getOrgIdTestViaWireMock() {
//
//        ORGANIZATION_SERVICE.stubFor(WireMock.get(WireMock.urlPathMatching( "/(.+)"))
//                .willReturn(WireMock.aResponse().withBody("org-idd-fdsf")));
//        String res =organizationFeignClient.getOrgId("fdsf").getBody();
//        assertThat(res).isEqualTo("org-idd-fdsf");
//    }
}