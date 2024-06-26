package com.br.mobiauto.management.service;

import com.br.mobiauto.management.dto.api.request.UserRequestDTO;
import com.br.mobiauto.management.dto.api.response.UserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserService {

    Page<UserResponseDTO> consultAll(Pageable pageable);

    UserResponseDTO consultById(Long id);

    UserResponseDTO createUser(UserRequestDTO request, UUID requisicionKey);

    UserResponseDTO updateUser(Long id, UserRequestDTO request);

    boolean existsByStoreId(Long storeId);

    void deleteUser(Long id);
}
