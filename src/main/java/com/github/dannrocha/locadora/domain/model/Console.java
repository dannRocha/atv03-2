package com.github.dannrocha.locadora.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
@Table(name = "console")
public record Console(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id,
    String nome,
    BigDecimal preco
) {
}
