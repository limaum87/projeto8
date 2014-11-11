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
import modelo.Item;
import gui.login;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Chamado;
import modelo.NotaFiscal;
import modelo.OrdemCompra;


/**
 *
 * @author felipe
 */
public class ItemDAO {

    private final Connection connection;
    ResultSet itens;
    ResultSet outrositens;
    ResultSet ordemcompra;
    Dialogos d = new Dialogos();
    public ItemDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void novoItem(Item item){
        String sql = "insert into itens (garantia, valor_compra, id_status_item,id_ordem_compra,nome_item,id_grupo,valor_venda) values (?,?,'1',?,?,(select id_grupo from grupo_item where nome_grupo=?),?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, item.getGarantia());
            stmt.setString(2, item.getValor_unitario());
            stmt.setLong(3, item.getId_ordemcompra());
            stmt.setString(4, item.getNome_item());
            stmt.setString(5, item.getNome_grupo());
            stmt.setString(6, item.getValor_venda());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
    }
    public ResultSet ItensemEstoque(){
        try { 
               Statement stmt = connection.createStatement();
               // old String sql = "SELECT  itens.id_item, itens.nome_item, itens.valor_venda, grupo_item.nome_grupo FROM public.itens, public.grupo_item WHERE itens.id_grupo = grupo_item.id_grupo AND id_status_item = '1' Order By id_item ASC;";
               String sql = "SELECT itens.nome_item, grupo_item.nome_grupo,itens.valor_venda, count(*) as total FROM public.itens, public.grupo_item WHERE id_status_item = '1' AND itens.id_grupo = grupo_item.id_grupo group by itens.nome_item,itens.valor_venda, grupo_item.nome_grupo ORDER BY itens.nome_item ASC";
               itens = stmt.executeQuery(sql); 
               connection.close();
           } catch (Exception u) {    
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar itens: "+u);      
           }        return itens;  
    }  
    public ResultSet ItensDisponiveis(){
        try { 
               Statement stmt = connection.createStatement();
               String sql = "SELECT itens.id_item, itens.valor_compra, itens.nome_item, grupo_item.nome_grupo, status_item.nome_status_item FROM public.itens,  public.grupo_item, public.status_item WHERE grupo_item.id_grupo = itens.id_grupo AND status_item.id_status_item = itens.id_status_item AND itens.id_status_item = '1' ORDER BY itens.id_item ASC;";
               itens = stmt.executeQuery(sql);   
               connection.close();
           } catch (Exception u) {    
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar itens: "+u);      
           }        return itens;  
    } 
        public ResultSet ItensReservados(){
        String sql = "SELECT itens.id_item, itens.valor_compra, itens.nome_item, grupo_item.nome_grupo, status_item.nome_status_item FROM public.itens,  public.grupo_item, public.status_item WHERE grupo_item.id_grupo = itens.id_grupo AND status_item.id_status_item = itens.id_status_item AND itens.id_status_item = '2' AND itens.id_usuario = ? ORDER BY itens.id_item ASC;";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, login.idusuariologado);            
            stmt.execute();
            outrositens = stmt.executeQuery();
            connection.close();
                        
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
        return outrositens;
                   
    } 
       public ResultSet ItensUtilizados(){
        String sql = "SELECT itens.id_item, itens.valor_compra, itens.nome_item, grupo_item.nome_grupo, status_item.nome_status_item FROM public.itens,  public.grupo_item, public.status_item WHERE grupo_item.id_grupo = itens.id_grupo AND status_item.id_status_item = itens.id_status_item AND itens.id_status_item = '3' AND itens.id_ocorrencia = ? ORDER BY itens.id_item ASC;";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, Long.parseLong(gui.MostraChamados.numeroos));            
            stmt.execute();
            outrositens = stmt.executeQuery();
            connection.close();
                        
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
        return outrositens;
                   
    }     
      public ResultSet ItensResUtil(){
        String sql = "SELECT itens.id_item,itens.valor_compra, itens.nome_item, grupo_item.nome_grupo, status_item.nome_status_item, itens.valor_venda FROM public.itens,  public.grupo_item, public.status_item WHERE grupo_item.id_grupo = itens.id_grupo AND status_item.id_status_item = itens.id_status_item AND itens.id_status_item = '3' AND itens.id_ocorrencia = ? OR  status_item.id_status_item = itens.id_status_item AND grupo_item.id_grupo = itens.id_grupo AND itens.id_status_item = '2' ORDER BY itens.id_item ASC;";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, Long.parseLong(gui.MostraChamados.numeroos));            
            stmt.execute();
            outrositens = stmt.executeQuery();
            connection.close();
                        
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
        return outrositens;
                   
    }  
          public ResultSet ItensResUtilf(Item item){
        String sql = "SELECT itens.id_item,itens.valor_compra, itens.nome_item, grupo_item.nome_grupo, status_item.nome_status_item, itens.valor_venda FROM public.itens,  public.grupo_item, public.status_item WHERE grupo_item.id_grupo = itens.id_grupo AND status_item.id_status_item = itens.id_status_item AND itens.id_status_item = '3' AND itens.id_ocorrencia = ? OR  status_item.id_status_item = itens.id_status_item AND grupo_item.id_grupo = itens.id_grupo AND itens.id_status_item = '2' ORDER BY itens.id_item ASC;";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, item.getId_ocorrencia());            
            stmt.execute();
            outrositens = stmt.executeQuery();
            connection.close();
                        
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
        return outrositens;
                   
    }  
    public void ReservaItem(Item item){
        String sql = "UPDATE itens set (id_status_item,id_usuario) = ('2',?) where id_item = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, item.getId_usuario());
            stmt.setLong(2, item.getId_item());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
    }
    public void LiberaItem(Item item){
        String sql = "UPDATE itens set (id_status_item) = ('1') where id_item = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, item.getId_item());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
    }
    
    public void AtualizaItem(Item item){
        String sql = "UPDATE itens set (id_status_item,data_venda,id_ocorrencia,valor_venda) = ('3',?,?,?) where id_item = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1, item.getData_venda());
            stmt.setLong(2, item.getId_ocorrencia());
            stmt.setString(3, item.getValor_venda());
            stmt.setLong(4, item.getId_item());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar itens: "+u); 
        }
    }
    public void AtualizaItem2(Item item){
        String sql = "UPDATE itens set (id_status_item,data_venda,id_ocorrencia,valor_venda,id_venda) = ('3',?,?,?,?) where id_item = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1, item.getData_venda());
            stmt.setNull(2,java.sql.Types.NULL); 
            stmt.setString(3, item.getValor_venda());
            stmt.setLong(4, item.getId_venda());
            stmt.setLong(5, item.getId_item());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar itens: "+u); 
        }
    }
    
           public ResultSet MostraItensOS(Chamado c){
        String sql = "SELECT itens.id_item, itens.nome_item,itens.valor_compra,itens.valor_venda FROM public.itens,  public.grupo_item, public.status_item WHERE grupo_item.id_grupo = itens.id_grupo AND status_item.id_status_item = itens.id_status_item AND (itens.id_status_item = '3' OR itens.id_status_item = '2') AND itens.id_ocorrencia = ? ORDER BY itens.id_item ASC";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, c.getId_ocorrencia());            
            stmt.execute();
            outrositens = stmt.executeQuery();
            connection.close();
                        
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
        return outrositens;
                   
    }  
           public ResultSet MostraItemNota(NotaFiscal n){
        String sql = "SELECT  itens.id_item,  itens.nome_item,itens.valor_venda FROM public.itens, public.fechamento, public.ocorrencias, public.notafiscal WHERE itens.id_ocorrencia = ocorrencias.id_ocorrencia AND fechamento.id_fechamento = notafiscal.id_fechamento AND ocorrencias.id_fechamento = fechamento.id_fechamento AND notafiscal.id_empresa = ocorrencias.id_empresa AND itens.id_status_item = 3 AND  notafiscal.id_nota = ? ";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, n.getId_nota());            
            stmt.execute();
            outrositens = stmt.executeQuery();
            
                        
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
        return outrositens;
                   
    }
           public ResultSet MostraItemNotaVenda(NotaFiscal n){
        String sql = "SELECT  itens.id_item,  itens.nome_item,itens.valor_venda FROM public.itens, public.notafiscal WHERE itens.id_status_item = 3 AND notafiscal.id_venda = itens.id_venda AND notafiscal.id_nota = ? ";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, n.getId_nota());            
            stmt.execute();
            outrositens = stmt.executeQuery();
            
                        
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
        return outrositens;
                   
    }
           public Integer ContaItemNota(NotaFiscal n){
               Integer count=0;
               String sql = "select count(*) as total from (SELECT  itens.id_item, itens.valor_venda, itens.nome_item FROM public.itens, public.fechamento, public.ocorrencias, public.notafiscal WHERE itens.id_ocorrencia = ocorrencias.id_ocorrencia AND fechamento.id_fechamento = notafiscal.id_fechamento AND ocorrencias.id_fechamento = fechamento.id_fechamento AND notafiscal.id_empresa = ocorrencias.id_empresa AND itens.id_status_item = 3 AND  notafiscal.id_nota = ?) as cont";
               try {
                   PreparedStatement stmt = connection.prepareStatement(sql);
                   stmt.setLong(1, n.getId_nota());          
                   stmt.execute();
                   outrositens = stmt.executeQuery();
                   outrositens.next();
                   count=(Integer)(outrositens.getInt(1));
                   
               } catch (SQLException u) {
                   d.MensagemErro(1,u);
                   System.out.println(" Erro ao contar itens: "+u);
               }
              
               return count;
           }
           public Integer ContaItemNotaVenda(NotaFiscal n){
               Integer count=0;
               String sql = "select count(*) as total from (SELECT  itens.id_item,  itens.nome_item,itens.valor_venda FROM public.itens, public.notafiscal WHERE itens.id_status_item = 3 AND notafiscal.id_venda = itens.id_venda AND notafiscal.id_nota = ?) as cont";
               try {
                   PreparedStatement stmt = connection.prepareStatement(sql);
                   stmt.setLong(1, n.getId_nota());          
                   stmt.execute();
                   outrositens = stmt.executeQuery();
                   outrositens.next();
                   count=(Integer)(outrositens.getInt(1));
                   
               } catch (SQLException u) {
                   d.MensagemErro(1,u);
                   System.out.println(" Erro ao contar itens: "+u);
               }
              
               return count;
           }
           public void novoItemNota(Item item){
        String sql = "insert into itens_nota (id_nota, id_item,nome_item, quantidade,valor_unitario,valor_total) values (?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, item.getId_venda());
            stmt.setLong(2, item.getId_item());
            stmt.setString(3, item.getNome_item());
            stmt.setLong(4, item.getQuantidade());
            stmt.setString(5, item.getValor_unitario());
            stmt.setString(6, item.getValor_venda());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
    }
           public ResultSet GruposemEstoque(){
               try { 
                   Statement stmt = connection.createStatement();
                   String sql = "SELECT grupo_item.nome_grupo, count(*) FROM public.itens, public.grupo_item WHERE grupo_item.id_grupo = itens.id_grupo AND itens.id_status_item = 1 group by grupo_item.nome_grupo order by nome_grupo ASC";
                   itens = stmt.executeQuery(sql); 
                   connection.close();
               } catch (Exception u) {    
                   d.MensagemErro(1,u);
                   System.out.println(" Erro ao consultar itens: "+u);  
                   }
                    return itens; 
                 
           }

    public ResultSet BuscaTodosItems() {
        String sql = "SELECT itens.id_item, itens.nome_item, itens.valor_venda, itens.valor_compra, itens.garantia, itens.data_venda, ordem_compra.data_compra, status_item.nome_status_item FROM public.itens, public.ordem_compra, public.status_item WHERE ordem_compra.id_ordem_compra = itens.id_ordem_compra AND status_item.id_status_item = itens.id_status_item ORDER BY itens.id_item ASC";
           try { 
               PreparedStatement stmt = connection.prepareStatement(sql);
               stmt.execute();
               itens = stmt.executeQuery();
               connection.close();
             
           } catch (Exception u) {
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar itens: "+u);      
           }                 
           return itens;
    }

    public ResultSet BuscaItemsID(Item item) {
        String sql = "SELECT itens.id_item, itens.nome_item, itens.valor_venda, itens.valor_compra, itens.garantia, itens.data_venda, ordem_compra.data_compra, status_item.nome_status_item FROM public.itens, public.ordem_compra, public.status_item WHERE ordem_compra.id_ordem_compra = itens.id_ordem_compra AND status_item.id_status_item = itens.id_status_item AND itens.id_item = ? ORDER BY itens.id_item ASC";
           try { 
               PreparedStatement stmt = connection.prepareStatement(sql);
               stmt.setLong(1, item.getId_item());
               stmt.execute();
               itens = stmt.executeQuery();
               connection.close();
             
           } catch (Exception u) {
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar itens: "+u);      
           }                 
           return itens;
    }

    public ResultSet BuscaItemsOS(Item item) {
        String sql = "SELECT itens.id_item, itens.nome_item, itens.valor_venda, itens.valor_compra, itens.garantia, itens.data_venda, ordem_compra.data_compra, status_item.nome_status_item FROM public.itens, public.ordem_compra, public.status_item WHERE ordem_compra.id_ordem_compra = itens.id_ordem_compra AND status_item.id_status_item = itens.id_status_item AND itens.id_ordem_compra = ? ORDER BY itens.id_item ASC";
           try { 
               PreparedStatement stmt = connection.prepareStatement(sql);
               stmt.setLong(1, item.getId_item());
               stmt.execute();
               itens = stmt.executeQuery();
               connection.close();
             
           } catch (Exception u) {
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar itens: "+u);      
           }                 
           return itens;
    }

    public ResultSet BuscaItemsOV(Item item) {
        String sql = "SELECT itens.id_item, itens.nome_item, itens.valor_venda, itens.valor_compra, itens.garantia, itens.data_venda, ordem_compra.data_compra, status_item.nome_status_item FROM public.itens, public.ordem_compra, public.status_item WHERE ordem_compra.id_ordem_compra = itens.id_ordem_compra AND status_item.id_status_item = itens.id_status_item AND itens.id_venda = ? ORDER BY itens.id_item ASC";
           try { 
               PreparedStatement stmt = connection.prepareStatement(sql);
               stmt.setLong(1, item.getId_item());
               stmt.execute();
               itens = stmt.executeQuery();
               connection.close();
             
           } catch (Exception u) {
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar itens: "+u);      
           }                 
           return itens;
    }

    public void RemoveItem(Item item) {
        String sql = "UPDATE itens set (id_status_item) = ('5') where id_item = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, item.getId_item());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar itens: "+u); 
        }
    }

    public ResultSet ItensNotaCompra(OrdemCompra oc) {
        String sql = "SELECT itens.nome_item, valor_compra,valor_venda ,count(*),public.grupo_item.nome_grupo FROM public.itens,  public.ordem_compra,  public.grupo_item WHERE itens.id_ordem_compra=? AND itens.id_ordem_compra = ordem_compra.id_ordem_compra AND  itens.id_grupo = grupo_item.id_grupo  Group by  itens.nome_item, valor_compra,valor_venda,public.grupo_item.nome_grupo  ORDER BY nome_item ASC;";
           try { 
               PreparedStatement stmt = connection.prepareStatement(sql);
               stmt.setLong(1, oc.getId_ordemcompra());
               stmt.execute();
               itens = stmt.executeQuery();
               connection.close();
             
           } catch (Exception u) {
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar itens: "+u);      
           }                 
           return itens;
    }

    public OrdemCompra NotaItem(Item it) {
        OrdemCompra oc = new OrdemCompra();
        String sql = "SELECT itens.id_ordem_compra,ordem_compra.data_compra,  fornecedores.nome_fornecedor, ordem_compra.valor_total FROM public.itens, public.ordem_compra, public.fornecedores WHERE ordem_compra.id_ordem_compra = itens.id_ordem_compra AND ordem_compra.id_fornecedor = fornecedores.id_fornecedor AND itens.id_item = ?";
           try { 
               PreparedStatement stmt = connection.prepareStatement(sql);
               stmt.setLong(1, it.getId_item());
               stmt.execute();
               ordemcompra = stmt.executeQuery();
               connection.close();
             
           } catch (Exception u) {
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar itens: "+u);      
           }                 
           try {  
            while (ordemcompra.next()){  
             oc.setId_ordemcompra(Long.parseLong(ordemcompra.getString(1)));
             oc.setNome_grupo(ordemcompra.getString(2));
             oc.setNome_fornecedor(ordemcompra.getString(3));
             oc.setValor_total(ordemcompra.getString(4));
                }  
            } catch (SQLException ex) {  
                System.out.println(" Erro ao adicionar linha: "); 
            }
           return oc;
    }

   
}
