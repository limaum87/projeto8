/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author felipe
 */
public class NotaFiscal {
    Long id_nota;
    Long id_empresa;
    Long id_cfop;
    String nome_fechamento;
    String nome_empresa;
    String data_emissao;
    String data_saida;
    String hora_saida;
    String valor_nota;
    String valor_servicos;
    String valor_produtos;
    Long id_venda;

    public Long getId_nota() {
        return id_nota;
    }

    public void setId_nota(Long id_nota) {
        this.id_nota = id_nota;
    }

    public Long getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(Long id_empresa) {
        this.id_empresa = id_empresa;
    }

    public Long getId_cfop() {
        return id_cfop;
    }

    public void setId_cfop(Long id_cfop) {
        this.id_cfop = id_cfop;
    }

    public String getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(String data_emissao) {
        this.data_emissao = data_emissao;
    }

    public String getData_saida() {
        return data_saida;
    }

    public void setData_saida(String data_saida) {
        this.data_saida = data_saida;
    }

    public String getHora_saida() {
        return hora_saida;
    }

    public void setHora_saida(String hora_saida) {
        this.hora_saida = hora_saida;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getValor_nota() {
        return valor_nota;
    }

    public void setValor_nota(String valor_nota) {
        this.valor_nota = valor_nota;
    }

    public String getNome_fechamento() {
        return nome_fechamento;
    }

    public void setNome_fechamento(String id_fechamento) {
        this.nome_fechamento = id_fechamento;
    }

    public Long getId_venda() {
        return id_venda;
    }

    public void setId_venda(Long id_venda) {
        this.id_venda = id_venda;
    }

    public String getValor_servicos() {
        return valor_servicos;
    }

    public void setValor_servicos(String valor_servicos) {
        this.valor_servicos = valor_servicos;
    }

    public String getValor_produtos() {
        return valor_produtos;
    }

    public void setValor_produtos(String valor_produtos) {
        this.valor_produtos = valor_produtos;
    }
    
    
    
   
            
}
