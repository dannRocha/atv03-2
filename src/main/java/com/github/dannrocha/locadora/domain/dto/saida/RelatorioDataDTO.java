package com.github.dannrocha.locadora.domain.dto.saida;

import com.github.dannrocha.locadora.domain.dto.cliente.SimpleClienteDTO;
import com.github.dannrocha.locadora.domain.dto.locacao.SimpleLocacaoDTO;

import java.util.List;

public record RelatorioDataDTO(
        SimpleClienteDTO clienteDTO,
        List<SimpleLocacaoDTO> locacoes
) {
}
