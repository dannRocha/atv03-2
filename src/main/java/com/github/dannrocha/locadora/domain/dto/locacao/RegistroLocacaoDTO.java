package com.github.dannrocha.locadora.domain.dto.locacao;

import com.github.dannrocha.locadora.domain.model.ItemLocacao;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public record RegistroLocacaoDTO(
    List<RegistroLocacaoJogoDTO> jogos

) {
    public List<ItemLocacao> toModelItemLocacao(Integer id) {
        return jogos
            .stream()
            .map(jogo ->
                ItemLocacao.builder()
                .id(null)
                .dias(jogo.quantidadeDeDias())
                .locacaoId(id)
                .preco(jogo.preco())
                .plataformaId(jogo.plataformaId())
                .build())
            .collect(Collectors.toList());
    }
}
