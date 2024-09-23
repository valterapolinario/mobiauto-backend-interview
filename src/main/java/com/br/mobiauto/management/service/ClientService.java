package com.br.mobiauto.management.service;

import com.br.mobiauto.management.dto.api.request.ClientRequestDTO;
import com.br.mobiauto.management.dto.api.response.ClientResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {

    Page<ClientResponseDTO> consultAll(Pageable pageable);

    ClientResponseDTO consultById(Long id);

    ClientResponseDTO createClient(ClientRequestDTO request);

    ClientResponseDTO updateClient(Long id, ClientRequestDTO request);

    void deleteClient(Long id);
}
