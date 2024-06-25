package com.br.mobiauto.management.repository;

import com.br.mobiauto.management.model.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDB, Long> {

    Boolean existsByEmail(String email);
}