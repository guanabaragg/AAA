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
        usuariosDAO userdao = new usuariosDAO();

        user.setNome(JOptionPane.showInputDialog("Informe o nome do usuário a ser deletado:"));
        userdao.deletar(user);

        JOptionPane.showMessageDialog(null, "O usuário " + user.getNome() + " foi deletado com sucesso.");

    }
}
