package com.github.dannrocha.locadora.domain.usecase.console;

import com.github.dannrocha.locadora.domain.dto.console.RegistroConsoleDTO;
import com.github.dannrocha.locadora.domain.dto.console.SimpleConsoleDTO;

import java.util.Optional;

public abstract class ConsolePersistencia {
    public abstract SimpleConsoleDTO salvarConsole(RegistroConsoleDTO consoleDTO);
    public abstract Optional<SimpleConsoleDTO> buscarConsolePorId(Integer consoleID);
    public abstract Optional<SimpleConsoleDTO> buscarConsolePorNome(String nome);
}
