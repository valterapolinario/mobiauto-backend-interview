package com.br.mobiauto.management.service.impl;

import com.br.mobiauto.management.dto.api.request.UserRequestDTO;
import com.br.mobiauto.management.dto.api.response.UserResponseDTO;
import com.br.mobiauto.management.exception.GeneralNotFoundException;
import com.br.mobiauto.management.model.StoreDB;
import com.br.mobiauto.management.model.UserDB;
import com.br.mobiauto.management.repository.UserRepository;
import com.br.mobiauto.management.service.StoreService;
import com.br.mobiauto.management.service.UserService;
import com.br.mobiauto.management.utils.EncriptUtils;
import com.br.mobiauto.management.utils.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

import static java.util.concurrent.TimeUnit.MINUTES;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private StoreService storeService;

    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserRepository repository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Page<UserResponseDTO> consultAll(Pageable pageable) {
        return repository
                .findAll(pageable)
                .map(mapper::toResponse);
    }

    @Override
    public UserResponseDTO consultById(Long id) {
        return mapper.toResponse(repository
                .findById(id).orElseThrow(
                        () -> new GeneralNotFoundException("Usuario não encontrado com o id : " + id, id)));
    }

    @Override
    @Transactional
    public UserResponseDTO createUser(UserRequestDTO request, UUID requisicionKey) {
        StoreDB storeDB = storeService
                .consultById(request.storeId()).orElseThrow(
                        () -> new GeneralNotFoundException("Loja não encontrada com o id : " + request.storeId(), request.storeId()));

        if (repository.existsByEmail(request.email())) {
            throw new GeneralNotFoundException("E-mail já cadastrado", request.email());
        }

        UserDB userTemp = (UserDB) redisTemplate.opsForValue().get(requisicionKey.toString());
        if (Objects.nonNull(userTemp)) {
            return mapper.toResponse(userTemp);
        }
        userTemp = mapper.toModel(request, storeDB);
        userTemp.setPassword(EncriptUtils.encrypt(request.password()));
        userTemp = repository.save(userTemp);
        redisTemplate.opsForValue().set(requisicionKey.toString(), userTemp);
        redisTemplate.opsForValue().set("user:" + userTemp.getId() + ":requisitionKey", requisicionKey.toString());
        redisTemplate.expire(requisicionKey.toString(), 5, MINUTES);
        return mapper.toResponse(userTemp);
    }

    @Override
    @Transactional
    public UserResponseDTO updateUser(Long id, UserRequestDTO request) {
        return repository
                .findById(id)
                .map(userDB -> {

                    if (!Objects.equals(userDB.getEmail(), request.email())
                            && repository.existsByEmail(request.email())) {
                        throw new GeneralNotFoundException("E-mail já cadastrado", request.email());
                    }
                    StoreDB temp = storeService
                            .consultById(request.storeId()).orElseThrow(
                                    () -> new GeneralNotFoundException("Loja não encontrada com o id : " + request.storeId(), request.storeId()));
                    return mapper.toResponse(
                            repository.save(
                                    mapper.toModelUpdate(id, request, temp)));
                })
                .orElseThrow(() -> new GeneralNotFoundException("Usuario não encontrado com o id : " + id, id));

    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        if (!repository.existsById(id)) {
            throw new GeneralNotFoundException("Usuário não encontrado com o id : " + id, id);
        }
        repository.deleteById(id);
        String requisitionKey = (String) redisTemplate.opsForValue().get("user:" + id + ":requisitionKey");
        if (Objects.nonNull(requisitionKey)) {
            redisTemplate.delete(requisitionKey);
            redisTemplate.delete("user:" + id + ":requisitionKey");
        }
    }
}
