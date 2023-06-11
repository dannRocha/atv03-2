package com.github.dannrocha.locadora.usecase.cliente;


import com.github.dannrocha.locadora.domain.dto.cliente.RegistroClienteDTO;
import com.github.dannrocha.locadora.domain.usecase.cliente.ClientePersistencia;
import com.github.dannrocha.locadora.domain.usecase.cliente.impl.ClientePersistenciaImpl;
import com.github.dannrocha.locadora.repository.inmemory.ClienteRepositoryInMemory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

public class ClienteUseCasePersistenciaTest {


    private ClientePersistencia clientePersistencia;

    @BeforeEach
    void setup() {
        clientePersistencia = new ClientePersistenciaImpl(new ClienteRepositoryInMemory());
    }
    @Test
    void deveSalvarUmClienteValido() {
        var registro = RegistroClienteDTO
            .builder()
            .senha("senha")
            .nome("Astrogildo")
            .telefone("99 9 9999-9999")
            .email("astrogildo@email.com")
            .build();

        var clienteSalvo = clientePersistencia.salvar(registro);

        assertAll(
            () -> registro.nome().equalsIgnoreCase(clienteSalvo.nome()),
            () -> registro.email().equalsIgnoreCase(clienteSalvo.email())
        );
    }

    @Test
    void deveBuscarUmClientePorIdOuEmail() {
        var registro1 = RegistroClienteDTO
                .builder()
                .senha("senha")
                .nome("Astrogildo")
                .telefone("99 9 9999-9991")
                .email("astrogildo@email.com")
                .build();

        var registro2 = RegistroClienteDTO
                .builder()
                .senha("senha")
                .nome("Ze da Manga")
                .telefone("99 9 9999-9992")
                .email("zedamanga@email.com")
                .build();

        var registroSalvo1 = clientePersistencia.salvar(registro1);
        var registroSalvo2 = clientePersistencia.salvar(registro2);

        var buscaRegistro1 = clientePersistencia.buscarClientePorId(registroSalvo1.id());
        var buscaRegistro2 = clientePersistencia.buscarClientePorId(registroSalvo2.id());

        assertAll(
            () -> buscaRegistro1.isPresent(),
            () -> buscaRegistro2.isPresent(),
            () -> buscaRegistro1.get().email().equalsIgnoreCase(registro1.email()),
            () -> buscaRegistro2.get().email().equalsIgnoreCase(registro2.email())
        );
    }
}
