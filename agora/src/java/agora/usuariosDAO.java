package agora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import util.Conexao;

@ManagedBean
public class usuariosDAO {

    public void salvar() {
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps;
            ps = conexao.prepareStatement("INSERT INTO `usuarios` (`nome`,`senha`,`email`) VALUES (?,?,?)");

            usuariosBean user = new usuariosBean();
            ps.setString(1, user.getNome());
            ps.setString(2, user.getSenha());
            ps.setString(3, user.getEmail());
            ps.execute();
            Conexao.fecharConexao();
        } catch (SQLException ex) {
            System.out.println("deu merda ao salvar" + ex);
        }
    }

    public void listar() {
        /*try {
         Connection conexao = FabricaConexao.getConexao();
         PreparedStatement ps = conexao.prepareStatement("select * from carro");
         ResultSet resultSet = ps.executeQuery();
         List<Carro> carros = new ArrayList<>();
         while(resultSet.next()){
         Carro carro = new Carro();
         carro.setId(resultSet.getInt("id"));
         carro.setModelo(resultSet.getString("modelo"));
         carro.setFabricante(resultSet.getString("fabricante"));
         carro.setCor(resultSet.getString("cor"));
         carro.setAno(resultSet.getDate("ano"));
         carros.add(carro);
         }
         FabricaConexao.fecharConexao();
         return carros;
            
         } catch (SQLException ex) {
         throw new ErroSistema("Erro ao buscar os carros!",ex);
         }*/
    }

    public void alterar() {

    }

    public void apagar() {

    }

}
