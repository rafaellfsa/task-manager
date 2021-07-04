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
     * ?faces-redirect=true
     */
    REDIRECT_TRUE("?faces-redirect=true"),
    /***
     * index.xml
     */
    INDEX("index.xml"),
    /***
     * tarefa/incluir.xml
     */
    INCLUIR("tarefa/incluir.xml");
    
    private String arquivo;

    private Paginas(String arquivo) {
        this.arquivo = arquivo;
    }
    
    public String arquivo() {
        return arquivo;
    }
    
    public String redirect() {
        return arquivo.concat(REDIRECT_TRUE.arquivo);
    }


}
