package com.github.dannrocha.locadora.domain.repository;

import com.github.dannrocha.locadora.domain.model.Locacao;

import java.util.List;
import java.util.Optional;

public interface LocacaoRepository {
    Locacao salvar(Locacao locacao);
    Optional<Locacao> buscarPorId(Integer locacaoId);

    List<Locacao> salvarMuitos(List<Locacao> locacoes);
}
