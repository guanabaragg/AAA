/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agora;

import javax.swing.JOptionPane;

/**
 *
 * @author guana
 */
public class alterarUser {

    public static void main(String[] args) {

        usuariosBean user = new usuariosBean();
        usuariosDAO userdao = new usuariosDAO();

        user.setNome(JOptionPane.showInputDialog("Nome:"));
        user.setSenha(JOptionPane.showInputDialog("Senha:"));
        user.setEmail(JOptionPane.showInputDialog("Email:"));

        userdao.alterar(user);

        JOptionPane.showMessageDialog(null, "O usuário '" + user.getNome() + "' foi alterado com sucesso.");

    }

}
