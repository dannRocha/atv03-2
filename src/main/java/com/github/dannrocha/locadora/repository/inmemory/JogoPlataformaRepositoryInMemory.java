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
            jogoPlataforma.setId(contador);
            return registrarPrecoJogoPorPlataforma(jogoPlataforma);
        }

        var jogoSalvoOptional = buscarJogoPorJogoIdEPlataformaId(
            JogoPlataformaID.builder()
                .plataformaId(jogoPlataforma.getPlataformaId())
                .jogoId(jogoPlataforma.getJogoId())
                .build());

        if(jogoSalvoOptional.isPresent()) {
            var jogoSalvoIndex = db.indexOf(jogoSalvoOptional.get());
            db.removeIf(it -> jogoSalvoOptional.get().getId().equals(it.getJogoId()));
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
                    .anyMatch(id -> id.jogoId().equals(it.getJogoId())
                        && id.plataformaId().equals(it.getPlataformaId()))
            )
            .collect(Collectors.toList());
    }

    @Override
    public Optional<JogoPlataforma> buscarJogoPorJogoIdEPlataformaId(JogoPlataformaID id) {
        return db.stream()
                .filter(jp -> jp.getJogoId().equals(id.jogoId())
                    && jp.getPlataformaId().equals(id.plataformaId()))
                .map(jp -> {
                    var plataforma = plataformaRepository.buscarPorId(id.plataformaId());
                    var jogo = jogoRepository.buscarPorId(id.jogoId());

                    return JogoPlataforma
                        .builder()
                        .plataformaId(plataforma.orElse(Plataforma.builder().build()).getId())
                        .jogoId(jogo.orElse(Jogo.builder().build()).getId())
                        .preco(jp.getPreco())
                        .build();
                })
                .findFirst();
    }
}
