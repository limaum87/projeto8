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
import modelo.Contrato;
import modelo.Mensalidade;

/**
 *
 * @author felipe
 */
public class ContratoDAO {
   
    private Connection connection;
    ResultSet resultado;
    Dialogos d = new Dialogos();
    
    public ContratoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }  

    public ResultSet ListaEmpresaSemContrato() {
        try { 
               Statement stmt = connection.createStatement();
               String sql = "select nome_empresa from empresa except (SELECT empresa.nome_empresa FROM public.contratos, public.empresa Where contratos.id_empresa = empresa.id_empresa) order by nome_empresa ASC ";
               resultado = stmt.executeQuery(sql);  
               connection.close();
               
           } catch (Exception u) {    
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar empresa: "+u);  
           }        return resultado;          
    }

    public ResultSet MostraContratos() {
        try { 
            Statement stmt = connection.createStatement();
            String sql = "SELECT e.nome_empresa, c.horas_contratadas, c.horas_restantes, c.valor_contrato FROM public.contratos as c, public.empresa as e  WHERE  c.id_status = '1' and e.id_empresa = c.id_empresa";
            resultado = stmt.executeQuery(sql);      
            connection.close();
           } catch (Exception u) {  
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar itens: "+u);      
           }        return resultado; 
    }

    public ResultSet ListaEmpresaComContrato() {
        try { 
            Statement stmt = connection.createStatement();
            String sql = "SELECT empresa.nome_empresa FROM public.contratos, public.empresa WHERE contratos.id_empresa = empresa.id_empresa AND contratos.id_status = 1 ORDER BY empresa.nome_empresa ASC ;";
            resultado = stmt.executeQuery(sql);      
            connection.close();
           } catch (Exception u) {  
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar itens: "+u);      
           }        return resultado; 
    }

    public void NovoContrato(Contrato c) {
        String sql = "INSERT INTO contratos(id_empresa,horas_contratadas,horas_restantes,valor_contrato,id_status) VALUES((select id_empresa from empresa where nome_empresa = ?),?,?,?,'1')";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, c.getNome_empresa());
            stmt.setString(2, c.getHoras_contratadas());
            stmt.setString(3, c.getHoras_contratadas());
            stmt.setString(3, c.getValor_contrato());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
    
    }
    
    
}
