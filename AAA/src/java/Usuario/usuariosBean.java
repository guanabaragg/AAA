package Usuario;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class usuariosBean {

    private int id;
    private String nome;
    private String senha;
    private String email;
    private String[] listaUsuarios;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(String[] listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
