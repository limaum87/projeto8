package dao;
import factory.ConnectionFactory;
import gui.componentes.Dialogos;
import java.sql.*;
import modelo.Area;

public class AreaDAO {
    private Connection connection;
    Long id_area;
    String nome_area;
    ResultSet resultado;
    Dialogos d = new Dialogos();
    public AreaDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public void novaarea(Area area){
        String sql = "INSERT INTO area(nome_area) VALUES(?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, area.getNome_area());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
    }
        public ResultSet ConsultarArea(){
        try { 
               Statement stmt = connection.createStatement();
               String sql = "select nome_area from area ";
               resultado = stmt.executeQuery(sql);   
               connection.close();
           } catch (Exception u) { 
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar Area: "+u);      
           }        return resultado;          
       }  
}
