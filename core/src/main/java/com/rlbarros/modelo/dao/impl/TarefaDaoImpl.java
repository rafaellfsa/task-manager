/**
 * @author Rafael.Barros
 * @date 4 de abr de 2019
 */
package com.rlbarros.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public void excluirTarefaById(Long id) throws SQLException, ClassNotFoundException {
        if (id == null) {
            throw new SQLException("Erro ao excluir tarefa, Parametro id tarefa nulo.");
        }
        
        Tarefa t = new Tarefa();
        t.setId(id);
        excluirTarefa(t);
    }

    public void excluirTarefa(Tarefa task) throws SQLException, ClassNotFoundException {
        
        String sql = this.consultas.getConsulta("DELETE_TAREFA");
        
        try (Connection connection = ConnectionFactory.getInstance().getConnection()){
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, task.getId());
            ps.executeUpdate();
            
        } catch (SQLException | ReflectiveOperationException e) {
            throw e;
        }
    }
    
    public Tarefa obterTarefa(Tarefa task) throws SQLException, ClassNotFoundException {
        
        String sql = this.consultas.getConsulta("SELECT_TAREFA_BY_ID");
        
        try (Connection connection = ConnectionFactory.getInstance().getConnection()){
            
            PreparedStatement ps = connection.prepareStatement(sql);
            int i = 1;
            ps.setLong(i++, task.getId());
            ResultSet rs = ps.executeQuery();
            
            
            List<Tarefa> tarefas = new ArrayList<>();
            
            if (rs.getFetchSize() != 1) {
                throw new SQLException(" A consulta obteve retorno diferente do esperado, entre em contato com o administrador. ");
            }
            
            while (rs.next()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setId(rs.getLong("ID"));
                rs.getInt("BOLCONCLUIDO");
                rs.getDate("DATALIMITETAREFA");
                rs.getDouble("VALORATIVIDADE");
                rs.getInt("RECORRENCIA");
                rs.getInt("BOLMESMOVALORRECORRENTE");
                tarefas.add(tarefa);
            }
            
            return tarefas.iterator().next();
            
        } catch (SQLException | ReflectiveOperationException e) {
            throw e;
        }
    }

    public Tarefa obterTarefaPorId(Long id) throws SQLException, ClassNotFoundException {
        if (id == null) {
            throw new SQLException("Parametro consulta de tarefa nulo.");
        }
        Tarefa t = new Tarefa();
        t.setId(id);        
        return obterTarefa(t);
    }

    public List<Tarefa> obterTarefas() throws SQLException, ClassNotFoundException {
        
        String sql = this.consultas.getConsulta("SELECT_LISTA_TAREFA");
        
        try (Connection connection = ConnectionFactory.getInstance().getConnection()){
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            List<Tarefa> tarefas = new ArrayList<>();
            
            while (rs.next()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setId(rs.getLong("ID"));
                rs.getInt("BOLCONCLUIDO");
                rs.getDate("DATALIMITETAREFA");
                rs.getDouble("VALORATIVIDADE");
                rs.getInt("RECORRENCIA");
                rs.getInt("BOLMESMOVALORRECORRENTE");
                tarefas.add(tarefa);
            }
            
            return tarefas;
            
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
