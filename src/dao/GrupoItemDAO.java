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
import modelo.GrupoItem;

/**
 *
 * @author felipe
 */
public class GrupoItemDAO {
    private Connection connection;
    ResultSet resultado;
    Dialogos d = new Dialogos();
    
public GrupoItemDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public ResultSet ConsultaGrupo(){
        try { 
               Statement stmt = connection.createStatement();
               String sql = "select nome_grupo from grupo_item";
               resultado = stmt.executeQuery(sql);   
               connection.close();
           } catch (Exception u) {    
               System.out.println(" Erro ao consultar grupo: "+u);   
               d.MensagemErro(1,u);
           }        return resultado;           
       }  
    
     public void adiciona(GrupoItem grupo){
        String sql = "INSERT INTO grupo_item(nome_grupo) VALUES(?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, grupo.getNome_grupo());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
            
        }
    }
}
