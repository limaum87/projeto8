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
import modelo.Servico;

/**
 *
 * @author felipe
 */
public class ServicoDAO {
    private Connection connection;
    ResultSet resultado;
    Dialogos d = new Dialogos();
    
    public ServicoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adicionaServico (Servico servico){
        String sql = "INSERT INTO servico(nome_servico,status_servico) VALUES(?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, servico.getNome_servico());
            stmt.setLong(2, servico.getStatus_servico());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1, u);
        }
    }
    public ResultSet MostraServicos(){
        try { 
               Statement stmt = connection.createStatement();
               String sql = "select nome_servico from servico where status_servico= '1'";
               resultado = stmt.executeQuery(sql);
               connection.close();
           } catch (Exception u) {    
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar grupo: "+u);      
           }        return resultado;           
       }  
    public void removeServico (Servico servico){
        String sql = "UPDATE servico set (status_servico) = ('2') where nome_servico = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, servico.getNome_servico());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1, u);
        }
    }
}
