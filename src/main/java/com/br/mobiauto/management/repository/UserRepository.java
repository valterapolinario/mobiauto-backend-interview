package com.br.mobiauto.management.repository;

import com.br.mobiauto.management.model.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDB, Long> {

    Boolean existsByEmail(String email);

    boolean existsByStore_Id(Long storeId);

    @Query(value = "SELECT u.* " +
            "FROM users u " +
            "LEFT JOIN opportunities o ON o.id_responsible = u.id " +
            "AND o.status = 'IN_PROGRESS' " +
            "WHERE u.`position` = 'ASSISTANT' " +
            "GROUP BY u.id " +
            "ORDER BY COUNT(o.id) ASC, " +
            "MAX(CASE WHEN o.status = 'IN_PROGRESS' THEN o.date_of_assignment ELSE NULL END) ASC, " +
            "MAX(o.date_of_assignment) ASC " +
            "LIMIT 1", nativeQuery = true)
    UserDB findUserWithLeastOpportunitiesInProgress();

}