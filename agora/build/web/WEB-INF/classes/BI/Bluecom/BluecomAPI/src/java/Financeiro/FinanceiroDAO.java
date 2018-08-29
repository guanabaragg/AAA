/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Financeiro;

import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guana
 */
public class FinanceiroDAO {

    public List<Financeiro> listarFinanceiro() {
        List<Financeiro> lst = new ArrayList<>();
        try {
            Conexao conexao = new Conexao();
            Connection conn = conexao.getConnection();

            String sql = "select * from VW_BI_FINANCEIRO";
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Financeiro lista = new Financeiro();

                lista.setCdLancamento(rs.getString("CD_LANCAMENTO"));
                lista.setData(rs.getDate("DATA"));
                lista.setVencimentoOriginal(rs.getDate("VENCIMENTO_ORIGINAL"));
                lista.setVencimento(rs.getDate("VENCIMENTO"));
                lista.setDtEmissao(rs.getDate("DT_EMISSAO"));
                lista.setSerie(rs.getString("SERIE"));
                lista.setNf(rs.getString("NF"));
                lista.setFatura(rs.getString("FATURA"));
                lista.setParcela(rs.getString("PARCELA"));
                lista.setDuplicata(rs.getString("DUPLICATA"));
                lista.setHistorico(rs.getString("HISTORICO"));
                lista.setContabilizado(rs.getString("CONTABILIZADO"));
                lista.setTipo(rs.getString("TIPO"));
                lista.setSituacao(rs.getString("SITUACAO"));
                lista.setStatus(rs.getString("STATUS"));
                lista.setCdConta(rs.getString("CD_CONTA"));
                lista.setConta(rs.getString("CONTA"));
                lista.setMedidaValor(rs.getBigDecimal("MEDIDA_VALOR"));
                lista.setCdEmpresa(rs.getString("CD_EMPRESA"));
                lista.setEmpresa(rs.getString("EMPRESA"));
                lista.setCdCobranca(rs.getString("CD_COBRANCA"));
                lista.setEmpresaCobranca(rs.getString("EMPRESA_COBRANCA"));
                lista.setCdPortador(rs.getString("CD_PORTADOR"));
                lista.setPortador(rs.getString("PORTADOR"));
                lista.setDtUltimaLiqui(rs.getDate("DT_ULTIMA_LIQUI"));
                lista.setLancamentoVinculado(rs.getString("LANCAMENTO_VINCULADO"));
                lista.setDocumento(rs.getString("DOCUMENTO"));
                lista.setContraPartida(rs.getString("CONTRA_PARTIDA"));

                lst.add(lista);
            }
            System.out.println(sql);

            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lst;
    }
}
