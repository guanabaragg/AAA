/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi;

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
public class AReceberDao {

    public List<AReceber> listarAReceber() {

        try {
            Conexao conexao = new Conexao();
            Connection conn = conexao.getConnection();

            List<AReceber> lst = new ArrayList<>();
            String sql = "select * From vw_bi_areceber ";
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AReceber lista = new AReceber();

                lista.setIdTitulo(rs.getString("idareceber"));
                lista.setTitulo(rs.getString("Titulo"));
                lista.setPessoa(rs.getString("pessoa"));
                lista.setDia(rs.getString("dia"));
                lista.setMes(rs.getString("mes"));
                lista.setAno(rs.getString("ano"));
                lista.setData(rs.getDate("DtEmissao"));
                lista.setNaturezalancamento(rs.getString("Natureza_Lancamento"));
                lista.setValor(rs.getBigDecimal("vlTitulo"));
                lista.setCep(rs.getString("Cep"));
                lista.setLogradouro(rs.getString("Logradouro"));
                lista.setBairro(rs.getString("Bairro"));
                lista.setCidade(rs.getString("Cidade"));
                lista.setIdUf(rs.getString("idUf"));
                lista.setUf(rs.getString("UF"));
                lista.setStatus(rs.getString("status"));

                lst.add(lista);
            }
            rs.close();
            ps.close();
            conn.close();
            System.out.println(sql);
            return lst;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao listar Lista.," + ex.getMessage());
        }
    }
}
