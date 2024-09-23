package com.br.mobiauto.management.utils.mapper;

import com.br.mobiauto.management.dto.api.request.UserRequestDTO;
import com.br.mobiauto.management.dto.api.response.UserResponseDTO;
import com.br.mobiauto.management.model.StoreDB;
import com.br.mobiauto.management.model.UserDB;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    //    @Mapping(target = "id", ignore = true)
    UserDB toModel(UserRequestDTO request, StoreDB store);

    //    @Mapping(target = "storeName", source = "store.nomeSocial")
//    @Mapping(target = "storeId", source = "store.id")
    UserResponseDTO toResponse(UserDB model);

    //    @Mapping(target = "store", source = "store")
//    @Mapping(target = "id", source = "id")
    UserDB toModelUpdate(Long id, UserRequestDTO request, StoreDB store);

}
