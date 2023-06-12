package com.github.dannrocha.locadora.domain.dto.cliente;

import com.github.dannrocha.locadora.domain.model.Cliente;
import lombok.Builder;

@Builder
public record SimpleClienteDTO(
    Integer id,
    String nome,
    String email
) {

    public static SimpleClienteDTO fromCliente(Cliente cliente) {
        return SimpleClienteDTO
            .builder()
            .email(cliente.getEmail())
            .nome(cliente.getNome())
            .id(cliente.getId())
            .build();
    }
}
