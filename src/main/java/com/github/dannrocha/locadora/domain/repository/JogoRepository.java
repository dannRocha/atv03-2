package com.github.dannrocha.locadora.domain.repository;

import com.github.dannrocha.locadora.domain.model.Jogo;

import java.util.Optional;

public interface JogoRepository {
    Optional<Jogo> buscarPorId(Integer id);
    Jogo salvar(Jogo jogo);
}
