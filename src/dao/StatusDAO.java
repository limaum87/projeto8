package dao;
import factory.ConnectionFactory;
import gui.componentes.Dialogos;
import java.sql.*;
import modelo.Status;

public class StatusDAO {
    private Connection connection;
    Long id_status;
    String nome_status;
    ResultSet resultado;
    Dialogos d = new Dialogos();
    
    public StatusDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public void novostatus(Status status){
        String sql = "INSERT INTO status(nome_status,invisivel) VALUES(?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, status.getNome_status());
            stmt.setBoolean(2, status.getVisibilidade());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
    }
    public ResultSet ConsultarStatus(){
        try { 
               Statement stmt = connection.createStatement();
               String sql = "select nome_status from status ";
               resultado = stmt.executeQuery(sql);   
               connection.close();
           } catch (Exception u) {
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar empresa: "+u);      
           }        return resultado;          
       }  
    
}

