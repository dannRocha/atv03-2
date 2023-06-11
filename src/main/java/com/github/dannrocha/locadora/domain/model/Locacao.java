package com.github.dannrocha.locadora.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

import java.time.LocalDate;
@Table(name = "locacao")
@Builder
public record Locacao(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id,
    LocalDate data
) {
}
