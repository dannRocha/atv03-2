package com.github.dannrocha.locadora.domain.repository;

import com.github.dannrocha.locadora.domain.model.Cliente;

import java.util.Optional;

public interface ClienteRepository {
    Optional<Cliente> buscarPorId(Integer id);
    Optional<Cliente> buscarPorEmail(String email);
    Cliente salvar(Cliente cliente);

}
