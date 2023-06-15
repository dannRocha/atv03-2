package com.github.dannrocha.locadora.domain.usecase.disponibilidade;

import com.github.dannrocha.locadora.domain.dto.saida.DisponibilidadeItemDTO;

import java.time.LocalDate;
import java.util.List;

public abstract class DisponibilidadeItem {
    public abstract List<DisponibilidadeItemDTO> buscarDisponibilidadeDeJogoOuConsolePorData(String nome, LocalDate data);
}
