package com.github.dannrocha.locadora.usecase.plataforma;

import com.github.dannrocha.locadora.domain.dto.plataforma.RegistroPlataformaDTO;
import com.github.dannrocha.locadora.domain.usecase.plataforma.PlataformaPersistencia;
import com.github.dannrocha.locadora.domain.usecase.plataforma.impl.PlataformaPersistenciaImpl;
import com.github.dannrocha.locadora.repository.inmemory.PlataformaRepositoryInMemory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlataformaUseCasePersistenciaTest {

    private PlataformaPersistencia plataformaPersistencia;

    @BeforeEach
    void setup() {
        plataformaPersistencia = new PlataformaPersistenciaImpl(new PlataformaRepositoryInMemory());
    }

    @Test
    void deveRegistrarUmaNovaPlataformaValida() {
        var registro = RegistroPlataformaDTO
            .builder()
            .nome("Xbox Cloud")
            .build();

        var registroSalvo = plataformaPersistencia.registrarPlataforma(registro);

        assertEquals(registro.nome(), registroSalvo.nome());
    }

    @Test
    void deveBuscarPlataformaPorId() {
        var registro1 = RegistroPlataformaDTO
                .builder()
                .nome("Xbox Cloud")
                .build();

        var registro2 = RegistroPlataformaDTO
                .builder()
                .nome("Steam")
                .build();

        var registroSalvo1 = plataformaPersistencia.registrarPlataforma(registro1);
        var registroSalvo2 = plataformaPersistencia.registrarPlataforma(registro2);

        final Integer PLATAFORMA_ID_INEXISTENTE = 999;

        assertAll(
            () -> plataformaPersistencia.buscarPlataformaPorId(registroSalvo1.id()).isPresent(),
            () -> plataformaPersistencia.buscarPlataformaPorId(registroSalvo2.id()).isPresent(),
            () -> plataformaPersistencia.buscarPlataformaPorId(PLATAFORMA_ID_INEXISTENTE).isEmpty()
        );
    }
}
