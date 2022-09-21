package co.com.bancolombia.models.Carfact.responseService;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.Valid;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseService {

    @Valid
    @JsonProperty("dataServ")
    private Data data;
}
