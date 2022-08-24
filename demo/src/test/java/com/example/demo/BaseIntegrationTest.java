package com.example.demo;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {
        "spring.cloud.loadbalancer.ribbon.enabled = false",
        "eureka.client.registerWithEureka = true",
        "eureka.client.fetchRegistry = true"
})
@ActiveProfiles("test")
public abstract class BaseIntegrationTest {
    static GenericContainer<?> eureka = new GenericContainer<>(DockerImageName.parse("vigohe/eureka:issue"))
            .withExposedPorts(8761);

    @DynamicPropertySource
    static void eurekaProperties(DynamicPropertyRegistry registry) {
        eureka.start();
        System.out.println(eureka.getHost());
        String defaultZone = "http://"+eureka.getHost()+":"+eureka.getFirstMappedPort()+"/eureka";
        registry.add("eureka.client.serviceUrl.defaultZone", () -> defaultZone);
    }
}