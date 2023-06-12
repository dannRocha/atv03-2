package com.github.dannrocha.locadora.repository.inmemory;

import com.github.dannrocha.locadora.domain.model.Locacao;
import com.github.dannrocha.locadora.domain.repository.LocacaoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LocacaoRepositoryInMemory extends DbInMemory<Locacao> implements LocacaoRepository {
    @Override
    public Locacao salvar(Locacao locacao) {
        if(locacao.getId() == null) {
            contador++;
            var locacaoCopia = Locacao
                    .builder()
                    .id(contador)
                    .data(locacao.getData())
                    .build();


            return salvar(locacaoCopia);
        }

        var locacaolSalvoOptional = buscarPorId(locacao.getId());

        if(locacaolSalvoOptional.isPresent()) {
//            var locacaoSalvoIndex = db.indexOf(locacaolSalvoOptional.get());
//            db.remove(locacaoSalvoIndex);
//            db.add(locacaoSalvoIndex, locacao);

            return locacao;
        }

        db.add(locacao);

        return locacao;
    }

    @Override
    public Optional<Locacao> buscarPorId(Integer locacaoId) {
        return db.stream()
            .filter(locacao -> locacao.getId().equals(locacaoId))
            .findFirst();
    }
}
