/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import externo.Money;

/**
 *
 * @author felipel
 */
public class Fechamento {
    Long id_fechamento;
    String nome_fechamento;
    String valor_servicos;
    String valor_deslocamento;
    String valor_venda_bruto;
    String valor_venda_liquido;
    String valor_mensalidades;
    String valor_total_servicos;
    String valor_total_liquido;
    String valor_total_bruto;
    String valor_ov_liquido;
    String valor_ov_bruto;
    String nome_empresa;
    Long status_fechamento;
    Integer mes_referencia;
    Dinheiro  vlr_total;
    Long tipo_fechamento;
    String parcelas;

    public Long getId_fechamento() {
        return id_fechamento;
    }

    public void setId_fechamento(Long id_fechamento) {
        this.id_fechamento = id_fechamento;
    }

    public String getNome_fechamento() {
        return nome_fechamento;
    }

    public void setNome_fechamento(String nome_fechamento) {
        this.nome_fechamento = nome_fechamento;
    }

    public String getValor_servicos() {
        return valor_servicos;
    }

    public void setValor_servicos(String valor_servicos) {
        this.valor_servicos = valor_servicos;
    }

    public String getValor_deslocamento() {
        return valor_deslocamento;
    }

    public void setValor_deslocamento(String valor_deslocamento) {
        this.valor_deslocamento = valor_deslocamento;
    }

    public String getValor_venda_bruto() {
        return valor_venda_bruto;
    }

    public void setValor_venda_bruto(String valor_venda_bruto) {
        this.valor_venda_bruto = valor_venda_bruto;
    }

    public String getValor_venda_liquido() {
        return valor_venda_liquido;
    }

    public void setValor_venda_liquido(String valor_venda_liquido) {
        this.valor_venda_liquido = valor_venda_liquido;
    }

    public String getValor_mensalidades() {
        return valor_mensalidades;
    }

    public void setValor_mensalidades(String valor_mensalidades) {
        this.valor_mensalidades = valor_mensalidades;
    }

    public String getValor_total_servicos() {
        return valor_total_servicos;
    }

    public void setValor_total_servicos(String valor_total_servicos) {
        this.valor_total_servicos = valor_total_servicos;
    }

    public String getValor_total_liquido() {
        return valor_total_liquido;
    }

    public void setValor_total_liquido(String valor_total_liquido) {
        this.valor_total_liquido = valor_total_liquido;
    }

    public String getValor_total_bruto() {
        return valor_total_bruto;
    }

    public void setValor_total_bruto(String valor_total_bruto) {
        this.valor_total_bruto = valor_total_bruto;
    }

    public Long getStatus_fechamento() {
        return status_fechamento;
    }

    public void setStatus_fechamento(Long status_fechamento) {
        this.status_fechamento = status_fechamento;
    }

    public Integer getMes_referencia() {
        return mes_referencia;
    }

    public void setMes_referencia(Integer mes_referencia) {
        this.mes_referencia = mes_referencia;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public Dinheiro getVlr_total() {
        return vlr_total;
    }

    public void setVlr_total(Dinheiro vlr_total) {
        this.vlr_total = vlr_total;
    }

    public Long getTipo_fechamento() {
        return tipo_fechamento;
    }

    public void setTipo_fechamento(Long tipo_fechamento) {
        this.tipo_fechamento = tipo_fechamento;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }

    public String getValor_ov_liquido() {
        return valor_ov_liquido;
    }

    public void setValor_ov_liquido(String valor_ov_liquido) {
        this.valor_ov_liquido = valor_ov_liquido;
    }

    public String getValor_ov_bruto() {
        return valor_ov_bruto;
    }

    public void setValor_ov_bruto(String valor_ov_bruto) {
        this.valor_ov_bruto = valor_ov_bruto;
    }
    
    
    
}
