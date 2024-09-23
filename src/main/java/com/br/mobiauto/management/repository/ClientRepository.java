package com.br.mobiauto.management.repository;

import com.br.mobiauto.management.model.ClientDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientDB, Long> {
}