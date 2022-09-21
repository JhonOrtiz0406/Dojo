package co.com.bancolombia.models.Customer.responseCustomerAPI;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCustomerApi {
    public HeaderRS HeaderRS;
    public String RFECHANAC;
    public String RFECHAEXP;
}
