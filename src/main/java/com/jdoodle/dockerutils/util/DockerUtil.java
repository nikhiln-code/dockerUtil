package com.jdoodle.dockerutils.util;

import com.amihaiemil.docker.Container;
import com.amihaiemil.docker.Docker;
import com.amihaiemil.docker.Exec;
import com.amihaiemil.docker.UnixDocker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class DockerUtil {
    private static final Logger logger = LoggerFactory.getLogger(DockerUtil.class);

    final Docker docker = new UnixDocker(
            new File("/var/run/docker.sock")
    );

    private String containerId = null;

    public String listNodes(){
        return docker.images().toString();
    }

    public String  createAndStartDockerContainer() {
        try {
            Container container = docker.containers().create(ApplicationConstants.NGINX_JDOODLE_IMAGE_NAME);
            containerId = container.containerId();
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
        Map <String, Iterable<String>> map = new HashMap<String, Iterable<String>>();
        map.put("status", Arrays.asList("running"));
        Container container =  docker.containers().filter(map).all().next();
        final JsonObject json = Json.createObjectBuilder()
                .add("AttachStdin",  false)
                .add( "AttachStdout", true)
                .add( "AttachStderr", true)
                .add("Cmd" , Json.createArrayBuilder()
                        .add("-it")
                        .add("curl")
                        .add("http://localhost")
                )
                .build();

        try {
            Exec exec = container.exec(json);

            logger.info(exec.inspect().toString());

          // docker.httpClient().execute(exec.inspect());

//            final HttpPost executePost = new HttpPost(
//                    this.baseUri.toString() + "/stop"
//            );
//            try {
//                this.client.execute(
//                        stop,
//                        new MatchStatus(stop.getURI(), HttpStatus.SC_NO_CONTENT)
//                );
//            } finally {
//                stop.releaseConnection();
//            }



            container.start();




            logger.info("Result :" , exec.inspect().toString(), " Done");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "Executing";
    }

    public String stopDockerNginx() {
        try {
            docker.containers().get(containerId).stop();
        } catch(Exception e){
            logger.error("Exception while stopping the container");
        }
        return "Stoped the container with nginx" + containerId;
    }
}
