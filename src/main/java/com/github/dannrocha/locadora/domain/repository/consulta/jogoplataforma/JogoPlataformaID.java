package com.github.dannrocha.locadora.domain.repository.consulta.jogoplataforma;

import lombok.Builder;

@Builder
public record JogoPlataformaID(
        Integer jogoId,
        Integer plataformaId
) {
}
