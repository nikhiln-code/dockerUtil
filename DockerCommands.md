
`Docker commands:`

 - Docker ps  - list all the running docker containers
- Docker images  - list all the images
- Docker run -d -p 80:80 jdoodle 
- Docker build - t jdoodle .    (Will create a image from the Dockerfile in current directory)
 -   docker exec -it 5d82b0eac4af bash
- Docker stop <containerid>
- Docker kill <containerid>
- Docker rm <containerid>
  docker exec -it c573a7820672 curl localhost

 - docker cp demofile.html 5d82b0eac4af:/var/www/html/index.nginx-debian.html


{
	"ExposedPorts": {
		“80/tcp": { }
	}, "PortBindings": {
        "container_port/tcp": [
            {
                 "HostPort": “80”
            }
        ]
    }
}

{“ExposedPorts": {"22/tcp": { }}}


caused by: java.lang.LinkageError: ClassCastException: attempting to castjar:file .m2/repository/javax/ws/rs/javax.ws.rs-api/2.1 /javax.ws.rs-api-2.1.jar!/javax/ws/rs/client/ClientBuilder.class .m2/repository/javax/ws/rs/javax.ws.rs-api/2.1/javax.ws.rs-api-2.1.jar!/javax/ws/rs/client/ClientBuilder.class