package com.br.mobiauto.management.dto.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
