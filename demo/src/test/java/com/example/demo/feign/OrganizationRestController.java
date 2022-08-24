package com.example.demo.feign;

import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@ActiveProfiles("test")
@RestController
public class OrganizationRestController {
    @GetMapping("{organizationId}")
    public ResponseEntity<String> getOrganization(@PathVariable("organizationId") String organizationId) {
        return ResponseEntity.ok("org-idd-" + organizationId);
    }
}
