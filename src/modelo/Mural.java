/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author felipe
 */
public class Mural {
    Long id_mural;
    Long id_usuario;
    String descricao;

    public Long getId_mural() {
        return id_mural;
    }

    public void setId_mural(Long id_mural) {
        this.id_mural = id_mural;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
