package com.github.dannrocha.locadora.domain.repository;

import com.github.dannrocha.locadora.domain.model.Jogo;

import java.time.LocalDate;
import java.util.Optional;

public interface JogoRepository {
    Optional<Jogo> buscarPorId(Integer id);
    Jogo salvar(Jogo jogo);

    Optional<Jogo> buscarJogoPorNome(String nome);

    Optional<Jogo> buscarJogoDisponivelPorNomeEData(String nome, LocalDate data);
}
