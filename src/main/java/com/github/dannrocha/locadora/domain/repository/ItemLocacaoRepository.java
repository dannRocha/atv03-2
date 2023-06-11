package com.github.dannrocha.locadora.domain.repository;

import com.github.dannrocha.locadora.domain.model.ItemLocacao;

import java.util.List;
import java.util.Optional;

public interface ItemLocacaoRepository {
    ItemLocacao salvar(ItemLocacao itemLocacao);
    Optional<ItemLocacao> buscarPorId(Integer itemLocacaoId);

    List<ItemLocacao> salvarMuitos(List<ItemLocacao> modelItemLocacao);
}
