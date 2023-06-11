package com.github.dannrocha.locadora.domain.dto.plataforma;

import com.github.dannrocha.locadora.domain.model.Jogo;
import com.github.dannrocha.locadora.domain.model.JogoPlataforma;
import com.github.dannrocha.locadora.domain.model.Plataforma;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record RegistroJogoPlataformaDTO(
    @NotNull
    Integer jogoId,

    @NotNull
    Integer plataformaId,

    @NotNull
    BigDecimal preco
) {

    public JogoPlataforma toModel() {
        return JogoPlataforma
            .builder()
            .jogo(Jogo.builder().id(jogoId).build())
            .preco(preco)
            .plataforma(Plataforma.builder().id(plataformaId).build())
            .build();
    }
}
