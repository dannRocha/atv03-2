package com.github.dannrocha.locadora.domain.repository;

import com.github.dannrocha.locadora.domain.model.Locacao;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface LocacaoRepository {
    Locacao salvar(Locacao locacao);
    Optional<Locacao> buscarPorId(Integer locacaoId);
}
