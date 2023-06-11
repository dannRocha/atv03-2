package com.github.dannrocha.locadora.repository.inmemory;

import com.github.dannrocha.locadora.domain.model.Jogo;
import com.github.dannrocha.locadora.domain.model.JogoPlataforma;
import com.github.dannrocha.locadora.domain.model.Plataforma;
import com.github.dannrocha.locadora.domain.repository.JogoPlataformaRepository;
import com.github.dannrocha.locadora.domain.repository.JogoRepository;
import com.github.dannrocha.locadora.domain.repository.PlataformaRepository;

import java.util.Optional;

public class JogoPlataformaRepositoryInMemory extends DbInMemory<JogoPlataforma> implements JogoPlataformaRepository {

    private final PlataformaRepository plataformaRepository;
    private final JogoRepository jogoRepository;

    public JogoPlataformaRepositoryInMemory(PlataformaRepository plataformaRepository, JogoRepository jogoRepository) {
        this.plataformaRepository = plataformaRepository;
        this.jogoRepository = jogoRepository;
    }

    @Override
    public JogoPlataforma registrarPrecoJogoPorPlataforma(JogoPlataforma jogoPlataforma) {
        if(jogoPlataforma.id() == null) {
            contador++;
            var jogoCopy = JogoPlataforma
                .builder()
                .id(contador)
                .jogo(jogoRepository.buscarPorId(jogoPlataforma.jogo().id()).orElseThrow())
                .plataforma(plataformaRepository.buscarPorId(jogoPlataforma.plataforma().id()).orElseThrow())
                .preco(jogoPlataforma.preco())
                .build();

            return registrarPrecoJogoPorPlataforma(jogoCopy);
        }

        var jogoSalvoOptional = buscarJogoPorJogoIdEPlataformaId(
                    jogoPlataforma.jogo().id(),
                    jogoPlataforma.plataforma().id());


        if(jogoSalvoOptional.isPresent()) {
            var jogoSalvoIndex = db.indexOf(jogoSalvoOptional.get());
            db.remove(jogoSalvoIndex);
            db.add(jogoSalvoIndex, jogoPlataforma);

            return jogoPlataforma;
        }

        db.add(jogoPlataforma);


        return jogoPlataforma;
    }

    @Override
    public Optional<JogoPlataforma> buscarJogoPorJogoIdEPlataformaId(Integer jogoId, Integer plataformaId) {
        return db.stream()
                .filter(jp -> jp.jogo().id().equals(jogoId) && jp.plataforma().id().equals(plataformaId))
                .map(jp -> {
                    var plataforma = plataformaRepository.buscarPorId(plataformaId);
                    var jogo = jogoRepository.buscarPorId(jogoId);

                    return JogoPlataforma
                        .builder()
                        .plataforma(plataforma.orElse(Plataforma.builder().build()))
                        .jogo(jogo.orElse(Jogo.builder().build()))
                        .preco(jp.preco())
                        .build();
                })
                .findFirst();
    }
}
