package com.br.mobiauto.management.dto.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserResponseDTO(

        Long id,

        @JsonProperty("nome")
        String name,

        @JsonProperty("email")
        String email,

        @JsonProperty("cargo")
        String position,

        @JsonProperty("nomeLoja")
        String storeName,

        @JsonProperty("idLoja")
        Long storeId
) {
}
