/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Financeiro;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author guana
 */
public class Financeiro {

    private String cdLancamento;
    private Date data;
    private Date vencimentoOriginal;
    private Date vencimento;
    private Date dtEmissao;
    private String serie;
    private String nf;
    private String fatura;
    private String parcela;
    private String duplicata;
    private String historico;
    private String contabilizado;
    private String tipo;
    private String situacao;
    private String status;
    private String cdConta;
    private String conta;
    private BigDecimal medidaValor;
    private String cdEmpresa;
    private String empresa;
    private String cdCobranca;
    private String empresaCobranca;
    private String cdPortador;
    private String portador;
    private Date dtUltimaLiqui;
    private String lancamentoVinculado;
    private String documento;
    private String contraPartida;

    public String getCdLancamento() {
        return cdLancamento;
    }

    public void setCdLancamento(String cdLancamento) {
        this.cdLancamento = cdLancamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getVencimentoOriginal() {
        return vencimentoOriginal;
    }

    public void setVencimentoOriginal(Date vencimentoOriginal) {
        this.vencimentoOriginal = vencimentoOriginal;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public Date getDtEmissao() {
        return dtEmissao;
    }

    public void setDtEmissao(Date dtEmissao) {
        this.dtEmissao = dtEmissao;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNf() {
        return nf;
    }

    public void setNf(String nf) {
        this.nf = nf;
    }

    public String getFatura() {
        return fatura;
    }

    public void setFatura(String fatura) {
        this.fatura = fatura;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    public String getDuplicata() {
        return duplicata;
    }

    public void setDuplicata(String duplicata) {
        this.duplicata = duplicata;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getContabilizado() {
        return contabilizado;
    }

    public void setContabilizado(String contabilizado) {
        this.contabilizado = contabilizado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCdConta() {
        return cdConta;
    }

    public void setCdConta(String cdConta) {
        this.cdConta = cdConta;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public BigDecimal getMedidaValor() {
        return medidaValor;
    }

    public void setMedidaValor(BigDecimal medidaValor) {
        this.medidaValor = medidaValor;
    }

    public String getCdEmpresa() {
        return cdEmpresa;
    }

    public void setCdEmpresa(String cdEmpresa) {
        this.cdEmpresa = cdEmpresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCdCobranca() {
        return cdCobranca;
    }

    public void setCdCobranca(String cdCobranca) {
        this.cdCobranca = cdCobranca;
    }

    public String getEmpresaCobranca() {
        return empresaCobranca;
    }

    public void setEmpresaCobranca(String empresaCobranca) {
        this.empresaCobranca = empresaCobranca;
    }

    public String getCdPortador() {
        return cdPortador;
    }

    public void setCdPortador(String cdPortador) {
        this.cdPortador = cdPortador;
    }

    public String getPortador() {
        return portador;
    }

    public void setPortador(String portador) {
        this.portador = portador;
    }

    public Date getDtUltimaLiqui() {
        return dtUltimaLiqui;
    }

    public void setDtUltimaLiqui(Date dtUltimaLiqui) {
        this.dtUltimaLiqui = dtUltimaLiqui;
    }

    public String getLancamentoVinculado() {
        return lancamentoVinculado;
    }

    public void setLancamentoVinculado(String lancamentoVinculado) {
        this.lancamentoVinculado = lancamentoVinculado;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getContraPartida() {
        return contraPartida;
    }

    public void setContraPartida(String contraPartida) {
        this.contraPartida = contraPartida;
    }

}
