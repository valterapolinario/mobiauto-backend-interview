package com.br.mobiauto.management.dto.api.request;

import com.br.mobiauto.management.model.UserPositionEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record UserRequestDTO(
        @NotBlank
        @JsonProperty("nome")
        String name,
        @NotBlank
        @Email
        @JsonProperty("email")
        String email,

        @NotBlank
        @JsonProperty("senha")
        String password,

        @NotNull
        @PositiveOrZero
        @JsonProperty("idLoja")
        Long storeId,

        @JsonProperty("cargo")
        UserPositionEnum position
) {
}
