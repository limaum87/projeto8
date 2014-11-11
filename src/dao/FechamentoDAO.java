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

/**
 *
 * @author felipel
 */
public class FechamentoDAO {
    private Connection connection;
    ResultSet resultado;
    Dialogos d = new Dialogos();
    
    public FechamentoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public ResultSet NovoFechamento(Fechamento fechamento){
        
        String sql = "INSERT INTO fechamento(nome_fechamento,mes_referencia,status_fechamento) VALUES(?,?,'1') returning id_fechamento";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, fechamento.getNome_fechamento());
            stmt.setLong(2, fechamento.getMes_referencia());
            resultado = stmt.executeQuery(); 
            connection.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
        return resultado;
    }
    
    public ResultSet MostraFechamento(){
        try { 
            Statement stmt = connection.createStatement();
            String sql = "SELECT fechamento.nome_fechamento FROM public.fechamento WHERE status_fechamento = '1' ORDER by id_fechamento ASC";
            resultado = stmt.executeQuery(sql);   
            connection.close();
        } catch (Exception u) {    
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar fechamentos: "+u);      
           }        return resultado;  
    }
    public ResultSet ChamadosFechamento(Fechamento f){
        String sql = "SELECT ocorrencias.id_ocorrencia, empresa.nome_empresa, ocorrencias.ocorrencia, ocorrencias.valor, tipo_atendimento.nome_tipo , ocorrencias.valor_total, ocorrencias.valor_deslocamento, ocorrencias.valor_equipamentos, ocorrencias.lucro_equipamentos FROM public.ocorrencias, public.empresa, public.tipo_atendimento, public.fechamento WHERE ocorrencias.id_empresa = empresa.id_empresa AND ocorrencias.id_tipo = tipo_atendimento.id_tipo AND tipo_atendimento.id_tipo = ocorrencias.id_tipo AND  ocorrencias.id_fechamento = fechamento.id_fechamento AND fechamento.nome_fechamento = ? ORDER BY id_ocorrencia ASC ";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, f.getNome_fechamento());
            resultado = stmt.executeQuery(); 
            connection.close();
        } catch (Exception u) {  
            d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar fechamentos: "+u);      
           }        return resultado;  
    }
    public void ValoresFechamento (Fechamento fs){
        String sql = "UPDATE fechamento set (valor_servicos,valor_deslocamentos,valor_vendas_bruto,valor_vendas_liquido,valor_mensalidades,valor_total_servicos,valor_total_liquido,valor_total_bruto,valor_ov_liquido, valor_ov_bruto) = (?,?,?,?,?,?,?,?,?,?) where nome_fechamento = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, fs.getValor_servicos());
            stmt.setString(2, fs.getValor_deslocamento()); 
            stmt.setString(3, fs.getValor_venda_bruto());
            stmt.setString(4, fs.getValor_venda_liquido());
            stmt.setString(5, fs.getValor_mensalidades());
            stmt.setString(6, fs.getValor_total_servicos());
            stmt.setString(7, fs.getValor_total_liquido());
            stmt.setString(8, fs.getValor_total_bruto());
            stmt.setString(9, fs.getValor_ov_liquido());
            stmt.setString(10, fs.getValor_ov_bruto());
            stmt.setString(11, fs.getNome_fechamento());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar fechamentos: "+u);      
        }
    }
    public ResultSet EmpresasFechamento(Fechamento f){
        String sql = "SELECT  empresa.nome_empresa FROM public.ocorrencias, public.empresa,public.mensalidades,  public.fechamento WHERE ocorrencias.id_empresa = empresa.id_empresa AND  ocorrencias.id_fechamento = fechamento.id_fechamento AND fechamento.nome_fechamento = ? Group by empresa.nome_empresa UNION SELECT  empresa.nome_empresa FROM public.empresa,public.mensalidades,  public.fechamento WHERE empresa.id_empresa = mensalidades.id_empresa AND(mes_cobranca = 13 OR mes_cobranca= (select mes_referencia from public.fechamento where nome_fechamento = ?) )Group by empresa.nome_empresa ORDER BY nome_empresa ASC ";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, f.getNome_fechamento());
            stmt.setString(2, f.getNome_fechamento());
            resultado = stmt.executeQuery(); 
            connection.close();
        } catch (Exception u) {   
            d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar fechamentos: "+u);      
           }        return resultado;  
    }
    public ResultSet ChamadosEmpresa(Fechamento f){
        String sql = "SELECT ocorrencias.id_ocorrencia, empresa.nome_empresa, ocorrencias.ocorrencia, ocorrencias.valor, tipo_atendimento.nome_tipo , ocorrencias.valor_total, ocorrencias.valor_deslocamento, ocorrencias.valor_equipamentos, ocorrencias.lucro_equipamentos FROM public.ocorrencias, public.empresa, public.tipo_atendimento, public.fechamento WHERE ocorrencias.id_empresa = empresa.id_empresa AND ocorrencias.id_tipo = tipo_atendimento.id_tipo AND tipo_atendimento.id_tipo = ocorrencias.id_tipo AND  ocorrencias.id_fechamento = fechamento.id_fechamento AND fechamento.nome_fechamento = ? AND empresa.nome_empresa = ? ORDER BY id_ocorrencia ASC";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, f.getNome_fechamento());
            stmt.setString(2, f.getNome_empresa());
            resultado = stmt.executeQuery(); 
            connection.close();
        } catch (Exception u) {    
            d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar fechamentos: "+u);      
           }        return resultado;  
    }
    public void FinalizaFechamento (Fechamento fs){
        String sql = "UPDATE fechamento set (status_fechamento) = ('2') where nome_fechamento = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, fs.getNome_fechamento());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            System.out.println(" Erro ao finalizar fechamentos: "+u);      
        }
    }
    public void RemoveFechamento (Fechamento fs){
        String sql1 = "UPDATE ocorrencias set (id_status) = ('5') FROM  public.fechamento where fechamento.id_fechamento = ocorrencias.id_fechamento AND fechamento.nome_fechamento = ?;";
        String sql2 = "UPDATE ordem_venda set (id_status) = ('5') FROM  public.fechamento where fechamento.id_fechamento = ordem_venda.id_fechamento AND fechamento.nome_fechamento = ?;";
        String sql = "UPDATE fechamento set (status_fechamento) = ('3') where nome_fechamento = ?";
        
        try {
            PreparedStatement stmt2 = connection.prepareStatement(sql2);
            stmt2.setString(1, fs.getNome_fechamento());
            stmt2.execute();
            stmt2.close();
            PreparedStatement stmt1 = connection.prepareStatement(sql1);
            stmt1.setString(1, fs.getNome_fechamento());
            stmt1.execute();
            stmt1.close();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, fs.getNome_fechamento());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            System.out.println(" Erro ao finalizar fechamentos: "+u);      
        }
    }

    public void EstaPago(Fechamento fs) {
        ResultSet resultado;
         Boolean existe;
         String sql = "SELECT case when exists (SELECT  empresa.nome_empresa FROM public.ocorrencias, public.empresa, public.fechamento WHERE ocorrencias.id_empresa = empresa.id_empresa AND  ocorrencias.id_fechamento = fechamento.id_fechamento AND fechamento.nome_fechamento = ? AND empresa.nome_empresa = ? AND ocorrencias.pago = FALSE) then 'true' else 'false'  end";
         try {
             PreparedStatement stmt = connection.prepareStatement(sql);
             stmt.setString(2, fs.getNome_empresa());
             stmt.setString(1, fs.getNome_fechamento());
             resultado = stmt.executeQuery();  
             resultado.next(); 
             existe=resultado.getBoolean(1);
             stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
            
            
        }
         if (existe==false){
             d.MensagemCuidado(2);
         }
    }
}
