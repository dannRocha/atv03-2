package com.github.dannrocha.locadora.domain.usecase.plataforma.impl;

import com.github.dannrocha.locadora.domain.dto.plataforma.RegistroPlataformaDTO;
import com.github.dannrocha.locadora.domain.dto.plataforma.SimplePlataformaDTO;
import com.github.dannrocha.locadora.domain.repository.PlataformaRepository;
import com.github.dannrocha.locadora.domain.usecase.plataforma.PlataformaPersistencia;

import java.util.Optional;

public class PlataformaPersistenciaImpl extends PlataformaPersistencia {

    private final PlataformaRepository plataformaRepository;

    public PlataformaPersistenciaImpl(PlataformaRepository plataformaRepository) {
        this.plataformaRepository = plataformaRepository;
    }

    @Override
    public SimplePlataformaDTO registrarPlataforma(RegistroPlataformaDTO registro) {
        return SimplePlataformaDTO
            .fromModel(plataformaRepository.registarPlataforma(registro.toModel()));

    }

    @Override
    public Optional<SimplePlataformaDTO> buscarPlataformaPorId(Integer plataformaId) {
        return plataformaRepository.buscarPorId(plataformaId)
            .map(SimplePlataformaDTO::fromModel);
    }
}
