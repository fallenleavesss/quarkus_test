package com.github.demo;

import java.util.Set;
import java.util.concurrent.CompletionStage;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("extension")
public class ExtensionsResource {
    @RestClient
    ExtensionsService extensionsService;

    @GET
    @Path("id/{id}")
    public Set<Extension> id(String id){
        return extensionsService.getById(id);
    }

    @GET
    @Path("/id-async/{id}")
    public CompletionStage<Set<Extension>> idAsync(String id) {
        return extensionsService.getByIdAsync(id);
    }

    @GET
    @Path("/id-uni/{id}")
    public Uni<Set<Extension>> idUni(String id) {
        return extensionsService.getByIdAsUni(id);
    }
}
