package com.jdoodle.dockerutils.services;

import com.jdoodle.dockerutils.util.DockerUtil;
import com.jdoodle.dockerutils.util.DockerUtilV2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DockerUtilityService {
    private static final Logger logger = LoggerFactory.getLogger(DockerUtilityService.class);

    @Autowired
    DockerUtilV2 dockerUtilV2;

    @Autowired
    DockerUtil dockerUtil;

    public String createAndStartDockerNginx(){
        return dockerUtil.createAndStartDockerContainer();
    }

    public String stopDockerNginx(){
        return dockerUtil.stopDockerNginx();

    }

    public String getPageDocker(){
        try {
            return dockerUtilV2.getPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String listNodes(){
        return dockerUtil.listNodes();
    }

}

