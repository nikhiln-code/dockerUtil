package com.jdoodle.dockerutils.util;

import com.amihaiemil.docker.Container;
import com.amihaiemil.docker.Docker;
import com.amihaiemil.docker.UnixDocker;
import com.google.gson.Gson;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.json.JsonObject;
import java.io.File;

@Service
public class DockerUtil {
    private static final Logger logger = LoggerFactory.getLogger(DockerUtil.class);

   // DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder().build();
   // DockerClient dockerClient = DockerClientBuilder.getInstance().build();

    final Docker docker = new UnixDocker(
            new File("/var/run/docker.sock")     //this is the default path to Docker's unix socket
    );
    final String[] ports = {"80", "22"};

    public String listNodes(){
        return docker.images().toString();
    }

    public String  createAndStartDockerContainer() {
        try {
            Container container = docker.containers().create(ApplicationConstants.NGINX_JDOODLE_IMAGE_NAME);
 //                   (JsonObject) new JSONParser().parse("{\"ExposedPorts\": {\"80/tcp\": { }}}"));
            logger.info("Got the container instance:"+ container.containerId());
            logger.info("Starting the container...");
            container.start();
            logger.info("Started the container...");
            return "Started the container with id: " + container.containerId();
        } catch (Exception e){
            logger.error("Exception while creating Container"+e);
        }
        return null;
    }

    public String getPageDocker(){
//            return docker.containers().all().forEachRemaining( container ->{
//         //       container.exec("").
//            });
        return "Executing";
    }
}
