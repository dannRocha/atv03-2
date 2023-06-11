package com.github.dannrocha.locadora.repository.inmemory;

import com.github.dannrocha.locadora.domain.model.Cliente;
import com.github.dannrocha.locadora.domain.repository.ClienteRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ClienteRepositoryInMemory extends DbInMemory<Cliente> implements ClienteRepository {

    @Override
    public Optional<Cliente> buscarPorId(Integer id) {
        return db.stream()
                .filter(cliente -> cliente.id().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Cliente> buscarPorEmail(String email) {
        return db.stream()
                .filter(cliente -> cliente.email().equalsIgnoreCase(email))
                .findFirst();
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        if(cliente.id() == null) {
            contador++;
            var clienteCopia = Cliente
                    .builder()
                    .id(contador)
                    .nome(cliente.nome())
                    .email(cliente.email())
                    .senha(cliente.senha())
                    .telefone(cliente.telefone())
                    .build();


            return salvar(clienteCopia);
        }

        var clienteSalvoOptional = buscarPorId(cliente.id());

        if(clienteSalvoOptional.isPresent()) {
            var clienteSalvoIndex = db.indexOf(clienteSalvoOptional.get());
            db.remove(clienteSalvoIndex);
            db.add(clienteSalvoIndex, cliente);

            return cliente;
        }

        db.add(cliente);

        return cliente;
    }
}
