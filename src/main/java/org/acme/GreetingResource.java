package org.acme;

import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.api.CheckedTemplate;
import org.acme.domain.User;
import org.acme.views.PageOptions;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/greeting")
public class GreetingResource {

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance greeting(PageOptions pageOptions, User user);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance greeting() {
        User user = new User("John Doe", 25);
        PageOptions pageOptions = new PageOptions("Greeting");
        return Templates.greeting(pageOptions, user);
    }
}
