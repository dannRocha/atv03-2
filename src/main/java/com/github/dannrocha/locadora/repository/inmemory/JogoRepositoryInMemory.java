package com.github.dannrocha.locadora.repository.inmemory;

import com.github.dannrocha.locadora.domain.model.Jogo;
import com.github.dannrocha.locadora.domain.repository.JogoRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public final class JogoRepositoryInMemory extends DbInMemory<Jogo> implements JogoRepository {

    @Override
    public Optional<Jogo> buscarPorId(Integer id) {
        return db.stream()
                .filter(jogo -> jogo.id().equals(id))
                .findFirst();
    }

    @Override
    public Jogo salvar(Jogo jogo) {
        if(jogo.id() == null) {
            contador++;
            var jogoCopy = Jogo
                    .builder()
                    .id(contador)
                    .titulo(jogo.titulo())
                    .build();


            return salvar(jogoCopy);
        }

        var jogoSalvoOptional = buscarPorId(jogo.id());

        if(jogoSalvoOptional.isPresent()) {
            var jogoSalvoIndex = db.indexOf(jogoSalvoOptional.get());
            db.remove(jogoSalvoIndex);
            db.add(jogoSalvoIndex, jogo);

            return jogo;
        }

        db.add(jogo);

        return jogo;
    }
}
