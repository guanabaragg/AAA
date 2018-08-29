package Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import util.Conexao;

@ManagedBean
public class usuariosDAO {

    private List lista;

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

    public List<usuariosBean> buscar() {

        List<usuariosBean> userBean = new ArrayList<>();

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

                userBean.add(user);
            }
            Conexao.fecharConexao();
            return userBean;

        } catch (SQLException ex) {
            System.out.println("deu merda ao buscar");
        }
        return userBean;
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
