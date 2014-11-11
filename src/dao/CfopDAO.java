package dao;
import factory.ConnectionFactory;
import gui.componentes.Dialogos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Cfop;

public class CfopDAO {
    private Connection connection;
    String id_cfop;
    String descricao;
    Dialogos d = new Dialogos();
    ResultSet resultado;
    
    public CfopDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public void NovoCfop(Cfop c){
        String sql = "INSERT INTO nf_operacao(cfop,nome_operacao) VALUES(?,?)";    
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, c.getId_cfop());
            stmt.setString(2, c.getDescricao());
            stmt.execute();
            stmt.close();
            d.MensagemSucesso(25);
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
    }    

    public ResultSet ConsultarCfop() {
        try {
            Statement stmt = connection.createStatement();
            String sql = "select cfop from nf_operacao where ativo=true ";
            resultado = stmt.executeQuery(sql);   
            connection.close();
        } catch (Exception u) { 
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar Area: "+u);      
        }        
        return resultado;         
    }
    public void RemoveCfop(Cfop c) {
        String sql = "UPDATE  nf_operacao set ativo = false where cfop = ?";    
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, c.getId_cfop());
            stmt.execute();
            stmt.close();
            d.MensagemSucesso(25);
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }     
    }
    public ResultSet BuscarCfop(Cfop c){
        String sql = "SELECT cfop, nome_operacao, id_operacao FROM nf_operacao where cfop =  ?";    
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, c.getCfop());
            stmt.execute();
            resultado = stmt.executeQuery();   
            connection.close();
        } catch (Exception u) {    
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar dados da empresa: "+u);      
           }        
        return resultado; 
    }    

    public void ModificaCfop(Cfop c) {
         String sql = "Update nf_operacao set (nome_operacao,cfop) = (?,?) where id_operacao = ?;";    
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, c.getDescricao());
            stmt.setString(2, c.getCfop());
            stmt.setLong(3, Long.parseLong(c.getId_cfop()));
            stmt.execute();
            stmt.close();
            d.MensagemSucesso(25);
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }     
    }
}
