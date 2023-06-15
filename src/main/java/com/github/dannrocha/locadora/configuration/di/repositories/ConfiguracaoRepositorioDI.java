package com.github.dannrocha.locadora.configuration.di.repositories;

import com.github.dannrocha.locadora.domain.repository.AcessorioRepository;
import com.github.dannrocha.locadora.domain.repository.ClienteRepository;
import com.github.dannrocha.locadora.domain.repository.ConsoleRepository;
import com.github.dannrocha.locadora.domain.repository.JogoPlataformaRepository;
import com.github.dannrocha.locadora.domain.repository.JogoRepository;
import com.github.dannrocha.locadora.domain.repository.LocacaoRepository;
import com.github.dannrocha.locadora.domain.repository.PlataformaRepository;
import com.github.dannrocha.locadora.domain.repository.RelatorioProcedureRepository;
import com.github.dannrocha.locadora.repository.dao.RelatorioProcedureRepositoryDAOAdapter;
import com.github.dannrocha.locadora.repository.inmemory.ClienteRepositoryInMemory;
import com.github.dannrocha.locadora.repository.inmemory.JogoPlataformaRepositoryInMemory;
import com.github.dannrocha.locadora.repository.inmemory.JogoRepositoryInMemory;
import com.github.dannrocha.locadora.repository.inmemory.LocacaoRepositoryInMemory;
import com.github.dannrocha.locadora.repository.inmemory.PlataformaRepositoryInMemory;
import com.github.dannrocha.locadora.repository.jpa.AcessorioRepositoryJPAAdapter;
import com.github.dannrocha.locadora.repository.jpa.ClienteRepositoryJPAAdapter;
import com.github.dannrocha.locadora.repository.jpa.ConsoleRepositoryJPAAdapter;
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

    private final ConsoleRepositoryJPAAdapter consoleRepositoryJPAAdapter;
    private final AcessorioRepositoryJPAAdapter acessorioRepositoryJPAAdapter;
    private final RelatorioProcedureRepositoryDAOAdapter relatorioProcedureRepositoryDAOAdapter;

    public ConfiguracaoRepositorioDI(JogoRepositoryInMemory jogoRepositoryInMemory, ClienteRepositoryInMemory clienteRepositoryInMemory, ClienteRepositoryJPAAdapter clienteRepositoryJPA, PlataformaRepositoryInMemory plataformaRepositoryInMemory, LocacaoRepositoryInMemory locacaoRepositoryInMemory, JogoPlataformaRepositoryInMemory jogoPlataformaRepositoryInMemory, ConsoleRepositoryJPAAdapter consoleRepositoryJPAAdapter, AcessorioRepositoryJPAAdapter acessorioRepositoryJPAAdapter, RelatorioProcedureRepositoryDAOAdapter relatorioProcedureRepositoryDAOAdapter) {
        this.jogoRepositoryInMemory = jogoRepositoryInMemory;
        this.clienteRepositoryInMemory = clienteRepositoryInMemory;
        this.clienteRepositoryJPA = clienteRepositoryJPA;
        this.plataformaRepositoryInMemory = plataformaRepositoryInMemory;
        this.locacaoRepositoryInMemory = locacaoRepositoryInMemory;
        this.jogoPlataformaRepositoryInMemory = jogoPlataformaRepositoryInMemory;
        this.consoleRepositoryJPAAdapter = consoleRepositoryJPAAdapter;
        this.acessorioRepositoryJPAAdapter = acessorioRepositoryJPAAdapter;
        this.relatorioProcedureRepositoryDAOAdapter = relatorioProcedureRepositoryDAOAdapter;
    }


    @Bean
    @Primary
    JogoRepository configuracaoDIJogoRepository() {
        return jogoRepositoryInMemory;
    }

    @Bean
    @Primary
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    ClienteRepository configuracaoDIClienteRepository() {
        return clienteRepositoryInMemory;
    }


    @Bean(name = "jpa")
    ClienteRepository configuracaoDIClienteRepositoryNamed() {
        return clienteRepositoryJPA;
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
    @Primary
    LocacaoRepository configuracaoDILocacaoRepository() {
        return locacaoRepositoryInMemory;
    }


    @Bean
    @Primary
    AcessorioRepository configuracaoDIAcessorioRepository() {
        return acessorioRepositoryJPAAdapter;
    }

    @Bean
    @Primary
    ConsoleRepository configuracaoDIConsoleRepository() {
        return consoleRepositoryJPAAdapter;
    }

    @Bean
    @Primary
    RelatorioProcedureRepository configuracaoDIRelatorioProcedureRepository() {
        return relatorioProcedureRepositoryDAOAdapter;
    }

}
