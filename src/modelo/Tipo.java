/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author felipe
 */
public class Tipo {
    Long id_tipo;
    String nome_tipo;
    Float valor_hora;
    Boolean deslocamento;

    public Long getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Long id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNome_tipo() {
        return nome_tipo;
    }

    public void setNome_tipo(String nome_tipo) {
        this.nome_tipo = nome_tipo;
    }

    public Float getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(Float valor_hora) {
        this.valor_hora = valor_hora;
    }

    public Boolean getDeslocamento() {
        return deslocamento;
    }

    public void setDeslocamento(Boolean deslocamento) {
        this.deslocamento = deslocamento;
    }
    
           
}
