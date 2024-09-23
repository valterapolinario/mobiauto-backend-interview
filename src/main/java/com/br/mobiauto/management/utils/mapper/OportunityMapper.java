package com.br.mobiauto.management.utils.mapper;

import com.br.mobiauto.management.dto.api.request.OportunityRequestDTO;
import com.br.mobiauto.management.dto.api.request.OportunityRequestUpdateDTO;
import com.br.mobiauto.management.dto.api.response.OportunityResponseDTO;
import com.br.mobiauto.management.model.OportunityDB;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OportunityMapper {

    OportunityMapper INSTANCE = Mappers.getMapper(OportunityMapper.class);

    //    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "client.name", source = "clientName")
//    @Mapping(target = "client.phone", source = "clientPhone")
//    @Mapping(target = "client.email", source = "clientEmail")
//    @Mapping(target = "vehicle.model", source = "vehicleModel")
//    @Mapping(target = "vehicle.yearOfRelease", source = "vehicleYear")
//    @Mapping(target = "vehicle.brand", source = "vehicleBrand")
//    @Mapping(target = "vehicle.version", source = "vehicleVersion")
    OportunityDB toModel(OportunityRequestDTO request);


    OportunityResponseDTO toResponse(OportunityDB model);

    //    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "client.name", source = "request.clientName")
//    @Mapping(target = "client.phone", source = "request.clientPhone")
//    @Mapping(target = "client.email", source = "request.clientEmail")
//    @Mapping(target = "vehicle.model", source = "request.vehicleModel")
//    @Mapping(target = "vehicle.yearOfRelease", source = "request.vehicleYear")
//    @Mapping(target = "vehicle.brand", source = "request.vehicleBrand")
//    @Mapping(target = "vehicle.version", source = "request.vehicleVersion")
    OportunityDB toModelUpdate(OportunityRequestUpdateDTO request, @MappingTarget OportunityDB entity);

}
