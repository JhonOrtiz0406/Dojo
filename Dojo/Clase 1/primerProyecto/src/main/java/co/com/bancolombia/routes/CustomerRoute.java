package co.com.bancolombia.routes;

import co.com.bancolombia.models.Customer.responseCustomerAPI.ResponseCustomerApi;
import co.com.bancolombia.models.Customer.responseCustomerServicio.ResponseCustomerService;
import co.com.bancolombia.processor.ErrorProcessor;
import co.com.bancolombia.processor.customerProcess;
import lombok.RequiredArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CustomerRoute extends RouteBuilder {

    @Autowired
    private customerProcess customerProcess;

    @Autowired
    private ErrorProcessor errorProcessor;

    @Override
    public void configure() throws Exception {

        //onException(ValidationException.class)
        //  .to("activemq:validationFailed");

        from("direct:customer")
                .tracing()
                .streamCaching()
                .setHeader("content-type", constant("application/json"))
                .to("https://internal-apigateway-dev.bancolombia.corp/lab/lab/v1/sales-service/customer-management/reference-data-management/customers/actions/query-birth-date?throwExceptionOnFailure=false&bridgeEndpoint=true&httpMethod=POST")
                .choice().when(header(Exchange.HTTP_RESPONSE_CODE).isEqualTo("200"))
                    .unmarshal(new JacksonDataFormat(ResponseCustomerApi.class))
                    .process(customerProcess)
                .otherwise()
                    .unmarshal(new JacksonDataFormat(Object.class))
                    .process(errorProcessor)
                .endRest();
    }
}