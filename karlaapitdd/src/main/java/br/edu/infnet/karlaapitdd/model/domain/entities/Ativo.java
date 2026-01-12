package br.edu.infnet.karlaapitdd.model.domain.entities;

import br.edu.infnet.karlaapitdd.model.enums.StatusAtivo;
import br.edu.infnet.karlaapitdd.model.enums.TipoAtivo;

import java.time.LocalDate;

public class Ativo {

    private String codigo;
    private TipoAtivo tipoAtivo;
    private StatusAtivo statusAtivo;
    private LocalDate dataInstalacao;
    private String endereco;

    public Ativo(String codigo, TipoAtivo tipoAtivo, StatusAtivo statusAtivo,
                 LocalDate dataInstalacao, String endereco) {
        this.codigo = codigo;
        this.tipoAtivo = tipoAtivo;
        this.statusAtivo = statusAtivo;
        this.dataInstalacao = dataInstalacao;
        this.endereco = endereco;
    }

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


}
