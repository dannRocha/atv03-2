package com.github.dannrocha.locadora.domain.repository;

import com.github.dannrocha.locadora.domain.model.Plataforma;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface PlataformaRepository {
    Plataforma registarPlataforma(Plataforma plataforma);
    Optional<Plataforma> buscarPorId(Integer plataformaId);

}
