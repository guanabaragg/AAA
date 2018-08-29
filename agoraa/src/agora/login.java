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
public class login {

    public static void main(String[] args) {

        usuariosDAO userDAO = new usuariosDAO();

        String nome = JOptionPane.showInputDialog("Nome:");
        String senha = JOptionPane.showInputDialog("Senha:");

        userDAO.validacaoLogin(nome, senha);

    }
}
