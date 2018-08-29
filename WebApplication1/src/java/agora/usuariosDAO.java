package agora;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
            PreparedStatement ps = conexao.prepareStatement("delete from usuarios where nome = ?");
            ps.setString(1, user.getNome());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("deu merda ao deletar " + ex);
        }
    }

}
