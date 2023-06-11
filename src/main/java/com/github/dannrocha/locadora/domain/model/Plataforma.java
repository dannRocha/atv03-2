package com.github.dannrocha.locadora.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

@Table(name = "plataforma")
@Builder
public record Plataforma(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  Integer id,
    String nome
) {
}
