package com.br.mobiauto.management.service.impl;

import com.br.mobiauto.management.dto.api.request.ClientRequestDTO;
import com.br.mobiauto.management.dto.api.response.ClientResponseDTO;
import com.br.mobiauto.management.exception.GeneralNotFoundException;
import com.br.mobiauto.management.repository.ClientRepository;
import com.br.mobiauto.management.service.ClientService;
import com.br.mobiauto.management.utils.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository repository;

    @Autowired
    ClientMapper mapper;

    @Override
    public Page<ClientResponseDTO> consultAll(Pageable pageable) {
        return repository
                .findAll(pageable)
                .map(mapper::toResponse);
    }

    @Override
    public ClientResponseDTO consultById(Long id) {
        return mapper.toResponse(repository
                .findById(id).orElseThrow(
                        () -> new GeneralNotFoundException("cliente não encontrado com o id : " + id, id)));
    }

    @Override
    public ClientResponseDTO createClient(ClientRequestDTO request) {
        return mapper.toResponse(repository.save(mapper.toModel(request)));
    }

    @Override
    public ClientResponseDTO updateClient(Long id, ClientRequestDTO request) {
        return repository
                .findById(id)
                .map(clientDB ->
                        mapper.toResponse(
                                repository.save(
                                        mapper.toModelUpdate(id, request))))
                .orElseThrow(() -> new GeneralNotFoundException("cliente não encontrado com o id : " + id, id));
    }

    @Override
    public void deleteClient(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new GeneralNotFoundException("cliente não encontrado com o id : " + id, id);
        }
    }
}
