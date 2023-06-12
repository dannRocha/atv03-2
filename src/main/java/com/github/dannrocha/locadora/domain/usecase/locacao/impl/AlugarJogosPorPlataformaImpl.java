package com.github.dannrocha.locadora.domain.usecase.locacao.impl;

import com.github.dannrocha.locadora.domain.dto.locacao.RegistroLocacaoDTO;
import com.github.dannrocha.locadora.domain.dto.locacao.RegistroLocacaoJogoDTO;
import com.github.dannrocha.locadora.domain.dto.locacao.SimpleLocacaoDTO;
import com.github.dannrocha.locadora.domain.dto.plataforma.SimpleJogoPlataformaDTO;
import com.github.dannrocha.locadora.domain.usecase.locacao.AlugarJogosPorPlataforma;
import com.github.dannrocha.locadora.domain.usecase.locacao.LocacaoPersistencia;
import com.github.dannrocha.locadora.domain.usecase.plataforma.JogoPlataformaPersistancia;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AlugarJogosPorPlataformaImpl implements AlugarJogosPorPlataforma {

    private final LocacaoPersistencia locacaoPersistencia;
    private final JogoPlataformaPersistancia jogoPlataformaPersistancia;

    public AlugarJogosPorPlataformaImpl(LocacaoPersistencia locacaoPersistencia, JogoPlataformaPersistancia jogoPlataformaPersistancia) {
        this.locacaoPersistencia = locacaoPersistencia;
        this.jogoPlataformaPersistancia = jogoPlataformaPersistancia;
    }

    @Override
    public SimpleLocacaoDTO alugarJogos(RegistroLocacaoDTO registro) {
        var jogosPorPlataforma = jogoPlataformaPersistancia
                .buscarPrecoJogoPorJogoEPlataformaPorLista(registro.jogos());

        if(jogosPorPlataforma.isEmpty()) {
            throw new RuntimeException();
        }

        var JogosValores = associarPrecosPlataformaEJogos(registro, jogosPorPlataforma);


        var locacao = RegistroLocacaoDTO
            .builder()
            .jogos(JogosValores)
            .build();

        var total = JogosValores
            .stream()
            .map(RegistroLocacaoJogoDTO::preco)
            .reduce(BigDecimal::add)
            .orElse(BigDecimal.ZERO);

        var locacaoSalvo = locacaoPersistencia.salvar(locacao);

        return SimpleLocacaoDTO
            .builder()
            .id(locacaoSalvo.id())
            .data(locacaoSalvo.data())
            .total(total)
            .build();
    }

    @Override
    public Optional<SimpleLocacaoDTO> buscarLocacaoPorId(Integer locacaoId) {
        return locacaoPersistencia.buscarLocacaoPorId(locacaoId);
    }

    private List<RegistroLocacaoJogoDTO> associarPrecosPlataformaEJogos(
        RegistroLocacaoDTO locacao,
        List<SimpleJogoPlataformaDTO> jogosPorPlataforma
    ) {
        return locacao
            .jogos()
            .stream()
            .map(jogo -> {
                var preco = jogosPorPlataforma
                    .stream()
                    .filter(it -> it.jogo().id().equals(jogo.jogoId()))
                    .map(SimpleJogoPlataformaDTO::preco)
                    .findFirst()
                    .get();

                return RegistroLocacaoJogoDTO
                    .builder()
                    .plataformaId(jogo.plataformaId())
                    .quantidadeDeDias(jogo.quantidadeDeDias())
                    .jogoId(jogo.jogoId())
                    .preco(preco)
                    .build();
            })
            .collect(Collectors.toList());
    }
}
