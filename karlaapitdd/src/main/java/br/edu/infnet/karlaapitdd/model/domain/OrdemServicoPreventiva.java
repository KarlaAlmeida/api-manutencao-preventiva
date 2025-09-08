package br.edu.infnet.karlaapitdd.model.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdemServicoPreventiva {

    private String numeroOS;

    private LocalDate dataCriacao;

    private List<ServicoPreventiva> servicoPreventiva = new ArrayList<>();

    private StatusOSManutencaoPreventiva statusOSManutencaoPreventiva;

    private String tecnico;

    public OrdemServicoPreventiva() {
        this.dataCriacao = LocalDate.now();
        this.statusOSManutencaoPreventiva = StatusOSManutencaoPreventiva.ABERTA;
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
}
