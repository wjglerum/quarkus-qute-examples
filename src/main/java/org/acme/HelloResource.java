package org.acme;

import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.api.CheckedTemplate;
import io.quarkus.security.identity.SecurityIdentity;
import org.acme.domain.Greeting;
import org.acme.services.GreetingService;
import org.acme.views.PageOptions;
import org.jboss.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

    private final GreetingService greetingService;
    private final Logger logger;

    public HelloResource(GreetingService greetingService,
                         Logger logger) {
        this.greetingService = greetingService;
        this.logger = logger;
    }

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance hello(PageOptions pageOptions, Greeting greeting);
    }

    @GET
    @Consumes(MediaType.TEXT_HTML)
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance html() {
        PageOptions options = new PageOptions("Hello");
        Greeting greeting = greetingService.get();
        logger.infof("Greeting with message %s", greeting.message);
        return Templates.hello(options, greeting);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting json() {
        return greetingService.get();
    }
}
