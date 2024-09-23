package com.br.mobiauto.management.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusOportunityEnum {

    NEW("NOVO"),
    IN_PROGRESS("EM_ATENDIMENTO"),
    COMPLETED("CONCLUIDO");

    private String description;

}
