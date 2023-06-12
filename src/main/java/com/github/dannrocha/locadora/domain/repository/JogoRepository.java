package com.github.dannrocha.locadora.domain.repository;

import com.github.dannrocha.locadora.domain.model.Jogo;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface JogoRepository {
    Optional<Jogo> buscarPorId(Integer id);
    Jogo salvar(Jogo jogo);
}
