/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author felipe
 */
public class Mensalidade {
    Long id_mensalidade;
    Long id_empresa;
    Long id_servico;
    String nome_empresa;
    String nome_servico;
    String valor;
    Long mes_cobranca;
    Long status;

    public Long getId_mensalidade() {
        return id_mensalidade;
    }

    public void setId_mensalidade(Long id_mensalidade) {
        this.id_mensalidade = id_mensalidade;
    }

    public Long getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(Long id_empresa) {
        this.id_empresa = id_empresa;
    }

    public Long getId_servico() {
        return id_servico;
    }

    public void setId_servico(Long id_servico) {
        this.id_servico = id_servico;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Long getMes_cobranca() {
        return mes_cobranca;
    }

    public void setMes_cobranca(Long mes_cobranca) {
        this.mes_cobranca = mes_cobranca;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getNome_servico() {
        return nome_servico;
    }

    public void setNome_servico(String nome_servico) {
        this.nome_servico = nome_servico;
    }
    
    
}
