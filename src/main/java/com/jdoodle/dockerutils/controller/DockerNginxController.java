package com.jdoodle.dockerutils.controller;

import com.jdoodle.dockerutils.services.DockerUtilityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/v1/dockerUtil")
public class DockerNginxController {
    private static final Logger logger = LoggerFactory.getLogger(DockerNginxController.class);

    @Autowired
    DockerUtilityService service ;


    @GetMapping("/create-start-docker-nginx")
    public ResponseEntity<?> createAndStartDockerNginx(){
        logger.info("Inside the createAndStartDockerNginx");
        return new ResponseEntity<>(service.createAndStartDockerNginx(), HttpStatus.OK);
    }

    @GetMapping("/stop-docker-nginx")
    public ResponseEntity<?> stopDockerNginx(){
        logger.info("Inside the stopDockerNginx");
        return new ResponseEntity<>(service.stopDockerNginx(), HttpStatus.OK);
    }

    @GetMapping("/get-page-docker")
    public ResponseEntity<?> getPageDocker(){
        logger.info("Inside the getPageDocker");
        return new ResponseEntity<>(service.getPageDocker(), HttpStatus.OK);
    }

    @GetMapping("/listNodes")
    public String getNodes(){
        logger.info("List nodes");
        return service.listNodes().toString();
    }

}
