package co.com.bancolombia.models.Customer.responseCustomerAPI;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseCustomerApi {
    public HeaderRS headerRS;
    @JsonProperty("RFECHANAC")
    public String rFECHANAC;
    @JsonProperty("RFECHAEXP")
    public String rFECHAEXP;
}
