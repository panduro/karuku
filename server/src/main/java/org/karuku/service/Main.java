package org.karuku.service;

import com.sun.jersey.api.container.grizzly.GrizzlyWebContainerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        final String baseUri = "http://localhost:"+(System.getenv("PORT")!=null?System.getenv("PORT"):"9998")+"/";
        final Map<String, String> initParams = new HashMap<String, String>();

        initParams.put("com.sun.jersey.config.property.packages","resources");

        System.out.println("Starting grizzly...");
        GrizzlyWebContainerFactory.create(baseUri, initParams);

        System.out.println(String.format("Jersey started with WADL available at %sapplication.wadl.",baseUri, baseUri));
    }
}

