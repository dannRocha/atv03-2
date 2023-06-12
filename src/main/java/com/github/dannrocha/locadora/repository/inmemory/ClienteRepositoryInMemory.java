package com.github.dannrocha.locadora.repository.inmemory;

import com.github.dannrocha.locadora.domain.model.Cliente;
import com.github.dannrocha.locadora.domain.repository.ClienteRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClienteRepositoryInMemory extends DbInMemory<Cliente> implements ClienteRepository {

    @Override
    public Optional<Cliente> buscarPorId(Integer id) {
        return db.stream()
                .filter(cliente -> cliente.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Cliente> buscarPorEmail(String email) {
        return db.stream()
                .filter(cliente -> cliente.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        if(cliente.getId() == null) {
            contador++;
            var clienteCopia = Cliente
                    .builder()
                    .id(contador)
                    .nome(cliente.getNome())
                    .email(cliente.getEmail())
                    .senha(cliente.getSenha())
                    .telefone(cliente.getTelefone())
                    .build();


            return salvar(clienteCopia);
        }

        var clienteSalvoOptional = buscarPorId(cliente.getId());

        if(clienteSalvoOptional.isPresent()) {
//            var clienteSalvoIndex = db.indexOf(clienteSalvoOptional.get());
//            db.remove(clienteSalvoIndex);
//            db.add(clienteSalvoIndex, cliente);

            return cliente;
        }

        db.add(cliente);

        return cliente;
    }
}
