package com.github.dannrocha.locadora.databuilder.jogo;

import com.github.dannrocha.locadora.domain.dto.jogo.RegistroJogoDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RegistroJogoDataBuilder {

    private List<RegistroJogoDTO> list = new ArrayList<>();
    private int tamanho = 0;

    private RegistroJogoDataBuilder(int tamanho) {
        this.tamanho = tamanho;
        gerarGrupoDeJogos();
    }

    public static RegistroJogoDataBuilder  umGrupoDeJogos(int tamanho) {
        return new RegistroJogoDataBuilder(tamanho);
    }

    public static RegistroJogoDataBuilder umJogo() {
        return new RegistroJogoDataBuilder(1);
    }

    private void gerarGrupoDeJogos() {
        for(int i = 0; i < tamanho; i++) {
            var r = RegistroJogoDTO
                .builder()
                .titulo("Super Mario %d".formatted(i))
                .build();

            list.add(r);
        }

    }

    public RegistroJogoDTO build() {
        return list.stream().findFirst().get();
    }


    public List<RegistroJogoDTO>buildGrupo() {
        return list;
    }
}
