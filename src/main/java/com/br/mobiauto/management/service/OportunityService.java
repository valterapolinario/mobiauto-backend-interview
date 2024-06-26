package com.br.mobiauto.management.service;

import com.br.mobiauto.management.dto.api.request.OportunityRequestDTO;
import com.br.mobiauto.management.dto.api.request.OportunityRequestUpdateDTO;
import com.br.mobiauto.management.dto.api.response.OportunityResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OportunityService {

    OportunityResponseDTO create(OportunityRequestDTO request);

    Page<OportunityResponseDTO> getAll(Pageable pageable);

    OportunityResponseDTO get(Long id);

    OportunityResponseDTO update(Long id, OportunityRequestUpdateDTO request);

    void delete(Long id);
}
