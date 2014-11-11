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
import modelo.Tipo;

/**
 *
 * @author felipe
 */
public class TipoDAO {
    private Connection connection;
    Long id_area;
    String nome_area;
    ResultSet resultado;
    Dialogos d = new Dialogos();
    
    public TipoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public void novotipo(Tipo tipo){
        String sql = "INSERT INTO tipo_atendimento(nome_tipo,valor_hr,deslocamento) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, tipo.getNome_tipo());
            stmt.setFloat(2, tipo.getValor_hora());
            stmt.setBoolean(3, tipo.getDeslocamento());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
    }
    public ResultSet ConsultarTipo(){
        try { 
            Statement stmt = connection.createStatement();
            String sql = "select nome_tipo from tipo_atendimento ";
            resultado = stmt.executeQuery(sql); 
            connection.close();
        } catch (Exception u) {  
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar empresa: "+u);  
        }   
        return resultado;          
       }       
    
    
}
