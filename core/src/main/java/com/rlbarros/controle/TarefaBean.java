/**
 * @author Rafael.Barros
 * @date 28 de mar de 2019
 */
package com.rlbarros.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.rlbarros.controle.tela.referencia.Paginas;
import com.rlbarros.modelo.dao.impl.TarefaDaoImpl;
import com.rlbarros.modelo.entidade.Tarefa;
import com.rlbarros.modelo.enums.RecorrenciaEnum;

/**
 * 28 de mar de 2019
 *
 */
@ViewScoped
@ManagedBean
public class TarefaBean {

    private Tarefa tarefa;
    private List<Tarefa> tarefas = new ArrayList<>();
    public Paginas pagina;
    public RecorrenciaEnum recorrenciaSelecionada;
    
    TarefaDaoImpl tarefaDao;
    
    public TarefaBean() {
        tarefas = listarTarefas();
        tarefa = new Tarefa();
        tarefaDao = new TarefaDaoImpl();
    }

    public String apresentaMensagem() {

        String msg = "Parabéns a tarefa " + tarefa.getDescricao() + " Foi concluida com sucesso!";

        System.out.println(msg);

        return msg;
    }

    public List<Tarefa> listarTarefas() {
        
        try {
            return tarefaDao.obterTarefas();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
        //        Tarefa t1 = new Tarefa();
//        Tarefa t2 = new Tarefa();
//        Tarefa t3 = new Tarefa();
//
//        t1.setId(1L);
//        t1.setConcluido(true);
//        t1.setDataLimiteTarefa(new Date());
//        t1.setDescricao("Desc");
//        t1.setMesmoValorRecorrente(false);
//        t1.setRecorrencia(RecorrenciaEnum.MENSAL);
//        t1.setValorAtividade(null);
//
//        t2.setId(2L);
//        t2.setConcluido(true);
//        t2.setDataLimiteTarefa(new Date());
//        t2.setDescricao("Desc 2");
//        t2.setMesmoValorRecorrente(false);
//        t2.setRecorrencia(RecorrenciaEnum.ANUAL);
//        t2.setValorAtividade(null);
//
//        t3.setId(3L);
//        t3.setConcluido(true);
//        t3.setDataLimiteTarefa(new Date());
//        t3.setDescricao("Desc 3");
//        t3.setMesmoValorRecorrente(false);
//        t3.setRecorrencia(RecorrenciaEnum.SEMANAL);
//        t3.setValorAtividade(null);
//
//        List<Tarefa> tasks = new ArrayList<>();
//        tasks.add(t1);
//        tasks.add(t2);
//        tasks.add(t3);

//        return tasks;
    }

    public String adicionarTarefa() {
        return Paginas.INCLUIR.arquivo();
    }

    public void habilitarEdicaoTarefa(Tarefa tarefa) {

        for (Tarefa t : tarefas) {
            if (t.getId() == tarefa.getId()) {
                t.setEditar(true);
            }
        }
    }

    public void editarTarefa(Tarefa tarefa) throws ClassNotFoundException, SQLException {

        tarefaDao.editarTarefa(tarefa);
        tarefa.setEditar(false);  
//        List<Tarefa> tarefas = new ArrayList<>();
//        this.tarefas.forEach(item -> tarefas.add(editarTarefaCalBack(item, tarefa)));
//        this.tarefas.clear();
//        this.tarefas = tarefas;
    }

    public void removerTarefa(Tarefa t) {

        try {
            tarefaDao.excluirTarefaById(t.getId());
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void salvarNovaTarefa() {
        try {
            tarefaDao.salvarTarefa(tarefa);
            tarefas.add(tarefa);
            irPagina(Paginas.INDEX.arquivo());
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 
     */
    private void irPagina(String pagina) {
        try {
            
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

            if (pagina == null || pagina.equals(Paginas.INDEX.arquivo())) {
                externalContext.redirect(externalContext.getRequestContextPath());
            }else {
                externalContext.redirect(externalContext.getRequestContextPath().concat("/"+pagina));
            }
        
        } catch (IOException e) {
              e.printStackTrace();
        }
    }
    
    public List<RecorrenciaEnum> getObterRecorrenciasTarefa(){

        List<RecorrenciaEnum> retorno = new ArrayList<>();
        
        for (RecorrenciaEnum r : RecorrenciaEnum.values()) {
            retorno.add(r);
        }
        return retorno;
    }

    /**
     * @param item
     * @return
     */
//    private Tarefa editarTarefaCalBack(Tarefa itemAntigo, Tarefa itemEditado) {
//        if (itemAntigo.getId() == itemEditado.getId()) {
//            itemEditado.setEditar(false);
//            return itemEditado;
//        }
//        return itemAntigo;
//    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public RecorrenciaEnum getRecorrenciaSelecionada() {
        return recorrenciaSelecionada;
    }

    public void setRecorrenciaSelecionada(RecorrenciaEnum recorrenciaSelecionada) {
        this.recorrenciaSelecionada = recorrenciaSelecionada;
    }

}
