package com.github.demo;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletionStage;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestQuery;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MultivaluedMap;

@Path("extensions")
@RegisterRestClient(configKey = "extensions-api")
public interface ExtensionsService {

    @GET
    Set<Extension> getById(@RestQuery ("id") String id);

    @GET
    Set<Extension> getByName(@RestQuery String name); 

    @GET
    Set<Extension> getByFilter(@RestQuery Map<String, String> filter); 

    @GET
    Set<Extension> getByFilters(@RestQuery MultivaluedMap<String, String> filters); 

    @GET
    CompletionStage<Set<Extension>> getByIdAsync(@RestQuery String id);

    @GET
    Uni<Set<Extension>> getByIdAsUni(@RestQuery String id);
}
