package com.github.dannrocha.locadora.domain.repository;

import com.github.dannrocha.locadora.domain.model.JogoPlataforma;

import java.util.Optional;

public interface JogoPlataformaRepository {
    JogoPlataforma registrarPrecoJogoPorPlataforma(JogoPlataforma registroJogoPlataformaDTO);
    Optional<JogoPlataforma> buscarJogoPorJogoIdEPlataformaId(Integer jogoId, Integer plataformaId);
}
