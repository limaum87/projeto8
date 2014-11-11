package dao;
import factory.ConnectionFactory;
import gui.componentes.Dialogos;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import modelo.Assentamento;
import modelo.Chamado;
/**
 *
 * @author felipe
 */
public class AssentamentoDAO {
    private Connection connection;
    ResultSet resultado;
    ResultSet resultado2;
    Dialogos d = new Dialogos();
    
    public AssentamentoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void NovoAssentamento(Assentamento assentamento){
        SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd"); //você pode usar outras máscaras
        java.util.Date y=new java.util.Date();
        Date date2 = new Date(0000-00-00);
        String data = sdf1.format(y);
        String sql = "INSERT INTO assentamentos(id_ocorrencia,assentamento,data_assentamento) VALUES(?,?,?)";    
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, assentamento.getId_ocorrencia());
            stmt.setString(2, assentamento.getAssentamento());
            stmt.setDate(3, date2.valueOf(data));
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
    }
    public ResultSet MostraAssentamentos(Assentamento assentamento){
        String sql = "SELECT assentamentos.assentamento, assentamentos.data_assentamento FROM public.assentamentos WHERE assentamentos.id_ocorrencia = ?";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, assentamento.getId_ocorrencia());
            stmt.execute();
            resultado = stmt.executeQuery();
            connection.close();
        } catch (Exception u) {  
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar dados da empresa: "+u);
        } return resultado;
      }
}
