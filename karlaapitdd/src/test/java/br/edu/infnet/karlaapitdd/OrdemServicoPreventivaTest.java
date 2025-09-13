package br.edu.infnet.karlaapitdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.edu.infnet.karlaapitdd.model.domain.ServicoPreventiva;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.edu.infnet.karlaapitdd.model.domain.OrdemServicoPreventiva;
import br.edu.infnet.karlaapitdd.model.domain.StatusOSManutencaoPreventiva;


public class OrdemServicoPreventivaTest {

    @Test
    @DisplayName("Deve inicializar OrdemServicoPreventiva com data de criação, status ABERTA" +
            " e número gerado automaticamente.")
    void deveInicializarOrdemServicoPreventivaComValoresPadrao() {
        // Dado: uma nova OrdemServicoPreventiva é instanciada
        LocalDate antesCriacao = LocalDate.now().minusDays(1);
        OrdemServicoPreventiva ordemServicoPreventiva = new OrdemServicoPreventiva();
        LocalDate depoisCriacao = LocalDate.now().plusDays(1);

        // Quando: os getters são chamados
        String numeroOS = ordemServicoPreventiva.getNumeroOS();
        LocalDate dataCriacao = ordemServicoPreventiva.getDataCriacao();
        StatusOSManutencaoPreventiva status = ordemServicoPreventiva.getStatusOSManutencaoPreventiva();
        String tecnico = ordemServicoPreventiva.getTecnico();

        // Então: os valores devem estar corretamente inicializados
        assertNotNull(numeroOS,
                "O número da OrdemServicorPreventiva não deve ser nulo.");
        assertTrue(isValidUUID(numeroOS),
                "O número da OrdemServicorPreventiva deve ser um UUID válido.");

        assertNotNull(dataCriacao, "A data de criação não deve ser nula.");
        assertTrue(dataCriacao.isAfter(antesCriacao),
                "A data de criação não deve ser anterior ao momento da criação do pedido.");
        assertTrue(dataCriacao.isBefore(depoisCriacao),
                "A data de criação não deve ser posterior ao momento da criação do pedido.");


        assertEquals(StatusOSManutencaoPreventiva.ABERTA, status,
                "O status inicial da OrdemServicorPreventiva deve ser ABERTA.");

        assertEquals(null, tecnico, "O nome do técnico deve ser nulo por padrão.");

        assertNotNull(ordemServicoPreventiva.getServicoPreventiva(),
                "A lista de itens não deve ser nula.");
        assertTrue(ordemServicoPreventiva.getServicoPreventiva().isEmpty(),
                "A lista de itens deve ser vazia por padrão.");
    }

    private boolean isValidUUID(String uuid) {
        try {
            UUID.fromString(uuid);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Test
    @DisplayName("Deve permitir definir e obter o nome do tecnico.")
    void devePermitirDefinirEObterNomeTecnico() {
        // Dado: uma nova OrdemServicoPreventiva
        OrdemServicoPreventiva ordemServicoPreventiva = new OrdemServicoPreventiva();
        String nomeTecicoEsperado = "Novo Tecnico Teste";

        // Quando: o nome do tecnico é definido
        ordemServicoPreventiva.setTecnico(nomeTecicoEsperado);

        // Então: o getter deve retornar o nome definido
        assertEquals(nomeTecicoEsperado, ordemServicoPreventiva.getTecnico(),
                "O nome do técnico deve ser o valor 'Novo Tecnico Teste'.");
    }

    @Test
    @DisplayName("Deve permitir definir e obter o status da ordem de serviço.")
    void devePermitirDefinirEObterStatusPedido() {
        // Dado: uma nova OrdemServicoPreventiva
        OrdemServicoPreventiva ordemServicoPreventiva = new OrdemServicoPreventiva();
        StatusOSManutencaoPreventiva statusEsperado = StatusOSManutencaoPreventiva.EM_ANDAMENTO;

        // Quando: o status da OrdemServicoPreventiva é definido
        ordemServicoPreventiva.setStatusOSManutencaoPreventiva(statusEsperado);

        // Então: o getter deve retornar o status definido
        assertEquals(statusEsperado, ordemServicoPreventiva.getStatusOSManutencaoPreventiva(),
                "O status do pedido deve ser 'EM_ANDAMENTO'.");
    }

    @Test
    @DisplayName("Deve permitir definir e obter a lista de serviços.")
    void devePermitirDefinirEObterServicoPreventiva() {
        // Dado: uma nova OrdemServicoPreventiva
        OrdemServicoPreventiva ordemServicoPreventiva = new OrdemServicoPreventiva();
        List<ServicoPreventiva> novosServicos = new ArrayList<>();
        novosServicos.add(new ServicoPreventiva());

        // Quando: a lista de itens é definida
        ordemServicoPreventiva.setServicoPreventiva(novosServicos);

        // Então: o getter deve retornar a lista definida
        assertEquals(novosServicos, ordemServicoPreventiva.getServicoPreventiva(),
                "A lista de serviços deve ser a lista definida.");
        assertFalse(ordemServicoPreventiva.getServicoPreventiva().isEmpty(),
                "A lista de serviços não deve estar vazia após a definição.");
    }

    @Test
    @DisplayName("deveRetornarFalse_quandoUUIDInvalido: " +
            "Garante que isValidUUID retorne false para strings que não são UUIDs válidos.")
    void deveRetornarFalse_quandoUUIDInvalido() {
        // Dado: Uma string que claramente NÃO é um UUID válido
        String invalidUuidString = "esta-nao-e-um-uuid-valido";

        // Quando: o método isValidUUID é chamado com uma string inválida
        boolean resultado = isValidUUID(invalidUuidString);

        // Então: deve retornar false, cobrindo o bloco catch
        assertFalse(resultado, "isValidUUID deve retornar false para strings inválidas.");
    }

}
