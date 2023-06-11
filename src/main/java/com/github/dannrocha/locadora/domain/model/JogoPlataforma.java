package com.github.dannrocha.locadora.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

import java.math.BigDecimal;

@Table(name = "jogo_plataforma")
@Builder
public record JogoPlataforma(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id,

    @Column(name = "jogo_id")
    Jogo jogo,

    @Column(name = "plataforma_id")
    Plataforma plataforma,
    BigDecimal preco
) {
}
