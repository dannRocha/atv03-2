package com.github.dannrocha.locadora.domain.repository;

import com.github.dannrocha.locadora.domain.model.Console;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ConsoleRepository {
    Console salvar(Console console);
    Optional<Console> buscarConsolePorId(Integer consoleID);
    Optional<Console> buscarConsolePorNome(String nome);

    List<Console>  buscarListaDeConsolesPorId(List<Integer> ids);

    Optional<Console> buscarConsoleDisponivelPorNomeEData(String nome, LocalDate data);
}
