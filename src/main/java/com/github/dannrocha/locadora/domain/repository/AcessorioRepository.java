package com.github.dannrocha.locadora.domain.repository;

import com.github.dannrocha.locadora.domain.model.Acessorio;

import java.util.List;

public interface AcessorioRepository {
    List<Acessorio> buscarConjuntoDeAcessoriosPorId(List<Integer> acessoriosId);
}
