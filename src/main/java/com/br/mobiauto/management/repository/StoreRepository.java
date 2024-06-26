package com.br.mobiauto.management.repository;

import com.br.mobiauto.management.model.StoreDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<StoreDB, Long> {

    Boolean existsByCnpj(String cnpj);
}