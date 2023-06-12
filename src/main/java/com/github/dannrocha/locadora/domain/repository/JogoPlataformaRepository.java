package com.github.dannrocha.locadora.domain.repository;

import com.github.dannrocha.locadora.domain.model.JogoPlataforma;
import com.github.dannrocha.locadora.domain.repository.consulta.jogoplataforma.JogoPlataformaID;

import java.util.List;
import java.util.Optional;

public interface JogoPlataformaRepository {
    JogoPlataforma registrarPrecoJogoPorPlataforma(JogoPlataforma registroJogoPlataformaDTO);
    Optional<JogoPlataforma> buscarJogoPorJogoIdEPlataformaId(JogoPlataformaID IDs);

    List<JogoPlataforma> buscarJogoPorJogoIdEPlataformaId(List<JogoPlataformaID> grupo);
}
