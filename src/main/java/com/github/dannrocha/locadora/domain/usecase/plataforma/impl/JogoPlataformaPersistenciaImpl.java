package com.github.dannrocha.locadora.domain.usecase.plataforma.impl;

import com.github.dannrocha.locadora.domain.dto.locacao.RegistroLocacaoJogoDTO;
import com.github.dannrocha.locadora.domain.dto.plataforma.RegistroJogoPlataformaDTO;
import com.github.dannrocha.locadora.domain.dto.plataforma.SimpleJogoPlataformaDTO;
import com.github.dannrocha.locadora.domain.repository.JogoPlataformaRepository;
import com.github.dannrocha.locadora.domain.repository.consulta.jogoplataforma.JogoPlataformaID;
import com.github.dannrocha.locadora.domain.usecase.plataforma.JogoPlataformaPersistancia;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        var consulta = JogoPlataformaID
                .builder()
                .jogoId(jogoId)
                .plataformaId(plataformaId)
                .build();

        return jogoPlataformaRepository
            .buscarJogoPorJogoIdEPlataformaId(consulta)
            .map(SimpleJogoPlataformaDTO::fromModel);
    }

    @Override
    public List<SimpleJogoPlataformaDTO> buscarPrecoJogoPorJogoEPlataformaPorLista(List<RegistroLocacaoJogoDTO> list) {
        var consultas = list
                .stream()
                .map(it -> JogoPlataformaID
                            .builder()
                            .jogoId(it.jogoId())
                            .plataformaId(it.plataformaId())
                            .build())
                .collect(Collectors.toList());
        return jogoPlataformaRepository
            .buscarJogoPorJogoIdEPlataformaId(consultas)
            .stream()
            .map(SimpleJogoPlataformaDTO::fromModel)
            .collect(Collectors.toList());

    }
}
