package org.jboss.examples.earproblem.services.impl;

import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public interface SampleLogicResource {

    @GET
    @Path("{message}")
    public String doLogic(@PathParam("message") String message);

}