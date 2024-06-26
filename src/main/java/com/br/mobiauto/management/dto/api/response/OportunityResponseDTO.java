package com.br.mobiauto.management.dto.api.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record OportunityResponseDTO(
        String id,
        @JsonProperty("motivo")
        String motive,

        @JsonProperty("status")
        String status,

        @JsonProperty("dataDeAtribuicao")
        @JsonFormat(pattern = "YYYY/MM/DD")
        String dateOfAssignment,

        @JsonProperty("dataDeConclusao")
        @JsonFormat(pattern = "YYYY/MM/DD")
        String dateOfCompletion,

        @JsonProperty("cliente")
        ClientResponseDTO client,

        @JsonProperty("veiculo")
        VehicleResponseDTO vehicle,

        @JsonProperty("responsavel")
        UserResponseDTO responsible,

        @JsonProperty("Loja")
        StoreResponseDTO resale
) {
}
