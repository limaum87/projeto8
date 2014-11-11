/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import externo.InvertePontos;
import externo.Money;
import factory.ConnectionFactory;
import gui.componentes.Dialogos;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Chamado;
import modelo.Empresa;
/**
 *
 * @author felipe
 */
public class ChamadoDAO {
    private Connection connection;
    Long id_ocorrencia;
    Long id_status;
    Long id_empresa;
    Long id_area;
    Long id_tipo;
    String ocorrencia;
    Date data_abertura;
    Date data_fechamento;
    Long id_nome;
    ResultSet resultado;
    ResultSet resultado2;
    ResultSet resultado3;
    ResultSet resultado4;
    ResultSet resultado5;
    ResultSet resultado6;
    ResultSet resultado7;
    ResultSet resultado8;
    Long codemp;
    Long codare;
    Long codstat;
    Long codtipo;
    Long codusr;
    Long vl_hr;
    String vlr;
    String vlr2;
    String nomests;
    String finalizado;
    Long valor;
    Dialogos d = new Dialogos();
    

    public ChamadoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
     public void NovoChamado(Chamado chamado){
                          
        SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd"); //você pode usar outras máscaras
         java.util.Date y=new java.util.Date();
         Date date2 = new Date(0000-00-00);
         String data = sdf1.format(y);
 
        
        String sql = "INSERT INTO ocorrencias(id_status,id_empresa,id_area,ocorrencia,data_abertura,id_nome,solucao) VALUES('3',(select id_empresa from empresa where nome_empresa = ?),(select id_area from area where nome_area = ?),?,?,'1','Aguardando Atendimento')";    
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, chamado.getNome_empresa());
            stmt.setString(2, chamado.getNome_area());
            stmt.setString(3, chamado.getOcorrencia());
            stmt.setDate(4, date2.valueOf(data));
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
    }
      public ResultSet ChamadosAbertos(){
          String sql2 = "SELECT ocorrencias.id_ocorrencia, empresa.nome_empresa, status.nome_status, ocorrencias.ocorrencia, ocorrencias.solucao, ocorrencias.data_abertura  FROM public.ocorrencias, public.empresa, public.status WHERE empresa.id_empresa = ocorrencias.id_empresa AND status.id_status = ocorrencias.id_status AND status.invisivel = false order by id_ocorrencia";
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
      
      public void AlteraChamado (Chamado chamado){
                           
            SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd"); //você pode usar outras máscaras
            java.util.Date y=new java.util.Date();
            Date date2 = new Date(0000-00-00);
            String data = sdf1.format(y);
            
            nomests = chamado.getNome_status();
            finalizado = "Finalizado";
 
            if (nomests.equalsIgnoreCase(finalizado)){
                String sql5 = "UPDATE ocorrencias set (id_status,id_empresa,ocorrencia,data_fechamento,solucao,id_tipo,valor,id_usuario,valor_total,valor_deslocamento,pago) = ((select id_status from status where nome_status = ?),(select id_empresa from empresa where nome_empresa = ?),?,?,?,(select id_tipo from tipo_atendimento where nome_tipo = ?),?,?,?,?,?) where id_ocorrencia = ?";
            try {
                PreparedStatement stmt = connection.prepareStatement(sql5);
                stmt.setLong(12, chamado.getId_ocorrencia());
                stmt.setString(1, chamado.getNome_status());
                stmt.setString(2,  chamado.getNome_empresa());
                stmt.setString(3, chamado.getOcorrencia());
                stmt.setDate(4, date2.valueOf(data));
                stmt.setString(5, chamado.getSolucao());
                stmt.setString(6,  chamado.getNome_tipo());
                stmt.setFloat(7, chamado.getValor());
                stmt.setFloat(8, chamado.getId_usuario());
                stmt.setString(9, chamado.getValor_total());
                stmt.setString(10, chamado.getValor_deslocamento());
                stmt.setBoolean(11, chamado.getPago());
                stmt.execute();
                stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar dados do status: "+u); 
        }            
            }else{
            
            String sql = "UPDATE ocorrencias set (id_status,id_empresa,ocorrencia,solucao,id_usuario) = ((select id_status from status where nome_status = ?),(select id_empresa from empresa where nome_empresa = ?),?,?,? ) where id_ocorrencia = ?";
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setLong(6, chamado.getId_ocorrencia());
                stmt.setString(1, chamado.getNome_status());
                stmt.setString(2, chamado.getNome_empresa());
                stmt.setString(3, chamado.getOcorrencia());
                stmt.setString(4, chamado.getSolucao());
                stmt.setFloat(5, chamado.getId_usuario());
                stmt.execute();
                stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar dados do status: "+u); 
        }
            }     
      
      }
      public ResultSet PesquisaChamado (Chamado chamado){
           String sql2 = "SELECT ocorrencias.id_ocorrencia, ocorrencias.ocorrencia, empresa.nome_empresa, status.nome_status, area.nome_area FROM public.ocorrencias, public.empresa, public.status, public.area WHERE ocorrencias.id_empresa = empresa.id_empresa AND ocorrencias.id_area = area.id_area AND ocorrencias.id_status = status.id_status AND empresa.nome_empresa = ? order by id_ocorrencia ;";
           try { 
                PreparedStatement stmt = connection.prepareStatement(sql2);
                stmt.setString(1, chamado.getNome_empresa());
                stmt.execute();
               resultado = stmt.executeQuery();   
               connection.close();
               
           } catch (Exception u) {    
               d.MensagemErro(1,u);
               System.out.println(" Erro azulo consultar dados da empresa: "+u);      
           }                 
           return resultado;
                 
     
      }
            public ResultSet PesquisaChamado2 (Chamado chamado){
           String sq2 = "SELECT ocorrencias.id_ocorrencia, ocorrencias.ocorrencia, empresa.nome_empresa, status.nome_status FROM public.ocorrencias, public.empresa, public.status, public.area WHERE ocorrencias.id_empresa = empresa.id_empresa AND ocorrencias.id_area = area.id_area AND ocorrencias.id_status = status.id_status AND empresa.nome_empresa = ? order by id_ocorrencia ;";
           String sql2 = "SELECT ocorrencias.ocorrencia, status.nome_status, empresa.nome_empresa, ocorrencias.id_ocorrencia, area.nome_area FROM public.ocorrencias, public.status, public.empresa, public.area WHERE empresa.nome_empresa = ? and area.nome_area =  ? and status.nome_status = ? and ocorrencias.id_empresa = empresa.id_empresa AND ocorrencias.id_status = status.id_status AND ocorrencias.id_area = area.id_area;";

           try { 
                PreparedStatement stmt = connection.prepareStatement(sql2);
                stmt.setString(1, chamado.getNome_empresa());
                stmt.setString(2, chamado.getNome_area());
                stmt.setString(3, chamado.getNome_status());
                stmt.execute();
               resultado = stmt.executeQuery();   
               
           } catch (Exception u) { 
               d.MensagemErro(1,u);
               System.out.println(" Erro azulo consultar dados da empresa: "+u);      
           }                 
           return resultado;
      }
      public void ChamadoEncaminhado(Chamado chamado){
          
          SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd"); //você pode usar outras máscaras
          java.util.Date y=new java.util.Date();
          Date date2 = new Date(0000-00-00);
          String data = sdf1.format(y);
          String sql = "INSERT INTO ocorrencias(id_status,id_empresa,id_area,ocorrencia,data_abertura,id_usuario,id_nome,solucao) VALUES('2',(select id_empresa from empresa where nome_empresa = ? ),(select id_area from area where nome_area = ?),?,?,(select id_nome from usuario where nome = ?),'1','Aguardando Atendimento')";    
          try {
              PreparedStatement stmt = connection.prepareStatement(sql);
              stmt.setString(1, chamado.getNome_empresa());
              stmt.setString(2, chamado.getNome_area());
              stmt.setString(3, chamado.getOcorrencia());
              stmt.setDate(4, date2.valueOf(data));
              stmt.setString(5, chamado.getNome_usuario());
              stmt.execute();
              stmt.close();
          } catch (SQLException u) {
              d.MensagemErro(1,u);
              throw new RuntimeException(u);
          }
      }
      public ResultSet ChamadosdoUsuario(Chamado chamado){
          String sql3 = "SELECT ocorrencias.id_ocorrencia, empresa.nome_empresa, status.nome_status, ocorrencias.ocorrencia, ocorrencias.solucao, ocorrencias.data_abertura FROM public.ocorrencias, public.empresa, public.status WHERE empresa.id_empresa = ocorrencias.id_empresa AND status.id_status = ocorrencias.id_status AND empresa.id_empresa = ocorrencias.id_empresa AND ocorrencias.id_usuario = ? AND status.invisivel_usr='false' order by id_ocorrencia";
          try { 
              PreparedStatement stmt = connection.prepareStatement(sql3);
              stmt.setLong(1, chamado.getId_usuario());
              stmt.execute();
              resultado6 = stmt.executeQuery();
              connection.close();
             
           } catch (Exception u) {    
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar dados da empresa: "+u);    
      } return resultado6;
      }
      public void EncaminharChamado (Chamado chamado){
         
          String sql = "UPDATE ocorrencias set (id_status,id_usuario) = (6,(select id_nome from usuario where nome = ? )) where id_ocorrencia = ?";
          try {
              PreparedStatement stmt = connection.prepareStatement(sql);
              stmt.setLong(2, chamado.getId_ocorrencia());
              stmt.setString(1, chamado.getNome_usuario());
              stmt.execute();
              stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar dados do status: "+u); 
        }
      }
       public ResultSet ChamadosFinalizados(){
          String sql2 = "SELECT ocorrencias.id_ocorrencia, empresa.nome_empresa, ocorrencias.ocorrencia, ocorrencias.data_abertura FROM public.ocorrencias, public.empresa WHERE ocorrencias.id_empresa = empresa.id_empresa AND id_status = 5 order by id_ocorrencia";
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
      public void AssociaFechamento(Chamado chamado){
          String sql = "UPDATE ocorrencias set (id_status,id_fechamento) = (1,?) where id_ocorrencia = ?";
          try {
              PreparedStatement stmt = connection.prepareStatement(sql);
              stmt.setLong(1, chamado.getId_fechamento());
              stmt.setLong(2, chamado.getId_ocorrencia());
              stmt.execute();
              stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            System.out.println(" Erro ao atualizar dados da os: "+u); 
        }
      }  
      public ResultSet ChamadosAssociados (Chamado chamado){
          String sql2 = "SELECT ocorrencias.id_ocorrencia, empresa.nome_empresa, ocorrencias.ocorrencia, ocorrencias.data_abertura FROM public.ocorrencias, public.empresa WHERE ocorrencias.id_empresa = empresa.id_empresa AND id_status = 5 order by id_ocorrencia";
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
      public String ValorChamado(Chamado chamado) throws SQLException{
        String vltotal,vlr;
        Float tempo;
        String sql2 = "SELECT tipo_atendimento.valor_hr FROM public.tipo_atendimento WHERE tipo_atendimento.nome_tipo = ?";
        
          try { 
              PreparedStatement stmt = connection.prepareStatement(sql2);
              stmt.setString(1, chamado.getNome_tipo());
              stmt.execute();
              resultado2 = stmt.executeQuery();
              
             
           } catch (Exception u) {    
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar dados do tipo de atendimento: "+u);    
      }
             
        resultado2.next();
        vlr=resultado2.getString(1);
        
        tempo=chamado.getValor();
        Double ds = tempo.doubleValue();
        Currency curr = Currency.getInstance("BRL");       
        BigDecimal valor1 = new BigDecimal(vlr);
        
        Money valort = new Money (valor1,curr);
        Money valorxtmp = valort.times(ds);
        
        vltotal=valorxtmp.toStringsemSimbolo();
        return vltotal; 
          
      }
      public String ValorDeslocamento (Chamado chamado) throws SQLException{
          String vldes=null;
           String sql2 = "SELECT tipo_atendimento.deslocamento FROM public.tipo_atendimento WHERE tipo_atendimento.nome_tipo = ?";
        
          try { 
              PreparedStatement stmt = connection.prepareStatement(sql2);
              stmt.setString(1, chamado.getNome_tipo());
              stmt.execute();
              resultado8 = stmt.executeQuery();
              
             
           } catch (Exception u) {    
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar dados do tipo de atendimento1: "+u);    
      }
         resultado8.next();
         if (resultado8.getBoolean(1)== false){
             vldes = "0";
         }
         else{
             String sql3 = "SELECT empresa.deslocamento FROM public.empresa WHERE nome_empresa = ?";
             try { 
              PreparedStatement stmt = connection.prepareStatement(sql3);
              stmt.setString(1, chamado.getNome_empresa());
              stmt.execute();
              resultado3 = stmt.executeQuery();
              
         }catch (Exception u) {  
             d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar dados do tipo de atendimento2: "+u);
         }
             resultado3.next();
             vldes= resultado3.getString(1);
         }
          
          return vldes;
      }
      public void ValoresChamado(Chamado chamado){
           String sql = "UPDATE ocorrencias set (valor_equipamentos,lucro_equipamentos) = (?,?) where id_ocorrencia = ?";
          try {
              PreparedStatement stmt = connection.prepareStatement(sql);
              stmt.setString(1, chamado.getValor_equipamentos());
              stmt.setString(2, chamado.getLucro_equipamentos());
              stmt.setLong(3, chamado.getId_ocorrencia());
              stmt.execute();
              stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            System.out.println(" Erro ao atualizar valores da os: "+u); 
        }
      }
      public ResultSet BuscaChamado(Chamado chamado){
          String sql = "SELECT ocorrencias.id_ocorrencia, empresa.nome_empresa, tipo_atendimento.nome_tipo, ocorrencias.ocorrencia, ocorrencias.solucao, ocorrencias.valor FROM   public.ocorrencias, public.empresa, public.tipo_atendimento WHERE   ocorrencias.id_empresa = empresa.id_empresa AND ocorrencias.id_tipo = tipo_atendimento.id_tipo AND ocorrencias.id_ocorrencia=? ";
          try { 
              PreparedStatement stmt = connection.prepareStatement(sql);
              stmt.setLong(1, chamado.getId_ocorrencia());
              stmt.execute();
              resultado = stmt.executeQuery();
              
         }catch (Exception u) {  
             d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar dados do tipo de atendimento: "+u);
         }
          return resultado;
      }
      public void AlteraValores(Chamado chamado){
          String sql = "UPDATE ocorrencias set (valor_total,valor_deslocamento) = (?,?) where id_ocorrencia = ?";
          try {
              PreparedStatement stmt = connection.prepareStatement(sql);
              stmt.setString(1, chamado.getValor_total());
              stmt.setString(2, chamado.getValor_deslocamento());
              stmt.setLong(3, chamado.getId_ocorrencia());
              stmt.execute();
              stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            System.out.println(" Erro ao atualizar dados da os: "+u); 
        }
      }  
      public ResultSet BuscaTodasOS (){
           String sql = "SELECT ocorrencias.id_ocorrencia, ocorrencias.ocorrencia, empresa.nome_empresa, status.nome_status, ocorrencias.data_abertura  FROM public.ocorrencias, public.empresa, public.status, public.area WHERE ocorrencias.id_empresa = empresa.id_empresa AND ocorrencias.id_area = area.id_area AND ocorrencias.id_status = status.id_status order by id_ocorrencia ;";
           try { 
               PreparedStatement stmt = connection.prepareStatement(sql);
               stmt.execute();
               resultado = stmt.executeQuery();
               connection.close();
             
           } catch (Exception u) {
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar chamados: "+u);      
           }                 
           return resultado;
      }
      public ResultSet BuscaOSCliente (Chamado chamado){
           String sql = "SELECT ocorrencias.id_ocorrencia, ocorrencias.ocorrencia, empresa.nome_empresa, status.nome_status , ocorrencias.data_abertura FROM public.ocorrencias, public.empresa, public.status, public.area WHERE ocorrencias.id_empresa = empresa.id_empresa AND ocorrencias.id_area = area.id_area AND ocorrencias.id_status = status.id_status AND empresa.nome_empresa = ? order by id_ocorrencia ;";
           try { 
               PreparedStatement stmt = connection.prepareStatement(sql);
               stmt.setString(1, chamado.getNome_empresa());
               stmt.execute();
               resultado = stmt.executeQuery();
               connection.close();
             
           } catch (Exception u) {
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar chamados: "+u);      
           }                 
           return resultado;
      }
       public ResultSet BuscaOSMes (Chamado chamado){
           String sql = "SELECT ocorrencias.id_ocorrencia, ocorrencias.ocorrencia, empresa.nome_empresa, status.nome_status, ocorrencias.data_abertura  FROM ocorrencias, empresa, status WHERE EXTRACT(month FROM data_abertura) = ? AND EXTRACT(year FROM data_abertura) = ? AND ocorrencias.id_empresa = empresa.id_empresa AND ocorrencias.id_status = status.id_status ORDER BY ocorrencias.id_ocorrencia ASC";
           try { 
               PreparedStatement stmt = connection.prepareStatement(sql);
               stmt.setLong(1, Long.parseLong(chamado.getMes()));
               stmt.setLong(2, Long.parseLong(chamado.getAno()));
               stmt.execute();
               resultado = stmt.executeQuery();
               connection.close();
             
           } catch (Exception u) {
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar chamados: "+u);      
           }                 
           return resultado;
       }
       public ResultSet BuscaOSMesCliente (Chamado chamado){
           String sql = "SELECT ocorrencias.id_ocorrencia, ocorrencias.ocorrencia, empresa.nome_empresa, status.nome_status , ocorrencias.data_abertura FROM ocorrencias, empresa, status WHERE EXTRACT(month FROM data_abertura) = ? AND EXTRACT(year FROM data_abertura) = ? AND ocorrencias.id_empresa = empresa.id_empresa AND ocorrencias.id_status = status.id_status AND nome_empresa = ? ORDER BY ocorrencias.id_ocorrencia ASC";
           try { 
               PreparedStatement stmt = connection.prepareStatement(sql);
               stmt.setLong(1, Long.parseLong(chamado.getMes()));
               stmt.setLong(2, Long.parseLong(chamado.getAno()));
               stmt.setString(3, chamado.getNome_empresa());
               stmt.execute();
               resultado = stmt.executeQuery();
               connection.close();
             
           } catch (Exception u) {
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar chamados: "+u);      
           }                 
           return resultado;
       }
       
       public ResultSet BuscaOSNumero (Chamado chamado){
           String sql = "SELECT ocorrencias.id_ocorrencia, ocorrencias.ocorrencia, empresa.nome_empresa, status.nome_status, ocorrencias.data_abertura  FROM ocorrencias, empresa, status WHERE  ocorrencias.id_empresa = empresa.id_empresa AND ocorrencias.id_status = status.id_status AND ocorrencias.id_ocorrencia = ? ORDER BY ocorrencias.id_ocorrencia ASC";
           try { 
               PreparedStatement stmt = connection.prepareStatement(sql);
               stmt.setLong(1, chamado.getId_ocorrencia());
               stmt.execute();
               resultado = stmt.executeQuery();
               connection.close();
             
           } catch (Exception u) {
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar chamados: "+u);      
           }                 
           return resultado;
       }
}
