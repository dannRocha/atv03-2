package com.github.dannrocha.locadora.domain.dto.cliente;

import com.github.dannrocha.locadora.domain.model.Cliente;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record RegistroClienteDTO(
        @NotEmpty
        String nome,

        @NotEmpty
        String email,

        @NotEmpty
        String telefone,

        @NotEmpty
        String senha
) {

    public Cliente toModel() {
        return Cliente.builder()
            .id(null)
            .nome(this.nome)
            .email(this.email)
            .senha(this.senha)
            .telefone(this.telefone)
            .build();
    }
}
