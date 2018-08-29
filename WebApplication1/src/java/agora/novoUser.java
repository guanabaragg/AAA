/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agora;

import javax.faces.bean.ManagedBean;
import javax.swing.JOptionPane;

/**
 *
 * @author guana
 */
@ManagedBean
public class novoUser {

    private String name;
    private String password;
    private String emaill;

    public static void main(String[] args) {

        usuariosBean user = new usuariosBean();
        usuariosDAO userdao = new usuariosDAO();

        user.setNome(JOptionPane.showInputDialog("Nome:"));
        user.setSenha(JOptionPane.showInputDialog("Senha:"));
        user.setEmail(JOptionPane.showInputDialog("Email:"));

        userdao.salvar(user);

        JOptionPane.showMessageDialog(null, "O usuário " + user.getNome() + " foi salvo com sucesso.");

    }

    public void salvar() {

        usuariosBean user = new usuariosBean();
        usuariosDAO userdao = new usuariosDAO();

        user.setNome(name);
        user.setSenha(password);
        user.setEmail(emaill);

        userdao.salvar(user);

        System.out.println("Salvo com sucesso.");
        setName("");
        setPassword("");
        setEmaill("");
    }

    public void deletar() {

        usuariosBean user = new usuariosBean();
        usuariosDAO userdao = new usuariosDAO();

        user.setNome(name);
        user.setSenha(password);
        user.setEmail(emaill);

        userdao.deletar(user);

        System.out.println("Deletado com sucesso.");
        setName("");
        setPassword("");
        setEmaill("");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmaill() {
        return emaill;
    }

    public void setEmaill(String emaill) {
        this.emaill = emaill;
    }

}
