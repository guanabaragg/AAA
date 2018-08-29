package agora;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class usuariosBean {

    private int id;
    private String nome;
    private String senha;
    private String email;

    public ArrayList<String> lista() {

        ArrayList<String> list = new ArrayList();
        list.add(nome);
        list.add(senha);
        list.add(email);

        for (String lista1 : list) {
            System.out.println(lista1);
        }

        return list;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
