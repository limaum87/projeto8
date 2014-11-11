/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import gui.componentes.Dialogos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author felipe
 */
public class ConfigDAO {
   
    private Connection connection;
    ResultSet resultado;
    Dialogos d = new Dialogos();
    public ConfigDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public String VersaoBanco(){
        String versao=null;
        
        try { 
               Statement stmt = connection.createStatement();
               String sql = "SELECT config.versao FROM public.config ";
               resultado = stmt.executeQuery(sql);  
               connection.close();
           } catch (Exception u) { 
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar empresa: "+u);      
           }        
        try {  
            while (resultado.next()){  
                versao=(resultado.getString(1));  
            } 
        } catch (SQLException u) {  
            d.MensagemErro(1,u);
            System.out.println(" Erro ao retornar id_venda "); 
        }
        return versao;
    }
}
