/**
 * @author Rafael.Barros
 * @date 1 de abr de 2019
 */
package com.rlbarros.controle.tela.referencia;

/**
 * 1 de abr de 2019
 *
 */
public enum Paginas {

    INDEX("index.xml"),
    INCLUIR("tarefa/incluir.xml");
    
    private String descricao;

    public String descricao() {
        return descricao;
    }

    private Paginas(String desc) {
        this.descricao = desc;
    }

}
