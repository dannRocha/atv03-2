package com.github.dannrocha.locadora.domain.repository;

import com.github.dannrocha.locadora.domain.model.ItemLocacao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ItemLocacaoRepository {
    ItemLocacao salvar(ItemLocacao itemLocacao);
    Optional<ItemLocacao> buscarPorId(Integer itemLocacaoId);

    List<ItemLocacao> salvarMuitos(List<ItemLocacao> modelItemLocacao);
}
