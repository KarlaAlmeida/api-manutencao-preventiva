package br.edu.infnet.karlaapitdd;

import br.edu.infnet.karlaapitdd.model.domain.entities.Ativo;
import br.edu.infnet.karlaapitdd.model.domain.entities.OrdemServicoPreventiva;
import br.edu.infnet.karlaapitdd.model.domain.entities.ServicoPreventiva;
import br.edu.infnet.karlaapitdd.model.enums.StatusAtivo;
import br.edu.infnet.karlaapitdd.model.enums.TipoAtivo;
import br.edu.infnet.karlaapitdd.model.enums.TipoServicoPreventiva;
import br.edu.infnet.karlaapitdd.model.utils.TabelaCustoPreventiva;
import br.edu.infnet.karlaapitdd.model.service.OrdemServicoPreventivaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrdemServicoPreventivaServiceTest {

    private OrdemServicoPreventivaService ordemServicoPreventivaService;
    private Ativo ativo1;
    private Ativo ativo2;

    @BeforeEach
    void setup(){
        ordemServicoPreventivaService = new OrdemServicoPreventivaService();

        ativo1 = new Ativo("P-001", TipoAtivo.POSTE, StatusAtivo.ATIVO,
                LocalDate.of(2025,9,12), "Rua Ana Vilar 472");
        ativo2 = new Ativo("T-001", TipoAtivo.TRANSFORMADOR, StatusAtivo.EM_MANUTENCAO,
                LocalDate.of(2025,5,2),"Rua Ana Vilar 472");

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
    @DisplayName("Deve calcular o custo total para uma ordem de serviço com um único serviço.")
    void deveCalcularCustoTotal_quandoOrdemServicoPreventivaPossuirUmItem() {
        // Dado: uma ordem de serviço com um serviço
        ServicoPreventiva servicoPreventiva = new ServicoPreventiva();
        servicoPreventiva.setAtivo(ativo1);
        servicoPreventiva.setQuantidade(2);
        servicoPreventiva.setTipoServico(TipoServicoPreventiva.INSPECAO_VISUAL);// 2 * 10.00 = 20.00

        List<ServicoPreventiva> listaServicos = new ArrayList<>();
        listaServicos.add(servicoPreventiva);

        OrdemServicoPreventiva ordemServicoPreventiva = new OrdemServicoPreventiva();
        ordemServicoPreventiva.setServicoPreventiva(listaServicos);

        BigDecimal custoTotalEsperado = new BigDecimal("20.00");

        // Quando: calcularCustoTotal é chamado
        BigDecimal custoTotalCalculado = ordemServicoPreventivaService.calcularCustoTotal(ordemServicoPreventiva);

        // Então: o custo total deve ser o esperado
        assertTrue(custoTotalEsperado.compareTo(custoTotalCalculado) == 0,
                "O total do custo da ordem de serviço com um item deve ser 20.00");
    }

    @Test
    @DisplayName("Deve calcular o custo total para uma ordem de serviço com vários serviços.")
    void deveCalcularCustoTotal_quandoOrdemServicoPreventivaPossuirVariosServicos() {
        // Dado: uma ordem de serviço com vários serviços
        ServicoPreventiva servicoPreventiva1 = new ServicoPreventiva();
        servicoPreventiva1.setAtivo(ativo1);
        servicoPreventiva1.setQuantidade(2);
        servicoPreventiva1.setTipoServico(TipoServicoPreventiva.INSPECAO_VISUAL);// 2 * 10.00 = 20.00

        ServicoPreventiva servicoPreventiva2 = new ServicoPreventiva();
        servicoPreventiva2.setAtivo(ativo2);
        servicoPreventiva2.setQuantidade(1);
        servicoPreventiva2.setTipoServico(TipoServicoPreventiva.REAPERTO);// 1 * 90.00 = 90.00

        List<ServicoPreventiva> listaServicos = new ArrayList<>();
        listaServicos.add(servicoPreventiva1);
        listaServicos.add(servicoPreventiva2);

        OrdemServicoPreventiva ordemServicoPreventiva = new OrdemServicoPreventiva();
        ordemServicoPreventiva.setServicoPreventiva(listaServicos);

        BigDecimal custoTotalEsperado = new BigDecimal("110.00");

        // Quando: calcularCustoTotal é chamado
        BigDecimal custoTotalCalculado = ordemServicoPreventivaService.calcularCustoTotal(ordemServicoPreventiva);

        // Então: o custo total deve ser o esperado
        assertTrue(custoTotalEsperado.compareTo(custoTotalCalculado) == 0,
                "O total do custo da ordem de serviço com vários itens deve ser 110.00");
    }

    @Test
    @DisplayName("Deve retornar zero quando a ordem de serviço não possuir serviços.")
    void deveRetornarZero_quandoOrdemServicoPreventivaNaoPossuirServicos() {
        // Dado: uma ordem de serviço sem serviços
        OrdemServicoPreventiva ordemServicoPreventiva = new OrdemServicoPreventiva();
        ordemServicoPreventiva.setServicoPreventiva(new ArrayList<>());

        BigDecimal custoTotalEsperado = BigDecimal.ZERO;

        // Quando: calcularCustoTotal é chamado
        BigDecimal custoTotalCalculado = ordemServicoPreventivaService.calcularCustoTotal(ordemServicoPreventiva);

        // Então: o custo total deve ser o esperado
        assertEquals(custoTotalEsperado,custoTotalCalculado,
                "O total do custo da ordem de serviço sem serviços deve ser zero");
    }

    @Test
    @DisplayName("Deve retornar zero quando a lista de serviços for nula.")
    void deveRetornarZero_quandoListaServicosNula() {
        // Dado: uma ordem de serviço com lista serviços nula
        OrdemServicoPreventiva ordemServicoPreventiva = new OrdemServicoPreventiva();
        ordemServicoPreventiva.setServicoPreventiva(null);

        BigDecimal custoTotalEsperado = BigDecimal.ZERO;

        // Quando: calcularCustoTotal é chamado
        BigDecimal custoTotalCalculado = ordemServicoPreventivaService.calcularCustoTotal(ordemServicoPreventiva);

        // Então: o custo total deve ser o esperado
        assertEquals(custoTotalEsperado,custoTotalCalculado,
                "O total do custo da ordem de serviço com lista de serviços nula deve ser zero");
    }

    @Test
    @DisplayName("Deve retornar zero quando a ordem de serviços for nula.")
    void deveRetornarZero_quandoOrdemServicoPreventivaNula() {
        // Dado: uma ordem de serviço nula
        OrdemServicoPreventiva ordemServicoPreventiva = null;

        BigDecimal custoTotalEsperado = BigDecimal.ZERO;

        // Quando: calcularCustoTotal é chamado
        BigDecimal custoTotalCalculado = ordemServicoPreventivaService.calcularCustoTotal(ordemServicoPreventiva);

        // Então: o custo total deve ser o esperado
        assertEquals(custoTotalEsperado,custoTotalCalculado,
                "O total do custo da ordem de serviço nula deve ser zero");
    }

    @Test
    @DisplayName("Uma ordem de serviço deve ser considerado válida quando todas as suas informações estão corretas.")
    void deveSerValida_quandoTodasInformacoesCorretas() {
        //Dado uma ordem de serviço com nome do técnico e lista de serviços válida
        ServicoPreventiva servicoPreventiva = new ServicoPreventiva();
        servicoPreventiva.setAtivo(ativo1);
        servicoPreventiva.setQuantidade(2);
        servicoPreventiva.setTipoServico(TipoServicoPreventiva.INSPECAO_VISUAL);

        OrdemServicoPreventiva ordemServicoPreventiva = new OrdemServicoPreventiva();
        ordemServicoPreventiva.setTecnico("João");
        ordemServicoPreventiva.setServicoPreventiva(List.of(servicoPreventiva));

        //Quando validarOrdemServicoPreventiva é chamado
        boolean isValid = ordemServicoPreventivaService.validarOrdemServicoPreventiva(ordemServicoPreventiva);

        // Então: deve retornar true
        assertTrue(isValid, "A ordem de serviço com todas as informações corretas deve ser válida.");
    }

    @Test
    @DisplayName("Uma ordem de serviços nula deve ser considerada inválida.")
    void deveSerInvalida_quandoOrdemServicoPreventivaNula() {
        // Dado: uma ordem de serviço nula
        OrdemServicoPreventiva ordemServicoPreventiva = null;

        //Quando validarOrdemServicoPreventiva é chamado
        boolean isValid = ordemServicoPreventivaService.validarOrdemServicoPreventiva(ordemServicoPreventiva);

        // Então: deve retornar false
        assertFalse(isValid, "Uma ordem de serviço nula deve ser inválida.");
    }

    @Test
    @DisplayName("Uma ordem de serviços com nome do técnico nulo deve ser considerada inválida.")
    void deveSerInvalida_quandoTecnicoNula() {
        //Dado uma ordem de serviço com nome do técnico nulo
        ServicoPreventiva servicoPreventiva = new ServicoPreventiva();
        servicoPreventiva.setAtivo(ativo1);
        servicoPreventiva.setQuantidade(2);
        servicoPreventiva.setTipoServico(TipoServicoPreventiva.INSPECAO_VISUAL);

        OrdemServicoPreventiva ordemServicoPreventiva = new OrdemServicoPreventiva();
        ordemServicoPreventiva.setTecnico(null);
        ordemServicoPreventiva.setServicoPreventiva(List.of(servicoPreventiva));

        //Quando validarOrdemServicoPreventiva é chamado
        boolean isValid = ordemServicoPreventivaService.validarOrdemServicoPreventiva(ordemServicoPreventiva);

        // Então: deve retornar false
        assertFalse(isValid, "Uma ordem de serviço com nome do técnico nulo deve ser inválida.");
    }

    @Test
    @DisplayName("Uma ordem de serviços com nome do técnico vazio deve ser considerada inválida.")
    void deveSerInvalida_quandoTecnicoVazio() {
        //Dado uma ordem de serviço com nome do técnico vazio
        ServicoPreventiva servicoPreventiva = new ServicoPreventiva();
        servicoPreventiva.setAtivo(ativo1);
        servicoPreventiva.setQuantidade(2);
        servicoPreventiva.setTipoServico(TipoServicoPreventiva.INSPECAO_VISUAL);

        OrdemServicoPreventiva ordemServicoPreventiva = new OrdemServicoPreventiva();
        ordemServicoPreventiva.setTecnico("");
        ordemServicoPreventiva.setServicoPreventiva(List.of(servicoPreventiva));

        //Quando validarOrdemServicoPreventiva é chamado
        boolean isValid = ordemServicoPreventivaService.validarOrdemServicoPreventiva(ordemServicoPreventiva);

        // Então: deve retornar false
        assertFalse(isValid, "Uma ordem de serviço com nome do técnico vazio deve ser inválida.");
    }

    @Test
    @DisplayName("Uma ordem de serviços com nome do técnico apenas com espaço vazio deve ser considerada inválida.")
    void deveSerInvalida_quandoTecnicoApenasEspaco() {
        //Dado uma ordem de serviço com nome do técnico apenas com espaços vazios
        ServicoPreventiva servicoPreventiva = new ServicoPreventiva();
        servicoPreventiva.setAtivo(ativo1);
        servicoPreventiva.setQuantidade(2);
        servicoPreventiva.setTipoServico(TipoServicoPreventiva.INSPECAO_VISUAL);

        OrdemServicoPreventiva ordemServicoPreventiva = new OrdemServicoPreventiva();
        ordemServicoPreventiva.setTecnico("  ");
        ordemServicoPreventiva.setServicoPreventiva(List.of(servicoPreventiva));

        //Quando validarOrdemServicoPreventiva é chamado
        boolean isValid = ordemServicoPreventivaService.validarOrdemServicoPreventiva(ordemServicoPreventiva);

        // Então: deve retornar false
        assertFalse(isValid, "Uma ordem de serviço com nome do técnico apenas com espaço vazio deve ser inválida.");
    }

    @Test
    @DisplayName("Uma ordem de serviços com lista de serviços nula deve ser considerada inválida.")
    void deveSerInvalida_quandoListaServicosNula() {
        //Dado uma ordem de serviço com lista de serviços nula
        OrdemServicoPreventiva ordemServicoPreventiva = new OrdemServicoPreventiva();
        ordemServicoPreventiva.setTecnico("João");
        ordemServicoPreventiva.setServicoPreventiva(null);

        //Quando validarOrdemServicoPreventiva é chamado
        boolean isValid = ordemServicoPreventivaService.validarOrdemServicoPreventiva(ordemServicoPreventiva);

        // Então: deve retornar false
        assertFalse(isValid, "Uma ordem de serviço com lista de serviços nula deve ser inválida.");
    }

    @Test
    @DisplayName("Uma ordem de serviços com lista de serviços vazia deve ser considerada inválida.")
    void deveSerInvalida_quandoListaServicosVazia() {
        //Dado uma ordem de serviço com lista de serviços nula
        OrdemServicoPreventiva ordemServicoPreventiva = new OrdemServicoPreventiva();
        ordemServicoPreventiva.setTecnico("João");
        ordemServicoPreventiva.setServicoPreventiva(new ArrayList<>());

        //Quando validarOrdemServicoPreventiva é chamado
        boolean isValid = ordemServicoPreventivaService.validarOrdemServicoPreventiva(ordemServicoPreventiva);

        // Então: deve retornar false
        assertFalse(isValid, "Uma ordem de serviço com lista de serviços vazia deve ser inválida.");
    }




}
