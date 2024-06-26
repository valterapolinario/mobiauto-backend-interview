package com.br.mobiauto.management.service;

import com.br.mobiauto.management.dto.api.request.OportunityRequestDTO;
import com.br.mobiauto.management.dto.api.request.OportunityRequestUpdateDTO;
import com.br.mobiauto.management.dto.api.response.OportunityResponseDTO;
import com.br.mobiauto.management.model.OportunityDB;
import com.br.mobiauto.management.model.UserDB;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OportunityService {

    OportunityResponseDTO create(OportunityRequestDTO request);

    Page<OportunityResponseDTO> getAll(Pageable pageable);

    OportunityResponseDTO get(Long id);

    OportunityResponseDTO update(Long id, OportunityRequestUpdateDTO request);

    void assignResponsible(Long id, Long userId);

    void delete(Long id);

    void assignResponsibleForSched(OportunityDB entity, UserDB responsible);

    List<OportunityDB> getOpportunityWithoutResponsibility();
}
