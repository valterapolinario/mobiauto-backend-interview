package com.br.mobiauto.management.dto.api.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthRequestDTO(

        @NotBlank
        @Email
        String email,

        String password
) {
}
