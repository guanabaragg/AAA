/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.Conexao;

/**
 *
 * @author guana
 */
public class listarUser {

    public static void main(String[] args) {

        try {

            Connection conexao = Conexao.getConexao();

            PreparedStatement ps = conexao.prepareStatement("select * from usuarios");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ArrayList<usuariosBean> lista = new ArrayList();

                usuariosBean user = new usuariosBean();

                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("nome"));
                user.setSenha(rs.getString("senha"));
                user.setEmail(rs.getString("email"));

                lista.add(user);

                for (usuariosBean lista1 : lista) {
                    System.out.println("Id: " + user.getId() + "\nNome: " + user.getNome() + "\nSenha: " + user.getSenha() + "\nEmail: " + user.getEmail() + "\n");
                }

            }
            Conexao.fecharConexao();

        } catch (SQLException ex) {
            System.out.println("deu merda ao buscar");
        }
    }

    public void lista() {

        try {

            Connection conexao = Conexao.getConexao();

            PreparedStatement ps = conexao.prepareStatement("select * from usuarios");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ArrayList<usuariosBean> lista = new ArrayList();

                usuariosBean user = new usuariosBean();

                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("nome"));
                user.setSenha(rs.getString("senha"));
                user.setEmail(rs.getString("email"));

                lista.add(user);

                for (usuariosBean lista1 : lista) {
                    System.out.println("Id: " + user.getId() + "\nNome: " + user.getNome() + "\nSenha: " + user.getSenha() + "\nEmail: " + user.getEmail() + "\n");
                    //JOptionPane.showMessageDialog(null, "Id: " + user.getId() + "\nNome: " + user.getNome() + "\nSenha: " + user.getSenha() + "\nEmail: " + user.getEmail());
                }

            }
            Conexao.fecharConexao();

        } catch (SQLException ex) {
            System.out.println("deu merda ao buscar");
        }
    }
}
