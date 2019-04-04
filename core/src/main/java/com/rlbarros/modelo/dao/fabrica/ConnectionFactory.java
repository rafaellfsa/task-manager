/**
 * @author Rafael.Barros
 * @date 4 de abr de 2019
 */
package com.rlbarros.modelo.dao.fabrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 4 de abr de 2019
 *
 */
public final class ConnectionFactory {

    public static ConnectionFactory getInstance(){
        return new ConnectionFactory();
    }
    
    public Connection getConnection() throws ClassNotFoundException {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            return DriverManager.getConnection("jdbc:hsqldb:file:taskManager", "SA", "");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection(Connection conexao) throws SQLException {
        if (!conexao.isClosed()) {
            conexao.close();
        }
    }
}
