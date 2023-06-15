package com.github.dannrocha.locadora.domain.usecase.relatorio.impl;

import com.github.dannrocha.locadora.domain.repository.RelatorioProcedureRepository;
import com.github.dannrocha.locadora.domain.usecase.relatorio.RelatorioLocacao;
import org.springframework.stereotype.Component;

@Component
public class RelatorioLocacaoImpl extends RelatorioLocacao {

    private final RelatorioProcedureRepository relatorioProcedureRepository;

    public RelatorioLocacaoImpl(RelatorioProcedureRepository relatorioProcedureRepository) {
        this.relatorioProcedureRepository = relatorioProcedureRepository;
    }

    @Override
    public void gerarRelatorioDeLocacao() {
        var relatorio = relatorioProcedureRepository.gerarRelatorio();

        if(relatorio.conteudo().isEmpty()) {
            System.out.println("sem dados pra processar!");
            return;
        }

        relatorio.conteudo().forEach(cliente -> {
            System.out.printf("%s - [%s]\n", cliente.clienteDTO().nome(), cliente.clienteDTO().email());
            cliente.locacoes().forEach(locacao -> {
                System.out.printf("\tID[%s] - %s - R$%s\n", locacao.id(), locacao.data(), locacao.total());
            });
            System.out.println("------------------------------------");
        });
    }
}
