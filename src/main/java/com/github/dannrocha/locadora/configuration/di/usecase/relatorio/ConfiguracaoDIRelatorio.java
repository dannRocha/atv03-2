package com.github.dannrocha.locadora.configuration.di.usecase.relatorio;

import com.github.dannrocha.locadora.domain.usecase.relatorio.RelatorioLocacao;
import com.github.dannrocha.locadora.domain.usecase.relatorio.impl.RelatorioLocacaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfiguracaoDIRelatorio {

    private final RelatorioLocacaoImpl relatorioLocacao;

    public ConfiguracaoDIRelatorio(RelatorioLocacaoImpl relatorioLocacao) {
        this.relatorioLocacao = relatorioLocacao;
    }

    @Bean
    @Primary
    RelatorioLocacao configuracaoDIRelatorioLocacao() {
        return relatorioLocacao;
    }
}
