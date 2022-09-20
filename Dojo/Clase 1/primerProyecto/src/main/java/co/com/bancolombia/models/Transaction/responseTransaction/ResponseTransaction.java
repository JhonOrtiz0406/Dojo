package co.com.bancolombia.models.Transaction.responseTransaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseTransaction {

    @JsonProperty("Envelope")
    public Envelope envelope;
}
