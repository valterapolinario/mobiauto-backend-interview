package com.br.mobiauto.management.dto.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OportunityRequestDTO(
        @JsonProperty("ClienteNome")
        @NotBlank
        String clientName,

        @JsonProperty("ClienteTelefone")
        @NotBlank
        String clientPhone,

        @JsonProperty("ClienteEmail")
        @NotBlank
        @Email
        String clientEmail,

        @JsonProperty("VeiculoModelo")
        @NotBlank
        String vehicleModel,

        @JsonProperty("VeiculoAno")
        @Positive
        @NotNull
        Integer vehicleYear,

        @JsonProperty("VeiculoMarca")
        @NotBlank
        String vehicleBrand,

        @JsonProperty("VeiculoVersao")
        @NotBlank
        String vehicleVersion,

        @JsonProperty("LojaId")
        @NotNull
        @Positive
        Long storeId


) {
}
