#!/bin/bash

#curl -X GET -G 'http://localhost:8080/hello/Roman' -d lastName=Anokhin
#echo 
#curl -X POST http://localhost:8080/hello \
# -H "Content-Type: application/json" \
# -d '{"firstName": "Roman", "lastName": "Anokhin"}'
#echo 
#echo spring actuator 
#curl -X GET -G 'http://localhost:8080/actuator/health/custom' | jq '.'
#echo 
#curl -X GET -G 'http://localhost:8071/licensing-service/default' | jq '.'
#echo 
curl -X GET -G 'http://localhost:8080/actuator/env' | jq '.'
#echo 

#echo 
#curl -X POST http://localhost:8080/v1/organization/some-org-id/license \
# -H "Content-Type: application/json" \
# -d '{"description": "description", "organizationId": "some-org-id", "productName":"some-prod-name", "licenseType":"some-lic-type"}'
#echo 

#echo 
#curl -X GET http://localhost:8080/v1/organization/some-org-id/license/60d8118d-21b2-4243-b906-e4b63dafab81 \
#echo

# method for refresh config from config server 
#curl -X POST -G 'http://localhost:8080/actuator/refresh'
#curl -X GET -G 'http://127.0.0.1:8071/licensing-service/default' -H "X-Config-Token: myroot"

