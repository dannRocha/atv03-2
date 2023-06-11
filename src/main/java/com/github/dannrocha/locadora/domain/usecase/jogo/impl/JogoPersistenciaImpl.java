package com.github.dannrocha.locadora.domain.usecase.jogo.impl;

import com.github.dannrocha.locadora.domain.dto.jogo.RegistroJogoDTO;
import com.github.dannrocha.locadora.domain.dto.jogo.SimpleJogoDTO;
import com.github.dannrocha.locadora.domain.repository.JogoRepository;
import com.github.dannrocha.locadora.domain.usecase.jogo.JogoPersistencia;

import java.util.Optional;

public class JogoPersistenciaImpl extends JogoPersistencia {

    private final JogoRepository repositorio;

    public JogoPersistenciaImpl(JogoRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public SimpleJogoDTO salvarJogo(RegistroJogoDTO registro) {
        return SimpleJogoDTO
                .fromModel(repositorio.salvar(registro.toModel()));
    }

    @Override
    public Optional<SimpleJogoDTO> buscarJogoPorId(Integer jogoId) {
        return repositorio
                .buscarPorId(jogoId)
                .map(SimpleJogoDTO::fromModel);
    }
}
