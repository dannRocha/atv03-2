package com.github.dannrocha.locadora.domain.dto.console;

import com.github.dannrocha.locadora.domain.model.Locacao;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record AlugarConsoleDTO(
    List<ConsoleEAcessoriosDTO> items
) {

    public List<Locacao> toLocacaoModel() {
        return this.items()
            .stream()
            .map(item -> Locacao
                    .builder()
                    .data(LocalDate.now())
                    .id(null)
                    .build()
            )
            .collect(Collectors.toList());
    }

    public List<Integer> toConsoleListId() {
        return this.items()
            .stream()
            .map(ConsoleEAcessoriosDTO::consoleId)
            .toList();
    }

}
