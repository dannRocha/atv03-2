package com.github.dannrocha.locadora.domain.usecase.plataforma.impl;

import com.github.dannrocha.locadora.domain.dto.plataforma.RegistroJogoPlataformaDTO;
import com.github.dannrocha.locadora.domain.dto.plataforma.SimpleJogoPlataformaDTO;
import com.github.dannrocha.locadora.domain.repository.JogoPlataformaRepository;
import com.github.dannrocha.locadora.domain.usecase.plataforma.JogoPlataformaPersistancia;

import java.util.Optional;

public class JogoPlataformaPersistenciaImpl extends JogoPlataformaPersistancia {

    private final JogoPlataformaRepository jogoPlataformaRepository;

    public JogoPlataformaPersistenciaImpl(JogoPlataformaRepository jogoPlataformaRepository) {
        this.jogoPlataformaRepository = jogoPlataformaRepository;
    }


    @Override
    public SimpleJogoPlataformaDTO registrarPrecoJogoPorPlataforma(RegistroJogoPlataformaDTO registroJogoPlataformaDTO) {
        return SimpleJogoPlataformaDTO.fromModel(jogoPlataformaRepository
                .registrarPrecoJogoPorPlataforma(registroJogoPlataformaDTO.toModel()));
    }

    @Override
    public Optional<SimpleJogoPlataformaDTO> buscarPrecoJogoPorJogoEPlataforma(Integer jogoId, Integer plataformaId) {
        return jogoPlataformaRepository
            .buscarJogoPorJogoIdEPlataformaId(jogoId, plataformaId)
            .map(SimpleJogoPlataformaDTO::fromModel);
    }
}
