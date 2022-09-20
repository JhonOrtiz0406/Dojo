package co.com.bancolombia.processor;

import co.com.bancolombia.models.Carfact.responseCarfact.ResponseCarfact;
import co.com.bancolombia.models.Carfact.responseService.Data;
import co.com.bancolombia.models.Carfact.responseService.ResponseService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;


@Component
public class carfactProcess implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception{
        ResponseCarfact responseCarfact = exchange.getIn().getBody(ResponseCarfact.class);
        ResponseService responseService = new ResponseService();
        Data data = new Data();
        data.setMensaje(responseCarfact.getFact());
        responseService.setData(data);
        exchange.getIn().setBody(responseService);
    }
}