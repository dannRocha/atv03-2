package com.github.dannrocha.locadora.domain.dto.jogo;

import com.github.dannrocha.locadora.domain.model.Jogo;
import lombok.Builder;

@Builder
public record RegistroJogoDTO(
    String titulo
) {

    public Jogo toModel() {
        return Jogo
            .builder()
            .id(null)
            .titulo(this.titulo)
            .build();
    }
}
