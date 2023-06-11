package com.github.dannrocha.locadora.domain.dto.locacao;

import com.github.dannrocha.locadora.domain.model.ItemLocacao;
import com.github.dannrocha.locadora.domain.model.Locacao;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record RegistroLocacaoDTO(

    @NotNull
    LocalDate data,

    @NotNull
    Integer plataformaId,
    List<RegistroItemLocaoDTO> items
) {
    public Locacao toModelLocacao() {
        return Locacao.builder()
                .data(this.data)
                .build();
    }

    public List<ItemLocacao> toModelItemLocacao(Integer locacaoId) {
        return items.stream()
                .map(item -> ItemLocacao
                    .builder()
                        .dias(item.dias())
                        .locacaoId(locacaoId)
                        .quantidade(item.quantidade())
                        .plataformaId(plataformaId)
                        .build()
                )
                .collect(Collectors.toList());
    }

    public List<ItemLocacao> toModelItemLocacao() {
        return toModelItemLocacao(null);
    }
}
