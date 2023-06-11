package com.github.dannrocha.locadora.domain.usecase.plataforma;

import com.github.dannrocha.locadora.domain.dto.plataforma.RegistroJogoPlataformaDTO;
import com.github.dannrocha.locadora.domain.dto.plataforma.SimpleJogoPlataformaDTO;

import java.util.Optional;

public abstract class JogoPlataformaPersistancia {
    public abstract SimpleJogoPlataformaDTO registrarPrecoJogoPorPlataforma(RegistroJogoPlataformaDTO registroJogoPlataformaDTO);
    public abstract Optional<SimpleJogoPlataformaDTO> buscarPrecoJogoPorJogoEPlataforma(Integer jogoId, Integer plataformaId);
}
