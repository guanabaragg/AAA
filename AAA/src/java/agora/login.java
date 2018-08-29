/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agora;

import Controller.LoginController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;

/**
 *
 * @author guana
 */
@ManagedBean
public class login {

    String nome;
    String senha;

    public static void main(String[] args) {

        usuariosDAO userDAO = new usuariosDAO();

        String nome = JOptionPane.showInputDialog("Nome:");
        String senha = JOptionPane.showInputDialog("Senha:");

        userDAO.validacaoLogin(nome, senha);

    }

    public void validacaoLogin() {
        usuariosDAO userDAO = new usuariosDAO();
        userDAO.validacaoLogin(getNome(), getSenha());
    }

    public void mudarPagina(String pPagina) {
        try {
            FacesContext ctx = FacesContext.getCurrentInstance();
            FacesContext.getCurrentInstance().getExternalContext().redirect(ctx.getExternalContext().getRequestContextPath() + pPagina);

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
