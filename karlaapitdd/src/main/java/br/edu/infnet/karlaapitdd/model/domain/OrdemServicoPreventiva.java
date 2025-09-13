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

    public OrdemServicoPreventiva() {
        this.setNumeroOS(UUID.randomUUID().toString());
        this.setDataCriacao(LocalDate.now());
        this.setServicoPreventiva(new ArrayList<ServicoPreventiva>());
        this.setStatusOSManutencaoPreventiva(StatusOSManutencaoPreventiva.ABERTA);
        this.setTecnico(null);
    }

    public String getNumeroOS() {
        throw new UnsupportedOperationException
                ("Método getNumeroOS não está implementado.");
    }

    public void setNumeroOS(String numeroOS) {
        this.numeroOS = numeroOS;
    }

    public LocalDate getDataCriacao() {
        throw new UnsupportedOperationException
                ("Método getDataCriacao não está implementado.");
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<ServicoPreventiva> getServicoPreventiva() {
        throw new UnsupportedOperationException
                ("Método getServicoPreventiva não está implementado.");
    }

    public void setServicoPreventiva(List<ServicoPreventiva> servicoPreventiva) {
        this.servicoPreventiva = servicoPreventiva;
    }

    public StatusOSManutencaoPreventiva getStatusOSManutencaoPreventiva() {
        throw new UnsupportedOperationException
                ("Método getStatusOSManutencaoPreventiva não está implementado.");
    }

    public void setStatusOSManutencaoPreventiva(StatusOSManutencaoPreventiva statusOSManutencaoPreventiva) {
        this.statusOSManutencaoPreventiva = statusOSManutencaoPreventiva;
    }

    public String getTecnico() {
        throw new UnsupportedOperationException
                ("Método getTecnico não está implementado.");
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

}
