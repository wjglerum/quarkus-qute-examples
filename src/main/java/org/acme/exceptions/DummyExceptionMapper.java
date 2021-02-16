package org.acme.exceptions;

import org.acme.GeneralTemplates;
import org.acme.domain.ErrorMessage;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DummyExceptionMapper implements ExceptionMapper<DummyException> {

    @Inject
    Logger logger;

    @Context
    HttpHeaders headers;

    @Override
    public Response toResponse(DummyException exception) {
        logger.error("Dummy Error", exception);
        logger.tracef("Accept headers: %s", headers.getAcceptableMediaTypes().toString());

        Response.ResponseBuilder response = Response.status(Response.Status.INTERNAL_SERVER_ERROR);

        if (headers.getAcceptableMediaTypes().contains(MediaType.APPLICATION_JSON_TYPE)) {
            return response
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .entity(new ErrorMessage(exception.getMessage()))
                    .build();
        } else {
            return response
                    .entity(GeneralTemplates.error(exception.getMessage()))
                    .build();
        }
    }
}
