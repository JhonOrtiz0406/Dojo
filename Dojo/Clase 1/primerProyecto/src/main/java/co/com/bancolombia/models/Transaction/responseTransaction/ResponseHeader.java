package co.com.bancolombia.models.Transaction.responseTransaction;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseHeader{
    public String systemId;
    public String messageId;
    public Date timestamp;
    public ResponseStatus responseStatus;
}
