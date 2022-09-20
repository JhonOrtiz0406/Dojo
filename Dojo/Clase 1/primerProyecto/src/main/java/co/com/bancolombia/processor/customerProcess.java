package co.com.bancolombia.processor;

import co.com.bancolombia.models.Customer.responseCustomerAPI.ResponseCustomerApi;
import co.com.bancolombia.models.Customer.responseCustomerServicio.Data;
import co.com.bancolombia.models.Customer.responseCustomerServicio.ResponseCustomerService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class customerProcess implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        ResponseCustomerApi rc = (ResponseCustomerApi) exchange.getIn().getBody();
        ResponseCustomerService rcServ = new ResponseCustomerService();
        Data data = new Data();

        data.setStatusCode(rc.getHeaderRS().getStatusCode());
        data.setStatusDesc(rc.getHeaderRS().getStatusDesc());
        data.setUserID(rc.getHeaderRS().getUserID());

        rcServ.setData(data);
        exchange.getIn().setBody(rcServ);
    }
}
