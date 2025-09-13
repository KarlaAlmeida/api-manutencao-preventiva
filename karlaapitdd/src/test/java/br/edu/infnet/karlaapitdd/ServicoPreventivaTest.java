package br.edu.infnet.karlaapitdd;

import br.edu.infnet.karlaapitdd.model.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;


public class ServicoPreventivaTest {

    private Ativo ativo;

    @BeforeEach
    void setUp() {

        // Inicialização dos custos dos serviços de preventiva por ativo
        // POSTE
        TabelaCustoPreventiva.definirCusto(TipoAtivo.POSTE, TipoServicoPreventiva.INSPECAO_VISUAL, new BigDecimal(10.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.POSTE, TipoServicoPreventiva.LIMPEZA, new BigDecimal(15.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.POSTE, TipoServicoPreventiva.REAPERTO, new BigDecimal(20.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.POSTE, TipoServicoPreventiva.MEDICAO, new BigDecimal(30.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.POSTE, TipoServicoPreventiva.TESTE, new BigDecimal(25.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.POSTE, TipoServicoPreventiva.TROCA_COMPONENTE, new BigDecimal(40.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.POSTE, TipoServicoPreventiva.SUBSTITUICAO, new BigDecimal(50.0));

        // TRANSFORMADOR
        TabelaCustoPreventiva.definirCusto(TipoAtivo.TRANSFORMADOR, TipoServicoPreventiva.INSPECAO_VISUAL, new BigDecimal(50.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.TRANSFORMADOR, TipoServicoPreventiva.LIMPEZA, new BigDecimal(70.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.TRANSFORMADOR, TipoServicoPreventiva.REAPERTO, new BigDecimal(90.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.TRANSFORMADOR, TipoServicoPreventiva.MEDICAO, new BigDecimal(110.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.TRANSFORMADOR, TipoServicoPreventiva.TESTE, new BigDecimal(120.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.TRANSFORMADOR, TipoServicoPreventiva.TROCA_COMPONENTE, new BigDecimal(200.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.TRANSFORMADOR, TipoServicoPreventiva.SUBSTITUICAO, new BigDecimal(300.0));

        // CHAVE FUSÍVEL
        TabelaCustoPreventiva.definirCusto(TipoAtivo.CHAVE_FUSIVEL, TipoServicoPreventiva.INSPECAO_VISUAL, new BigDecimal(20.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.CHAVE_FUSIVEL, TipoServicoPreventiva.LIMPEZA, new BigDecimal(25.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.CHAVE_FUSIVEL, TipoServicoPreventiva.REAPERTO, new BigDecimal(35.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.CHAVE_FUSIVEL, TipoServicoPreventiva.MEDICAO, new BigDecimal(45.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.CHAVE_FUSIVEL, TipoServicoPreventiva.TESTE, new BigDecimal(55.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.CHAVE_FUSIVEL, TipoServicoPreventiva.TROCA_COMPONENTE, new BigDecimal(70.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.CHAVE_FUSIVEL, TipoServicoPreventiva.SUBSTITUICAO, new BigDecimal(100.0));

        // PÁRA-RAIOS
        TabelaCustoPreventiva.definirCusto(TipoAtivo.PARA_RAIOS, TipoServicoPreventiva.INSPECAO_VISUAL, new BigDecimal(15.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.PARA_RAIOS, TipoServicoPreventiva.LIMPEZA, new BigDecimal(20.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.PARA_RAIOS, TipoServicoPreventiva.REAPERTO, new BigDecimal(30.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.PARA_RAIOS, TipoServicoPreventiva.MEDICAO, new BigDecimal(40.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.PARA_RAIOS, TipoServicoPreventiva.TESTE, new BigDecimal(50.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.PARA_RAIOS, TipoServicoPreventiva.TROCA_COMPONENTE, new BigDecimal(60.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.PARA_RAIOS, TipoServicoPreventiva.SUBSTITUICAO, new BigDecimal(80.0));

        // REGULADOR
        TabelaCustoPreventiva.definirCusto(TipoAtivo.REGULADOR, TipoServicoPreventiva.INSPECAO_VISUAL, new BigDecimal(40.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.REGULADOR, TipoServicoPreventiva.LIMPEZA, new BigDecimal(60.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.REGULADOR, TipoServicoPreventiva.REAPERTO, new BigDecimal(80.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.REGULADOR, TipoServicoPreventiva.MEDICAO, new BigDecimal(100.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.REGULADOR, TipoServicoPreventiva.TESTE, new BigDecimal(130.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.REGULADOR, TipoServicoPreventiva.TROCA_COMPONENTE, new BigDecimal(180.0));
        TabelaCustoPreventiva.definirCusto(TipoAtivo.REGULADOR, TipoServicoPreventiva.SUBSTITUICAO, new BigDecimal(250.0));
    }

    @Test
    @DisplayName("Deve realizar o cálculo do custo do serviço para um serviço válido.")
    void deveCalcularCusto_quandoServicoValido() {
        // Dado: um serviço com ativo, quantidade e tipo de serviço válidos
        String codigo = "1";
        TipoAtivo tipoAtivo = TipoAtivo.POSTE;
        StatusAtivo statusAtivo = StatusAtivo.ATIVO;
        LocalDate dataInstalacao = LocalDate.of(2025, 9, 8);
        String endereco = "Rua Pantanal 150, Apto 702 Orquidea, Nova Parnamrim, Parnamirim, RN, CEP: 59150-105";
        int quantidade = 1;
        TipoServicoPreventiva tipoServicoPreventiva = TipoServicoPreventiva.INSPECAO_VISUAL;

        ativo = new Ativo(codigo, tipoAtivo, statusAtivo, dataInstalacao, endereco);

        ServicoPreventiva servicoPreventiva = new ServicoPreventiva();
        servicoPreventiva.setAtivo(ativo);
        servicoPreventiva.setQuantidade(quantidade);
        servicoPreventiva.setTipoServico(tipoServicoPreventiva);

        BigDecimal custoEsperado = new BigDecimal(10.0);

        // Quando: chamar o método calcularCusto
        BigDecimal custoCalculado = servicoPreventiva.calcularCusto();

        // Então: o resultado do custoServico será o valor esperado
        assertEquals(custoEsperado, custoCalculado,
                "O custo deste serviço deve ser 15.00");

        assertEquals(codigo, ativo.getCodigo(),
                "O código utilizado na criação do ativo deve ser '1'");
        assertEquals(tipoAtivo, ativo.getTipoAtivo(),
                "O tipo utilizado na criação do ativo deve ser 'POSTE'");
        assertEquals(statusAtivo, ativo.getStatusAtivo(),
                "O status utilizado na criação do ativo deve ser 'ATIVO'");
        assertEquals(dataInstalacao, ativo.getDataInstalacao(),
                "A data da instalação utilizada na criação do ativo deve ser '2025-09-08'");
        assertEquals(endereco, ativo.getEndereco(),
                "O endereço utilizado na criação do ativo deve ser " +
                "'Rua Pantanal 150, Apto 702 Orquidea, Nova Parnamrim, Parnamirim, RN, CEP: 59150-105'");
        assertEquals(quantidade, servicoPreventiva.getQuantidade(),
                "A quantidade do serviço utilizado na criação do serviço deve ser 1");
        assertEquals(tipoServicoPreventiva, servicoPreventiva.getTipoServico(),
                "O tipo de serviço utilizado na criação do serviço deve ser 'LIMPEZA'");
        assertNotNull(servicoPreventiva.getAtivo());
    }

    @Test
    @DisplayName("Deve retornar zero quando a quantidade for zero.")
    void deveRetornarZero_quandoQuantidadeForZero() {
        // Dado: um serviço com ativo, quantidade e tipo de serviço válidos
        ServicoPreventiva servicoPreventiva = new ServicoPreventiva();
        servicoPreventiva.setQuantidade(0);

        BigDecimal custoEsperado = BigDecimal.ZERO;

        // Quando: chamar o método calcularCusto
        BigDecimal custoCalculado = servicoPreventiva.calcularCusto();

        // Dado: um serviço com ativo, quantidade e tipo de serviço válidos
        assertEquals(custoEsperado, custoCalculado,
                "O custo do serviço deve ser zero quando a quantidade estiver zerada.");
    }

    @Test
    @DisplayName("Deve retornar zero quando a quantidade for negativa.")
    void deveRetornarZero_quandoQuantidadeForNegativa() {
        // Dado: um serviço com ativo, quantidade e tipo de serviço válidos
        ServicoPreventiva servicoPreventiva = new ServicoPreventiva();
        servicoPreventiva.setQuantidade(-1);

        BigDecimal custoEsperado = BigDecimal.ZERO;

        // Quando: chamar o método calcularCusto
        BigDecimal custoCalculado = servicoPreventiva.calcularCusto();

        // Então: o resultado do custoServico será o valor esperado
        assertEquals(custoEsperado, custoCalculado,
                "O custo do serviço deve ser zero quando a quantidade for negativa.");
    }

    @Test
    @DisplayName("Deve retornar zero quando o ativo estiver nulo.")
    void deveRetornarZero_quandoAtivoNulo() {
        // Dado: um serviço com ativo, quantidade e tipo de serviço válidos
        ServicoPreventiva servicoPreventiva = new ServicoPreventiva();
        servicoPreventiva.setAtivo(null);
        servicoPreventiva.setQuantidade(1);

        BigDecimal custoEsperado = BigDecimal.ZERO;

        // Quando: chamar o método calcularCusto
        BigDecimal custoCalculado = servicoPreventiva.calcularCusto();

        // Então: o resultado do custoServico será o valor esperado
        assertEquals(custoEsperado, custoCalculado,
                "O custo do serviço deve ser zero quando o ativo estiver nulo.");
    }

    @Test
    @DisplayName("Deve retornar zero quando o tipo de serviço estiver nulo.")
    void deveRetornarZero_quandoTipoServicoNulo() {
        // Dado: um serviço com ativo, quantidade e tipo de serviço válidos
        String codigo = "1";
        TipoAtivo tipoAtivo = TipoAtivo.POSTE;
        StatusAtivo statusAtivo = StatusAtivo.ATIVO;
        LocalDate dataInstalacao = LocalDate.of(2025, 9, 8);
        String endereco = "Rua Pantanal 150, Apto 702 Orquidea, Nova Parnamrim, Parnamirim, RN, CEP: 59150-105";

        ativo = new Ativo(codigo, tipoAtivo, statusAtivo, dataInstalacao, endereco);

        ServicoPreventiva servicoPreventiva = new ServicoPreventiva();
        servicoPreventiva.setAtivo(ativo);
        servicoPreventiva.setQuantidade(1);
        TipoServicoPreventiva tipoServicoPreventiva = null;

        BigDecimal custoEsperado = BigDecimal.ZERO;

        // Quando: chamar o método calcularCusto
        BigDecimal custoCalculado = servicoPreventiva.calcularCusto();

        // Então: o resultado do custoServico será o valor esperado
        assertEquals(custoEsperado, custoCalculado,
                "O custo do serviço deve ser zero quando o tipo de serviço estiver nulo.");
    }

}
