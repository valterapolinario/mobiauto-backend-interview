package com.br.mobiauto.management.adapters.in.mapper;

import com.br.poc.payment.adapters.in.api.UserRequest;
import com.br.poc.payment.adapters.in.api.UserResponse;
import com.br.poc.payment.application.core.domain.UserDB;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T15:49:41-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Azul Systems, Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDB toModel(UserRequest request) {
        if ( request == null ) {
            return null;
        }

        UserDB userDB = new UserDB();

        userDB.setFullName( request.fullName() );
        userDB.setDocument( request.document() );
        userDB.setEmail( request.email() );
        userDB.setPassword( request.password() );
        userDB.setType( request.type() );

        return userDB;
    }

    @Override
    public UserResponse toResponse(UserDB userDB) {
        if ( userDB == null ) {
            return null;
        }

        Long id = null;
        String fullName = null;
        String email = null;
        String document = null;
        String type = null;

        id = userDB.getId();
        fullName = userDB.getFullName();
        email = userDB.getEmail();
        document = userDB.getDocument();
        if ( userDB.getType() != null ) {
            type = userDB.getType().name();
        }

        UserResponse userResponse = new UserResponse( id, fullName, email, document, type );

        return userResponse;
    }

    @Override
    public List<UserResponse> toListResponse(List<UserDB> userDBS) {
        if ( userDBS == null ) {
            return null;
        }

        List<UserResponse> list = new ArrayList<UserResponse>( userDBS.size() );
        for ( UserDB userDB : userDBS ) {
            list.add( toResponse( userDB ) );
        }

        return list;
    }
}
