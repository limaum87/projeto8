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
public class PagamentoPF {
    Long id_pagamento;
    Long id_empresa;
    Long id_fechamento;
    String valor;
    Boolean pago;
    String nome_empresa;
    String nome_fechamento;
    Date data_vencimento; 
    String mes;
    String ano;        

    public Long getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(Long id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public Long getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(Long id_empresa) {
        this.id_empresa = id_empresa;
    }

    public Long getId_fechamento() {
        return id_fechamento;
    }

    public void setId_fechamento(Long id_fechamento) {
        this.id_fechamento = id_fechamento;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getNome_fechamento() {
        return nome_fechamento;
    }

    public void setNome_fechamento(String nome_fechamento) {
        this.nome_fechamento = nome_fechamento;
    }

    public Date getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(Date data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    
    
    
}
