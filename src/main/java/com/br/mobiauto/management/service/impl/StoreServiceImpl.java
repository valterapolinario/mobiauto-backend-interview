package com.br.mobiauto.management.service.impl;

import com.br.mobiauto.management.model.StoreDB;
import com.br.mobiauto.management.repository.StoreRepository;
import com.br.mobiauto.management.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
