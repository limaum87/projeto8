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
import modelo.Mural;

/**
 *
 * @author felipe
 */
public class MuralDAO {
    private  Connection connection;
    Dialogos d = new Dialogos();
    ResultSet resultado;
    
    public MuralDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public ResultSet CarregaMural() {
                try { 
            Statement stmt = connection.createStatement();
            String sql = "SELECT mural.descricao FROM public.mural Where id_mural = '1'";
            resultado = stmt.executeQuery(sql);   
            connection.close();
        } catch (Exception u) {    
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar mural: "+u);      
           }        return resultado; 
    }

    public void EditaMural(Mural m) {
        String sql5 = "UPDATE mural set descricao = ?  where id_mural = '1'";
            try {
                PreparedStatement stmt = connection.prepareStatement(sql5);
                stmt.setString(1, m.getDescricao());
                stmt.execute();
                stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            System.out.println(" Erro ao editar mural: "+u); 
        }            
    }
    
}
