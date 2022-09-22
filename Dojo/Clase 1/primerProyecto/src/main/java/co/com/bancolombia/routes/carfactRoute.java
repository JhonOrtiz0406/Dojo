package co.com.bancolombia.routes;

import co.com.bancolombia.models.Carfact.responseCarfact.ResponseCarfact;
import co.com.bancolombia.processor.carfactProcess;
import lombok.RequiredArgsConstructor;
import org.apache.camel.ValidationException;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class carfactRoute extends RouteBuilder {

    @Autowired
    private carfactProcess carfactProcess;

    @Override
    public void configure() throws Exception {

        //onException(ValidationException.class)
        //  .to("activemq:validationFailed");

        from("direct:carfact")
                .to("http://catfact.ninja/fact?throwExceptionOnFailure=false&bridgeEndpoint=true&httpMethod=GET")
                .unmarshal(new JacksonDataFormat(ResponseCarfact.class))
                .process(carfactProcess)
                .end();
    }
}
