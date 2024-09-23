package com.br.mobiauto.management.dto.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record StoreResponseDTO(
        Long id,

        String nomeSocial,

        String cnpj


) {
}
