package com.jdoodle.dockerutils.controller;

import com.jdoodle.dockerutils.services.DockerUtilityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/v1/dockerUtil")
public class DockerNginxController {
    private static final Logger logger = LoggerFactory.getLogger(DockerNginxController.class);

    @Autowired
    DockerUtilityService service ;


    @GetMapping("/create-start-docker-nginx")
    public String createAndStartDockerNginx(){
        logger.info("Inside the createAndStartDockerNginx");
        return service.createAndStartDockerNginx();
    }


    @GetMapping("/stop-docker-nginx")
    public String stopDockerNginx(){
        logger.info("Inside the stopDockerNginx");
        return service.stopDockerNginx();
    }

    @GetMapping("/get-page-docker")
    public String getPageDocker(){
        logger.info("Inside the getPageDocker");
        return service.getPageDocker();

    }

    @GetMapping("/listNodes")
    public String getNodes(){
        logger.info("List nodes");
        return service.listNodes().toString();
    }

}
