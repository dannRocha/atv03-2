package com.github.dannrocha.locadora.domain.dto.plataforma;

import com.github.dannrocha.locadora.domain.model.Plataforma;
import lombok.Builder;

@Builder
public record RegistroPlataformaDTO(
    String nome
) {
    public Plataforma toModel() {
        return Plataforma
            .builder()
            .id(null)
            .nome(this.nome)
            .build();
    }
}
