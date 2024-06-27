package com.br.mobiauto.management.utils.mapper;

import com.br.mobiauto.management.dto.api.request.ClientRequestDTO;
import com.br.mobiauto.management.dto.api.response.ClientResponseDTO;
import com.br.mobiauto.management.model.ClientDB;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-27T10:22:57-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Azul Systems, Inc.)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDB toModel(ClientRequestDTO request) {
        if ( request == null ) {
            return null;
        }

        ClientDB clientDB = new ClientDB();

        return clientDB;
    }

    @Override
    public ClientResponseDTO toResponse(ClientDB model) {
        if ( model == null ) {
            return null;
        }

        String name = null;
        String email = null;
        String phone = null;

        ClientResponseDTO clientResponseDTO = new ClientResponseDTO( name, email, phone );

        return clientResponseDTO;
    }

    @Override
    public ClientDB toModelUpdate(Long id, ClientRequestDTO request) {
        if ( id == null && request == null ) {
            return null;
        }

        ClientDB clientDB = new ClientDB();

        return clientDB;
    }
}
