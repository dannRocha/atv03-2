package com.github.dannrocha.locadora.domain.usecase.plataforma;

import com.github.dannrocha.locadora.domain.dto.plataforma.RegistroPlataformaDTO;
import com.github.dannrocha.locadora.domain.dto.plataforma.SimplePlataformaDTO;

import java.util.Optional;

public abstract class PlataformaPersistencia {
    public abstract SimplePlataformaDTO registrarPlataforma(RegistroPlataformaDTO registro);
    public abstract Optional<SimplePlataformaDTO> buscarPlataformaPorId(Integer plataformaId);
}
