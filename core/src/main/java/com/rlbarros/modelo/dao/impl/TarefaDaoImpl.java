/**
 * @author Rafael.Barros
 * @date 4 de abr de 2019
 */
package com.rlbarros.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rlbarros.modelo.dao.MapaConsultas;
import com.rlbarros.modelo.dao.fabrica.ConnectionFactory;
import com.rlbarros.modelo.entidade.Tarefa;


/**
 * 4 de abr de 2019
 *
 */
public class TarefaDaoImpl {
    
    /**
     * ARQUIVO_QUERIES
     */
    protected static final String ARQUIVO_QUERIES = "tm.queries.yaml";
    
    /**
     * 
     */
    protected final MapaConsultas consultas = new MapaConsultas(ARQUIVO_QUERIES);
    
    
    public void salvarTarefa(Tarefa task) throws SQLException, ClassNotFoundException {

        String sql = this.consultas.getConsulta("CREATE_TAREFA");
        
        try (Connection connection = ConnectionFactory.getInstance().getConnection()){
            
            PreparedStatement ps = connection.prepareStatement(sql);
            int i = 1;
            ps.setDate(i++, new java.sql.Date(task.getDataLimiteTarefa().getTime()));
            ps.setString(i++, task.getDescricao());
            ps.setInt(i++, convertBolleantoInt(task.getMesmoValorRecorrente()));
            ps.setInt(i++, task.getRecorrencia().getCodigo());
            ps.setDouble(i++, task.getValorAtividade());
            ps.executeUpdate();
            
        } catch (SQLException | ReflectiveOperationException e) {
            throw e;
        }
    }

    public void editarTarefa(Tarefa task) throws SQLException, ClassNotFoundException {
        
        String sql = this.consultas.getConsulta("UPDATE_TAREFA");
        
        try (Connection connection = ConnectionFactory.getInstance().getConnection()){
            
            PreparedStatement ps = connection.prepareStatement(sql);
            int i = 1;
            ps.setLong(i++, task.getId());
            ps.setDate(i++, new java.sql.Date(task.getDataLimiteTarefa().getTime()));
            ps.setString(i++, task.getDescricao());
            ps.setInt(i++, convertBolleantoInt(task.getMesmoValorRecorrente()));
            ps.setString(i++, task.getRecorrencia().getDescricao());
            ps.setDouble(i++, task.getValorAtividade());
            ps.executeUpdate();
            
        } catch (SQLException | ReflectiveOperationException e) {
            throw e;
        }
    }
    
    /**
     * @param bol
     * @return
     */
    private int convertBolleantoInt(Boolean bol) {
        if (bol == null) {
            return 0;
        }
        if (bol == true) {
            return 1;
        }else {
            return 0;
        }
        // TODO Auto-generated method stub
    }

}
