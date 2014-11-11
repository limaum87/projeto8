/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.componentes;

import dao.ChamadoDAO;
import dao.ContratoDAO;
import dao.FechamentoDAO;
import javax.swing.table.DefaultTableModel;
import dao.ItemDAO;
import dao.MensalidadeDAO;
import dao.ParcelaDAO;
import dao.VendaDAO;
import externo.JMoneyField;
import gui.ModificaChamado;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultCellEditor;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import modelo.Chamado;
import modelo.Fechamento;
import modelo.Item;
import modelo.OrdemCompra;

public class Tabelas {
    ResultSet resultado;
    public void ResUtil (DefaultTableModel modelo){
        ItemDAO f = new ItemDAO();  
        resultado=f.ItensResUtil(); 
        try {  
            while (resultado.next()){  
            modelo.addRow(new String [] {resultado.getString(1),resultado.getString(3),resultado.getString(2),resultado.getString(6)});  
            }  
        } catch (SQLException ex) {  
                System.out.println(" Erro ao adicionar equipamentos reservados: "+ ex); 
                
        }
    }
    public void ResUtil (DefaultTableModel modelo, Item item){
        ItemDAO f = new ItemDAO();  
        
        resultado=f.ItensResUtilf(item); 
        try {  
            while (resultado.next()){  
            modelo.addRow(new String [] {resultado.getString(1),resultado.getString(3),resultado.getString(2),resultado.getString(6)});  
            }  
        } catch (SQLException ex) {  
                System.out.println(" Erro ao adicionar equipamentos reservados: "+ ex); 
                
        }
    }
    public void ItensDisponiveis (DefaultTableModel modelo){
        ItemDAO fa = new ItemDAO();  
        resultado=fa.ItensDisponiveis(); 
        try {  
            while (resultado.next()){  
            modelo.addRow(new String [] {resultado.getString(1),resultado.getString(3),resultado.getString(4),resultado.getString(2)});  
                }  
            } catch (SQLException ex) {  
                System.out.println(" Erro ao adicionar linha: "); 
            }
    }
    public void OSFinalizadas (DefaultTableModel modelo){
        ChamadoDAO fa = new ChamadoDAO();  
        resultado=fa.ChamadosFinalizados(); 
        try {  
            while (resultado.next()){  
            modelo.addRow(new String [] {resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getString(4)});  
                }  
            } catch (SQLException ex) {  
                System.out.println(" Erro ao adicionar linha: "); 
            }
    }
    public void OSFechamento (DefaultTableModel modelo, Fechamento f){
        FechamentoDAO fa = new FechamentoDAO();  
        resultado=fa.ChamadosFechamento(f); 
        try {  
            while (resultado.next()){  
            modelo.addRow(new String [] {resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getString(5),resultado.getString(6),resultado.getString(7),resultado.getString(8),resultado.getString(9)});  
                }  
            } catch (SQLException ex) {  
                System.out.println(" Erro ao adicionar linha: "); 
            }
        
    }
    public void OSEmpresa (DefaultTableModel modelo, Fechamento f){
        FechamentoDAO fa = new FechamentoDAO();  
        resultado=fa.ChamadosEmpresa(f); 
        try {  
            while (resultado.next()){  
            modelo.addRow(new String [] {resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getString(5),resultado.getString(6),resultado.getString(7),resultado.getString(8),resultado.getString(9)});  
                }  
            } catch (SQLException ex) {  
                System.out.println(" Erro ao adicionar linha: " +ex); 
            }
    }
    public void MostraMensalidades (DefaultTableModel modelo){
        MensalidadeDAO md = new MensalidadeDAO();
        resultado=md.MostraMensalidades();
        try {  
            while (resultado.next()){  
            modelo.addRow(new String [] {resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getString(5)});  
                }  
            } catch (SQLException ex) {  
                System.out.println(" Erro ao adicionar linha: "); 
            }
    }
    
