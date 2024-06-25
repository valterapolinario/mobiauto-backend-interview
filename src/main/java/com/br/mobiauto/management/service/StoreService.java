package com.br.mobiauto.management.service;

import com.br.mobiauto.management.model.StoreDB;

import java.util.Optional;

public interface StoreService {

    Optional<StoreDB> consultById(Long id);
}
