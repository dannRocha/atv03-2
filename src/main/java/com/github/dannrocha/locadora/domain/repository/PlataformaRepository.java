package com.github.dannrocha.locadora.domain.repository;

import com.github.dannrocha.locadora.domain.model.Plataforma;

import java.util.Optional;

public interface PlataformaRepository {
    Plataforma registarPlataforma(Plataforma plataforma);
    Optional<Plataforma> buscarPorId(Integer plataformaId);

}
