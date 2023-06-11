package com.github.dannrocha.locadora.domain.usecase.jogo;

import com.github.dannrocha.locadora.domain.dto.jogo.RegistroJogoDTO;
import com.github.dannrocha.locadora.domain.dto.jogo.SimpleJogoDTO;

import java.util.Optional;

public abstract class JogoPersistencia {
    public abstract SimpleJogoDTO salvarJogo(RegistroJogoDTO registro);
    public abstract Optional<SimpleJogoDTO> buscarJogoPorId(Integer jogoId);
}
