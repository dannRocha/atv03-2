package com.github.dannrocha.locadora.repository.jpa;

import com.github.dannrocha.locadora.domain.model.Cliente;
import com.github.dannrocha.locadora.domain.repository.ClienteRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
public class ClienteRepositoryJPAAdapter implements ClienteRepository {

    private final ClienteJpaIntegration clienteJpaIntegration;

    public ClienteRepositoryJPAAdapter(@Lazy ClienteJpaIntegration clienteJpaIntegration) {
        this.clienteJpaIntegration = clienteJpaIntegration;
    }

    @Override
    public Optional<Cliente> buscarPorId(Integer id) {
        return clienteJpaIntegration.findById(id);
    }

    @Override
    public Optional<Cliente> buscarPorEmail(String email) {
        return clienteJpaIntegration.findByEmail(email);
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        return clienteJpaIntegration.save(cliente);
    }

    @Repository
    public interface ClienteJpaIntegration extends JpaRepository<Cliente, Integer> {

        Optional<Cliente> findByEmail(String email);
    }
 }
