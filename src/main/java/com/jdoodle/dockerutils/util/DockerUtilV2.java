package com.jdoodle.dockerutils.util;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.command.ExecStartResultCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;

@Component
public class DockerUtilV2 {

    private static final Logger logger = LoggerFactory.getLogger(DockerUtilV2.class);

    DockerClient dockerClient = DockerClientBuilder.getInstance().build();
    String id ="4b24a33e4db7";

    public String getPage() throws IOException {
        //get the running container
        Optional<Container> container = dockerClient.listContainersCmd().exec()
                .stream()
                .filter(c-> c.getStatus().contains("Up") && c.getImage().equals(ApplicationConstants.NGINX_JDOODLE_IMAGE_NAME))
                .findFirst();

        if(container.isPresent()){
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try {
                logger.info("Got the running container with id :{}", container.get().getId());
                dockerClient
                        .execStartCmd(dockerClient.execCreateCmd(container.get().getId())
                                .withAttachStdout(true)
                                .withTty(true).withAttachStderr(true).withCmd("curl", "http://localhost").exec().getId())
                        .exec(new ExecStartResultCallback(outputStream, null))
                        .awaitCompletion();
            } catch (Exception e) {
                logger.debug("Can't exec disk checking command", e);
            }

            return (outputStream.toString());
        }

        return "Container with spcified image not running";
    }
}
