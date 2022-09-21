package co.com.bancolombia.models.Customer.responseCustomerServicio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Data {
    @JsonProperty("StatusCode")
    private String StatusCode;
    @JsonProperty("StatusDesc")
    private String StatusDesc;
    @JsonProperty("userID")
    private int userID;
}
