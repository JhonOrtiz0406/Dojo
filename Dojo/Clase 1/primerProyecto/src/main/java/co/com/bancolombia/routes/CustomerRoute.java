package co.com.bancolombia.routes;

import co.com.bancolombia.models.Customer.responseCustomerAPI.ResponseCustomerApi;
import co.com.bancolombia.processor.customerProcess;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerRoute extends RouteBuilder {

    @Autowired
    private ResponseCustomerApi responseCustomerApi;

    @Autowired
    private customerProcess customerProcess;

    @Override
    public void configure() throws Exception {
        from("direct:customer")
                .streamCaching()
                .to("https://internal-apigateway-dev.bancolombia.corp/lab/lab/v1/sales-service/customer-management/reference-data-management/customers/actions/query-birth-date?throwExceptionOnFailure=false&bridgeEndpoint=true&httpMethod=POST")
                //.unmarshal(new JsonDataFormat(ResponseCustomer.class))
                .process(customerProcess)
                .end();
    }
}