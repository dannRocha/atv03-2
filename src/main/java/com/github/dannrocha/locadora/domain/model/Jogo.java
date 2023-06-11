package com.github.dannrocha.locadora.domain.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

@Table(name = "jogo")
@Builder
public record Jogo(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id,
    String titulo
) {
}
