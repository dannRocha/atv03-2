package com.github.dannrocha.locadora.repository.inmemory;

import com.github.dannrocha.locadora.domain.model.Plataforma;
import com.github.dannrocha.locadora.domain.repository.PlataformaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PlataformaRepositoryInMemory extends DbInMemory<Plataforma> implements PlataformaRepository {
    @Override
    public Plataforma registarPlataforma(Plataforma plataforma) {
        if(plataforma.id() == null) {
            this.contador++;
            var jogoCopy = plataforma
                    .builder()
                    .id(contador)
                    .nome(plataforma.nome())
                    .build();


            return registarPlataforma(jogoCopy);
        }

        var jogoSalvoOptional = buscarPorId(plataforma.id());

        if(jogoSalvoOptional.isPresent()) {
            var jogoSalvoIndex = db.indexOf(jogoSalvoOptional.get());
            db.remove(jogoSalvoIndex);
            db.add(jogoSalvoIndex, plataforma);

            return plataforma;
        }

        db.add(plataforma);

        return plataforma;
    }

    @Override
    public Optional<Plataforma> buscarPorId(Integer plataformaId) {
        return db.stream()
            .filter(plataforma -> plataforma.id().equals(plataformaId))
            .findFirst();
    }
}