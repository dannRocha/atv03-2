package com.github.dannrocha.locadora.domain.dto.locacao;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RegistroItemLocaoDTO(
    @NotNull
    Integer dias,

    @NotNull
    Integer quantidade
) {
}
