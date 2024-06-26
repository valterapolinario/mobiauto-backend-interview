package com.br.mobiauto.management.dto.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;

public record OportunityRequestUpdateDTO(
        @JsonProperty("ClienteNome")
        String clientName,

        @JsonProperty("ClienteTelefone")
        String clientPhone,

        @JsonProperty("ClienteEmail")
        @Email
        String clientEmail,

        @JsonProperty("VeiculoModelo")
        String vehicleModel,

        @JsonProperty("VeiculoAno")
        @Positive
        Integer vehicleYear,

        @JsonProperty("VeiculoMarca")
        String vehicleBrand,

        @JsonProperty("VeiculoVersao")
        String vehicleVersion
//
//        @JsonProperty("LojaId")
//        @Positive
//        Long storeId


) {
}
