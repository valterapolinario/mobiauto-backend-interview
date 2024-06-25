package com.br.mobiauto.management.dto.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ClientResponseDTO(
        @JsonProperty("nome")
        String name,

        @JsonProperty("email")
        String email,

        @JsonProperty("telefone")
        String phone
) {
}
