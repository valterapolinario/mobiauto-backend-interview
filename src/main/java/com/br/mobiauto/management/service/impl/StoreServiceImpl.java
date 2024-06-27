package com.br.mobiauto.management.service.impl;

import com.br.mobiauto.management.dto.api.request.StoreReqquestDTO;
import com.br.mobiauto.management.dto.api.response.StoreResponseDTO;
import com.br.mobiauto.management.exception.DatabaseRulesException;
import com.br.mobiauto.management.exception.GeneralNotFoundException;
import com.br.mobiauto.management.model.StoreDB;
import com.br.mobiauto.management.repository.StoreRepository;
import com.br.mobiauto.management.service.StoreService;
import com.br.mobiauto.management.service.UserDependencyService;
import com.br.mobiauto.management.utils.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository repository;

    @Autowired
    private UserDependencyService userDependencyService;

    @Autowired
    private StoreMapper mapper;

    @Override
    public Optional<StoreDB> consultById(Long id) {
        return repository.findById(id);
    }

    @Override
    public StoreResponseDTO consultEntityById(Long id) {
        return consultById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new GeneralNotFoundException("revenda não encontrada para o id :" + id, id));
    }

    @Override
    public StoreResponseDTO create(StoreReqquestDTO request) {
        if (repository.existsByCnpj(request.cnpj())) {
            throw new GeneralNotFoundException("revenda já cadastrada para o cnpj :" + request.cnpj(), request.cnpj());
        } else {
            return mapper
                    .toResponse(repository
                            .save(mapper.toModel(request)));
        }
    }

    @Override
    public StoreResponseDTO update(Long id, StoreReqquestDTO request) {
        return mapper.toResponse(
                repository.findById(id)
                        .map(store -> {
                            if (!Objects.equals(request.cnpj(), store.getCnpj())
                                    && repository.existsByCnpj(request.cnpj())) {
                                throw new GeneralNotFoundException("revenda já cadastrada para o cnpj :" + request.cnpj(), request.cnpj());
                            } else {
                                store = mapper.toModelUpdate(id, request);
                                return repository.save(store);
                            }
                        })
                        .orElseThrow(() -> new GeneralNotFoundException("revenda não encontrada para o id :" + id, id))
        );
    }

    @Override
    public Page<StoreResponseDTO> consultAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toResponse);
    }

    @Override
    public void delete(Long id) {
        consultById(id)
                .ifPresentOrElse(entity -> {
                    if (userDependencyService.existsByStoreId(id)) {
                        throw new DatabaseRulesException("Não é possível excluir uma revenda com usuários vinculados", id);
                    } else {
                        repository.deleteById(id);
                    }
                }, () -> {
                    throw new GeneralNotFoundException("revenda não encontrada para o id : " + id, id);
                });
    }
}
