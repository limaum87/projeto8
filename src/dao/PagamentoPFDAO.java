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
import java.sql.Statement;
import modelo.Chamado;
import modelo.Fechamento;
import modelo.PagamentoPF;

/**
 *
 * @author felipe
 */
public class PagamentoPFDAO {
    private final Connection connection;
    Dialogos d = new Dialogos();
    ResultSet resultado;
    
    public PagamentoPFDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public void Novopagamento(PagamentoPF p) {
        String sql = "INSERT INTO pagamentospf(id_empresa,id_fechamento,valor,data_vencimento) VALUES((select id_empresa from empresa where nome_empresa = ?),(select id_fechamento from fechamento where nome_fechamento = ?),?,?)";
        Date date2 = new Date(0000-00-00) ;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, p.getNome_empresa());
            stmt.setString(2, p.getNome_fechamento());
            stmt.setString(3, p.getValor());
            stmt.setDate(4, p.getData_vencimento());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            System.out.println(" Erro ao gerar parcela "+u);
        }
    }

    public ResultSet PagamentoFechamento(PagamentoPF pf) {
        String sql = "SELECT empresa.nome_empresa,   empresa.telefone,   fechamento.nome_fechamento,   pagamentospf.data_vencimento,   pagamentospf.valor FROM   public.pagamentospf,   public.empresa,   public.fechamento WHERE pagamentospf.id_fechamento = fechamento.id_fechamento AND  empresa.id_empresa = pagamentospf.id_empresa AND fechamento.nome_fechamento = ? AND pagamentospf.pago = false;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, pf.getNome_fechamento());
            stmt.execute();
            resultado = stmt.executeQuery();
            connection.close();
        } catch (Exception u) {    
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar pagamentos em aberto: "+u);      
           }        return resultado;    
    
    }

    public ResultSet PagamentoCliente(PagamentoPF pf) {
        String sql = "SELECT empresa.nome_empresa,   empresa.telefone,   fechamento.nome_fechamento,   pagamentospf.data_vencimento,   pagamentospf.valor FROM   public.pagamentospf,   public.empresa,   public.fechamento WHERE pagamentospf.id_fechamento = fechamento.id_fechamento AND  empresa.id_empresa = pagamentospf.id_empresa AND pagamentospf.pago = false AND empresa.nome_empresa = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, pf.getNome_empresa());
            stmt.execute();
            resultado = stmt.executeQuery();
            connection.close();
        } catch (Exception u) {    
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar pagamentos em aberto: "+u);      
           }        return resultado;    
    }

    public ResultSet PagamentoMes(PagamentoPF pf) {
        String sql = "SELECT empresa.nome_empresa,   empresa.telefone,   fechamento.nome_fechamento,   pagamentospf.data_vencimento,   pagamentospf.valor FROM   public.pagamentospf,   public.empresa,   public.fechamento WHERE pagamentospf.id_fechamento = fechamento.id_fechamento AND  empresa.id_empresa = pagamentospf.id_empresa AND pagamentospf.pago = false AND  EXTRACT(month FROM data_vencimento) = ? AND EXTRACT(year FROM data_vencimento) = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, Long.parseLong(pf.getMes()));
            stmt.setLong(2, Long.parseLong(pf.getAno()));
            stmt.execute();
            resultado = stmt.executeQuery();
            connection.close();
        } catch (Exception u) {    
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar pagamentos em aberto: "+u);      
           }        return resultado;    
    }

    public ResultSet PagamentosemAberto() {
        try { 
            Statement stmt = connection.createStatement();
            String sql = "SELECT empresa.nome_empresa,   empresa.telefone,   fechamento.nome_fechamento,   pagamentospf.data_vencimento,   pagamentospf.valor FROM   public.pagamentospf,   public.empresa,   public.fechamento WHERE pagamentospf.id_fechamento = fechamento.id_fechamento AND  empresa.id_empresa = pagamentospf.id_empresa AND pagamentospf.pago = false;";
            resultado = stmt.executeQuery(sql);   
            connection.close();
        } catch (Exception u) {    
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar pagamentos em aberto: "+u);      
           }        return resultado;    
    }
    
    
}
