package com.github.dannrocha.locadora.domain.dto.plataforma;

import com.github.dannrocha.locadora.domain.dto.jogo.SimpleJogoDTO;
import com.github.dannrocha.locadora.domain.model.Jogo;
import com.github.dannrocha.locadora.domain.model.JogoPlataforma;
import com.github.dannrocha.locadora.domain.model.Plataforma;
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
            .jogo(SimpleJogoDTO.fromModel(Jogo.builder().id(jogoPlataforma.getJogoId()).build()))
            .plataforma(SimplePlataformaDTO.fromModel(Plataforma.builder().id(jogoPlataforma.getPlataformaId()).build()))
            .preco(jogoPlataforma.getPreco())
            .build();
    }
}
