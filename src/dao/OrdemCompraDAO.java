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
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.OrdemCompra;


/**
 *
 * @author felipe
 */
public class OrdemCompraDAO {
    private final Connection connection;
    Dialogos d = new Dialogos();
    ResultSet resultado;
    
    public OrdemCompraDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public ResultSet novaOrdemCompra(OrdemCompra oc){
        String sql = "insert into ordem_compra (data_compra, id_fornecedor, valor_total,valor_frete,status) values (?,(select id_fornecedor from fornecedores where nome_fornecedor=?),?,?,'1')  returning id_ordem_compra";
        SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd"); //você pode usar outras máscaras
        java.util.Date y=oc.getData_compra();
        java.sql.Date date2 = new java.sql.Date(0000-00-00);
        String data = sdf1.format(y);
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1,  date2.valueOf(data));
            stmt.setString(2, oc.getNome_fornecedor());
            stmt.setString(3, oc.getValor_total());
            stmt.setString(4, oc.getValor_frete());
            resultado = stmt.executeQuery();  
            connection.close();
            
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
        return resultado;
        
    }
    public void teste(OrdemCompra oc){
        String sql = " insert into ordem_compra (data_compra, id_fornecedor, valor_total,valor_frete,status) values ('01-02-2012',(select id_fornecedor from fornecedores where nome_fornecedor=?),?,?,'1')";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, oc.getNome_fornecedor());
            stmt.setString(2, oc.getValor_total());
            stmt.setString(3, oc.getValor_frete());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
    }
}
