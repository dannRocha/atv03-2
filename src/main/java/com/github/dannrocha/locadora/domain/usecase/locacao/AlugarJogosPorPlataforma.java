package com.github.dannrocha.locadora.domain.usecase.locacao;

import com.github.dannrocha.locadora.domain.dto.locacao.RegistroLocacaoDTO;
import com.github.dannrocha.locadora.domain.dto.locacao.SimpleLocacaoDTO;

import java.util.Optional;

public interface AlugarJogosPorPlataforma {
    SimpleLocacaoDTO alugarJogos(RegistroLocacaoDTO locacao);
    Optional<SimpleLocacaoDTO> buscarLocacaoPorId(Integer locacaoId);
}
