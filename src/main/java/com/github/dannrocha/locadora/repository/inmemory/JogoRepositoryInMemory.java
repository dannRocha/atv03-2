package com.github.dannrocha.locadora.repository.inmemory;

import com.github.dannrocha.locadora.domain.model.Jogo;
import com.github.dannrocha.locadora.domain.repository.JogoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public final class JogoRepositoryInMemory extends DbInMemory<Jogo> implements JogoRepository {

    @Override
    public Optional<Jogo> buscarPorId(Integer id) {
        return db.stream()
                .filter(jogo -> jogo.getId().equals(id))
                .findFirst();
    }

    @Override
    public Jogo salvar(Jogo jogo) {
        if(jogo.getId() == null) {
            contador++;
            jogo.setId(contador);
            return salvar(jogo);
        }

        var jogoSalvoOptional = buscarPorId(jogo.getId());

        if(jogoSalvoOptional.isPresent()) {
//            var jogoSalvoIndex = db.indexOf(jogoSalvoOptional.get());
//            db.remove(jogoSalvoIndex);
//            db.add(jogoSalvoIndex, jogo);

            return jogo;
        }

        db.add(jogo);

        return jogo;
    }
}
