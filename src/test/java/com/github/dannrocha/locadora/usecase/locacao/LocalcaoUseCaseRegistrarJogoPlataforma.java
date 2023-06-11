package com.github.dannrocha.locadora.usecase.locacao;

import com.github.dannrocha.locadora.databuilder.RegistroPlataformaDataBuilder;
import com.github.dannrocha.locadora.databuilder.jogo.RegistroJogoDataBuilder;
import com.github.dannrocha.locadora.domain.dto.plataforma.RegistroJogoPlataformaDTO;
import com.github.dannrocha.locadora.domain.dto.plataforma.SimpleJogoPlataformaDTO;
import com.github.dannrocha.locadora.domain.repository.JogoRepository;
import com.github.dannrocha.locadora.domain.repository.PlataformaRepository;
import com.github.dannrocha.locadora.domain.usecase.plataforma.JogoPlataformaPersistancia;
import com.github.dannrocha.locadora.factory.repository.JogoPlataformaPersistenciaFactory;
import com.github.dannrocha.locadora.repository.inmemory.JogoRepositoryInMemory;
import com.github.dannrocha.locadora.repository.inmemory.PlataformaRepositoryInMemory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocalcaoUseCaseRegistrarJogoPlataforma {


    private JogoPlataformaPersistancia jogoPlataformaPersistancia;

    private JogoRepository jogoRepository;
    private PlataformaRepository plataformaRepository;

    @BeforeEach
    void setup() {
        jogoRepository = new JogoRepositoryInMemory();
        plataformaRepository = new PlataformaRepositoryInMemory();
        jogoPlataformaPersistancia = JogoPlataformaPersistenciaFactory.criar(jogoRepository, plataformaRepository);
    }

    @Test
    void deveRegistrarNovoRequiscaoDeLocacao() {
        configureDataSource().forEach(it -> {
            assertTrue(it.jogo().titulo() != null);
            assertTrue(it.plataforma().nome() != null);
        });
    }

    @Test
    void deveBuscarPrecoDeJogoPorJogoIDePlataformaID() {
       var registroSalvo = configureDataSource()
           .stream()
           .findAny()
           .get();


       final int JOGO_ID = 1;
       final int PLATAFORMA_ID = 1;

       var registro = jogoPlataformaPersistancia.buscarPrecoJogoPorJogoEPlataforma(
               JOGO_ID, PLATAFORMA_ID);


       assertTrue(registro.isPresent());
       assertEquals(registro.get().jogo().id(), JOGO_ID);
       assertEquals(registro.get().plataforma().id(), PLATAFORMA_ID);
    }

    private List<SimpleJogoPlataformaDTO> configureDataSource() {
        var jogos = RegistroJogoDataBuilder.umGrupoDeJogos(10).buildGrupo();
        var plataformas = RegistroPlataformaDataBuilder.algumasPlataformas().buildGrupo();

        jogos.forEach(it -> jogoRepository.salvar(it.toModel()));
        plataformas.forEach(it -> plataformaRepository.registarPlataforma(it.toModel()));

        var registro1 = RegistroJogoPlataformaDTO
                .builder()
                .jogoId(1)
                .plataformaId(1)
                .preco(BigDecimal.valueOf(90D))
                .build();

        var registro2 = RegistroJogoPlataformaDTO
                .builder()
                .jogoId(2)
                .plataformaId(3)
                .preco(BigDecimal.valueOf(390D))
                .build();

        return List.of(registro1, registro2)
                .stream()
                .map(jogoPlataformaPersistancia::registrarPrecoJogoPorPlataforma)
                .collect(Collectors.toList());
    }
}
