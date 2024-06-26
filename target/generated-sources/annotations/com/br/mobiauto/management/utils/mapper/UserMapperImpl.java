package com.br.mobiauto.management.utils.mapper;

import com.br.mobiauto.management.dto.api.request.UserRequestDTO;
import com.br.mobiauto.management.dto.api.response.UserResponseDTO;
import com.br.mobiauto.management.model.StoreDB;
import com.br.mobiauto.management.model.UserDB;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-26T18:22:01-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Azul Systems, Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDB toModel(UserRequestDTO request, StoreDB store) {
        if ( request == null && store == null ) {
            return null;
        }

        UserDB userDB = new UserDB();

        if ( request != null ) {
            userDB.setName( request.name() );
            userDB.setEmail( request.email() );
            userDB.setPassword( request.password() );
            userDB.setPosition( request.position() );
        }
        userDB.setStore( store );

        return userDB;
    }

    @Override
    public UserResponseDTO toResponse(UserDB model) {
        if ( model == null ) {
            return null;
        }

        String storeName = null;
        Long storeId = null;
        Long id = null;
        String name = null;
        String email = null;
        String position = null;

        storeName = modelStoreNomeSocial( model );
        storeId = modelStoreId( model );
        id = model.getId();
        name = model.getName();
        email = model.getEmail();
        if ( model.getPosition() != null ) {
            position = model.getPosition().name();
        }

        UserResponseDTO userResponseDTO = new UserResponseDTO( id, name, email, position, storeName, storeId );

        return userResponseDTO;
    }

    @Override
    public UserDB toModelUpdate(Long id, UserRequestDTO request, StoreDB store) {
        if ( id == null && request == null && store == null ) {
            return null;
        }

        UserDB userDB = new UserDB();

        if ( request != null ) {
            userDB.setName( request.name() );
            userDB.setEmail( request.email() );
            userDB.setPassword( request.password() );
            userDB.setPosition( request.position() );
        }
        userDB.setId( id );
        userDB.setStore( store );

        return userDB;
    }

    private String modelStoreNomeSocial(UserDB userDB) {
        if ( userDB == null ) {
            return null;
        }
        StoreDB store = userDB.getStore();
        if ( store == null ) {
            return null;
        }
        String nomeSocial = store.getNomeSocial();
        if ( nomeSocial == null ) {
            return null;
        }
        return nomeSocial;
    }

    private Long modelStoreId(UserDB userDB) {
        if ( userDB == null ) {
            return null;
        }
        StoreDB store = userDB.getStore();
        if ( store == null ) {
            return null;
        }
        Long id = store.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
