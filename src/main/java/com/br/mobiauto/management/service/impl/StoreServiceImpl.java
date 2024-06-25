package com.br.mobiauto.management.service.impl;

import com.br.mobiauto.management.dto.api.request.StoreReqquestDTO;
import com.br.mobiauto.management.dto.api.response.StoreResponseDTO;
import com.br.mobiauto.management.model.StoreDB;
import com.br.mobiauto.management.repository.StoreRepository;
import com.br.mobiauto.management.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository repository;
    @Override
    public Optional<StoreDB> consultById(Long id) {
        return repository.findById(id);
    }

    @Override
    public StoreResponseDTO consultEntityById(Long id) {
        return null;
    }

    @Override
    public StoreResponseDTO create(StoreReqquestDTO request) {
        return null;
    }

    @Override
    public StoreResponseDTO update(Long id, StoreReqquestDTO request) {
        return null;
    }

    @Override
    public Page<StoreResponseDTO> consultAll(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
