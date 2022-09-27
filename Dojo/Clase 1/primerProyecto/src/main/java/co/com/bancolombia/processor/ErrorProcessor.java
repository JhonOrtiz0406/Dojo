package co.com.bancolombia.processor;

import co.com.bancolombia.models.Excepciones.Data;
import co.com.bancolombia.models.Excepciones.ErrorControl;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class ErrorProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {

        int code = (int) exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE);
        ErrorControl errorControl = new ErrorControl();
        Data data = new Data();

        data.setCode(code);
        data.setDescription("Testeo de pruebita error");

        exchange.getIn().removeHeaders("X-Client-IP");
        errorControl.setData(data);
        exchange.getIn().setBody(errorControl);

    }
}