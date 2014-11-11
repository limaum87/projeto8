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
import java.sql.Statement;
import modelo.NfOperacao;

/**
 *
 * @author felipe
 */
public class NfOperacaoDAO {
    private Connection connection;
    ResultSet resultado;
    Dialogos d = new Dialogos();
    
    public NfOperacaoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
   public ResultSet ConsultaOperacao(NfOperacao no){
       String sql = "SELECT nf_operacao.nome_operacao, nf_operacao.cfop  FROM  public.nf_operacao WHERE  nf_operacao.id_operacao = ?";
       try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, no.getId_operacao());
            stmt.execute();
            resultado = stmt.executeQuery();  
            connection.close();     
           } catch (Exception erro) {    
               d.MensagemErro(1,erro);
               System.out.println(" Erro ao consultar itens: "+erro);      
           }        return resultado;  
    } 
}
