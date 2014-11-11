/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import gui.componentes.Dialogos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Fechamento;
import modelo.Venda;

/**
 *
 * @author felipe
 */
public class VendaDAO {
    private Connection connection;
    ResultSet resultado;
    Dialogos d = new Dialogos();
    
    public VendaDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public Long NovaVenda(Venda v){
         Long idvenda=null;
         String sql = "insert into ordem_venda (id_empresa, valor_total,lucro_total, data_venda,id_status ) values ((select id_empresa from empresa where nome_empresa=?),?,?,?,?)  returning id_venda";
        Date date2 = new Date(0000-00-00) ;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, v.getNome_empresa());
            stmt.setString(2, v.getValor_total());
            stmt.setString(3, v.getLucro_total());
            stmt.setDate(4, date2.valueOf(v.getData_venda()));
            stmt.setLong(5, 5l);
            resultado = stmt.executeQuery();  
            connection.close();
            
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            System.out.println(" Erro ao ordem venda nota "+u);
        }
        try {  
            while (resultado.next()){  
                idvenda=(resultado.getLong(1));  
            } 
        } catch (SQLException u) { 
            d.MensagemErro(1,u);
            System.out.println(" Erro ao retornar id_venda "); 
        }
        return idvenda;     
        
    }
    public ResultSet VendasFinalizadas(){
        String sql2 = "SELECT ordem_venda.id_venda,  empresa.nome_empresa, ordem_venda.valor_total, ordem_venda.data_venda FROM public.ordem_venda,public.empresa WHERE  empresa.id_empresa = ordem_venda.id_empresa AND  id_status = 5";
          try { 
              PreparedStatement stmt = connection.prepareStatement(sql2);
              stmt.execute();
              resultado = stmt.executeQuery();
              connection.close();
             
           } catch (Exception u) {  
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar dados da empresa: "+u);    
      } return resultado;
      }
    public void AssociaFechamento(Venda v){
        String sql = "UPDATE ordem_venda set (id_status,id_fechamento) = (1,?) where id_venda = ?";
          try {
              PreparedStatement stmt = connection.prepareStatement(sql);
              stmt.setLong(1, v.getId_fechamento());
              stmt.setLong(2, v.getId_venda());
              stmt.execute();
              stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            System.out.println(" Erro ao atualizar dados da ov: "+u); 
        }
    }
    public ResultSet OVFechamento(Fechamento f){
        String sql = "SELECT ordem_venda.id_venda,  empresa.nome_empresa, ordem_venda.lucro_total,ordem_venda.valor_total FROM public.ordem_venda, public.empresa, public.fechamento WHERE ordem_venda.id_fechamento = (select  fechamento.id_fechamento FROM public.fechamento where fechamento.nome_fechamento = ?) AND fechamento.id_fechamento = ordem_venda.id_fechamento AND empresa.id_empresa = ordem_venda.id_empresa AND ordem_venda.id_status = 1;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, f.getNome_fechamento());
            stmt.execute();
            resultado = stmt.executeQuery();  
            connection.close();
           } catch (Exception u) {    
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar ovs: "+u);      
           }        return resultado;  
    }
}

