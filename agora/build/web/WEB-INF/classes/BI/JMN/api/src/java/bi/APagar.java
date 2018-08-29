/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author CROSS
 */
public class APagar {

    String idTitulo;
    String titulo;
    String pessoa;
    String dia;
    String mes;
    String ano;
    Date data;
    String naturezalancamento;
    BigDecimal valor;
    String cep;
    String logradouro;
    String bairro;
    String cidade;
    String idUf;
    String uf;
    String status;

    public APagar() {
        this.idTitulo = "";
        this.titulo = "";
        this.pessoa = "";
        this.dia = "";
        this.mes = "";
        this.ano = "";
        this.naturezalancamento = "";
        this.cep = "";
        this.logradouro = "";
        this.bairro = "";
        this.cidade = "";
        this.idUf = "";
        this.uf = "";
        this.status = "";
    }

    /* GET SET */
    public String getIdTitulo() {
        return idTitulo;
    }

    public void setIdTitulo(String idTitulo) {
        this.idTitulo = idTitulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNaturezalancamento() {
        return naturezalancamento;
    }

    public void setNaturezalancamento(String naturezalancamento) {
        this.naturezalancamento = naturezalancamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getIdUf() {
        return idUf;
    }

    public void setIdUf(String idUf) {
        this.idUf = idUf;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
