package co.com.bancolombia.processor;

import co.com.bancolombia.models.Transaction.responseService.Data;
import co.com.bancolombia.models.Transaction.responseService.ResponseServiceTS;
import co.com.bancolombia.models.Transaction.responseTransaction.ResponseTransaction;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class TransactionProcess implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {

        ResponseTransaction rt = (ResponseTransaction) exchange.getIn().getExchange();
        ResponseServiceTS rpTS = new ResponseServiceTS();
        Data data = new Data();

        data.setSystemId(rt.getEnvelope().getHeader().getResponseHeader().getSystemId());
        data.setStatusCode(rt.getEnvelope().getHeader().getResponseHeader().getResponseStatus().getStatusCode());
        data.setComprobante(rt.getEnvelope().getBody().getAcumularTopeResponse().getComprobante());

        rpTS.setData(data);
        exchange.getIn().setBody(rpTS);
    }
}
