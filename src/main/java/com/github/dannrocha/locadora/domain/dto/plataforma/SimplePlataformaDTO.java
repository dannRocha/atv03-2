package com.github.dannrocha.locadora.domain.dto.plataforma;

import com.github.dannrocha.locadora.domain.model.Plataforma;
import lombok.Builder;

@Builder
public record SimplePlataformaDTO(
    Integer id,
    String nome
) {

    public static SimplePlataformaDTO fromModel(Plataforma plataforma) {
        return SimplePlataformaDTO
            .builder()
            .nome(plataforma.nome())
            .id(plataforma.id())
            .build();
    }
}
