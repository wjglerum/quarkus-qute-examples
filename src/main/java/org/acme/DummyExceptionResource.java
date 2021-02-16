package org.acme;

import io.quarkus.qute.TemplateInstance;
import org.acme.domain.Greeting;
import org.acme.exceptions.DummyException;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/exception")
public class DummyExceptionResource {

    @Inject
    Logger logger;

    @GET
    @Consumes(MediaType.TEXT_HTML)
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance html() {
        logger.info("Throwing dummy exception for HTML response");
        throw new DummyException("Dummy exception");
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting json() {
        logger.info("Throwing dummy exception for JSON response");
        throw new DummyException("Dummy exception");
    }
}
