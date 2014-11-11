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
import modelo.Empresa;
import modelo.Fechamento;
import modelo.Parcela;

/**
 *
 * @author felipe
 */
public class ParcelaDAO {
    private Connection connection;
    ResultSet resultado;
    Dialogos d = new Dialogos();
    
    public ParcelaDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public void NovaParcela(Parcela p){
        String sql = "INSERT INTO parcelamento(id_notafiscal,valor,data_vencimento) VALUES(?,?,?)";
        Date date2 = new Date(0000-00-00) ;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, p.getId_notafiscal());
            stmt.setString(2, p.getValor());
            stmt.setDate(3, p.getData_vencimento());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            System.out.println(" Erro ao gerar parcela "+u);
        }
    }

    public ResultSet ParcelasemAberto() {
        try { 
            Statement stmt = connection.createStatement();
            String sql = "SELECT empresa.nome_empresa, empresa.telefone, fechamento.nome_fechamento, parcelamento.data_vencimento, parcelamento.valor, parcelamento.pago FROM   public.parcelamento,   public.notafiscal,   public.empresa,   public.fechamento WHERE  parcelamento.id_notafiscal = notafiscal.id_nota AND  empresa.id_empresa = notafiscal.id_empresa AND notafiscal.id_fechamento = fechamento.id_fechamento AND parcelamento.pago = false ORDER BY empresa.nome_empresa ASC;";
            resultado = stmt.executeQuery(sql);   
            connection.close();
        } catch (Exception u) {    
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar pagamentos em aberto: "+u);      
           }        return resultado;    
    }
    
    public ResultSet ParcelaEmpresa(Fechamento e) {
        String sql = "SELECT empresa.nome_empresa, empresa.telefone, fechamento.nome_fechamento, parcelamento.data_vencimento, parcelamento.valor, parcelamento.pago FROM   public.parcelamento,   public.notafiscal,   public.empresa,   public.fechamento WHERE  parcelamento.id_notafiscal = notafiscal.id_nota AND  empresa.id_empresa = notafiscal.id_empresa  AND parcelamento.pago = false AND nome_empresa = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, e.getNome_empresa());
            stmt.execute();
            resultado = stmt.executeQuery();
            connection.close();
        } catch (Exception u) {    
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar pagamentos em aberto: "+u);      
           }        return resultado;    
    }

    public ResultSet ParcelaFechamento(Fechamento f) {
        String sql = "SELECT empresa.nome_empresa, empresa.telefone, fechamento.nome_fechamento, parcelamento.data_vencimento, parcelamento.valor, parcelamento.pago FROM   public.parcelamento,   public.notafiscal,   public.empresa,   public.fechamento WHERE  parcelamento.id_notafiscal = notafiscal.id_nota AND  empresa.id_empresa = notafiscal.id_empresa  AND parcelamento.pago = false AND nome_fechamento = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, f.getNome_fechamento());
            stmt.execute();
            resultado = stmt.executeQuery();
            connection.close();
        } catch (Exception u) {    
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar pagamentos em aberto: "+u);      
           }        return resultado;    
    }

    public ResultSet ParcelaMes(Chamado f) {
        String sql = "SELECT empresa.nome_empresa, empresa.telefone, fechamento.nome_fechamento, parcelamento.data_vencimento, parcelamento.valor, parcelamento.pago FROM   public.parcelamento,   public.notafiscal,   public.empresa,   public.fechamento WHERE  parcelamento.id_notafiscal = notafiscal.id_nota AND  empresa.id_empresa = notafiscal.id_empresa  AND parcelamento.pago = false AND  EXTRACT(month FROM data_vencimento) = ? AND EXTRACT(year FROM data_vencimento) = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, Long.parseLong(f.getMes()));
            stmt.setLong(2, Long.parseLong(f.getAno()));
            stmt.execute();
            resultado = stmt.executeQuery();
            connection.close();
        } catch (Exception u) {    
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar pagamentos em aberto: "+u);      
           }        return resultado;    
    }

    public void BaixaPagamento(Parcela p) {
        String sql = "UPDATE parcelamento SET pago = 'TRUE' where parcelamento.valor = ? AND parcelamento.data_vencimento = ?";
        Date date2 = new Date(0000-00-00) ;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(2, date2.valueOf(p.getDt_venc()));
            stmt.setString(1, p.getValor());
            stmt.execute();
            stmt.close();
        } catch (Exception u) {    
            d.MensagemErro(1,u);
            System.out.println(" Erro ao modificar pagamentos em aberto: "+u);      
           }        
    }
}
