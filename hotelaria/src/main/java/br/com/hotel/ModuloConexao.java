package br.com.hotel;

import  java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModuloConexao {

    Connection conexao = null;
       static String driver = "com.mysql.cj.jdbc.Driver";
       static String url = "jdbc:mysql://localhost:3306/hotel";
       static String user = "root";
       static String senha = "235813";

    public static Connection conector(){
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url,user,senha);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na coneção",ex);
        }

       
    }

    public static void closeConector(Connection conexao){
        try {
            if(conexao!=null){
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModuloConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public static void closeConector(Connection conexao, PreparedStatement stmt){
       
        closeConector(conexao);
        try {
            if(stmt!=null){
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModuloConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConector(Connection conexao, PreparedStatement stmt,ResultSet rs){
       
        closeConector(conexao,stmt);
        try {
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModuloConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}