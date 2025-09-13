package br.edu.infnet.karlaapitdd.model.domain;


import java.math.BigDecimal;

public class ServicoPreventiva {

    private Ativo ativo;
    private int quantidade;
    private TipoServicoPreventiva tipoServico;

    public ServicoPreventiva(Ativo ativo, int quantidade, TipoServicoPreventiva tipoServico) {
        this.ativo = ativo;
        this.quantidade = quantidade;
        this.tipoServico = tipoServico;
    }

    public ServicoPreventiva() {
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public TipoServicoPreventiva getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServicoPreventiva tipoServico) {
        this.tipoServico = tipoServico;
    }

    public BigDecimal calcularCusto() {
        throw new UnsupportedOperationException
                ("Método calcularCusto não está implementado.");
    }

}
