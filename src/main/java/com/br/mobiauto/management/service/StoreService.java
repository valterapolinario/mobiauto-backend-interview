package com.br.mobiauto.management.service;

import com.br.mobiauto.management.dto.api.request.StoreReqquestDTO;
import com.br.mobiauto.management.dto.api.response.StoreResponseDTO;
import com.br.mobiauto.management.model.StoreDB;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface StoreService {

    Optional<StoreDB> consultById(Long id);

    StoreResponseDTO consultEntityById(Long id);

    StoreResponseDTO create(StoreReqquestDTO request);

    StoreResponseDTO update(Long id, StoreReqquestDTO request);

    Page<StoreResponseDTO> consultAll(Pageable pageable);

    void delete(Long id);
}
