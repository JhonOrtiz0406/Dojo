package co.com.bancolombia.models.Transaction.responseService;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.Valid;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Data {
    @JsonProperty("systemId")
    private String systemId;

    @JsonProperty("statusCode")
    private String statusCode;

    @JsonProperty("comprobante")
    private int comprobante;
}
