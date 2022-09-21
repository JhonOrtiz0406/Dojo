package co.com.bancolombia.models.Customer.responseCustomerServicio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseCustomerService{
    @JsonProperty("data")
    private Data data;
}
