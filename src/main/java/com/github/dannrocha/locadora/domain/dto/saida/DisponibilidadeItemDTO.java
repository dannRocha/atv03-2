package com.github.dannrocha.locadora.domain.dto.saida;

import lombok.Builder;

@Builder
public record DisponibilidadeItemDTO(
    String nome,
    Boolean disponivel
) {
}
