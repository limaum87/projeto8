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
public class Chamado {
    Long id_ocorrencia;
    Long id_status;
    Long id_empresa;
    Long id_area;
    Long id_usuario;
    String ocorrencia;
    Date data_abertura;
    Date data_fechamento;
    Long id_nome;
    String nome_usuario;
    String nome_empresa;
    String nome_area;
    String nome_status;
    String ocorrencia_string;
    String solucao;
    Long id_tipo;
    String nome_tipo;
    Float valor;
    Long id_fechamento;
    String valor_total;
    String valor_deslocamento;
    String valor_equipamentos;
    String lucro_equipamentos;
    String mes;
    String ano;
    Boolean pago;
    
    public Long getId_ocorrencia() {
        return id_ocorrencia;
    }

    public void setId_ocorrencia(Long id_ocorrencia) {
        this.id_ocorrencia = id_ocorrencia;
    }

    public Long getId_status() {
        return id_status;
    }

    public void setId_status(Long id_status) {
        this.id_status = id_status;
    }

    public Long getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(Long id_empresa) {
        this.id_empresa = id_empresa;
    }

    public Long getId_area() {
        return id_area;
    }

    public void setId_area(Long id_area) {
        this.id_area = id_area;
    }

    public String getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(String ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public Date getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(Date data_abertura) {
        this.data_abertura = data_abertura;
    }

    public Date getData_fechamento() {
        return data_fechamento;
    }

    public void setData_fechamento(Date data_fechamento) {
        this.data_fechamento = data_fechamento;
    }

    public Long getId_nome() {
        return id_nome;
    }

    public void setId_nome(Long id_nome) {
        this.id_nome = id_nome;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getNome_area() {
        return nome_area;
    }

    public void setNome_area(String nome_area) {
        this.nome_area = nome_area;
    }

    public String getNome_status() {
        return nome_status;
    }

    public void setNome_status(String nome_status) {
        this.nome_status = nome_status;
    }

    public String getOcorrencia_string() {
        return ocorrencia_string;
    }

    public void setOcorrencia_string(String ocorrencia_string) {
        this.ocorrencia_string = ocorrencia_string;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Long id_tipo) {
        this.id_tipo = id_tipo;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getNome_tipo() {
        return nome_tipo;
    }

    public void setNome_tipo(String nome_tipo) {
        this.nome_tipo = nome_tipo;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public Long getId_fechamento() {
        return id_fechamento;
    }

    public void setId_fechamento(Long id_fechamento) {
        this.id_fechamento = id_fechamento;
    }

    public String getValor_total() {
        return valor_total;
    }

    public void setValor_total(String valor_total) {
        this.valor_total = valor_total;
    }

    public String getValor_deslocamento() {
        return valor_deslocamento;
    }

    public void setValor_deslocamento(String valor_deslocamento) {
        this.valor_deslocamento = valor_deslocamento;
    }

    public String getValor_equipamentos() {
        return valor_equipamentos;
    }

    public void setValor_equipamentos(String valor_equipamentos) {
        this.valor_equipamentos = valor_equipamentos;
    }

    public String getLucro_equipamentos() {
        return lucro_equipamentos;
    }

    public void setLucro_equipamentos(String lucro_equipamentos) {
        this.lucro_equipamentos = lucro_equipamentos;
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

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    
    
    
}
