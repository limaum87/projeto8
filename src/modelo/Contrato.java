/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author felipe
 */
public class Contrato {
    
    String nome_empresa;
    Integer id_empresa;
    String horas_contratadas;
    String horas_restantes;
    String valor_contrato;
    

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public Integer getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(Integer id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getHoras_contratadas() {
        return horas_contratadas;
    }

    public void setHoras_contratadas(String horas_contratadas) {
        this.horas_contratadas = horas_contratadas;
    }

    public String getHoras_restantes() {
        return horas_restantes;
    }

    public void setHoras_restantes(String horas_restantes) {
        this.horas_restantes = horas_restantes;
    }

    public String getValor_contrato() {
        return valor_contrato;
    }

    public void setValor_contrato(String valor_contrato) {
        this.valor_contrato = valor_contrato;
    }
    
    
            
}
