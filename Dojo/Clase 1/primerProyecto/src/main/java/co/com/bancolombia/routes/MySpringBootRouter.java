package co.com.bancolombia.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class MySpringBootRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json)
                .enableCORS(true)
                .host("localhost")
                .port("8080");

        rest("operation")
                //Get
                .get("/carfact")
                .route()
                .to("direct:carfact")
                .endRest()
                //Post
                .post("/transaction")
                .route()
                .to("direct:transaction")
                .endRest();
    }

}
