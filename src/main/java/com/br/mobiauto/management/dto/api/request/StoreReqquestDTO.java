package com.br.mobiauto.management.dto.api.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

public record StoreReqquestDTO(

        @NotBlank
        @CNPJ
        String cnpj,

        @NotBlank
        String nomeSocial
) {
}
