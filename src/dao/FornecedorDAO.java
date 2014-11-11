/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import gui.componentes.Dialogos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Fornecedor;

/**
 *
 * @author felipe
 */
public class FornecedorDAO {
    private Connection connection;
    Long id_empresa;
    String nome_empresa;
    String razaosocial;
    Long cnpj;
    Long inscricao_estadual;
    String rua;
    String numero;
    Long complemento;
    String bairro;
    String cidade;
    String estado;
    String email;
    Long telefone;
    ResultSet resultado;
    Dialogos d = new Dialogos();
   
    public FornecedorDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public void adiciona(Fornecedor fornecedor){
        String sql = "INSERT INTO fornecedores(nome_fornecedor,razaosocial,cnpj,inscricaoestadual,rua,numero,complemento,bairro,cidade,email,telefone,cep,contato,estado) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, fornecedor.getNome_fornecedor());
            stmt.setString(2, fornecedor.getRazaosocial());
            stmt.setString(3, fornecedor.getCnpj());
            stmt.setString(4, fornecedor.getInscricao_estadual());
            stmt.setString(5, fornecedor.getRua());
            stmt.setString(6, fornecedor.getNumero());
            stmt.setString(7, fornecedor.getComplemento());
            stmt.setString(8, fornecedor.getBairro());
            stmt.setString(9, fornecedor.getCidade());
            stmt.setString(10, fornecedor.getEmail());
            stmt.setString(11, fornecedor.getTelefone());
            stmt.setString(12, fornecedor.getCep());
            stmt.setString(13, fornecedor.getContato());
            stmt.setString(14, fornecedor.getEstado());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
    }
    public ResultSet ConsultarFornecedor(){
        try { 
            Statement stmt = connection.createStatement();
            String sql = "select nome_fornecedor from fornecedores ";
            resultado = stmt.executeQuery(sql);  
            connection.close();
        } catch (Exception u) {  
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar empresa: "+u);      
           }        
        return resultado;          
       }  
    public ResultSet RetornaDados(Fornecedor fornecedor){
               String sql = "select * from fornecedores where nome_fornecedor = ? ";
           try { 
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, fornecedor.getNome_fornecedor());           
                
                stmt.execute();
               resultado = stmt.executeQuery();   
               connection.close();
               
           } catch (Exception u) {    
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar dados da empresa: "+u);      
           }        return resultado;          
       }
    public void altera(Fornecedor f){
           String sql = "UPDATE fornecedores set (nome_fornecedor,razaosocial,cnpj,inscricaoestadual,rua,numero,complemento,bairro,cidade,cep,estado,contato,email, telefone) = (?,?,?,?,?,?,?,?,?,?,?,?,?,?) where id_fornecedor = ? ";
           try {
               PreparedStatement stmt = connection.prepareStatement(sql);
               stmt.setString(1, f.getNome_fornecedor());
               stmt.setString(2, f.getRazaosocial());
               stmt.setString(3, f.getCnpj());
               stmt.setString(4, f.getInscricao_estadual());
               stmt.setString(5, f.getRua());
               stmt.setString(6, f.getNumero());
               stmt.setString(7, f.getComplemento());
               stmt.setString(8, f.getBairro());
               stmt.setString(9, f.getCidade());
               stmt.setString(10, f.getCep());
               stmt.setString(11, f.getEstado());
               stmt.setString(12, f.getContato());
               stmt.setString(13, f.getEmail());
               stmt.setString(14, f.getTelefone());
               stmt.setLong(15, f.getId_fornecedor());
               stmt.execute();
               stmt.close();
           } catch (SQLException u) {
               d.MensagemErro(1,u);
               throw new RuntimeException(u);
           }
           }

    public ResultSet ListaFornecedores() {
         try { 
            Statement stmt = connection.createStatement();
            String sql = "select nome_fornecedor from fornecedores ";
            resultado = stmt.executeQuery(sql);  
            connection.close();
               
           } catch (Exception u) {    
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar dados da empresa: "+u);      
           }        return resultado;          
       }
    
        
}
