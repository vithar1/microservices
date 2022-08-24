package com.example.demo.rest;

import com.example.demo.service.OrganizationFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.lang.String;

@RestController
@RequestMapping(value="v1/organization")
public class OrganizationController {
    @Autowired
    public OrganizationFeignClient organizationFeignClient;

    @GetMapping("/{organizationId}")
    public ResponseEntity<String> getOrgId(@PathVariable("organizationId") String organizationId) {
        return organizationFeignClient.getOrgId(organizationId);
    }
}
