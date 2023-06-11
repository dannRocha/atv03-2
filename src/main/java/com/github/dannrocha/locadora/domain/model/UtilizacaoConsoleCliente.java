package com.github.dannrocha.locadora.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table(name = "utilizacao_console_cliente")
public record UtilizacaoConsoleCliente(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id,
    LocalDateTime inicio,
    LocalDateTime fim
) {
}
