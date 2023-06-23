package com.jdoodle.dockerutils.util;

import com.amihaiemil.docker.Container;
import com.amihaiemil.docker.Docker;
import com.amihaiemil.docker.UnixDocker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.io.File;
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
//
//        Container container =  docker.containers().all().next();
//        final JsonObject json = Json.createObjectBuilder()
//                .add("AttachStdin",  false)
//                .add( "AttachStdout", true)
//                .add( "AttachStderr", true)
//                .add("Cmd" , Json.createArrayBuilder()
//                        .add("-it")
//                        .add("curl")
//                        .add("http://localhost")
//                )
//                .build();
//
////
////        {
////            "AttachStdin": false,
////                "AttachStdout": true,
////                "AttachStderr": true,
////                "Cmd": ["bash","-c","echo '*/5 * * * * /usr/bin/php /app/yii cronrun/job001'>> /var/spool/cron/crontabs/root"]
////        }
//        try {
////            docker.containers().forEach(container1 ->
////            );
//
//            Exec exec = container.exec(json);
//            logger.info("Result :" , exec.inspect().toString(), " Done");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
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
