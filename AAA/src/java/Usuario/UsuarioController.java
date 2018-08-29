/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import util.Conexao;

/**
 *
 * @author guana
 */
@ManagedBean
public class UsuarioController {

    private int id;
    private String name;
    private String password;
    private String emaill;
    private String[] listaUsuarios;

    private ArrayList<usuariosBean> lista = new ArrayList();

    public void lista() {

        try {

            Connection conexao = Conexao.getConexao();

            PreparedStatement ps = conexao.prepareStatement("select * from usuarios");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                usuariosBean user = new usuariosBean();

                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("nome"));
                user.setSenha(rs.getString("senha"));
                user.setEmail(rs.getString("email"));

                lista.add(user);

                for (usuariosBean lista1 : lista) {
                    setId(lista1.getId());

//                    setName(lista1.getNome());
//                    setPassword(lista1.getSenha());
//                    setEmaill(lista1.getEmail());
//                    System.out.println("\nId: " + lista1.getId() + "\nNome: " + lista1.getNome() + "\nSenha: " + lista1.getSenha() + "\nEmail: " + lista1.getEmail() + "\n ");
//                    //JOptionPane.showMessageDialog(null, "Id: " + user.getId() + "\nNome: " + user.getNome() + "\nSenha: " + user.getSenha() + "\nEmail: " + user.getEmail());                    
                }
            }
            System.out.println("foi mané uhuhuhulll");
            Conexao.fecharConexao();

        } catch (SQLException ex) {
            System.out.println("deu merda ao buscar");
        }
    }

    public void salvar() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        usuariosBean user = new usuariosBean();
        usuariosDAO userdao = new usuariosDAO();

        user.setNome(name);
        user.setSenha(password);
        user.setEmail(emaill);

        userdao.salvar(user);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário salvo com sucesso!", ""));
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
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário deletado com sucesso!", ""));
        System.out.println("Deletado com sucesso.");
        setName("");
        setPassword("");
        setEmaill("");
    }

    public void buscar() {

        usuariosBean user = new usuariosBean();
        usuariosDAO userdao = new usuariosDAO();

        name = user.getNome();
        password = user.getSenha();
        emaill = user.getEmail();

        userdao.buscar();
        System.out.println("buscou");
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

    public String[] getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(String[] listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<usuariosBean> getLista() {
        return lista;
    }

    public void setLista(ArrayList<usuariosBean> lista) {
        this.lista = lista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
