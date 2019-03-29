/**
 * @author Rafael.Barros
 * @date 28 de mar de 2019
 */
package com.rlbarros.controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.rlbarros.modelo.entidade.Tarefa;

/**
 * 28 de mar de 2019
 *
 */
@ViewScoped
@ManagedBean
public class TarefaBean {
    
    private Tarefa tarefa = new Tarefa();

    public String apresentaMensagem() {
        
        String msg = "Parabéns a tarefa "+tarefa.getDescricao()+" Foi concluida com sucesso!";
        
        System.out.println(msg);
        
        return msg;
    }
    
    
    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }


}
