package com.github.dannrocha.locadora.domain.usecase.cliente.impl;

import com.github.dannrocha.locadora.domain.dto.cliente.RegistroClienteDTO;
import com.github.dannrocha.locadora.domain.dto.cliente.SimpleClienteDTO;
import com.github.dannrocha.locadora.domain.repository.ClienteRepository;
import com.github.dannrocha.locadora.domain.usecase.cliente.ClientePersistencia;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public final class ClientePersistenciaImpl extends ClientePersistencia {

    private final ClienteRepository repositorio;

    public ClientePersistenciaImpl(ClienteRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public SimpleClienteDTO salvar(RegistroClienteDTO registro) {
        var novoCliente = registro.toModel();
        var clienteSalvo = repositorio.salvar(novoCliente);
        return SimpleClienteDTO.fromCliente(clienteSalvo);
    }

    @Override
    public Optional<SimpleClienteDTO> buscarClientePorId(Integer clienteId) {
        return repositorio
            .buscarPorId(clienteId)
            .map(SimpleClienteDTO::fromCliente);
    }
}
