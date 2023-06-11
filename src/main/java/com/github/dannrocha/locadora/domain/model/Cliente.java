package com.github.dannrocha.locadora.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

@Table(name = "cliente")
@Builder
public record Cliente(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id,
    @Column(nullable = false)
    String nome,
    @Column(nullable = false)
    String email,
    String telefone,

    @Column(nullable = false)
    String senha
) {
}
