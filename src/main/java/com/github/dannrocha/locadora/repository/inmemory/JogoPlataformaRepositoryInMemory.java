package com.github.dannrocha.locadora.repository.inmemory;

import com.github.dannrocha.locadora.domain.model.Jogo;
import com.github.dannrocha.locadora.domain.model.JogoPlataforma;
import com.github.dannrocha.locadora.domain.model.Plataforma;
import com.github.dannrocha.locadora.domain.repository.JogoPlataformaRepository;
import com.github.dannrocha.locadora.domain.repository.JogoRepository;
import com.github.dannrocha.locadora.domain.repository.PlataformaRepository;
import com.github.dannrocha.locadora.domain.repository.consulta.jogoplataforma.JogoPlataformaID;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JogoPlataformaRepositoryInMemory extends DbInMemory<JogoPlataforma> implements JogoPlataformaRepository {

    private final PlataformaRepository plataformaRepository;
    private final JogoRepository jogoRepository;

    public JogoPlataformaRepositoryInMemory(
            @Lazy PlataformaRepository plataformaRepository,
            @Lazy JogoRepository jogoRepository) {
        this.plataformaRepository = plataformaRepository;
        this.jogoRepository = jogoRepository;
    }

    @Override
    public JogoPlataforma registrarPrecoJogoPorPlataforma(JogoPlataforma jogoPlataforma) {
        if(jogoPlataforma.getId() == null) {
            contador++;
            var jogoCopy = JogoPlataforma
                .builder()
                .id(contador)
                .jogo(jogoRepository.buscarPorId(jogoPlataforma.getJogo().getId()).orElseThrow())
                .plataforma(plataformaRepository.buscarPorId(jogoPlataforma.getPlataforma().getId()).orElseThrow())
                .preco(jogoPlataforma.getPreco())
                .build();

            return registrarPrecoJogoPorPlataforma(jogoCopy);
        }

        var jogoSalvoOptional = buscarJogoPorJogoIdEPlataformaId(
            JogoPlataformaID.builder()
                .plataformaId(jogoPlataforma.getPlataforma().getId())
                .jogoId(jogoPlataforma.getJogo().getId())
                .build());

        if(jogoSalvoOptional.isPresent()) {
            var jogoSalvoIndex = db.indexOf(jogoSalvoOptional.get());
            db.removeIf(it -> jogoSalvoOptional.get().getId().equals(it.getJogo().getId()));
            db.add(jogoSalvoIndex, jogoPlataforma);

            return jogoPlataforma;
        }

        db.add(jogoPlataforma);


        return jogoPlataforma;
    }

    @Override
    public List<JogoPlataforma> buscarJogoPorJogoIdEPlataformaId(List<JogoPlataformaID> lista) {
        return db
            .stream()
            .filter(it -> lista
                    .stream()
                    .anyMatch(id -> id.jogoId().equals(it.getJogo().getId())
                        && id.plataformaId().equals(it.getPlataforma().getId()))
            )
            .collect(Collectors.toList());
    }

    @Override
    public Optional<JogoPlataforma> buscarJogoPorJogoIdEPlataformaId(JogoPlataformaID id) {
        return db.stream()
                .filter(jp -> jp.getJogo().getId().equals(id.jogoId())
                    && jp.getPlataforma().getId().equals(id.plataformaId()))
                .map(jp -> {
                    var plataforma = plataformaRepository.buscarPorId(id.plataformaId());
                    var jogo = jogoRepository.buscarPorId(id.jogoId());

                    return JogoPlataforma
                        .builder()
                        .plataforma(plataforma.orElse(Plataforma.builder().build()))
                        .jogo(jogo.orElse(Jogo.builder().build()))
                        .preco(jp.getPreco())
                        .build();
                })
                .findFirst();
    }
}
