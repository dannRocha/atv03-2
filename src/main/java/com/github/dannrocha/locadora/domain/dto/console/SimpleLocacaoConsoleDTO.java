package com.github.dannrocha.locadora.domain.dto.console;

import com.github.dannrocha.locadora.domain.model.Locacao;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record SimpleLocacaoConsoleDTO(
    Integer id,
    LocalDate data
) {
    public static SimpleLocacaoConsoleDTO fromModel(Locacao locacao) {
        return SimpleLocacaoConsoleDTO
            .builder()
            .id(locacao.getId())
            .data(locacao.getData())
            .build();
    }
}
