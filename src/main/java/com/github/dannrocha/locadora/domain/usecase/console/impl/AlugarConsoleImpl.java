package com.github.dannrocha.locadora.domain.usecase.console.impl;

import com.github.dannrocha.locadora.domain.dto.console.AlugarConsoleDTO;
import com.github.dannrocha.locadora.domain.dto.console.SimpleAlugarConsoleDetalhesDTO;
import com.github.dannrocha.locadora.domain.dto.console.SimpleLocacaoConsoleDTO;
import com.github.dannrocha.locadora.domain.model.Console;
import com.github.dannrocha.locadora.domain.model.ItemLocacao;
import com.github.dannrocha.locadora.domain.model.Locacao;
import com.github.dannrocha.locadora.domain.repository.AcessorioRepository;
import com.github.dannrocha.locadora.domain.repository.ConsoleRepository;
import com.github.dannrocha.locadora.domain.repository.ItemLocacaoRepository;
import com.github.dannrocha.locadora.domain.repository.LocacaoRepository;
import com.github.dannrocha.locadora.domain.usecase.console.AlugarConsole;
import jakarta.transaction.Transactional;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class AlugarConsoleImpl extends AlugarConsole {

    private final LocacaoRepository locacaoRepository;
    private final ItemLocacaoRepository itemLocacaoRepository;

    private final ConsoleRepository consoleRepository;

    private final AcessorioRepository acessorioRepository;

    public AlugarConsoleImpl(LocacaoRepository locacaoRepository, ItemLocacaoRepository itemLocacaoRepository, ConsoleRepository consoleRepository, AcessorioRepository acessorioRepository) {
        this.locacaoRepository = locacaoRepository;
        this.itemLocacaoRepository = itemLocacaoRepository;
        this.consoleRepository = consoleRepository;
        this.acessorioRepository = acessorioRepository;
    }

    @Override
    @Transactional
    public SimpleAlugarConsoleDetalhesDTO alugarConsolesEAcessorios(AlugarConsoleDTO alugarConsoleDTO) {

        var locacoes = locacaoRepository.salvarMuitos(alugarConsoleDTO.toLocacaoModel());

        var consolesId = alugarConsoleDTO.toConsoleListId();

        var consoles = consoleRepository
            .buscarListaDeConsolesPorId(consolesId);


        if(consoles.isEmpty() || consoles.size() != consolesId.size()) {
            throw new RuntimeException();
        }

        var itemsConsoleLocacao = parseParaItemsLocacoaEUnirComLocacao(alugarConsoleDTO, locacoes, consoles);

        var total = registrarLocacaoECalcularTotal(itemsConsoleLocacao);

        var locacoesConsoleDTO = locacoes
            .stream()
            .map(SimpleLocacaoConsoleDTO::fromModel)
            .toList();

        return SimpleAlugarConsoleDetalhesDTO
            .builder()
            .preco(total)
            .locacoes(locacoesConsoleDTO)
            .build();
    }

    private BigDecimal registrarLocacaoECalcularTotal(List<LocacaoConsoleAcessorio> itemsConsoleLocacao) {
        return itemsConsoleLocacao
                .stream()
                .peek(item -> {
                    itemLocacaoRepository
                            .salvar(item.console());
                    itemLocacaoRepository
                            .salvarMuitos(item.acessorios());
                })
                .map(LocacaoConsoleAcessorio::getPreco)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private List<LocacaoConsoleAcessorio> parseParaItemsLocacoaEUnirComLocacao(AlugarConsoleDTO alugarConsoleDTO, List<Locacao> locacoes, List<Console> consoles) {
        return locacoes.stream().map(locacao -> {

                    var console = consoles.remove(0);
                    var acessoriosId = obterAcessosriosDoConsole(alugarConsoleDTO, console);


                    var builder = LocacaoConsoleAcessorio.builder();
                    var consoleLocacao = ItemLocacao
                            .builder()
                            .locacaoId(locacao.getId())
                            .preco(console.getPreco())
                            .build();

                    builder.console(consoleLocacao);

                    var acessorios = acessorioRepository
                            .buscarConjuntoDeAcessoriosPorId(acessoriosId);


                    var acessoriosLocacao = acessorios
                            .stream()
                            .map(item -> ItemLocacao
                                    .builder()
                                    .locacaoId(locacao.getId())
                                    .preco(item.getPreco())
                                    .build()
                            )
                            .toList();

                    return builder
                            .acessorios(acessoriosLocacao)
                            .build();
                })
                .toList();
    }

    private List<Integer> obterAcessosriosDoConsole(AlugarConsoleDTO alugarConsoleDTO, Console console) {
        return alugarConsoleDTO
                .items()
                .stream()
                .filter(con -> con.consoleId().equals(console.getId()))
                .findFirst()
                .get()
                .acessoriosId();
    }

    @Builder
    private  record LocacaoConsoleAcessorio(
        ItemLocacao console,
        List<ItemLocacao> acessorios

    ) {

        public BigDecimal getPreco() {
            return acessorios
                .stream()
                .map(ItemLocacao::getPreco)
                .reduce(BigDecimal::add).get()
                .add(console.getPreco());
        }
    }
}
