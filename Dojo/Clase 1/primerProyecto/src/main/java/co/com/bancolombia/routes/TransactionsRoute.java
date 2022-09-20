package co.com.bancolombia.routes;

import co.com.bancolombia.processor.TransactionProcess;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@RequiredArgsConstructor
public class TransactionsRoute extends RouteBuilder {

   @Autowired
   private TransactionProcess transactionProcess;

    @Override
    public void configure() throws Exception {
        from("direct:transaction")
                .streamCaching()
                .setHeader("accept",simple("application/xml"))
                //.marshal(xmlJsonFormat)
                .to("https://internal-apigateway-dev.bancolombia.corp/lab/lab/v1/operations/trade-banking/limit/exposure/transactions-limit/customers-amount-limits/customers-amount-limits/acumulate?throwExceptionOnFailure=false&bridgeEndpoint=true")
                .process(transactionProcess)
                .end();
    }
}