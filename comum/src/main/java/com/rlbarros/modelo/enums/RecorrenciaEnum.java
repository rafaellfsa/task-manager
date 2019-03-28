/**
 * @author Rafael.Barros
 * @date 25 de mar de 2019
 */
package com.rlbarros.modelo.enums;

/**
 * 25 de mar de 2019
 *
 */
public enum RecorrenciaEnum {
    
    DIARIO(1,"recorrência diária"),
    SEMANAL(2,"recorrência semanal"),
    MENSAL(3,"recorrência  mensal"),
    BIMESTRAL(4,"recorrência bimestral"),
    TRIMESTRAL(5,"recorrência trimestral"),
    SEMESTRAL(6,"recorrência semestral"),
    ANUAL(7,"recorrência anual");
    
    private Integer codigo;
    private String descricao;
    
    private RecorrenciaEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public static RecorrenciaEnum getByCodigo(Integer codigo) {
        
        for (RecorrenciaEnum objeto : RecorrenciaEnum.values() ) {
            
            if (objeto.getCodigo().equals(codigo)) {
                return objeto;
            }
        }
        return null;
    }
    
    
    
    
}
