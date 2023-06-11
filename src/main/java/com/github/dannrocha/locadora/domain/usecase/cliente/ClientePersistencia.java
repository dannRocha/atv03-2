package com.github.dannrocha.locadora.domain.usecase.cliente;

import com.github.dannrocha.locadora.domain.dto.cliente.RegistroClienteDTO;
import com.github.dannrocha.locadora.domain.dto.cliente.SimpleClienteDTO;

import java.util.Optional;

public abstract class ClientePersistencia   {
    public abstract SimpleClienteDTO salvar(RegistroClienteDTO registro);
    public abstract Optional<SimpleClienteDTO> buscarClientePorId(Integer clienteId);
}
