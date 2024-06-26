package com.br.mobiauto.management.utils.mapper;

import com.br.mobiauto.management.dto.api.request.ClientRequestDTO;
import com.br.mobiauto.management.dto.api.request.StoreReqquestDTO;
import com.br.mobiauto.management.dto.api.response.ClientResponseDTO;
import com.br.mobiauto.management.dto.api.response.StoreResponseDTO;
import com.br.mobiauto.management.model.ClientDB;
import com.br.mobiauto.management.model.StoreDB;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StoreMapper {

    @Mapping(target = "id", ignore = true)
    StoreDB toModel(StoreReqquestDTO request);


    StoreResponseDTO toResponse(StoreDB model);

    StoreDB toModelUpdate(Long id, StoreReqquestDTO request);

}
