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
import modelo.Fechamento;
import modelo.Mensalidade;

/**
 *
 * @author felipe
 */
public class MensalidadeDAO {
    
    private  Connection connection;
    Dialogos d = new Dialogos();
    ResultSet resultado;
    
    public MensalidadeDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public void NovaMensalidade(Mensalidade m){
        String sql = "INSERT INTO mensalidades(id_servico,id_empresa,valor,mes_cobranca,status) VALUES((select id_servico from servico where nome_servico = ?),(select id_empresa from empresa where nome_empresa = ?),?,?,'1')";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, m.getNome_servico());
            stmt.setString(2, m.getNome_empresa());
            stmt.setString(3, m.getValor());
            stmt.setLong(4, m.getMes_cobranca());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
    }
    public ResultSet MostraMensalidades(){
        try { 
               Statement stmt = connection.createStatement();
               String sql = "SELECT m.id_mensalidade, e.nome_empresa, s.nome_servico, m.valor, m.mes_cobranca FROM public.mensalidades as m, public.empresa as e,  public.servico as s WHERE  m.status = '1' and e.id_empresa = m.id_empresa and s.id_servico = m.id_servico;";
               resultado = stmt.executeQuery(sql);      
               connection.close();
           } catch (Exception u) {  
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar itens: "+u);      
           }        return resultado;  
    } 
    public void RemoveMensalidade(Mensalidade m){
        String sql = "UPDATE mensalidades set (status) = ('2') where id_mensalidade = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, m.getId_mensalidade());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1, u);
        }
    
    }
    public ResultSet MensalidadesFechamento(Fechamento f){
        String sql = "SELECT empresa.nome_empresa, servico.nome_servico, mensalidades.valor FROM public.mensalidades, public.empresa, public.servico WHERE   mensalidades.status = 1 AND  mensalidades.id_empresa = empresa.id_empresa AND   mensalidades.id_servico = servico.id_servico AND  (mensalidades.mes_cobranca = (select fechamento.mes_referencia from fechamento where nome_fechamento = ?) OR  mensalidades.mes_cobranca = 13)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, f.getNome_fechamento());
            stmt.execute();
            resultado = stmt.executeQuery(); 
            connection.close();
            
           } catch (Exception u) {   
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar mensalidades: "+u);      
           }        return resultado;  
    }
    public ResultSet MensalidadeEmpresa(Fechamento f){
        String sql = "SELECT empresa.nome_empresa, servico.nome_servico, mensalidades.valor FROM public.mensalidades, public.empresa, public.servico WHERE   mensalidades.status = 1 AND  mensalidades.id_empresa = empresa.id_empresa AND   mensalidades.id_servico = servico.id_servico AND  empresa.nome_empresa = ? AND  (mensalidades.mes_cobranca = (select fechamento.mes_referencia from fechamento where nome_fechamento = ?) OR  mensalidades.mes_cobranca = 13)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(2, f.getNome_fechamento());
            stmt.setString(1, f.getNome_empresa());
            stmt.execute();
            resultado = stmt.executeQuery();  
            connection.close();
            
           } catch (Exception u) { 
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar mensalidades: "+u);      
           }        return resultado;  
    }

    public void ExisteMensalidade(Fechamento fs) {
        ResultSet resultado;
         Boolean existe;
         String sql = "SELECT case when exists (SELECT empresa.nome_empresa, servico.nome_servico, mensalidades.valor FROM public.mensalidades, public.empresa, public.servico WHERE   mensalidades.status = 1 AND  mensalidades.id_empresa = empresa.id_empresa AND   mensalidades.id_servico = servico.id_servico AND  empresa.nome_empresa = ? AND  (mensalidades.mes_cobranca = (select fechamento.mes_referencia from fechamento where nome_fechamento = ?) OR  mensalidades.mes_cobranca = 13)) then 'true' else 'false'  end";
         try {
             PreparedStatement stmt = connection.prepareStatement(sql);
             stmt.setString(1, fs.getNome_empresa());
             stmt.setString(2, fs.getNome_fechamento());
             resultado = stmt.executeQuery();  
             resultado.next(); 
             existe=resultado.getBoolean(1);
             stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
            
            
        }
         if (existe==true){
             d.MensagemCuidado(3);
         }
    }
    
}
