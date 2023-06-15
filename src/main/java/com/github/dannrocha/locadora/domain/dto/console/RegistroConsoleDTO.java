package com.github.dannrocha.locadora.domain.dto.console;

import com.github.dannrocha.locadora.domain.model.Console;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record RegistroConsoleDTO(
    String nome,
    BigDecimal preco
) {

    public Console toModel() {
        return Console
            .builder()
            .id(null)
            .preco(this.preco)
            .nome(this.nome)
            .build();
    }
}
