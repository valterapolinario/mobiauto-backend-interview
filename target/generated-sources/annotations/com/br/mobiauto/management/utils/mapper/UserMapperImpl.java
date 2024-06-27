package com.br.mobiauto.management.utils.mapper;

import com.br.mobiauto.management.dto.api.request.UserRequestDTO;
import com.br.mobiauto.management.dto.api.response.UserResponseDTO;
import com.br.mobiauto.management.model.StoreDB;
import com.br.mobiauto.management.model.UserDB;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-27T10:22:57-0300",
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

        return userDB;
    }

    @Override
    public UserResponseDTO toResponse(UserDB model) {
        if ( model == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String email = null;
        String position = null;
        String storeName = null;
        Long storeId = null;

        UserResponseDTO userResponseDTO = new UserResponseDTO( id, name, email, position, storeName, storeId );

        return userResponseDTO;
    }

    @Override
    public UserDB toModelUpdate(Long id, UserRequestDTO request, StoreDB store) {
        if ( id == null && request == null && store == null ) {
            return null;
        }

        UserDB userDB = new UserDB();

        return userDB;
    }
}
