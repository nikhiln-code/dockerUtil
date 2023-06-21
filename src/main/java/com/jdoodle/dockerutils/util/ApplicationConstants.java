package com.jdoodle.dockerutils.util;

public class ApplicationConstants {
    public static final String NGINX_JDOODLE_IMAGE_NAME = "jdoodle";
    public static final String JSON_CONTAINER = "{\n" +
            "\t\"ExposedPorts\": {\n" +
            "\t\t“80/tcp\": { }\n" +
            "\t}\n"+
//            , \"PortBindings\": {\n" +
//            "        \"container_port/tcp\": [\n" +
//            "            {\n" +
//            "                 \"HostPort\": “80”\n" +
//            "            }\n" +
//            "        ]\n" +
//            "    }\n" +
            "}";
}
