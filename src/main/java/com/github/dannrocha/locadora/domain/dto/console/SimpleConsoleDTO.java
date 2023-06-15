package com.github.dannrocha.locadora.domain.dto.console;

import com.github.dannrocha.locadora.domain.model.Console;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record SimpleConsoleDTO(
    Integer id,
    String nome,
    BigDecimal preco
) {

    public static SimpleConsoleDTO fromModel(Console console) {
        return SimpleConsoleDTO
            .builder()
            .id(console.getId())
            .preco(console.getPreco())
            .nome(console.getNome())
            .build();
    }
}
