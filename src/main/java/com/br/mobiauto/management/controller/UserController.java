package com.br.mobiauto.management.controller;

import com.br.mobiauto.management.dto.api.request.UserRequestDTO;
import com.br.mobiauto.management.dto.api.response.UserResponseDTO;
import com.br.mobiauto.management.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.xml.bind.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Usuarios")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    public ResponseEntity<Page<UserResponseDTO>> listAll(Pageable pageable) {
        return ResponseEntity.ok().body(service.consultAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.consultById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Endpoint utilizado para criar novo Usuario", description = "Create user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuario criado", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDTO.class))
            })

    })
    public ResponseEntity<UserResponseDTO> createUser(
            @Parameter(description = " novo Usuario", required = true, schema = @Schema(implementation = UserRequestDTO.class)) @Valid @RequestBody UserRequestDTO request,
            @Parameter(description = "chave da requisição", example = "ffc2a683-8f90-4571-98cb-de7e1bc21e2a",
                    required = true, schema = @Schema(implementation = UUID.class)) @RequestHeader(value = "chave-requisicao") UUID requisicionKey
    ) throws ValidationException {

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(service
                        .createUser(request, requisicionKey).id())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO requestDTO) {
        return ResponseEntity.ok().body(service.updateUser(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
