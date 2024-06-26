package com.br.mobiauto.management.repository;

import com.br.mobiauto.management.model.OportunityDB;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OportunityRepository extends JpaRepository<OportunityDB, Long> {

    List<OportunityDB> findAllByResale_Id(Long id);

    List<OportunityDB> findAllByResponsible_IdIsNull();

    List<OportunityDB> findByResponsibleNull();
}
