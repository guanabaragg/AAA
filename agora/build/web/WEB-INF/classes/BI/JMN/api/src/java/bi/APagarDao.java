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
 * @author CROSS
 */
public class APagarDao {

    public List<APagar> listarAPagar() {

        try {
            Conexao conexao = new Conexao();
            Connection conn = conexao.getConnection();

            List<APagar> lst = new ArrayList<>();
            String sql = "select * From vw_bi_apagar ";
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                APagar lista = new APagar();

                lista.setIdTitulo(rs.getString("idApagar"));
                lista.setTitulo(rs.getString("titulo"));
                lista.setPessoa(rs.getString("pessoa"));
                lista.setDia(rs.getString("dia"));
                lista.setMes(rs.getString("mes"));
                lista.setAno(rs.getString("Ano"));
                lista.setData(rs.getDate("dtEmissao"));
                lista.setNaturezalancamento(rs.getString("Natureza_Lancamento"));
                lista.setValor(rs.getBigDecimal("vlTitulo"));
                lista.setCep(rs.getString("Cep"));
                lista.setLogradouro(rs.getString("Logradouro"));
                lista.setBairro(rs.getString("bairro"));
                lista.setCidade(rs.getString("cidade"));
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
