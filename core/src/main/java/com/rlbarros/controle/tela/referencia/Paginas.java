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

    /***
     * index.xml
     */
    INDEX("index.xml"),
    /***
     * tarefa/incluir.xml
     */
    INCLUIR("tarefa/incluir.xml");
    
    private String arquivo;

    public String arquivo() {
        return arquivo;
    }

    private Paginas(String arquivo) {
        this.arquivo = arquivo;
    }

}
