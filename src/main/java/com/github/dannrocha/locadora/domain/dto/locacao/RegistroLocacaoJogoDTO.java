package com.github.dannrocha.locadora.domain.dto.locacao;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record RegistroLocacaoJogoDTO(
    @NotNull
    Integer jogoId,
    @NotNull
    Integer plataformaId,
    @NotNull
    Integer quantidadeDeDias,
    BigDecimal preco
) {
}
