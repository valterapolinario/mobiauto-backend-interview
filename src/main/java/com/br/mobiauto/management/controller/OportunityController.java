package com.br.mobiauto.management.controller;

import com.br.mobiauto.management.dto.api.request.OportunityRequestDTO;
import com.br.mobiauto.management.dto.api.request.OportunityRequestUpdateDTO;
import com.br.mobiauto.management.dto.api.response.OportunityResponseDTO;
import com.br.mobiauto.management.service.OportunityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/oportunidades")
@Tag(name = "oportunidades")
public class OportunityController {

    @Autowired
    OportunityService service;

    @GetMapping
    public ResponseEntity<Page<OportunityResponseDTO>> listAll(Pageable pageable) {
        return ResponseEntity.ok().body(service.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OportunityResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.get(id));
    }

    @PostMapping
    public ResponseEntity<OportunityResponseDTO> create(@RequestBody OportunityRequestDTO request) {
        return ResponseEntity.ok().body(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OportunityResponseDTO> update(@PathVariable Long id, @RequestBody OportunityRequestUpdateDTO requestDTO) {
        return ResponseEntity.ok().body(service.update(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/definir-responsavel/{usuarioId}")
    public ResponseEntity<Void> assignResponsible(@PathVariable Long id, @PathVariable Long usuarioId) {
        service.assignResponsible(id, usuarioId);
        return ResponseEntity.noContent().build();
    }
}
