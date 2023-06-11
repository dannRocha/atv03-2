package com.github.dannrocha.locadora.domain.usecase.locacao.impl.facade;

import com.github.dannrocha.locadora.domain.dto.locacao.RegistroLocacaoDTO;
import com.github.dannrocha.locadora.domain.dto.locacao.SimpleLocacaoDTO;
import com.github.dannrocha.locadora.domain.repository.ItemLocacaoRepository;
import com.github.dannrocha.locadora.domain.repository.LocacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class RegistrarLocacaoFacade {

    private final LocacaoRepository locacaoRepository;
    private final ItemLocacaoRepository itemLocacaoRepository;

    public RegistrarLocacaoFacade(LocacaoRepository locacaoRepository, ItemLocacaoRepository itemLocacaoRepository) {
        this.locacaoRepository = locacaoRepository;
        this.itemLocacaoRepository = itemLocacaoRepository;
    }

    public static RegistrarLocacaoFacade bind(LocacaoRepository locacaoRepository, ItemLocacaoRepository itemLocacaoRepository) {
        return new RegistrarLocacaoFacade(locacaoRepository, itemLocacaoRepository);
    }

    @Transactional
    public SimpleLocacaoDTO salvar(RegistroLocacaoDTO registro) {
        var locacaoSalva = locacaoRepository.salvar(registro.toModelLocacao());
        itemLocacaoRepository.salvarMuitos(registro.toModelItemLocacao(locacaoSalva.id()));

        return SimpleLocacaoDTO.fromModel(locacaoSalva);
    }
}
