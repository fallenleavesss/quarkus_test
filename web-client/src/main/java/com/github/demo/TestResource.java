package com.github.demo;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("test")
public class TestResource {
    @RestClient
    TestService testService;

    @GET
    public String get(){
        return testService.get();
    }

    @GET
    @Path("getUni")
    public Uni<String> getUni(){
        return testService.getUni();
    }
}
