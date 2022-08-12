package com.example.organization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@SpringBootApplication
@RestController
@RefreshScope
@EnableDiscoveryClient
public class OrganizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationApplication.class, args);
	}

	@GetMapping("/{organizationId}")
	@RolesAllowed({"ADMIN"})
	public ResponseEntity<String> getOrganization(@PathVariable("organizationId") String organizationId) {
		return ResponseEntity.ok("org-idd-" + organizationId);
	}
}
