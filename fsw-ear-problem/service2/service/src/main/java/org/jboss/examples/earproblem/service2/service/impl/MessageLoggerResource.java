package org.jboss.examples.earproblem.service2.service.impl;

import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public interface MessageLoggerResource {

    @GET
    @Path("{message}")
    public String logMesssage(@PathParam("message") String message);

}