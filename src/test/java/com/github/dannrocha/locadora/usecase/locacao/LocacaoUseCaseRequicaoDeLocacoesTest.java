package com.github.dannrocha.locadora.usecase.locacao;

import com.github.dannrocha.locadora.databuilder.jogo.RegistroJogoDataBuilder;
import com.github.dannrocha.locadora.databuilder.locacao.RegistroLocacaoJogoDTODataBuilder;
import com.github.dannrocha.locadora.databuilder.plataforma.RegistroPlataformaDataBuilder;
import com.github.dannrocha.locadora.domain.dto.locacao.RegistroLocacaoDTO;
import com.github.dannrocha.locadora.domain.dto.locacao.RegistroLocacaoJogoDTO;
import com.github.dannrocha.locadora.domain.dto.plataforma.RegistroPlataformaDTO;
import com.github.dannrocha.locadora.domain.model.JogoPlataforma;
import com.github.dannrocha.locadora.domain.repository.JogoPlataformaRepository;
import com.github.dannrocha.locadora.domain.repository.JogoRepository;
import com.github.dannrocha.locadora.domain.repository.PlataformaRepository;
import com.github.dannrocha.locadora.domain.usecase.locacao.AlugarJogosPorPlataforma;
import com.github.dannrocha.locadora.domain.usecase.locacao.impl.AlugarJogosPorPlataformaImpl;
import com.github.dannrocha.locadora.factory.repository.AlugarJogosPorPlataformaFactory;
import com.github.dannrocha.locadora.repository.inmemory.JogoPlataformaRepositoryInMemory;
import com.github.dannrocha.locadora.repository.inmemory.JogoRepositoryInMemory;
import com.github.dannrocha.locadora.repository.inmemory.PlataformaRepositoryInMemory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocacaoUseCaseRequicaoDeLocacoesTest {

    private AlugarJogosPorPlataforma alugarJogosPorPlataforma;
    private JogoRepository jogoRepository;
    private PlataformaRepository plataformaRepository;
    private JogoPlataformaRepository jogoPlataformaRepository;

    @BeforeEach
    void setup() {
        jogoRepository = new JogoRepositoryInMemory();
        plataformaRepository = new PlataformaRepositoryInMemory();
        jogoPlataformaRepository = new JogoPlataformaRepositoryInMemory(plataformaRepository, jogoRepository);

        configurarDataSource();

        alugarJogosPorPlataforma = AlugarJogosPorPlataformaFactory
            .criar(jogoPlataformaRepository);

    }

    @Test
    void deveRegistrarNovaRequisicaoDeLocacaoDeJogosValido() {
        var registroLocacao = RegistroLocacaoJogoDTODataBuilder
                .umGrupoDeRegistroDeAlocacao()
                .buildGrupo();

        var registroSalvos = registroLocacao
            .stream()
            .map(alugarJogosPorPlataforma::alugarJogos)
            .toList();


        registroSalvos.forEach(it -> {
           assertTrue(alugarJogosPorPlataforma.buscarLocacaoPorId(it.id()).isPresent());
        });
    }


    private void configurarDataSource() {
        var jogos = RegistroJogoDataBuilder.umGrupoDeJogos(4).buildGrupo();
        var plataformas = RegistroPlataformaDataBuilder.algumasPlataformas().buildGrupo();


        var jogosSalvos = jogos
            .stream()
            .map(it -> jogoRepository.salvar(it.toModel()))
            .collect(Collectors.toList());

        var plataformasSalvas = plataformas
            .stream()
            .map(it -> plataformaRepository.registarPlataforma(it.toModel()))
            .collect(Collectors.toList());


        plataformasSalvas.forEach(plataforma -> {
            jogosSalvos.forEach(jogo -> {
                var registro = JogoPlataforma
                    .builder()
                    .preco(BigDecimal.valueOf(10D))
                    .jogoId(jogo.getId())
                    .plataformaId(plataforma.getId())
                    .build();

                jogoPlataformaRepository.registrarPrecoJogoPorPlataforma(registro);
            });
        });
    }
}
