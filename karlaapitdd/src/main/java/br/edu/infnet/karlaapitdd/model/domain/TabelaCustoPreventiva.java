package br.edu.infnet.karlaapitdd.model.domain;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

public class TabelaCustoPreventiva {

    private static final Map<TipoAtivo, Map<TipoServicoPreventiva, BigDecimal>>
            custos = new EnumMap<>(TipoAtivo.class);

    public static void definirCusto(TipoAtivo ativo, TipoServicoPreventiva servico, BigDecimal custo) {
        custos.computeIfAbsent(ativo, k -> new EnumMap<>(TipoServicoPreventiva.class))
                .put(servico, custo);
    }

    public static BigDecimal getCustoUnitario(TipoAtivo ativo, TipoServicoPreventiva servico) {
        return custos.getOrDefault(ativo, Map.of()).getOrDefault(servico, new BigDecimal(0.00));
    }
}
