/**
 * @author Rafael.Barros
 * @date 28 de mar de 2019
 */
package com.rlbarros.controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import com.rlbarros.controle.tela.referencia.Paginas;
import com.rlbarros.modelo.entidade.Tarefa;
import com.rlbarros.modelo.enums.RecorrenciaEnum;

/**
 * 28 de mar de 2019
 *
 */
@ViewScoped
@ManagedBean
public class TarefaBean {
    
    private Tarefa tarefa = new Tarefa();
    private List<Tarefa> tarefas = new ArrayList<>();
    public Paginas pagina;
    
    
    public TarefaBean() {
        tarefas = listarTarefas();
    }

    public String apresentaMensagem() {
        
        String msg = "Parabéns a tarefa "+tarefa.getDescricao()+" Foi concluida com sucesso!";
        
        System.out.println(msg);
        
        return msg;
    }
    
    public List<Tarefa> listarTarefas(){
        Tarefa t1 = new Tarefa();
        Tarefa t2 = new Tarefa();
        Tarefa t3 = new Tarefa();
        
        t1.setId(1L);
        t1.setConcluido(true);
        t1.setDataLimiteTarefa(new Date());
        t1.setDescricao("Desc");
        t1.setMesmoValorRecorrente(false);
        t1.setRecorrencia(RecorrenciaEnum.MENSAL);
        t1.setValorAtividade(null);
        
        t2.setId(2L);
        t2.setConcluido(true);
        t2.setDataLimiteTarefa(new Date());
        t2.setDescricao("Desc 2");
        t2.setMesmoValorRecorrente(false);
        t2.setRecorrencia(RecorrenciaEnum.ANUAL);
        t2.setValorAtividade(null);
        
        t3.setId(3L);
        t3.setConcluido(true);
        t3.setDataLimiteTarefa(new Date());
        t3.setDescricao("Desc 3");
        t3.setMesmoValorRecorrente(false);
        t3.setRecorrencia(RecorrenciaEnum.SEMANAL);
        t3.setValorAtividade(null);
        
        List<Tarefa> tasks =  new ArrayList<>();
        tasks.add(t1);
        tasks.add(t2);
        tasks.add(t3);
        
        return tasks;
    }
    
    public String adicionarTarefa() {
//        List<Tarefa> tarefas = listarTarefas();
//        tarefas.add(t);
        return Paginas.INCLUIR.descricao();
    }
    
    public void habilitarEdicaoTarefa(Tarefa t) {
        
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == t.getId()) {
                tarefa.setEditar(true);
            }
        }
        refresh();
//        return tarefas;
    }

    public void editarTarefa(Tarefa t) {
        
        List<Tarefa> tarefas = listarTarefas();
        tarefas.forEach(item -> item = editarTarefaCalBack(item, t) );
        refresh();
//        return tarefas;
    }
    
    public List<Tarefa> removerTarefa(Tarefa t) {
        
        List<Tarefa> tarefas = listarTarefas();
        
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == t.getId()) {
                tarefas.remove(t);
            }
            refresh();
        }

        return tarefas;
    }

    /**
     * @param item
     * @return
     */
    private Tarefa editarTarefaCalBack(Tarefa itemAntigo, Tarefa itemEditado) {
        if (itemAntigo.getId() == itemEditado.getId()) {
            return itemEditado;
            
        }
        return itemAntigo;
    }

    
    public void refresh() {

        FacesContext context = FacesContext.getCurrentInstance();

        Application application = context.getApplication();

        ViewHandler viewHandler = application.getViewHandler();

        UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());

        context.setViewRoot(viewRoot);

        context.renderResponse();

        }
    
    
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


}
