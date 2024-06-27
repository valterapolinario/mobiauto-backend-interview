package com.br.mobiauto.management.utils.mapper;

import com.br.mobiauto.management.dto.api.request.OportunityRequestDTO;
import com.br.mobiauto.management.dto.api.request.OportunityRequestUpdateDTO;
import com.br.mobiauto.management.dto.api.response.ClientResponseDTO;
import com.br.mobiauto.management.dto.api.response.OportunityResponseDTO;
import com.br.mobiauto.management.dto.api.response.StoreResponseDTO;
import com.br.mobiauto.management.dto.api.response.UserResponseDTO;
import com.br.mobiauto.management.dto.api.response.VehicleResponseDTO;
import com.br.mobiauto.management.model.OportunityDB;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-27T10:22:57-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Azul Systems, Inc.)"
)
@Component
public class OportunityMapperImpl implements OportunityMapper {

    @Override
    public OportunityDB toModel(OportunityRequestDTO request) {
        if ( request == null ) {
            return null;
        }

        OportunityDB oportunityDB = new OportunityDB();

        return oportunityDB;
    }

    @Override
    public OportunityResponseDTO toResponse(OportunityDB model) {
        if ( model == null ) {
            return null;
        }

        String id = null;
        String motive = null;
        String status = null;
        String dateOfAssignment = null;
        String dateOfCompletion = null;
        ClientResponseDTO client = null;
        VehicleResponseDTO vehicle = null;
        UserResponseDTO responsible = null;
        StoreResponseDTO resale = null;

        OportunityResponseDTO oportunityResponseDTO = new OportunityResponseDTO( id, motive, status, dateOfAssignment, dateOfCompletion, client, vehicle, responsible, resale );

        return oportunityResponseDTO;
    }

    @Override
    public OportunityDB toModelUpdate(OportunityRequestUpdateDTO request, OportunityDB entity) {
        if ( request == null ) {
            return entity;
        }

        return entity;
    }
}
