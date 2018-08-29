package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    static Connection conn;

    public Connection getConnection() throws SQLException {
        /*
         try {
         if (conn != null) {
         if (!conn.isClosed()) {        
         return conn;
         }
         }
         } catch (SQLException ex) {
         Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
         }
         */

        String usuario = "sa";

        String URL = "jdbc:sqlserver://192.168.0.10:1433;" + "databaseName=ALTERDATA;";
        //String URL = "jdbc:sqlserver://192.168.0.10:1433;" + "databaseName=HOMOLOG;";
        String password = "//jmncbb100";

        String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

        try {

            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(URL, usuario, password);
            conn = con;
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("Erro na conexao!");
            throw new SQLException(e.getMessage());

        }
    }

    public Connection conectarSGM() {
        System.out.println("CONECTAR SGM");
        /*
         try {
         if (conn != null) {
         if (!conn.isClosed()) {        
         return conn;
         }
         }
         } catch (SQLException ex) {
         Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
         }
         */

        try {
            String usuario = "sa";//esse usuário é um sysadmin ele tem todos os poderes, é bom que se crie um login e usuário a parte  

            String URL = "jdbc:sqlserver://192.168.0.10:1433;" + "databaseName=SGM;";//se não for acessar localmente mude localhost pelo nome do servidor  
            String password = "//jmncbb100";

            String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//Esse é o nome do driver, que na internet você vai encontrar de varias maneiras, mas só esse resolveu meus problemas  

            Class.forName(DRIVER);
            Connection con;

            con = DriverManager.getConnection(URL, usuario, password);
            conn = con;
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public static void executarSqlALTERDATA(String pSql) {

        try {
            Conexao conexao = new Conexao();
            Connection conn;
            conn = conexao.getConnection();

            Util util = new Util();
            PreparedStatement ps = conn.prepareStatement(pSql);
            ps = conn.prepareStatement(pSql);
            ps.execute();
            ps.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void executarSqlSGM(String pSql) {

        try {
            Conexao conexao = new Conexao();
            Connection conn;
            conn = conexao.conectarSGM();

            Util util = new Util();
            PreparedStatement ps = conn.prepareStatement(pSql);
            ps = conn.prepareStatement(pSql);
            ps.execute();
            ps.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
