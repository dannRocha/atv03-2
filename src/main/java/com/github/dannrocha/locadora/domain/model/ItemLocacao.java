package com.github.dannrocha.locadora.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

import java.math.BigDecimal;

@Table(name = "item_locacao")
@Builder
public record ItemLocacao(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id,
    @Column(nullable = false)
    Integer dias,
    @Column(nullable = false)
    Integer quantidade,

    @Column(nullable = false)
    BigDecimal preco,

    @Column(name = "plataforma_id")
    Integer plataformaId,

    @Column(name = "locacao_id")
    Integer locacaoId
) {
}
