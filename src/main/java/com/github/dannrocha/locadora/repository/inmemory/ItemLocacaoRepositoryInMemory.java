package com.github.dannrocha.locadora.repository.inmemory;

import com.github.dannrocha.locadora.domain.model.ItemLocacao;
import com.github.dannrocha.locadora.domain.repository.ItemLocacaoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ItemLocacaoRepositoryInMemory extends DbInMemory<ItemLocacao> implements ItemLocacaoRepository {
    @Override
    public ItemLocacao salvar(ItemLocacao itemLocacao) {
        return null;
    }

    @Override
    public Optional<ItemLocacao> buscarPorId(Integer itemLocacaoId) {
        return Optional.empty();
    }

    @Override
    public List<ItemLocacao> salvarMuitos(List<ItemLocacao> modelItemLocacao) {
        return null;
    }
}
