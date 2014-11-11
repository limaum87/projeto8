/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import modelo.OrdemCompra;
import modelo.Item;
import dao.FornecedorDAO;
import dao.GrupoItemDAO;
import dao.ItemDAO;
import dao.OrdemCompraDAO;
import externo.JMoneyField;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import externo.Money;
import java.math.BigDecimal;
import java.util.Currency;
import externo.InvertePontos;
import gui.componentes.Dialogos;
import gui.componentes.Telas;
import static gui.home.cards;
import java.awt.CardLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import modelo.Dinheiro;

/**
 *
 * @author felipe
 */
public class CompraItem extends javax.swing.JPanel {

    Dialogos d = new Dialogos();
    Telas t = new Telas();
    public CompraItem() {
        initComponents();
    }
    public Long ofc;
    ResultSet resultado;
    ResultSet resultado2;
    public String tprod;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        jLabel7 = new javax.swing.JLabel();
        jFormattedTextField2 = new JMoneyField();

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel1.setText("Ordem de Compra");

        jLabel2.setText("Fornecedor");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        FornecedorDAO f = new FornecedorDAO();
        resultado=f.ConsultarFornecedor();
        try {
            while (resultado.next()){
                jComboBox1.addItem(resultado.getString(1));
                jComboBox1.updateUI();
            }
        } catch (SQLException ex) {
            System.out.println(" Erro ao consultar empresa: ");
        }

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Quantidade", "Garantia", "Valor Unitario", "Grupo"
            }
        ));
        TableColumn sportColumn = jTable1.getColumnModel().getColumn(2);
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("3 meses");
        comboBox.addItem("6 meses");
        comboBox.addItem("1 ano");
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));

        TableColumn grupos = jTable1.getColumnModel().getColumn(4);
        JComboBox grupoitem = new JComboBox();
        grupos.setCellEditor(new DefaultCellEditor(grupoitem));
        GrupoItemDAO g = new GrupoItemDAO();
        resultado=g.ConsultaGrupo();
        try {
            while (resultado.next()){
                grupoitem.addItem(resultado.getString(1));
                grupoitem.updateUI();
            }
        } catch (SQLException ex) {
            System.out.println(" Erro ao consultar grupo item ");
        }
        TableColumn clvlrun = jTable1.getColumnModel().getColumn(3);
        JTextField text = new JMoneyField();
        clvlrun.setCellEditor(new DefaultCellEditor(text));
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setText("Itens:");

        jLabel4.setText("Data Compra:");

        jLabel5.setText("Valor Total:");

        jLabel6.setText("R$ 0,00");

        jButton1.setText("Finalizar Compra");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        jButton3.setText("-");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jFormattedTextField1.setText("");
        jFormattedTextField1.setValue(new Date());
        Date date = (Date) jFormattedTextField1.getValue();
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Valor Frete:");

        jFormattedTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(225, 225, 225)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton1)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(63, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
      
    public void calculatotal(){
        Currency curr = Currency.getInstance("BRL");       
        Money total = new Money(new BigDecimal("0"),curr);
        BigDecimal frete = new BigDecimal(InvertePontos.convertePonto(jFormattedTextField2.getText()));
        Money vlfrete = new Money (frete,curr);
        
        for (int i = 0, rows = jTable1.getRowCount(); i < rows; i++)  {  
            String preco = (String)jTable1.getValueAt(i,3);
            String quantidade = (String)jTable1.getValueAt(i,1);
            preco=InvertePontos.convertePonto(preco);
            quantidade=InvertePontos.convertePonto(quantidade);
            BigDecimal dinheiro = new BigDecimal(preco);
            Integer qntd = Integer.parseInt(quantidade);
            Money valor = new Money(dinheiro,curr);
            Money valorxqnt = valor.times(qntd);
            total=total.plus(valorxqnt);
            tprod=total.toStringsemSimbolo();
        }   
            total=total.plus(vlfrete);
       
            jLabel6.setText(total.toStringcomSimbolo()); 
    }
    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1PropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int erro = 0;
        int itens = jTable1.getRowCount();
        for (int i = 0, rows = jTable1.getRowCount(); i < rows; i++)  { 
            if ((jTable1.getValueAt(i, 0)==null)||(jTable1.getValueAt(i, 1)==null)||(jTable1.getValueAt(i, 2)==null)||(jTable1.getValueAt(i, 4)==null) ||(jTable1.getValueAt(i, 3)==null) ){
                erro++;
            }
          
        }
        if ((jComboBox1.getSelectedItem().equals("")) ||(jFormattedTextField1.getText().isEmpty()) || itens==0 || erro>0 ) {
            Dialogos d = new Dialogos();
            d.MensagemErro(1);
        }
        else{ 
            calculatotal();    
            SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy"); //você pode usar outras máscaras
            Date data=null;
            try {
                data = sdf1.parse( jFormattedTextField1.getText() );
            } catch (ParseException ex) {
                Logger.getLogger(CompraItem.class.getName()).log(Level.SEVERE, null, ex);
            }
            OrdemCompra oc = new OrdemCompra();
            oc.setNome_fornecedor(jComboBox1.getSelectedItem().toString());
            oc.setData_compra(data);
            oc.setValor_total(tprod);
            oc.setValor_frete(InvertePontos.convertePonto(jFormattedTextField2.getText()));
            OrdemCompraDAO dao = new OrdemCompraDAO();
            
            resultado2=dao.novaOrdemCompra(oc);  
               try {  
                while (resultado2.next()){  
                    ofc=(resultado2.getLong(1));  
                    System.out.println(" id criado: "+ ofc);
                }  
            } catch (SQLException ex) {  
                d.MensagemErro(1, ex);
                System.out.println(" Erro ao retornar id_Ordem_compra "); 
            }
            for (int i = 0, rows = jTable1.getRowCount(); i < rows; i++)  {
                int qua =Integer.parseInt(jTable1.getValueAt(i, 1).toString());
                for (int j = 0; j < qua; j++) {
                                Item novositens = new Item();
                                novositens.setNome_item(jTable1.getValueAt(i, 0).toString());
                                novositens.setGarantia(jTable1.getValueAt(i, 2).toString());
                                novositens.setValor_unitario(jTable1.getValueAt(i, 3).toString());
                                novositens.setValor_venda(CalculaValorVenda(jTable1.getValueAt(i, 3).toString()));
                                novositens.setId_ordemcompra(ofc);
                                novositens.setNome_grupo(jTable1.getValueAt(i, 4).toString());
                                ItemDAO dao2 = new ItemDAO();
                                dao2.novoItem(novositens);        
                                
                            }
            }
            
            
            
            d.MensagemSucesso(16);
            t.TelaInicio();

            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        calculatotal();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(    new Object [][] 
        {null, null, null, null, null}
    );
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int rows ;
        rows = jTable1.getRowCount();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.removeRow(rows-1);
        rows = jTable1.getRowCount();
        calculatotal();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed
        

    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

    private void jFormattedTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField2ActionPerformed

    private String CalculaValorVenda(String vlrcompra) {
        String valorfinal;
        Dinheiro d1 = new Dinheiro();
        d1.setDinheiro(vlrcompra);
        d1=d1.porcento();
        valorfinal=d1.getDinheiro();
        return valorfinal;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    
}
