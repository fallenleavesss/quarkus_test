package com.github.demo.resource;

import org.jboss.resteasy.reactive.RestCookie;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.RestHeader;
import org.jboss.resteasy.reactive.RestMatrix;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestQuery;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/rest")
public class Endpoint {

    @GET
    public String get() {
        return "get";
    }

    @POST
    public String post() {
        return "post";
    }

    @DELETE
    public String del() {
        return "del";
    }

    @POST
    @Path("/params/{type}")
    public String params(@RestPath String type,
            @RestForm String name,
            @RestQuery String age,
            @RestCookie String level,
            @RestHeader("X-Cheese-Secret-Handshake") String secretHandshake,
            @RestMatrix String variant) {

        return type + "-" + name + "-" + level + "-" + secretHandshake + "-" + age + "-" + variant;
    }

    @GET
    @Path("hello")
    public RestResponse<String> hello() {
        return ResponseBuilder
                .ok("hello", MediaType.TEXT_PLAIN_TYPE)
                .build();
    }


}
