package com.jdoodle.dockerutils.services;

import com.jdoodle.dockerutils.util.DockerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DockerUtilityService {
    private static final Logger logger = LoggerFactory.getLogger(DockerUtilityService.class);

    @Autowired
    DockerUtil dockerUtil;

    public String createAndStartDockerNginx(){
        return dockerUtil.createAndStartDockerContainer();
    }

    public void stopDockerNginx(){

    }

    public void getPageDocker(){

    }

    public String listNodes(){
        return dockerUtil.listNodes();
    }

}

