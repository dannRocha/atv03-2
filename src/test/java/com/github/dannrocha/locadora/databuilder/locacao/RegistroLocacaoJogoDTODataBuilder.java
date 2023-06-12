package com.github.dannrocha.locadora.databuilder.locacao;

import com.github.dannrocha.locadora.domain.dto.locacao.RegistroLocacaoDTO;
import com.github.dannrocha.locadora.domain.dto.locacao.RegistroLocacaoJogoDTO;

import java.util.ArrayList;
import java.util.List;

public class RegistroLocacaoJogoDTODataBuilder {

    private List<RegistroLocacaoDTO> list;

    private RegistroLocacaoJogoDTODataBuilder(List<RegistroLocacaoDTO> list) {
        this.list = list;
    }


    public static RegistroLocacaoJogoDTODataBuilder umGrupoDeRegistroDeAlocacao() {
        return new RegistroLocacaoJogoDTODataBuilder(gerarGrupoDeRegistroDeAlocacao());
    }

    private static List<RegistroLocacaoDTO> gerarGrupoDeRegistroDeAlocacao() {

        var list = new ArrayList<RegistroLocacaoDTO>();

        var jogos = List.of(
            RegistroLocacaoJogoDTO.builder().jogoId(1).plataformaId(1).build(),
            RegistroLocacaoJogoDTO.builder().jogoId(1).plataformaId(2).build(),
            RegistroLocacaoJogoDTO.builder().jogoId(2).plataformaId(1).build()
        );

        var registro = RegistroLocacaoDTO
            .builder()
            .jogos(jogos)
            .build();

        list.add(registro);

        jogos = List.of(
            RegistroLocacaoJogoDTO.builder().jogoId(3).plataformaId(1).build(),
            RegistroLocacaoJogoDTO.builder().jogoId(3).plataformaId(2).build(),
            RegistroLocacaoJogoDTO.builder().jogoId(4).plataformaId(1).build()
        );

        registro = RegistroLocacaoDTO
            .builder()
            .jogos(jogos)
            .build();

        list.add(registro);

        return list;

    }

    public List<RegistroLocacaoDTO> buildGrupo() {
        return list;
    }

}
