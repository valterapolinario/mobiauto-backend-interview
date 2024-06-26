package com.br.mobiauto.management.service;

import com.br.mobiauto.management.dto.api.request.UserRequestDTO;
import com.br.mobiauto.management.dto.api.response.UserResponseDTO;
import com.br.mobiauto.management.model.UserDB;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserService {

    Page<UserResponseDTO> consultAll(Pageable pageable);

    UserResponseDTO consultById(Long id);

    UserResponseDTO createUser(UserRequestDTO request, UUID requisicionKey);

    UserResponseDTO updateUser(Long id, UserRequestDTO request);

    void deleteUser(Long id);


}
