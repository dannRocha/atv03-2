package com.github.dannrocha.locadora.factory.repository;

import com.github.dannrocha.locadora.repository.inmemory.ItemLocacaoRepositoryInMemory;
import com.github.dannrocha.locadora.domain.repository.JogoPlataformaRepository;
import com.github.dannrocha.locadora.domain.usecase.locacao.AlugarJogosPorPlataforma;
import com.github.dannrocha.locadora.domain.usecase.locacao.impl.AlugarJogosPorPlataformaImpl;
import com.github.dannrocha.locadora.domain.usecase.locacao.impl.LocacaoPersistenciaImpl;
import com.github.dannrocha.locadora.domain.usecase.plataforma.impl.JogoPlataformaPersistenciaImpl;
import com.github.dannrocha.locadora.repository.inmemory.LocacaoRepositoryInMemory;

public class AlugarJogosPorPlataformaFactory {

    private AlugarJogosPorPlataformaFactory() {}

    public static AlugarJogosPorPlataforma criar(JogoPlataformaRepository jogoPlataformaRepository) {
        return new AlugarJogosPorPlataformaImpl(
            new LocacaoPersistenciaImpl(
                    new LocacaoRepositoryInMemory(),
                    new ItemLocacaoRepositoryInMemory()),
            new JogoPlataformaPersistenciaImpl(jogoPlataformaRepository)
        );
    }
}
