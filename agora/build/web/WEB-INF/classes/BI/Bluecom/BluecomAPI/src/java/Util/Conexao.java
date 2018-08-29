/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guana
 */
public class Conexao {

    static Connection conn;

    public static void main(String[] args) throws SQLException {
        Connection con = Conexao.getConnection();
    }

    public static Connection getConnection() {
        try {
            if (conn != null) {
                if (!conn.isClosed()) {
                    return conn;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            String url = "jdbc:oracle:thin:@192.168.40.48:1521:oraprd";
            //String url = "jdbc:oracle:thin:@192.168.0.252:1521:orajmm";
            String usuario = "BLUECOM_TESTE2";
            String senha = "BLUECOMTESTE2";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = null;
            con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("conectou");
            conn = con;
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
