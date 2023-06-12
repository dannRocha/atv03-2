package com.github.dannrocha.locadora.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Table(name = "jogo_plataforma")
@Builder
@AllArgsConstructor
@Getter
public class JogoPlataforma {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "jogo_id")

    private Jogo jogo;

//    @Column(name = "plataforma_id")
    @OneToMany
    private Plataforma plataforma;

    private BigDecimal preco;
}
