package com.github.dannrocha.locadora.repository.jpa;

import com.github.dannrocha.locadora.domain.model.Console;
import com.github.dannrocha.locadora.domain.repository.ConsoleRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class ConsoleRepositoryJPAAdapter implements ConsoleRepository {

    private final ConsoleJpaIntegration consoleJpaIntegration;

    public ConsoleRepositoryJPAAdapter(@Lazy ConsoleJpaIntegration consoleJpaIntegration) {
        this.consoleJpaIntegration = consoleJpaIntegration;
    }

    @Override
    public Console salvar(Console console) {
        return null;
    }

    @Override
    public Optional<Console> buscarConsolePorId(Integer consoleID) {
        return Optional.empty();
    }

    @Override
    public Optional<Console> buscarConsolePorNome(String nome) {
        return Optional.empty();
    }

    @Override
    public List<Console> buscarListaDeConsolesPorId(List<Integer> ids) {
        return null;
    }

    @Override
    public Optional<Console> buscarConsoleDisponivelPorNomeEData(String nome, LocalDate data) {
        return Optional.empty();
    }

    @Repository
    public interface ConsoleJpaIntegration extends JpaRepository<Console, Integer> {
    }
}
