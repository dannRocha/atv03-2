package com.github.dannrocha.locadora.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Table(name = "item_locacao")
@Builder
@AllArgsConstructor
@Getter
public class ItemLocacao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer dias;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(name = "plataforma_id")
    private Integer plataformaId;

    @Column(name = "locacao_id")
    private Integer locacaoId;
}
