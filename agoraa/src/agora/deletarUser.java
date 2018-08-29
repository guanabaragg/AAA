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
public class deletarUser {

    public static void main(String[] args) {

        usuariosBean user = new usuariosBean();
        listarUser lista = new listarUser();
        usuariosDAO userdao = new usuariosDAO();

        JOptionPane.showMessageDialog(null, "Os usuários são:");
        lista.lista();
        user.setId(Integer.parseInt(JOptionPane.showInputDialog("Informe a id do usuário a ser deletado:")));

        userdao.deletar(user);
        JOptionPane.showMessageDialog(null, "O usuário " + user.getId() + " foi deletado com sucesso.");
        lista.lista();
    }
}
