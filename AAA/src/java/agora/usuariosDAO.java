package agora;

import Controller.LoginController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;
import util.Conexao;

public class usuariosDAO {

    public void salvar(usuariosBean user) {
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps;
            ps = conexao.prepareStatement("INSERT INTO `usuarios` (`nome`,`senha`,`email`) VALUES (?,?,?)");

            ps.setString(1, user.getNome());
            ps.setString(2, user.getSenha());
            ps.setString(3, user.getEmail());
            ps.execute();
            Conexao.fecharConexao();
        } catch (SQLException ex) {
            System.out.println("deu merda ao salvar" + ex);
        }
    }

    public List<usuariosBean> listar() {
        List<usuariosBean> usuarios = new ArrayList<>();
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from usuarios");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                usuariosBean usuario = new usuariosBean();
                usuario.setNome(resultSet.getString("nome"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setEmail(resultSet.getString("email"));
                usuarios.add(usuario);
            }
            Conexao.fecharConexao();
            return usuarios;
        } catch (SQLException ex) {
            System.out.println("deu merda ao buscar usuarios. " + ex);
        }
        return usuarios;
    }

    public void alterar(usuariosBean user) {

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps;
            ps = conexao.prepareStatement("update usuarios set senha = ?, email = ? where nome = ?");

            ps.setString(1, user.getSenha());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getNome());
            ps.execute();
            Conexao.fecharConexao();
        } catch (SQLException ex) {
            System.out.println("Erro ao tentar salvar!" + ex);
        }

    }

    public void deletar(usuariosBean user) {
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("delete from usuarios where id = ?");
            ps.setInt(1, user.getId());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("deu merda ao deletar " + ex);
        }
    }

    public void novoUser() {

        usuariosBean user = new usuariosBean();
        usuariosDAO userdao = new usuariosDAO();

        user.setNome(JOptionPane.showInputDialog("Nome:"));
        user.setSenha(JOptionPane.showInputDialog("Senha:"));
        user.setEmail(JOptionPane.showInputDialog("Email:"));

        userdao.salvar(user);

        JOptionPane.showMessageDialog(null, "O usuário " + user.getNome() + " foi salvo com sucesso.");

    }

    public List<usuariosBean> validacaoLogin(String nome, String senha) {

        List<usuariosBean> usuarios = new ArrayList<>();

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from usuarios");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                usuariosBean usuario = new usuariosBean();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setEmail(resultSet.getString("email"));
                usuarios.add(usuario);

                if (nome.equals(usuario.getNome()) && senha.equals(usuario.getSenha())) {
                    //JOptionPane.showMessageDialog(null, "Sucesso guanabara,\nlogin: " + usuario.getNome() + "\nId: " + usuario.getId());
                    System.out.println("Sucesso guanabara,\n  login: " + usuario.getNome() + "\n  Id: " + usuario.getId());
                    LoginController logincon = new LoginController();
                    logincon.mudarPagina("/principal/principal.jsf");
                    Conexao.fecharConexao();
                    //System.exit(0);
                }
            }

            System.out.println("erro ao validar login");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario ou senha invalido!", ""));
            //JOptionPane.showMessageDialog(null, "Deu merda na validação de login guanabara\nLogin/Senha Incorretos!\nCrie um novo usuário");
            //novoUser();

            Conexao.fecharConexao();
            return usuarios;
        } catch (SQLException ex) {
            //System.out.println("Apenas ignore");
            //System.out.println("deu merda ao buscar usuarios. " + ex);
        }
        return usuarios;
    }

}
