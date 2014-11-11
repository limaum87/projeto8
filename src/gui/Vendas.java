/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ItemDAO;
import dao.NotaFiscalDAO;
import dao.ParcelaDAO;
import dao.VendaDAO;
import externo.InvertePontos;
import externo.JMoneyField;
import externo.Money;
import gui.componentes.Tabelas;
import gui.componentes.Combo;
import gui.componentes.Dialogos;
import gui.componentes.Telas;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import javax.swing.DefaultCellEditor;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import modelo.Data;
import modelo.Dinheiro;
import modelo.Fechamento;
import modelo.Item;
import modelo.NotaFiscal;
import modelo.Parcela;
import modelo.Venda;
import org.jdesktop.swingx.renderer.DefaultTableRenderer;
import org.jdesktop.swingx.renderer.FormatStringValue;
import org.jdesktop.swingx.renderer.StringValue;
import org.jdesktop.swingx.table.DatePickerCellEditor;
import relatorios.Imprimenf;

/**
 *
 * @author felipe
 */
public class Vendas extends javax.swing.JPanel {

    /**
     * Creates new form Vendas
     */
    public Vendas() {
        initComponents();
    }

    Dinheiro totallucro = new Dinheiro();
    Dinheiro totalvenda = new Dinheiro();
    Dialogos d = new Dialogos();
    Telas t = new Telas();
    Data dt = new Data();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel1.setText("Vendas");

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });
        ChangeListener changeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent changeEvent) {
                JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
                int index = sourceTabbedPane.getSelectedIndex();
                if (sourceTabbedPane.getSelectedIndex()==1){
                    CalculaTotal();

                }
            }
        };
        jTabbedPane1.addChangeListener(changeListener);

        jLabel2.setText("Empresa:");

        Combo c = new Combo();
        c.ListaEmpresa(jComboBox1);

        jLabel3.setText("Items");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Valor Compra", "Valor Venda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DefaultTableModel modelo2 = (DefaultTableModel) jTable1.getModel();
        Tabelas t = new Tabelas();
        t.ResUtil(modelo2);
        TableColumn clvlrvnd = jTable1.getColumnModel().getColumn(3);
        JTextField text2 = new JMoneyField();
        clvlrvnd.setCellEditor(new DefaultCellEditor(text2));
        jScrollPane3.setViewportView(jTable1);

        jButton4.setText("Remover");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel15.setText("R$ 0,00");

        jLabel17.setText("R$ 0,00");

        jLabel16.setText("Lucro Liquido:");

        jLabel14.setText("Valor Total: ");

        jLabel12.setText("Equipamentos em estoque:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Grupo", "Valor Compra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
        Tabelas t1 = new Tabelas();
        t1.ItensDisponiveis(modelo);
        jScrollPane4.setViewportView(jTable2);

        jButton2.setText("Adicionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(287, 287, 287)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel14))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel17))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Efetuar Compra", jPanel1);

        jLabel59.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        jLabel59.setText("Número de  Parcelas:");

        jButton20.setText("OK");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vencimento", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane12.setViewportView(jTable8);

        jLabel18.setText("Valor Total: ");

        jLabel19.setText("R$ 0,00");

        jButton1.setText("Finalizar Compra");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel59)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton20))
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(364, 364, 364))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addGap(218, 218, 218))
        );

        jTabbedPane1.addTab("Modo de Pagamento", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addGap(89, 89, 89))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Item itema = new Item();
        int selectedRowIndex = jTable1.getSelectedRow();
        itema.setId_item((Long.parseLong((String)jTable1.getValueAt(selectedRowIndex, 0))));
        ItemDAO dao = new ItemDAO();
        dao.LiberaItem(itema);
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel.setRowCount(0);
        Tabelas t = new Tabelas();
        t.ResUtil(tableModel);
        tableModel = (DefaultTableModel) jTable2.getModel();
        tableModel.setRowCount(0);
        t.ItensDisponiveis(tableModel);
        CalculaTotal();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Item items = new Item();
        int selectedRowIndex = jTable2.getSelectedRow();
        items.setId_item((Long.parseLong((String)jTable2.getValueAt(selectedRowIndex, 0))));
        items.setId_usuario(login.getIdusuariologado());
        ItemDAO dao = new ItemDAO();
        dao.ReservaItem(items);
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel.setRowCount(0);
        Tabelas t = new Tabelas();
        t.ResUtil(tableModel);
        tableModel = (DefaultTableModel) jTable2.getModel();
        tableModel.setRowCount(0);
        t.ItensDisponiveis(tableModel);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Long vendaid;
        CalculaTotal();
        int erro = 0;
        int itens = jTable1.getRowCount();
        for (int i = 0, rows = jTable1.getRowCount(); i < rows; i++)  {
            if ((jTable1.getValueAt(i, 0)==null)||(jTable1.getValueAt(i, 1)==null)||(jTable1.getValueAt(i, 2)==null)||(jTable1.getValueAt(i, 3)==null) ){
                erro++;
            }
        }
        if ( erro>0 || itens==0) {
            
            if (erro>0){
                d.MensagemErro(1);
            }
            if (itens==0){
                d.MensagemErro(2);
            }
        }else{
        SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd"); //você pode usar outras máscaras
        java.util.Date y=new java.util.Date();
        String data = sdf1.format(y);
        Date date2 = new Date(0000-00-00);
        SimpleDateFormat ft = new SimpleDateFormat ("hh:mm:ss");
        String hora = ft.format(y);
        Venda v = new Venda();
        VendaDAO vd = new VendaDAO();
        v.setNome_empresa(jComboBox1.getSelectedItem().toString());
        v.setValor_total(totalvenda.getDinheiro());
        v.setLucro_total(totallucro.getDinheiro());
        v.setData_venda(data);
        vendaid=vd.NovaVenda(v);
        Long idnota=null;
        Item item = new Item();
            for (int i = 0, rows = jTable1.getRowCount(); i < rows; i++)  {
                String valorvenda = (String)jTable1.getValueAt(i,3);
                item.setData_venda(date2.valueOf(data));
                item.setId_ocorrencia(null);
                item.setValor_venda(valorvenda);
                item.setId_item((Long.parseLong((String)jTable1.getValueAt(i, 0))));
                item.setId_venda(vendaid);
                item.setStatus_item(3l);
                ItemDAO dao = new ItemDAO();
                dao.AtualizaItem2(item);
                
            }
            NotaFiscal nf = new NotaFiscal();
            NotaFiscalDAO nfdao = new NotaFiscalDAO();
            Parcela p = new Parcela();
            ParcelaDAO pdao = new ParcelaDAO();
            nf.setData_emissao(data);
            nf.setData_saida(data);
            nf.setHora_saida(hora);
            nf.setId_cfop(2l);
            nf.setNome_empresa(jComboBox1.getSelectedItem().toString());
            nf.setValor_nota(totalvenda.getDinheiro());
            nf.setId_venda(vendaid);
            idnota=nfdao.GeraNotaVenda(nf);
            
            for (int i = 0, rows = jTable8.getRowCount(); i < rows; i++)  { 
                p.setId_notafiscal(idnota);
                p.setValor(jTable8.getValueAt(i,1).toString());
                
                
                SimpleDateFormat sv1 = new SimpleDateFormat("dd/MM/yyyy");
                TableColumn dateColumn = jTable8.getColumnModel().getColumn(0);
                DatePickerCellEditor a = new DatePickerCellEditor();
                a.setFormats(sv1);
                dateColumn.setCellEditor(a);
                java.util.Date b= a.getCellEditorValue();
                String dateAsString = jTable8.getValueAt(i,0).toString();
                dt.RetornaData(dateAsString);
                p.setData_vencimento(dt.getData());
                pdao.NovaParcela(p);
            }

            nf.setId_nota(idnota);
            GeraItensNota(nf);
            Imprimenf relatest= new Imprimenf(nf);
            t.TelaInicio();            
        
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        Fechamento fs1 = new Fechamento();
        Dinheiro tot = new Dinheiro();
        SimpleDateFormat sv1 = new SimpleDateFormat("dd/MM/yyyy");
        TableColumn dateColumn = jTable8.getColumnModel().getColumn(0);
        DatePickerCellEditor a = new DatePickerCellEditor();
        a.setFormats(sv1);
        dateColumn.setCellEditor(a);
        tot.setDinheiro(totalvenda.getDinheiro());
        StringValue sv = new FormatStringValue(new SimpleDateFormat("dd/MM/yyyy"));
        TableCellRenderer r = new DefaultTableRenderer(sv);
        dateColumn.setCellRenderer(r);
        java.util.Date b = a.getCellEditorValue();

        if (jTextField2.getText()==null){
            d.MensagemErro(9);
        } else{
            fs1.setParcelas(jTextField2.getText());
            fs1.setVlr_total(tot);
            CalculaParcelas(fs1);

        }

    }//GEN-LAST:event_jButton20ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
       
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    public void CalculaTotal(){
        Dinheiro valorcompra = new Dinheiro();
        Dinheiro valorvenda = new Dinheiro();
        Dinheiro totalcompra = new Dinheiro();
        totallucro.setDinheiro("0");
        totalvenda.setDinheiro("0");
        totalcompra.setDinheiro("0");
        
        
        for (int i = 0, rows = jTable1.getRowCount(); i < rows; i++)  {  
            valorcompra.setDinheiro((String)jTable1.getValueAt(i,2));
            valorvenda.setDinheiro((String)jTable1.getValueAt(i,3));
            totalvenda=totalvenda.soma(valorvenda);
            totalcompra=totalcompra.soma(valorcompra);
        }   
            totallucro=totallucro.subtrai(totalvenda,totalcompra);
            
            jLabel15.setText(totalvenda.getDinheirosimbolo());
            jLabel19.setText(totalvenda.getDinheirosimbolo());
            jLabel17.setText(totallucro.getDinheirosimbolo()); 
    }
    private void CalculaParcelas(Fechamento fs1){
        DefaultTableModel model1 = (DefaultTableModel) jTable8.getModel();
        Dinheiro valortotal = new Dinheiro();
        Dinheiro valorparcela = new Dinheiro();
        Dinheiro ultimaparcela = new Dinheiro();
        BigDecimal qtdParcelas = new BigDecimal(fs1.getParcelas());
        valortotal=fs1.getVlr_total();
        valorparcela=valortotal.divide(qtdParcelas);
        ultimaparcela=valortotal.dividesobra(qtdParcelas);
        model1.setRowCount(0);
        for (int i = 0, rows = Integer.parseInt(fs1.getParcelas()); i < rows-1; i++){
             
             model1.addRow(new Object[]{"", valorparcela.getDinheiro()});
         }
             model1.addRow(new Object[]{"", ultimaparcela.getDinheiro()});
        
                
    }
    
    private void GeraItensNota(NotaFiscal nf){
        ResultSet itensnota;
        Item it = new Item();
        ItemDAO itd = new ItemDAO();
        itensnota=itd.MostraItemNotaVenda(nf);
        Integer size = 0;
        size= itd.ContaItemNotaVenda(nf);
        size++;
        Item[] grpitem = new Item[size];
        Item[] agrupado = new Item[size];

         
         
       for (Integer j=1; j< size;j++){
           
           try {  
               itensnota.next(); 
               grpitem[j]=new Item();
               grpitem[j].setId_item(Long.parseLong(itensnota.getString(1)));
               grpitem[j].setNome_item(itensnota.getString(2));
               grpitem[j].setValor_venda(itensnota.getString(3));
               
           } catch (SQLException ex) {  
                d.MensagemErro(1, ex);
                System.out.println(" Não foi possivel adicionar item ao array "); 
            }
       }
       
       
       Integer qntagr = 1;
       for (int j=1; j< size;j++){
           int itemigual=0;
           for (int k=1; k< qntagr;k++){
               String a=grpitem[j].getNome_item();
               String b = agrupado[k].getNome_item();  
               String c = grpitem[j].getValor_venda();
               String d = agrupado[k].getValor_venda();
               Boolean igual = a.equals(b);
               Boolean igualpreco = c.equals(d);
               if (igual==true&& igualpreco==true){
                   Integer mu=agrupado[k].getQuantidade();
                   mu++;
                   agrupado[k].setQuantidade(mu);
                   k=qntagr;
                   itemigual++;
                   
               }
           }
           if (itemigual==0){
               agrupado[j]=new Item();
               agrupado[j].setId_item(grpitem[j].getId_item());
               agrupado[j].setNome_item(grpitem[j].getNome_item());
               agrupado[j].setValor_venda(grpitem[j].getValor_venda());
               agrupado[j].setQuantidade(1);
               qntagr++;
           }
       }
       
       for (int j=1; j< qntagr;j++){
           Dinheiro d = new Dinheiro();
           d.setDinheiro(agrupado[j].getValor_venda());
           d=d.multiplica(agrupado[j].getQuantidade());
           agrupado[j].setValor_unitario(agrupado[j].getValor_venda());
           agrupado[j].setValor_venda(d.getDinheiro()); 
           agrupado[j].setId_venda(nf.getId_nota());
           System.out.println("Nota "+agrupado[j].getId_venda()+"Item "+agrupado[j].getNome_item()+" Quantidade:"+agrupado[j].getQuantidade()+" Valor Unitario:"+agrupado[j].getValor_unitario()+" Valor Total:"+agrupado[j].getValor_venda());
           itd.novoItemNota(agrupado[j]);
        }
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable8;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
