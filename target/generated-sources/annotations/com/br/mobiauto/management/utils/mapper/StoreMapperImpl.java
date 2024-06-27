package com.br.mobiauto.management.utils.mapper;

import com.br.mobiauto.management.dto.api.request.StoreReqquestDTO;
import com.br.mobiauto.management.dto.api.response.StoreResponseDTO;
import com.br.mobiauto.management.model.StoreDB;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-27T12:26:19-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Azul Systems, Inc.)"
)
@Component
public class StoreMapperImpl implements StoreMapper {

    @Override
    public StoreDB toModel(StoreReqquestDTO request) {
        if ( request == null ) {
            return null;
        }

        StoreDB storeDB = new StoreDB();

        storeDB.setCnpj( request.cnpj() );
        storeDB.setNomeSocial( request.nomeSocial() );

        return storeDB;
    }

    @Override
    public StoreResponseDTO toResponse(StoreDB model) {
        if ( model == null ) {
            return null;
        }

        Long id = null;
        String nomeSocial = null;
        String cnpj = null;

        id = model.getId();
        nomeSocial = model.getNomeSocial();
        cnpj = model.getCnpj();

        StoreResponseDTO storeResponseDTO = new StoreResponseDTO( id, nomeSocial, cnpj );

        return storeResponseDTO;
    }

    @Override
    public StoreDB toModelUpdate(Long id, StoreReqquestDTO request) {
        if ( id == null && request == null ) {
            return null;
        }

        StoreDB storeDB = new StoreDB();

        if ( request != null ) {
            storeDB.setCnpj( request.cnpj() );
            storeDB.setNomeSocial( request.nomeSocial() );
        }
        storeDB.setId( id );

        return storeDB;
    }
}
