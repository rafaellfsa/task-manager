/**
 * @author Rafael.Barros
 * @date 21 de mar de 2019
 */
package com.rlbarros.modelo.entidade;

import java.io.Serializable;
import java.util.Date;

import com.rlbarros.modelo.enums.RecorrenciaEnum;

/**
 * 21 de mar de 2019
 *
 */
public class Tarefa implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 524148694891225135L;
    
    private Long id;
    
    private boolean isConcluido;
    
    private String Descricao;
    
    private Date dataLimiteTarefa;
    
    private Double valorAtividade;
    
    private RecorrenciaEnum recorrencia;
    
    private boolean isMesmoValorRecorrente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isConcluido() {
        return isConcluido;
    }

    public void setConcluido(boolean isConcluido) {
        this.isConcluido = isConcluido;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public Date getDataLimiteTarefa() {
        return dataLimiteTarefa;
    }

    public void setDataLimiteTarefa(Date dataLimiteTarefa) {
        this.dataLimiteTarefa = dataLimiteTarefa;
    }

    public Double getValorAtividade() {
        return valorAtividade;
    }

    public void setValorAtividade(Double valorAtividade) {
        this.valorAtividade = valorAtividade;
    }

    public RecorrenciaEnum getRecorrencia() {
        return recorrencia;
    }

    public void setRecorrencia(RecorrenciaEnum recorrencia) {
        this.recorrencia = recorrencia;
    }

    public boolean isMesmoValorRecorrente() {
        return isMesmoValorRecorrente;
    }

    public void setMesmoValorRecorrente(boolean isMesmoValorRecorrente) {
        this.isMesmoValorRecorrente = isMesmoValorRecorrente;
    }

    @Override
    public String toString() {
        return "Tarefa [id=" + id + ", isConcluido=" + isConcluido + ", Descricao=" + Descricao + ", dataLimiteTarefa=" + dataLimiteTarefa + ", valorAtividade=" + valorAtividade
                + ", recorrencia=" + recorrencia + ", isMesmoValorRecorrente=" + isMesmoValorRecorrente + "]";
    }

}
