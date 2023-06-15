package com.github.dannrocha.locadora.repository.dao;

import com.github.dannrocha.locadora.domain.dto.saida.RelatorioDTO;
import com.github.dannrocha.locadora.domain.repository.RelatorioProcedureRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Component;

@Component
public class RelatorioProcedureRepositoryDAOAdapter implements RelatorioProcedureRepository {

    private final EntityManager entityManager;

    public RelatorioProcedureRepositoryDAOAdapter(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public RelatorioDTO gerarRelatorio() {
        /*
        * Aqui vai fazer a chamada a procedure
        * */
        return null;
    }
}
