package br.edu.infnet.karlaapitdd.model.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Ativo {

    private String codigo;

    private TipoAtivo tipoAtivo;

    private StatusAtivo statusAtivo;

    private LocalDate dataInstalacao;

    private String endereco;

    private BigDecimal custoServicoPreventiva;

    private Double duracaoServicoPreventiva;


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public TipoAtivo getTipoAtivo() {
        return tipoAtivo;
    }

    public void setTipoAtivo(TipoAtivo tipoAtivo) {
        this.tipoAtivo = tipoAtivo;
    }

    public StatusAtivo getStatusAtivo() {
        return statusAtivo;
    }

    public void setStatusAtivo(StatusAtivo statusAtivo) {
        this.statusAtivo = statusAtivo;
    }

    public LocalDate getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(LocalDate dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public BigDecimal getCustoServicoPreventiva() {
        return custoServicoPreventiva;
    }

    public void setCustoServicoPreventiva(BigDecimal custoServicoPreventiva) {
        this.custoServicoPreventiva = custoServicoPreventiva;
    }

    public Double getDuracaoServicoPreventiva() {
        return duracaoServicoPreventiva;
    }

    public void setDuracaoServicoPreventiva(Double duracaoServicoPreventiva) {
        this.duracaoServicoPreventiva = duracaoServicoPreventiva;
    }
}
