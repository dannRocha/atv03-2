package com.github.dannrocha.locadora.factory.repository;

import com.github.dannrocha.locadora.domain.repository.JogoRepository;
import com.github.dannrocha.locadora.domain.repository.PlataformaRepository;
import com.github.dannrocha.locadora.domain.usecase.plataforma.JogoPlataformaPersistancia;
import com.github.dannrocha.locadora.domain.usecase.plataforma.impl.JogoPlataformaPersistenciaImpl;
import com.github.dannrocha.locadora.repository.inmemory.JogoPlataformaRepositoryInMemory;

public class JogoPlataformaPersistenciaFactory {

    public static JogoPlataformaPersistancia criar(JogoRepository jogoRepository, PlataformaRepository plataformaRepository) {
        return new JogoPlataformaPersistenciaImpl(
                new JogoPlataformaRepositoryInMemory(
                    plataformaRepository,
                    jogoRepository)
        );
    }
}
