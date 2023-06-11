package com.github.dannrocha.locadora.domain.usecase.locacao.impl;

import com.github.dannrocha.locadora.domain.dto.locacao.RegistroLocacaoDTO;
import com.github.dannrocha.locadora.domain.dto.locacao.SimpleLocacaoDTO;
import com.github.dannrocha.locadora.domain.repository.ItemLocacaoRepository;
import com.github.dannrocha.locadora.domain.repository.LocacaoRepository;
import com.github.dannrocha.locadora.domain.usecase.locacao.LocacaoPersistencia;
import com.github.dannrocha.locadora.domain.usecase.locacao.impl.facade.RegistrarLocacaoFacade;

import java.util.Optional;

public final class LocacaoPersistenciaImpl extends LocacaoPersistencia {

    private final LocacaoRepository repositorioLocacao;
    private final ItemLocacaoRepository itemLocacaoRepositorio;

    public LocacaoPersistenciaImpl(LocacaoRepository repositorioLocacao,
                                   ItemLocacaoRepository itemLocacaoRepositorio) {
        this.repositorioLocacao = repositorioLocacao;
        this.itemLocacaoRepositorio = itemLocacaoRepositorio;
    }

    @Override
    public SimpleLocacaoDTO salvar(RegistroLocacaoDTO registro) {
        return RegistrarLocacaoFacade
            .bind(repositorioLocacao, itemLocacaoRepositorio)
            .salvar(registro);
    }

    @Override
    public Optional<SimpleLocacaoDTO> buscarLocacaoPorId(Integer locacaoId) {
        return repositorioLocacao
            .buscarPorId(locacaoId)
            .map(SimpleLocacaoDTO::fromModel);
    }

}
