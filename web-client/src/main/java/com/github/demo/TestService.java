package com.github.demo;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("rest")
@RegisterRestClient(configKey = "test-api")
public interface TestService {
    @GET
    public String get();

    @GET
    @Path("getUni")
    public Uni<String> getUni();

}
