package com.br.mobiauto.management.dto.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record VehicleResponseDTO(
        String id,

        @JsonProperty("marca")
        String brand,

        @JsonProperty("modelo")
        String model,
        @JsonProperty("versao")
        String version,
        @JsonProperty("anoDeLancamento")
        int yearOfRelease
) {
}
