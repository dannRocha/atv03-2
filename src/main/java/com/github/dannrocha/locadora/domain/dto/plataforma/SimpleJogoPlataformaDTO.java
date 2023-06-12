package com.github.dannrocha.locadora.domain.dto.plataforma;

import com.github.dannrocha.locadora.domain.dto.jogo.SimpleJogoDTO;
import com.github.dannrocha.locadora.domain.model.JogoPlataforma;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record SimpleJogoPlataformaDTO(
    SimpleJogoDTO jogo,
    SimplePlataformaDTO plataforma,
    BigDecimal preco
) {
    public static SimpleJogoPlataformaDTO fromModel(JogoPlataforma jogoPlataforma) {
        return SimpleJogoPlataformaDTO
            .builder()
            .jogo(SimpleJogoDTO.fromModel(jogoPlataforma.getJogo()))
            .plataforma(SimplePlataformaDTO.fromModel(jogoPlataforma.getPlataforma()))
            .preco(jogoPlataforma.getPreco())
            .build();
    }
}
