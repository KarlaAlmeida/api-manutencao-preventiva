package br.edu.infnet.karlaapitdd.model.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrdemServicoPreventiva {

    private String numeroOS;
    private LocalDate dataCriacao;
    private List<ServicoPreventiva> servicoPreventiva;
    private StatusOSManutencaoPreventiva statusOSManutencaoPreventiva;
    private String tecnico;
    private String dataAgendada;
    private String dataExecucao;

    public OrdemServicoPreventiva() {
        this.setNumeroOS(UUID.randomUUID().toString());
        this.setDataCriacao(LocalDate.now());
        this.setServicoPreventiva(new ArrayList<ServicoPreventiva>());
        this.setStatusOSManutencaoPreventiva(StatusOSManutencaoPreventiva.ABERTA);
        this.setTecnico(null);
    }

    public String getNumeroOS() {
        return numeroOS;
    }

    public void setNumeroOS(String numeroOS) {
        this.numeroOS = numeroOS;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<ServicoPreventiva> getServicoPreventiva() {
        return servicoPreventiva;
    }

    public void setServicoPreventiva(List<ServicoPreventiva> servicoPreventiva) {
        this.servicoPreventiva = servicoPreventiva;
    }

    public StatusOSManutencaoPreventiva getStatusOSManutencaoPreventiva() {
        return statusOSManutencaoPreventiva;
    }

    public void setStatusOSManutencaoPreventiva(StatusOSManutencaoPreventiva statusOSManutencaoPreventiva) {
        this.statusOSManutencaoPreventiva = statusOSManutencaoPreventiva;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getDataAgendada() {
        return dataAgendada;
    }

    public void setDataAgendada(String dataAgendada) {
        this.dataAgendada = dataAgendada;
    }

    public String getDataExecucao() {
        return dataExecucao;
    }

    public void setDataExecucao(String dataExecucao) {
        this.dataExecucao = dataExecucao;
    }
}
