package com.br.mobiauto.management.utils.db;

import com.br.mobiauto.management.model.UserDB;
import com.br.mobiauto.management.model.UserPositionEnum;
import com.br.mobiauto.management.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DbInitValuesUtils {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        if (repository.findByEmail("emaildeault@gmail.com").isEmpty()) {
            UserDB adminUser = new UserDB();
            adminUser.setName("userDefault");
            adminUser.setPassword(passwordEncoder.encode("admin123"));
            adminUser.setPosition(UserPositionEnum.ADMIN);
            adminUser.setEmail("emaildeault@gmail.com");
            repository.save(adminUser);
        }
    }
}
