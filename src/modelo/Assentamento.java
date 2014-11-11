/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author felipe
 */
public class Assentamento {
    Long id_assentamento;
    Long id_ocorrencia;
    String assentamento;
    Date data_assentamento;

    public Long getId_assentamento() {
        return id_assentamento;
    }

    public void setId_assentamento(Long id_assentamento) {
        this.id_assentamento = id_assentamento;
    }

    public Long getId_ocorrencia() {
        return id_ocorrencia;
    }

    public void setId_ocorrencia(Long id_ocorrencia) {
        this.id_ocorrencia = id_ocorrencia;
    }

    public String getAssentamento() {
        return assentamento;
    }

    public void setAssentamento(String assentamento) {
        this.assentamento = assentamento;
    }

    public Date getData_assentamento() {
        return data_assentamento;
    }

    public void setData_assentamento(Date data_assentamento) {
        this.data_assentamento = data_assentamento;
    }

    
    
    
    
}
