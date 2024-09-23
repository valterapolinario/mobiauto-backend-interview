package com.br.mobiauto.management.utils.mapper;

import com.br.mobiauto.management.dto.api.request.ClientRequestDTO;
import com.br.mobiauto.management.dto.api.response.ClientResponseDTO;
import com.br.mobiauto.management.model.ClientDB;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    //    @Mapping(target = "id", ignore = true)
    ClientDB toModel(ClientRequestDTO request);


    ClientResponseDTO toResponse(ClientDB model);

    ClientDB toModelUpdate(Long id, ClientRequestDTO request);

}
