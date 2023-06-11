package com.github.dannrocha.locadora.usecase.jogo;

import com.github.dannrocha.locadora.domain.dto.jogo.RegistroJogoDTO;
import com.github.dannrocha.locadora.domain.usecase.jogo.JogoPersistencia;
import com.github.dannrocha.locadora.domain.usecase.jogo.impl.JogoPersistenciaImpl;
import com.github.dannrocha.locadora.repository.inmemory.JogoRepositoryInMemory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JogoUseCasePersistenciaTest {

    private JogoPersistencia jogoPersistencia;

    @BeforeEach
    void setup() {
        jogoPersistencia = new JogoPersistenciaImpl(new JogoRepositoryInMemory());
    }

    @Test
    void deveSalvarUmNovoJogoValido() {
        var registro = RegistroJogoDTO
            .builder()
            .titulo("CoD")
            .build();

        var jogoSalvo = jogoPersistencia.salvarJogo(registro);

        assertNotEquals(jogoSalvo.id(), null);
        assertEquals(jogoSalvo.titulo(), registro.titulo());
    }

    @Test
    void deveBuscarJogoPorId() {
        var registro1 = RegistroJogoDTO
                .builder()
                .titulo("CoD")
                .build();

        var registro2 = RegistroJogoDTO
                .builder()
                .titulo("War Zone")
                .build();

        var jogoSalvo1 = jogoPersistencia.salvarJogo(registro1);
        var jogoSalvo2 = jogoPersistencia.salvarJogo(registro2);

        final Integer JOGO_ID_NAO_EXISTENTE = 999;

        assertTrue(jogoPersistencia.buscarJogoPorId(jogoSalvo1.id()).isPresent());
        assertTrue(jogoPersistencia.buscarJogoPorId(jogoSalvo2.id()).isPresent());
        assertTrue(jogoPersistencia.buscarJogoPorId(JOGO_ID_NAO_EXISTENTE).isEmpty());


    }
}