        public void MensalidadesFechamento (DefaultTableModel modelo, Fechamento f){
        MensalidadeDAO md = new MensalidadeDAO();
        resultado=md.MensalidadesFechamento(f);
        try {  
            while (resultado.next()){  
            modelo.addRow(new String [] {resultado.getString(1),resultado.getString(2),resultado.getString(3)});  
                }  
            } catch (SQLException ex) {  
                System.out.println(" Erro ao adicionar linha: "); 
            }
    }
        public void MensalidadesEmpresa (DefaultTableModel modelo, Fechamento f){
        MensalidadeDAO md = new MensalidadeDAO();
        resultado=md.MensalidadeEmpresa(f);
        try {  
            while (resultado.next()){  
            modelo.addRow(new String [] {resultado.getString(1),resultado.getString(2),resultado.getString(3)});  
                }  
            } catch (SQLException ex) {  
                System.out.println(" Erro ao adicionar linha: "); 
            }
    }
    
        public void ItensOS (DefaultTableModel modelo, Chamado c){
        ItemDAO cd = new ItemDAO();
        resultado=cd.MostraItensOS(c);
        try {  
            while (resultado.next()){  
            modelo.addRow(new String [] {resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getString(4)});  
                }  
            } catch (SQLException ex) {  
                System.out.println(" Erro ao adicionar linha: "); 
            }
    }
        public void OVFinalizadas (DefaultTableModel modelo){
        VendaDAO vd = new VendaDAO();  
        resultado=vd.VendasFinalizadas(); 
        try {  
            while (resultado.next()){  
            modelo.addRow(new String [] {resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getString(4)});  
                }  
            } catch (SQLException ex) {  
                System.out.println(" Erro ao adicionar linha: "); 
            }
    }
        public void OVFechamento (DefaultTableModel modelo, Fechamento f){
        VendaDAO vd = new VendaDAO();
        resultado=vd.OVFechamento(f);
        try {  
            while (resultado.next()){  
            modelo.addRow(new String [] {resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getString(4)});  
                }  
            } catch (SQLException ex) {  
                System.out.println(" Erro ao adicionar linha: "); 
            }
    }
        
    public Integer Mesparanumero (String mes){
        Integer m;
        switch (mes){
            case "Janeiro" :
                m=1;
                return m;
            case "Fevereiro" :
                m=2;
                return m;
            case "Março" :
                m=3;
                return m;
            case "Abril" :
                m=4;
                return m;
                 
            case "Maio" :
                m=5;
                return m;
            case "Junho" :
                m=6;
                return m;
            case "Julho" :
                m=7;
                return m;
            case "Agosto" :
                m=8;
                return m;
            case "Setembro" :
                m=9;
                return m;
            case "Outubro" :
                m=10;
                return m;
            case "Novembro" :
                m=11;
                return m;
            case "Dezembro" :
                m=12;
                return m;   
        }
        return null;
    }

    public void MostraContratos(DefaultTableModel modelo) {
        ContratoDAO cd = new ContratoDAO();
        resultado=cd.MostraContratos();
        try {  
            while (resultado.next()){  
            modelo.addRow(new String [] {resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getString(5)});  
                }  
            } catch (SQLException ex) {  
                System.out.println(" Erro ao adicionar linha: "); 
            }
    }

    public void PagamentosemAberto(DefaultTableModel modelo) {
        ParcelaDAO pd = new ParcelaDAO();
        resultado=pd.ParcelasemAberto();
        try {  
            while (resultado.next()){  
            modelo.addRow(new String [] {resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getString(5)});  
                }  
            } catch (SQLException ex) {  
                System.out.println(" Erro ao adicionar linha: "); 
            }
    }

 public void ItensNotaCompra(DefaultTableModel modelo, OrdemCompra oc) {
        Item it = new Item();
        ItemDAO itd = new ItemDAO();
        resultado=itd.ItensNotaCompra(oc);
        try {  
            while (resultado.next()){  
            modelo.addRow(new String [] {resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getString(5)});  
                }  
            } catch (SQLException ex) {  
                System.out.println(" Erro ao adicionar linha: "); 
            }
    }

    public void EmpresasFechamento(DefaultTableModel modelo, Fechamento fs) {
        
        FechamentoDAO fd = new FechamentoDAO();
        resultado=fd.EmpresasFechamento(fs);
        String booleanx = "true";
        try {  
            while (resultado.next()){  
            modelo.addRow(new Object [] {resultado.getString(1),Boolean.TRUE});  
                }  
            } catch (SQLException ex) {  
                System.out.println(" Erro ao adicionar linha: "); 
            }
    }


}
