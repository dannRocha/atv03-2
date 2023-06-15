package com.github.dannrocha.locadora.domain.dto.console;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record SimpleAlugarConsoleDetalhesDTO(
    BigDecimal preco,
    List<SimpleLocacaoConsoleDTO> locacoes
) {
}
