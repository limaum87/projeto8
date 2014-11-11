/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.componentes;

import dao.CfopDAO;
import dao.ContratoDAO;
import dao.EmpresaDAO;
import dao.FechamentoDAO;
import dao.FornecedorDAO;
import dao.NotaFiscalDAO;
import dao.ServicoDAO;
import gui.Fechamentos;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import modelo.Fechamento;

/**
 *
 * @author felipel
 */
public class Combo {
    ResultSet resultado;
    
    public void ListaFechamentos(JComboBox combo){
        FechamentoDAO f = new FechamentoDAO();  
        resultado=f.MostraFechamento();
        combo.removeAllItems();
               try {  
                while (resultado.next()){  
                    combo.addItem(resultado.getString(1));  
                    combo.updateUI();  
                }  
                resultado.close();
                
            } catch (SQLException ex) {  
                System.out.println(" Erro ao consultar empresa: "); 
            }
    }
  
        public void ListaServicos(JComboBox combo){
        ServicoDAO f = new ServicoDAO();  
        resultado=f.MostraServicos();
        combo.removeAllItems();
               try {  
                while (resultado.next()){  
                    combo.addItem(resultado.getString(1));  
                    combo.updateUI();  
                }  
                resultado.close();
            } catch (SQLException ex) {  
                System.out.println(" Erro ao consultar servicos: "); 
            }
    }
        public void ListaEmpresa(JComboBox combo){
            EmpresaDAO f = new EmpresaDAO(); 
            resultado=f.ConsultarEmpresa();  
            combo.removeAllItems();
            try {
                while (resultado.next()){  
                    combo.addItem(resultado.getString(1));  
                    combo.updateUI();  
                }  
                resultado.close();
            } catch (SQLException ex) {  
                System.out.println(" Erro ao consultar empresa: "); 
            }
        }
        public void ListaEmpresaFechamento(JComboBox combo, Fechamento f){
            FechamentoDAO fd = new FechamentoDAO(); 
            resultado=fd.EmpresasFechamento(f);  
            combo.removeAllItems();
            try {
                while (resultado.next()){  
                    combo.addItem(resultado.getString(1));  
                    combo.updateUI();  
                }  
                resultado.close();
            } catch (SQLException ex) {  
                System.out.println(" Erro ao consultar empresa: "); 
            }
        }
        public void ListaNotaFechamento(JComboBox combo, Fechamento f){
            NotaFiscalDAO nf = new NotaFiscalDAO(); 
            resultado=nf.ListaNotaFechamento(f);  
            combo.removeAllItems();
            try {
                while (resultado.next()){  
                    combo.addItem(resultado.getString(1));  
                    combo.updateUI();  
                }  
                resultado.close();
            } catch (SQLException ex) {  
                System.out.println(" Erro ao consultar notasfiscais: "); 
            }
        }

    public void ListaEmpresasSemContrato(JComboBox combo) {
        ContratoDAO cd = new ContratoDAO();
        resultado = cd.ListaEmpresaSemContrato();
        combo.removeAllItems();
            try {
                while (resultado.next()){  
                    combo.addItem(resultado.getString(1));  
                    combo.updateUI();  
                }  
                resultado.close();
            } catch (SQLException ex) {  
                System.out.println(" Erro ao consultar contratos: "); 
            }
    }

    public void ListaEmpresasComContrato(JComboBox combo) {
        ContratoDAO cd = new ContratoDAO();
        resultado = cd.ListaEmpresaComContrato();
        combo.removeAllItems();
            try {
                while (resultado.next()){  
                    combo.addItem(resultado.getString(1));  
                    combo.updateUI();  
                }  
                resultado.close();
            } catch (SQLException ex) {  
                System.out.println(" Erro ao consultar contratos: "); 
            }
    }

   
    public void ListaFornecedores(JComboBox combo) {
      FornecedorDAO cd = new FornecedorDAO();
        resultado = cd.ConsultarFornecedor();
        combo.removeAllItems();
            try {
                while (resultado.next()){  
                    combo.addItem(resultado.getString(1));  
                    combo.updateUI();  
                }  
                resultado.close();
            } catch (SQLException ex) {  
                System.out.println(" Erro ao consultar fornecedores: "); 
            }
    }

    public void ListaCfop(JComboBox combo) {
        CfopDAO cd = new CfopDAO();
        resultado = cd.ConsultarCfop();
        combo.removeAllItems();
            try {
                while (resultado.next()){  
                    combo.addItem(resultado.getString(1));  
                    combo.updateUI();  
                }  
                resultado.close();
            } catch (SQLException ex) {  
                System.out.println(" Erro ao consultar cfops: "); 
            }
    }
}
