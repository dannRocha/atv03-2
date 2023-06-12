package com.github.dannrocha.locadora.configuration.di.usecase.persistencia;

import com.github.dannrocha.locadora.domain.usecase.cliente.ClientePersistencia;
import com.github.dannrocha.locadora.domain.usecase.cliente.impl.ClientePersistenciaImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracaoPersistenciaDI {

    private final ClientePersistenciaImpl clientePersistenciaImpl;

    public ConfiguracaoPersistenciaDI(ClientePersistenciaImpl clientePersistenciaImpl) {
        this.clientePersistenciaImpl = clientePersistenciaImpl;
    }

    @Bean
    ClientePersistencia configuracaoClientePersistencia() {
        return clientePersistenciaImpl;
    }
}
