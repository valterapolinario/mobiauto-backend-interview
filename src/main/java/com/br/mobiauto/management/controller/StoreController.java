package com.br.mobiauto.management.controller;

import com.br.mobiauto.management.dto.api.request.StoreReqquestDTO;
import com.br.mobiauto.management.dto.api.response.StoreResponseDTO;
import com.br.mobiauto.management.service.StoreService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/revendas")
@Tag(name = "revendas")
public class StoreController {

    @Autowired
    StoreService service;

    @GetMapping
    public ResponseEntity<Page<StoreResponseDTO>> listAll(Pageable pageable) {
        return ResponseEntity.ok().body(service.consultAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.consultEntityById(id));
    }

    @PostMapping
    public ResponseEntity<StoreResponseDTO> create(@RequestBody StoreReqquestDTO request) {
        return ResponseEntity.ok().body(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StoreResponseDTO> update(@PathVariable Long id, @RequestBody StoreReqquestDTO requestDTO) {
        return ResponseEntity.ok().body(service.update(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
