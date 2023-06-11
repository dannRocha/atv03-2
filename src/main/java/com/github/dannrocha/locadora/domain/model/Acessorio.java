package com.github.dannrocha.locadora.domain.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "acessorio")
public record Acessorio(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id,
    String nome
) {
}
