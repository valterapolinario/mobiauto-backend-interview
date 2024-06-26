package com.br.mobiauto.management.service;

import com.br.mobiauto.management.model.UserDB;

public interface UserDependencyService {

    boolean existsByStoreId(Long storeId);

    UserDB getUserById(Long id);

    UserDB getUserForResponsible();
}
