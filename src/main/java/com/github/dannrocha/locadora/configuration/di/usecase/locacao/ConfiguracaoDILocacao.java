package com.github.dannrocha.locadora.configuration.di.usecase.locacao;

import com.github.dannrocha.locadora.domain.usecase.console.AlugarConsole;
import com.github.dannrocha.locadora.domain.usecase.console.impl.AlugarConsoleImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracaoDILocacao {
    private final AlugarConsoleImpl alugarConsole;

    public ConfiguracaoDILocacao(AlugarConsoleImpl alugarConsole) {
        this.alugarConsole = alugarConsole;
    }

    @Bean
    AlugarConsole configuracaoAlugarConsoleUseCase() {
        return alugarConsole;
    }
}
