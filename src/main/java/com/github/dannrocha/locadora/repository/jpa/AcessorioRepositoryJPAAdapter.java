package com.github.dannrocha.locadora.repository.jpa;

import com.github.dannrocha.locadora.domain.model.Acessorio;
import com.github.dannrocha.locadora.domain.repository.AcessorioRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class AcessorioRepositoryJPAAdapter implements AcessorioRepository {

    private final AcessorioJPAIntegration acessorioJPAIntegration;

    public AcessorioRepositoryJPAAdapter(@Lazy AcessorioJPAIntegration acessorioJPAIntegration) {
        this.acessorioJPAIntegration = acessorioJPAIntegration;
    }

    @Override
    public List<Acessorio> buscarConjuntoDeAcessoriosPorId(List<Integer> acessoriosId) {
        return null;
    }

    @Repository
    public interface AcessorioJPAIntegration extends JpaRepository<Acessorio, Integer> {

    }
}
