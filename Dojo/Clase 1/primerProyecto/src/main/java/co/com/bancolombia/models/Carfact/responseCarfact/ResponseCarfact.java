package co.com.bancolombia.models.Carfact.responseCarfact;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.*;

import javax.validation.Valid;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseCarfact {

    @Valid
    @JsonProperty("fact")
    public String fact;

    @Valid
    @JsonProperty("length")
    public int length;
}
