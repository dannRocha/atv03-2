package com.github.dannrocha.locadora.domain.dto.jogo;

import com.github.dannrocha.locadora.domain.model.Jogo;
import lombok.Builder;

@Builder
public record SimpleJogoDTO(
    Integer id,
    String titulo
) {

    public static SimpleJogoDTO fromModel(Jogo jogo) {
        return SimpleJogoDTO
            .builder()
            .id(jogo.getId())
            .titulo(jogo.getTitulo())
            .build();
    }
}
