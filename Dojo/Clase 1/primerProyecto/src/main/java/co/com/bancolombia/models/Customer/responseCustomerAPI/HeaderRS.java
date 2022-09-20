package co.com.bancolombia.models.Customer.responseCustomerAPI;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HeaderRS {
    @JsonProperty("StatusCode")
    public String statusCode;
    @JsonProperty("StatusDesc")
    public String statusDesc;
    @JsonProperty("userID")
    public int userID;
}
