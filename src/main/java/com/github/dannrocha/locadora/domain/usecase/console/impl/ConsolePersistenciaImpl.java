package com.github.dannrocha.locadora.domain.usecase.console.impl;

import com.github.dannrocha.locadora.domain.dto.console.RegistroConsoleDTO;
import com.github.dannrocha.locadora.domain.dto.console.SimpleConsoleDTO;
import com.github.dannrocha.locadora.domain.repository.ConsoleRepository;
import com.github.dannrocha.locadora.domain.usecase.console.ConsolePersistencia;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ConsolePersistenciaImpl extends ConsolePersistencia {

    private final ConsoleRepository consoleRepository;

    public ConsolePersistenciaImpl(ConsoleRepository consoleRepository) {
        this.consoleRepository = consoleRepository;
    }

    @Override
    public SimpleConsoleDTO salvarConsole(RegistroConsoleDTO consoleDTO) {
        return SimpleConsoleDTO
            .fromModel(consoleRepository.salvar(consoleDTO.toModel()));
    }

    @Override
    public Optional<SimpleConsoleDTO> buscarConsolePorId(Integer consoleID) {
        return consoleRepository
                .buscarConsolePorId(consoleID)
                .map(SimpleConsoleDTO::fromModel);
    }

    @Override
    public Optional<SimpleConsoleDTO> buscarConsolePorNome(String nome) {
        return consoleRepository
                .buscarConsolePorNome(nome)
                .map(SimpleConsoleDTO::fromModel);
    }
}
