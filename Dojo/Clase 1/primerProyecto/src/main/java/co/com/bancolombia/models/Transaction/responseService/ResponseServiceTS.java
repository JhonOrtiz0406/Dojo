package co.com.bancolombia.models.Transaction.responseService;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseServiceTS {
    @JsonProperty("data")
    private Data data;
}
