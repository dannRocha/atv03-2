package com.github.dannrocha.locadora.domain.usecase.console;

import com.github.dannrocha.locadora.domain.dto.console.AlugarConsoleDTO;
import com.github.dannrocha.locadora.domain.dto.console.SimpleAlugarConsoleDetalhesDTO;

public abstract class AlugarConsole {
    public abstract SimpleAlugarConsoleDetalhesDTO alugarConsolesEAcessorios(AlugarConsoleDTO alugarConsoleDTO);
}
