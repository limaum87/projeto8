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
public class Parcela {
    String valor;
    Date data_vencimento;
    Long id_notafiscal;
    String dt_venc;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Date getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(Date data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public Long getId_notafiscal() {
        return id_notafiscal;
    }

    public void setId_notafiscal(Long id_notafiscal) {
        this.id_notafiscal = id_notafiscal;
    }

    public String getDt_venc() {
        return dt_venc;
    }

    public void setDt_venc(String dt_venc) {
        this.dt_venc = dt_venc;
    }
    
    
}
