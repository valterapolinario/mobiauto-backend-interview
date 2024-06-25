package com.br.mobiauto.management.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserPositionEnum {
    ADMIN("ADMINISTRADOR"),
    MANAGER("GERENTE"),
    ASSISTANT("ASSISTENTE"),
    OWNER("PROPRIETARIO"),
    OTHER("OUTRO");

    private String description;
}
