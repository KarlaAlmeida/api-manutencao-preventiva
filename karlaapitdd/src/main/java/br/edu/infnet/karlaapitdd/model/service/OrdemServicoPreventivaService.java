package br.edu.infnet.karlaapitdd.model.service;

import br.edu.infnet.karlaapitdd.model.domain.entities.OrdemServicoPreventiva;
import br.edu.infnet.karlaapitdd.model.domain.entities.ServicoPreventiva;

import java.math.BigDecimal;
import java.util.Objects;

public class OrdemServicoPreventivaService {

    public BigDecimal calcularCustoTotal(OrdemServicoPreventiva ordem) {

        if (Objects.isNull(ordem)) {
            return BigDecimal.ZERO;
        }

        if (Objects.isNull(ordem.getServicoPreventiva()) || ordem.getServicoPreventiva().isEmpty()) {
            return BigDecimal.ZERO;
        }

        return ordem.getServicoPreventiva()
                .stream()
                .map(ServicoPreventiva::calcularCusto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    public boolean validarOrdemServicoPreventiva(OrdemServicoPreventiva ordem) {
        if(Objects.isNull(ordem)) {
            return false;
        }

        if(Objects.isNull(ordem.getTecnico()) || ordem.getTecnico().trim().isEmpty()) {
            return false;
        }

        if(Objects.isNull(ordem.getServicoPreventiva()) || ordem.getServicoPreventiva().isEmpty()) {
            return false;
        }

        return true;
    }
}
