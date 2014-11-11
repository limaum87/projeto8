/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author felipe
 */
public class OrdemCompra {
    Long id_ordemcompra;
    Date data_compra;
    Long id_fornecedor;
    String valor_total;
    String valor_frete;
    String nome_fornecedor;
    String nome_grupo;
    
    public Long getId_ordemcompra() {
        return id_ordemcompra;
    }

    public void setId_ordemcompra(Long id_ordemcompra) {
        this.id_ordemcompra = id_ordemcompra;
    }

    public Date getData_compra() {
        return data_compra;
    }

    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
    }

    public Long getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(Long id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public String getValor_total() {
        return valor_total;
    }

    public void setValor_total(String valor_total) {
        this.valor_total = valor_total;
    }

    public String getNome_fornecedor() {
        return nome_fornecedor;
    }

    public void setNome_fornecedor(String nome_fornecedor) {
        this.nome_fornecedor = nome_fornecedor;
    }

    public String getValor_frete() {
        return valor_frete;
    }

    public void setValor_frete(String valor_frete) {
        this.valor_frete = valor_frete;
    }

    public String getNome_grupo() {
        return nome_grupo;
    }

    public void setNome_grupo(String nome_grupo) {
        this.nome_grupo = nome_grupo;
    }
    
    
    
}
