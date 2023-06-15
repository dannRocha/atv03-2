package com.github.dannrocha.locadora.domain.dto.saida;

import com.github.dannrocha.locadora.domain.dto.cliente.SimpleClienteDTO;

import java.util.List;

public record RelatorioDTO(
    List<RelatorioDataDTO> conteudo
) {
}
