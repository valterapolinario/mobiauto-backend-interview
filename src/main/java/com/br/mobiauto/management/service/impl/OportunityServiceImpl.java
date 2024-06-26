package com.br.mobiauto.management.service.impl;

import com.br.mobiauto.management.dto.api.request.OportunityRequestDTO;
import com.br.mobiauto.management.dto.api.request.OportunityRequestUpdateDTO;
import com.br.mobiauto.management.dto.api.response.OportunityResponseDTO;
import com.br.mobiauto.management.exception.ApiBussinesException;
import com.br.mobiauto.management.exception.GeneralNotFoundException;
import com.br.mobiauto.management.model.OportunityDB;
import com.br.mobiauto.management.model.StoreDB;
import com.br.mobiauto.management.model.UserDB;
import com.br.mobiauto.management.repository.OportunityRepository;
import com.br.mobiauto.management.service.OportunityService;
import com.br.mobiauto.management.service.StoreService;
import com.br.mobiauto.management.service.UserDependencyService;
import com.br.mobiauto.management.utils.DateUtils;
import com.br.mobiauto.management.utils.mapper.OportunityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.br.mobiauto.management.model.StatusOportunityEnum.IN_PROGRESS;

@Service
public class OportunityServiceImpl implements OportunityService {

    @Autowired
    private OportunityRepository repository;

    @Autowired
    private OportunityMapper mapper;

    @Autowired
    private StoreService storeService;

    @Autowired
    private UserDependencyService dependencyService;

    @Override
    @Transactional
    public OportunityResponseDTO create(OportunityRequestDTO request) {
        StoreDB store = storeService.consultById(request.storeId()).orElseThrow(() -> new GeneralNotFoundException("revenda nao encontrada com o id :", request.storeId()));
        OportunityDB entity = mapper.toModel(request);
        entity.setResale(store);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public Page<OportunityResponseDTO> getAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toResponse);
    }

    @Override
    public OportunityResponseDTO get(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new GeneralNotFoundException("oportunidade nao encontrada com o id :", id));
    }

    @Override
    @Transactional
    public OportunityResponseDTO update(Long id, OportunityRequestUpdateDTO request) {
        return mapper.toResponse(
                repository.findById(id)
                        .map(entity -> {
                            OportunityDB modelUpdate = mapper.toModelUpdate(request, entity);
                            return repository.save(modelUpdate);
                        })
                        .orElseThrow(() -> new GeneralNotFoundException("oportunidade nao encontrada com o id :" + id, id)));
    }

    @Override
    @Transactional
    public void assignResponsible(Long id, Long userId) {
        UserDB responsible = dependencyService.getUserById(userId);
        if(!responsible.getPosition().isAssistent()){
            throw new ApiBussinesException(String.format("Cargo de '%s' nao  e elegivel para assumir responsabilidade", responsible.getPosition().getDescription()));
        }
        repository.findById(id).ifPresentOrElse(entity -> {
            entity.setResponsible(responsible);
            entity.setDateOfAssignment(DateUtils.now());
            entity.setStatus(IN_PROGRESS);
            repository.save(entity);
        }, () -> {
            throw new GeneralNotFoundException("oportunidade nao encontrada com o id :" + id, id);
        });
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new GeneralNotFoundException("oportunidade nao encontrada com o id :" + id, id);
        } else {
            repository.deleteById(id);
        }
    }

    @Override
    public void assignResponsibleForSched(OportunityDB entity, UserDB responsible) {
        entity.setResponsible(responsible);
        entity.setDateOfAssignment(DateUtils.now());
        entity.setStatus(IN_PROGRESS);
        repository.save(entity);

    }

    @Override
    public List<OportunityDB> getOpportunityWithoutResponsibility() {
        List<OportunityDB>test = repository.findAllByResponsible_IdIsNull();
        List<OportunityDB>test2 = repository.findByResponsibleNull();
        return  test;
    }
}
