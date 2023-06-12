package com.github.dannrocha.locadora.configuration.di.repositories;

import com.github.dannrocha.locadora.domain.repository.ClienteRepository;
import com.github.dannrocha.locadora.domain.repository.JogoPlataformaRepository;
import com.github.dannrocha.locadora.domain.repository.JogoRepository;
import com.github.dannrocha.locadora.domain.repository.LocacaoRepository;
import com.github.dannrocha.locadora.domain.repository.PlataformaRepository;
import com.github.dannrocha.locadora.domain.usecase.cliente.ClientePersistencia;
import com.github.dannrocha.locadora.repository.inmemory.ClienteRepositoryInMemory;
import com.github.dannrocha.locadora.repository.inmemory.JogoPlataformaRepositoryInMemory;
import com.github.dannrocha.locadora.repository.inmemory.JogoRepositoryInMemory;
import com.github.dannrocha.locadora.repository.inmemory.LocacaoRepositoryInMemory;
import com.github.dannrocha.locadora.repository.inmemory.PlataformaRepositoryInMemory;
import com.github.dannrocha.locadora.repository.jpa.ClienteRepositoryJPAAdapter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfiguracaoRepositorioDI {

    private final JogoRepositoryInMemory jogoRepositoryInMemory;
    private final ClienteRepositoryInMemory clienteRepositoryInMemory;
    private final ClienteRepositoryJPAAdapter clienteRepositoryJPA;

    private final PlataformaRepositoryInMemory plataformaRepositoryInMemory;
    private final LocacaoRepositoryInMemory locacaoRepositoryInMemory;
    private final JogoPlataformaRepositoryInMemory jogoPlataformaRepositoryInMemory;

    public ConfiguracaoRepositorioDI(JogoRepositoryInMemory jogoRepositoryInMemory, ClienteRepositoryInMemory clienteRepositoryInMemory, ClienteRepositoryJPAAdapter clienteRepositoryJPA, PlataformaRepositoryInMemory plataformaRepositoryInMemory, LocacaoRepositoryInMemory locacaoRepositoryInMemory, JogoPlataformaRepositoryInMemory jogoPlataformaRepositoryInMemory) {
        this.jogoRepositoryInMemory = jogoRepositoryInMemory;
        this.clienteRepositoryInMemory = clienteRepositoryInMemory;
        this.clienteRepositoryJPA = clienteRepositoryJPA;
        this.plataformaRepositoryInMemory = plataformaRepositoryInMemory;
        this.locacaoRepositoryInMemory = locacaoRepositoryInMemory;
        this.jogoPlataformaRepositoryInMemory = jogoPlataformaRepositoryInMemory;
    }


    @Bean
    @Primary
    JogoRepository configuracaoDIJogoRepository() {
        return jogoRepositoryInMemory;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    ClienteRepository configuracaoDIClienteRepository() {
        return clienteRepositoryInMemory;
    }

    @Bean
    @Primary
    PlataformaRepository configuracaoDIPlataformaRepositorio() {
        return  plataformaRepositoryInMemory;
    }

    @Bean
    JogoPlataformaRepository configuracaoDIJogoPlataformaRepositorio() {
        return jogoPlataformaRepositoryInMemory;
    }


    @Bean
    LocacaoRepository configuracaoDILocacaoRepository() {
        return locacaoRepositoryInMemory;
    }


}
