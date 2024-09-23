package com.br.mobiauto.management.dto.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ClientResponseDTO(
        @JsonProperty("nome")
        String name,

        @JsonProperty("email")
        String email,

        @JsonProperty("telefone")
        String phone
) {
}
