package com.github.dannrocha.locadora.databuilder;

import com.github.dannrocha.locadora.domain.dto.plataforma.RegistroPlataformaDTO;

import java.util.ArrayList;
import java.util.List;

public class RegistroPlataformaDataBuilder {

    private List<RegistroPlataformaDTO> list;

    private RegistroPlataformaDataBuilder(List<RegistroPlataformaDTO> list) {
        this.list = list;
    }

    public static RegistroPlataformaDataBuilder algumasPlataformas() {

        var list = new ArrayList<RegistroPlataformaDTO>();
        list.add(RegistroPlataformaDTO.builder().nome("PC").build());
        list.add(RegistroPlataformaDTO.builder().nome("Xbox").build());
        list.add(RegistroPlataformaDTO.builder().nome("PS4").build());
        list.add(RegistroPlataformaDTO.builder().nome("Switch").build());

        return new RegistroPlataformaDataBuilder(list);
    }

    public List<RegistroPlataformaDTO> buildGrupo() {
        return list;
    }
}
