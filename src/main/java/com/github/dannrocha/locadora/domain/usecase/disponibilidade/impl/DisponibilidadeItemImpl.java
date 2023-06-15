package com.github.dannrocha.locadora.domain.usecase.disponibilidade.impl;

import com.github.dannrocha.locadora.domain.dto.saida.DisponibilidadeItemDTO;
import com.github.dannrocha.locadora.domain.repository.ConsoleRepository;
import com.github.dannrocha.locadora.domain.repository.JogoRepository;
import com.github.dannrocha.locadora.domain.usecase.disponibilidade.DisponibilidadeItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class DisponibilidadeItemImpl extends DisponibilidadeItem {

    private final JogoRepository jogoRepository;
    private final ConsoleRepository consoleRepository;

    public DisponibilidadeItemImpl(JogoRepository jogoRepository, ConsoleRepository consoleRepository) {
        this.jogoRepository = jogoRepository;
        this.consoleRepository = consoleRepository;
    }


    @Override
    public List<DisponibilidadeItemDTO> buscarDisponibilidadeDeJogoOuConsolePorData(String nome, LocalDate data) {
        var executors = Executors.newCachedThreadPool();

        var list = new ArrayList<DisponibilidadeItemDTO>();
        var jogoTask = executors.submit(() -> consoleRepository.buscarConsoleDisponivelPorNomeEData(nome, data));
        var consoleTask = executors.submit(() -> jogoRepository.buscarJogoDisponivelPorNomeEData(nome, data));

        try {
            executors.awaitTermination(5, TimeUnit.SECONDS);
            if(jogoTask.get().isEmpty() && consoleTask.get().isEmpty()) {
                return List.of();
            }


            if(jogoTask.get().isPresent()) {
                var jogo = jogoTask.get();
                list.add(new DisponibilidadeItemDTO(jogo.get().getNome(), true));
            }

            if(consoleTask.get().isPresent()) {
                var console = consoleTask.get();
                list.add(new DisponibilidadeItemDTO(console.get().getTitulo(), true));
            }

            return list;
        }
        catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
}
