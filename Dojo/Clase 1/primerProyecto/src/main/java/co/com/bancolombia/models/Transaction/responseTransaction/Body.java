package co.com.bancolombia.models.Transaction.responseTransaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Body {

   @JsonProperty("acumularTopeResponse")
    public AcumularTopeResponse acumularTopeResponse;
}