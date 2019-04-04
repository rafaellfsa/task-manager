/**
 * @author Rafael.Barros
 * @date 4 de abr de 2019
 */
package com.rlbarros.controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rlbarros.modelo.dao.fabrica.ConnectionFactory;

/**
 * 4 de abr de 2019
 *
 */
public class JDBCExemplo {

    /**
     * @param args
     * @throws ClassNotFoundException 
     */
    public static void main(String[] args) throws ClassNotFoundException {
        Connection conexao = null;;
        try {
            
            conexao = ConnectionFactory.getInstance().getConnection();
            conexao.createStatement().executeQuery("CREATE TABLE table_name ( column1 int );");
            conexao.commit();

            conexao = ConnectionFactory.getInstance().getConnection();
            conexao.createStatement().executeUpdate("insert into table_name ( column1 ) values (3) ;");
            conexao.commit();
            
            conexao = ConnectionFactory.getInstance().getConnection();
            ResultSet resultSet = conexao.createStatement().executeQuery("select column1  from table_name;");
            while (resultSet.next()) {
                System.out.println("resultado: "+resultSet.getInt("column1"));
            }

            conexao.commit();
            
            System.out.println("Conectado!");
            conexao.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            System.out.println("Desconectado!");
        }

    }

}
