package com.github.dannrocha.locadora.domain.dto.console;

import java.util.List;

public record ConsoleEAcessoriosDTO(
    Integer consoleId,
    List<Integer> acessoriosId
) {
}
