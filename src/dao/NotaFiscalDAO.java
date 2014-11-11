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
import modelo.Item;
import modelo.NotaFiscal;
import modelo.OrdemCompra;

/**
 *
 * @author felipe
 */
public class NotaFiscalDAO {
    private Connection connection;
     ResultSet resultado;
     Dialogos d = new Dialogos();
    
    public NotaFiscalDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
     public Long GeraNota(NotaFiscal nf){
         Long idnota=null;
         String sql = "insert into notafiscal (id_empresa, id_cfop, data_emissao,data_saida,hora_saida,valor_nota,valor_servicos,id_fechamento,valor_produtos ) values ((select id_empresa from empresa where nome_empresa=?),?,?,?,?,?,?,(select id_fechamento from fechamento where nome_fechamento=?),?)  returning id_nota";
        Date date2 = new Date(0000-00-00) ;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nf.getNome_empresa());
            stmt.setLong(2, nf.getId_cfop());
            stmt.setDate(3, date2.valueOf(nf.getData_emissao()));
            stmt.setDate(4, date2.valueOf(nf.getData_saida()));
            stmt.setString(5, nf.getHora_saida());
            stmt.setString(6, nf.getValor_nota());
            stmt.setString(7, nf.getValor_servicos());
            stmt.setString(8, nf.getNome_fechamento());
            stmt.setString(9, nf.getValor_produtos());
            resultado = stmt.executeQuery();  
            connection.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            System.out.println(" Erro ao gerar nota "+u);
        }
        try {  
            while (resultado.next()){  
                idnota=(resultado.getLong(1));  
            } 
        } catch (SQLException u) {  
            d.MensagemErro(1,u);
            System.out.println(" Erro ao retornar id_nota "); 
        }
        return idnota;     
        
     }
     
     public Long GeraNotaVenda(NotaFiscal nf){
         Long idnota=null;
         String sql = "insert into notafiscal (id_empresa, id_cfop, data_emissao,data_saida,hora_saida,valor_nota,id_venda ) values ((select id_empresa from empresa where nome_empresa=?),?,?,?,?,?,?)  returning id_nota";
        Date date2 = new Date(0000-00-00) ;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nf.getNome_empresa());
            stmt.setLong(2, nf.getId_cfop());
            stmt.setDate(3, date2.valueOf(nf.getData_emissao()));
            stmt.setDate(4, date2.valueOf(nf.getData_saida()));
            stmt.setString(5, nf.getHora_saida());
            stmt.setString(6, nf.getValor_nota());
            stmt.setLong(7, nf.getId_venda());
            resultado = stmt.executeQuery();  
            connection.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            System.out.println(" Erro ao gerar nota "+u);
        }
        try {  
            while (resultado.next()){  
                idnota=(resultado.getLong(1));  
            } 
        } catch (SQLException u) {  
            d.MensagemErro(1,u);
            System.out.println(" Erro ao retornar id_nota "); 
        }
        return idnota;     
        
     }
     public ResultSet ListaNotaFechamento (Fechamento f){
         
         String sql = "select id_nota from notafiscal where  id_fechamento = (select id_fechamento from fechamento where nome_fechamento = ?)  order by id_nota ASC ";
         try {
             PreparedStatement stmt = connection.prepareStatement(sql);
             stmt.setString(1, f.getNome_fechamento());
             resultado = stmt.executeQuery();  
             connection.close();
             
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
        return resultado;
     }
     public void ExisteNota (Fechamento f){
         ResultSet resultado;
         Boolean existe;
         String sql = "SELECT case when exists (select notafiscal.id_nota FROM public.notafiscal, public.empresa, public.fechamento WHERE notafiscal.id_empresa = empresa.id_empresa AND fechamento.id_fechamento = notafiscal.id_fechamento AND  empresa.nome_empresa= ? AND fechamento.nome_fechamento = ?) then 'true' else 'false'  end;";
         try {
             PreparedStatement stmt = connection.prepareStatement(sql);
             stmt.setString(1, f.getNome_empresa());
             stmt.setString(2, f.getNome_fechamento());
             resultado = stmt.executeQuery();  
             resultado.next(); 
             existe=resultado.getBoolean(1);
             stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
            
            
        }
         if (existe==true){
             d.MensagemCuidado(1);
         }
         
     }

    public ResultSet DadosNota(NotaFiscal n) {
        String sql = "SELECT  notafiscal.id_nota,   nf_operacao.nome_operacao,  nf_operacao.cfop,   to_char(notafiscal.data_emissao,'DD/MM/YYYY'), to_char(notafiscal.data_saida,'DD/MM/YYYY'), notafiscal.hora_saida, notafiscal.valor_nota, notafiscal.valor_servicos, notafiscal.valor_produtos, empresa.razaosocial, empresa.rua, empresa.numero, empresa.complemento, empresa.bairro, empresa.cidade,  empresa.telefone,  empresa.cnpj, empresa.cep, empresa.estado, empresa.inscricao_estadual FROM public.notafiscal, public.nf_operacao, public.empresa WHERE notafiscal.id_empresa = empresa.id_empresa AND nf_operacao.id_operacao = notafiscal.id_cfop AND  notafiscal.id_nota= ?;";
         try {
             PreparedStatement stmt = connection.prepareStatement(sql);
             stmt.setLong(1, n.getId_nota());
             resultado = stmt.executeQuery();  
             connection.close();
             
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
        return resultado;
    }

    public ResultSet ParcelasNota(NotaFiscal nf) {
         String sql = "SELECT to_char (parcelamento.data_vencimento,'dd/MM/yyyy'), parcelamento.valor FROM public.parcelamento WHERE parcelamento.id_notafiscal= ?;";
         try {
             PreparedStatement stmt = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             stmt.setLong(1, nf.getId_nota());
             resultado = stmt.executeQuery();  
             connection.close();
             
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
        return resultado;
    }
    
    public ResultSet ItensNota(NotaFiscal nf) {
         String sql = "SELECT itens_nota.id_item, itens_nota.nome_item, itens_nota.quantidade, itens_nota.valor_unitario, itens_nota.valor_total FROM public.itens_nota WHERE itens_nota.id_nota=?";
         try {
             PreparedStatement stmt = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             stmt.setLong(1, nf.getId_nota());
             resultado = stmt.executeQuery();  
             connection.close();
             
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
        return resultado;
    }

    public ResultSet BuscaNotaID(Item item) {
        String sql = "SELECT   notafiscal.id_nota,   notafiscal.data_emissao, empresa.nome_empresa, notafiscal.valor_nota FROM public.notafiscal, public.empresa, public.itens_nota WHERE empresa.id_empresa = notafiscal.id_empresa AND itens_nota.id_nota = notafiscal.id_nota AND  itens_nota.id_item = ? order by notafiscal.id_nota";
         try {
             PreparedStatement stmt = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             stmt.setLong(1, item.getId_item());
             resultado = stmt.executeQuery();  
             connection.close();
             
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
        return resultado;
    }

    public ResultSet BuscaNotaEmpresa(NotaFiscal nf) {
        String sql = "SELECT notafiscal.id_nota, notafiscal.data_emissao, notafiscal.valor_nota, empresa.nome_empresa FROM  public.notafiscal,  public.empresa WHERE   empresa.id_empresa = notafiscal.id_empresa AND  empresa.nome_empresa = ? order by notafiscal.id_nota";
         try {
             PreparedStatement stmt = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             stmt.setString(1, nf.getNome_empresa());
             resultado = stmt.executeQuery();  
             connection.close();
             
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
        return resultado;
    }

    public ResultSet BuscaNotaFechamento(NotaFiscal nf) {
        String sql = "SELECT notafiscal.id_nota, notafiscal.data_emissao, notafiscal.valor_nota, empresa.nome_empresa FROM   public.notafiscal, public.empresa, public.fechamento WHERE notafiscal.id_empresa = empresa.id_empresa AND  fechamento.id_fechamento = notafiscal.id_fechamento  AND fechamento.nome_fechamento = ? order by notafiscal.id_nota";
         try {
             PreparedStatement stmt = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             stmt.setString(1, nf.getNome_fechamento());
             resultado = stmt.executeQuery();  
             connection.close();
             
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
        return resultado;
    }

    public ResultSet BuscaNotaMes(Chamado chamado) {
        String sql = "SELECT notafiscal.id_nota, notafiscal.data_emissao, notafiscal.valor_nota, empresa.nome_empresa FROM   public.notafiscal, public.empresa WHERE notafiscal.id_empresa = empresa.id_empresa AND EXTRACT(month FROM data_emissao) = ? AND EXTRACT(year FROM data_emissao) = ? order by notafiscal.id_nota";
         try {
             PreparedStatement stmt = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             stmt.setLong(1, Long.parseLong(chamado.getMes()));
             stmt.setLong(2, Long.parseLong(chamado.getAno()));
             resultado = stmt.executeQuery();  
             connection.close();
             
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
        return resultado;
    }

    public ResultSet BuscaOrdemCompra(OrdemCompra oc) {
        String sql = "SELECT ordem_compra.id_ordem_compra, ordem_compra.data_compra, fornecedores.nome_fornecedor, ordem_compra.valor_total FROM public.ordem_compra, public.fornecedores WHERE  fornecedores.id_fornecedor = ordem_compra.id_fornecedor AND fornecedores.nome_fornecedor = ? order by ordem_compra.id_ordem_compra";
         try {
             PreparedStatement stmt = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             stmt.setString(1, oc.getNome_fornecedor());
             resultado = stmt.executeQuery();  
             connection.close();
             
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
        return resultado;
    }

    public ResultSet BuscaOCMes(Chamado chamado) {
        String sql = "SELECT ordem_compra.id_ordem_compra, ordem_compra.data_compra, fornecedores.nome_fornecedor, ordem_compra.valor_total FROM public.ordem_compra, public.fornecedores WHERE  fornecedores.id_fornecedor = ordem_compra.id_fornecedor AND EXTRACT(month FROM data_compra) = ? AND EXTRACT(year FROM data_compra) = ? order by ordem_compra.id_ordem_compra";
         try {
             PreparedStatement stmt = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             stmt.setLong(1, Long.parseLong(chamado.getMes()));
             stmt.setLong(2, Long.parseLong(chamado.getAno()));
             resultado = stmt.executeQuery();  
             connection.close();
             
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
        return resultado;
    }

    
}
