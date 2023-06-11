package com.github.dannrocha.locadora.domain.usecase.locacao;

import com.github.dannrocha.locadora.domain.dto.locacao.RegistroLocacaoDTO;
import com.github.dannrocha.locadora.domain.dto.locacao.SimpleLocacaoDTO;

import java.util.Optional;

public abstract class LocacaoPersistencia {
    public abstract SimpleLocacaoDTO salvar(RegistroLocacaoDTO registro);
    public abstract Optional<SimpleLocacaoDTO> buscarLocacaoPorId(Integer locacaoId);
}
