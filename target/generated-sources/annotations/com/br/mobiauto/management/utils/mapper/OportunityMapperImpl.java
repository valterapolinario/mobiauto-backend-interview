package com.br.mobiauto.management.utils.mapper;

import com.br.mobiauto.management.dto.api.request.OportunityRequestDTO;
import com.br.mobiauto.management.dto.api.request.OportunityRequestUpdateDTO;
import com.br.mobiauto.management.dto.api.response.ClientResponseDTO;
import com.br.mobiauto.management.dto.api.response.OportunityResponseDTO;
import com.br.mobiauto.management.dto.api.response.StoreResponseDTO;
import com.br.mobiauto.management.dto.api.response.UserResponseDTO;
import com.br.mobiauto.management.dto.api.response.VehicleResponseDTO;
import com.br.mobiauto.management.model.ClientDB;
import com.br.mobiauto.management.model.OportunityDB;
import com.br.mobiauto.management.model.StoreDB;
import com.br.mobiauto.management.model.UserDB;
import com.br.mobiauto.management.model.VehicleDB;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-26T13:10:17-0300",
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

        oportunityDB.setClient( oportunityRequestDTOToClientDB( request ) );
        oportunityDB.setVehicle( oportunityRequestDTOToVehicleDB( request ) );

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

        if ( model.getId() != null ) {
            id = String.valueOf( model.getId() );
        }
        motive = model.getMotive();
        if ( model.getStatus() != null ) {
            status = model.getStatus().name();
        }
        if ( model.getDateOfAssignment() != null ) {
            dateOfAssignment = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( model.getDateOfAssignment() );
        }
        if ( model.getDateOfCompletion() != null ) {
            dateOfCompletion = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( model.getDateOfCompletion() );
        }
        client = clientDBToClientResponseDTO( model.getClient() );
        vehicle = vehicleDBToVehicleResponseDTO( model.getVehicle() );
        responsible = userDBToUserResponseDTO( model.getResponsible() );
        resale = storeDBToStoreResponseDTO( model.getResale() );

        OportunityResponseDTO oportunityResponseDTO = new OportunityResponseDTO( id, motive, status, dateOfAssignment, dateOfCompletion, client, vehicle, responsible, resale );

        return oportunityResponseDTO;
    }

    @Override
    public OportunityDB toModelUpdate(OportunityRequestUpdateDTO request, OportunityDB entity) {
        if ( request == null ) {
            return entity;
        }

        if ( entity.getClient() == null ) {
            entity.setClient( new ClientDB() );
        }
        oportunityRequestUpdateDTOToClientDB( request, entity.getClient() );
        if ( entity.getVehicle() == null ) {
            entity.setVehicle( new VehicleDB() );
        }
        oportunityRequestUpdateDTOToVehicleDB( request, entity.getVehicle() );

        return entity;
    }

    protected ClientDB oportunityRequestDTOToClientDB(OportunityRequestDTO oportunityRequestDTO) {
        if ( oportunityRequestDTO == null ) {
            return null;
        }

        ClientDB clientDB = new ClientDB();

        clientDB.setName( oportunityRequestDTO.clientName() );
        clientDB.setPhone( oportunityRequestDTO.clientPhone() );
        clientDB.setEmail( oportunityRequestDTO.clientEmail() );

        return clientDB;
    }

    protected VehicleDB oportunityRequestDTOToVehicleDB(OportunityRequestDTO oportunityRequestDTO) {
        if ( oportunityRequestDTO == null ) {
            return null;
        }

        VehicleDB vehicleDB = new VehicleDB();

        vehicleDB.setModel( oportunityRequestDTO.vehicleModel() );
        if ( oportunityRequestDTO.vehicleYear() != null ) {
            vehicleDB.setYearOfRelease( oportunityRequestDTO.vehicleYear() );
        }
        vehicleDB.setBrand( oportunityRequestDTO.vehicleBrand() );
        vehicleDB.setVersion( oportunityRequestDTO.vehicleVersion() );

        return vehicleDB;
    }

    protected ClientResponseDTO clientDBToClientResponseDTO(ClientDB clientDB) {
        if ( clientDB == null ) {
            return null;
        }

        String name = null;
        String email = null;
        String phone = null;

        name = clientDB.getName();
        email = clientDB.getEmail();
        phone = clientDB.getPhone();

        ClientResponseDTO clientResponseDTO = new ClientResponseDTO( name, email, phone );

        return clientResponseDTO;
    }

    protected VehicleResponseDTO vehicleDBToVehicleResponseDTO(VehicleDB vehicleDB) {
        if ( vehicleDB == null ) {
            return null;
        }

        String id = null;
        String brand = null;
        String model = null;
        String version = null;
        int yearOfRelease = 0;

        if ( vehicleDB.getId() != null ) {
            id = String.valueOf( vehicleDB.getId() );
        }
        brand = vehicleDB.getBrand();
        model = vehicleDB.getModel();
        version = vehicleDB.getVersion();
        yearOfRelease = vehicleDB.getYearOfRelease();

        VehicleResponseDTO vehicleResponseDTO = new VehicleResponseDTO( id, brand, model, version, yearOfRelease );

        return vehicleResponseDTO;
    }

    protected UserResponseDTO userDBToUserResponseDTO(UserDB userDB) {
        if ( userDB == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String email = null;
        String position = null;

        id = userDB.getId();
        name = userDB.getName();
        email = userDB.getEmail();
        if ( userDB.getPosition() != null ) {
            position = userDB.getPosition().name();
        }

        String storeName = null;
        Long storeId = null;

        UserResponseDTO userResponseDTO = new UserResponseDTO( id, name, email, position, storeName, storeId );

        return userResponseDTO;
    }

    protected StoreResponseDTO storeDBToStoreResponseDTO(StoreDB storeDB) {
        if ( storeDB == null ) {
            return null;
        }

        Long id = null;
        String nomeSocial = null;
        String cnpj = null;

        id = storeDB.getId();
        nomeSocial = storeDB.getNomeSocial();
        cnpj = storeDB.getCnpj();

        StoreResponseDTO storeResponseDTO = new StoreResponseDTO( id, nomeSocial, cnpj );

        return storeResponseDTO;
    }

    protected void oportunityRequestUpdateDTOToClientDB(OportunityRequestUpdateDTO oportunityRequestUpdateDTO, ClientDB mappingTarget) {
        if ( oportunityRequestUpdateDTO == null ) {
            return;
        }

        if ( oportunityRequestUpdateDTO.clientName() != null ) {
            mappingTarget.setName( oportunityRequestUpdateDTO.clientName() );
        }
        if ( oportunityRequestUpdateDTO.clientPhone() != null ) {
            mappingTarget.setPhone( oportunityRequestUpdateDTO.clientPhone() );
        }
        if ( oportunityRequestUpdateDTO.clientEmail() != null ) {
            mappingTarget.setEmail( oportunityRequestUpdateDTO.clientEmail() );
        }
    }

    protected void oportunityRequestUpdateDTOToVehicleDB(OportunityRequestUpdateDTO oportunityRequestUpdateDTO, VehicleDB mappingTarget) {
        if ( oportunityRequestUpdateDTO == null ) {
            return;
        }

        if ( oportunityRequestUpdateDTO.vehicleModel() != null ) {
            mappingTarget.setModel( oportunityRequestUpdateDTO.vehicleModel() );
        }
        if ( oportunityRequestUpdateDTO.vehicleYear() != null ) {
            mappingTarget.setYearOfRelease( oportunityRequestUpdateDTO.vehicleYear() );
        }
        if ( oportunityRequestUpdateDTO.vehicleBrand() != null ) {
            mappingTarget.setBrand( oportunityRequestUpdateDTO.vehicleBrand() );
        }
        if ( oportunityRequestUpdateDTO.vehicleVersion() != null ) {
            mappingTarget.setVersion( oportunityRequestUpdateDTO.vehicleVersion() );
        }
    }
}
