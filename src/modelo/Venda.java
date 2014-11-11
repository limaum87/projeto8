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
public class Venda {
    Long id_venda;
    Long id_empresa;
    Long id_status;
    Long id_fechamento;
    String data_venda;
    String valor_total;
    String nome_empresa;
    String lucro_total;
    

    public Long getId_venda() {
        return id_venda;
    }

    public void setId_venda(Long id_venda) {
        this.id_venda = id_venda;
    }

    public Long getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(Long id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getData_venda() {
        return data_venda;
    }

    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    public String getValor_total() {
        return valor_total;
    }

    public void setValor_total(String valor_total) {
        this.valor_total = valor_total;
    }

    public Long getId_status() {
        return id_status;
    }

    public void setId_status(Long id_status) {
        this.id_status = id_status;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getLucro_total() {
        return lucro_total;
    }

    public void setLucro_total(String lucro_total) {
        this.lucro_total = lucro_total;
    }

    public Long getId_fechamento() {
        return id_fechamento;
    }

    public void setId_fechamento(Long id_fechamento) {
        this.id_fechamento = id_fechamento;
    }
    
    
            
}
