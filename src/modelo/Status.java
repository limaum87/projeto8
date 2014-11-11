/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author felipe
 */
public class Status {
    Long id_status;
    String nome_status;
    Boolean visibilidade;

    public Boolean getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(Boolean visibilidade) {
        this.visibilidade = visibilidade;
    }

    public Long getId_status() {
        return id_status;
    }

    public void setId_status(Long id_status) {
        this.id_status = id_status;
    }

    public String getNome_status() {
        return nome_status;
    }

    public void setNome_status(String nome_status) {
        this.nome_status = nome_status;
    }


    
    
}
