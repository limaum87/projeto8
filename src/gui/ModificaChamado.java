/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import dao.StatusDAO;
import dao.EmpresaDAO;
import dao.ChamadoDAO;
import dao.AssentamentoDAO;
import dao.ItemDAO;
import dao.TipoDAO;
import externo.InvertePontos;
import externo.JMoneyField;
import externo.Money;
import java.sql.*;
import javax.swing.JOptionPane;
import modelo.Status;
import modelo.Empresa;
import modelo.Chamado;
import gui.MostraChamados;
import gui.componentes.Dialogos;
import gui.componentes.Tabelas;
import gui.componentes.Telas;
import static gui.home.cards;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SpinnerDateModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Assentamento;
import modelo.Item;
import relatorios.VerChamado;
/**
 *
 * @author felipe
 */
public class ModificaChamado extends javax.swing.JPanel {

    ResultSet resultado;
    ResultSet resultado2;
    String vlreq=null;
    String lceq=null;
    
    public ModificaChamado() {
        initComponents();
    }

    Dialogos d = new Dialogos();
    Telas t = new Telas();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jTextField2 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane5.setViewportView(jTextArea3);

        jTextField2.setText("jTextField2");

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jLabel2.setText("ID");

        jTextField1.setText(MostraChamados.numeroos);
        jTextField1.setEditable(false);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        StatusDAO f = new StatusDAO();
        resultado=f.ConsultarStatus();
        try {
            while (resultado.next()){
                jComboBox2.addItem(resultado.getString(1));
                jComboBox2.updateUI();
            }
        } catch (SQLException ex) {
            System.out.println(" Erro ao consultar empresa: ");
        }
        if (MostraChamados.flag==1){
            jComboBox2.setSelectedItem("Finalizado");
        }
        else {
            jComboBox2.setSelectedItem("Em Atendimento");
        }
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Status");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icones/printers-&-Faxes32.png"))); // NOI18N
        jButton3.setToolTipText("Imprimir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextArea1.setText(MostraChamados.descricaoos);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel5.setText("Descrição");

        jLabel3.setText("Cliente");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        EmpresaDAO g = new EmpresaDAO();
        resultado=g.ConsultarEmpresa();
        try {
            while (resultado.next()){
                jComboBox1.addItem(resultado.getString(1));
                jComboBox1.updateUI();
            }
        } catch (SQLException ex) {
            System.out.println(" Erro ao consultar empresa: ");
        }
        jComboBox1.setSelectedItem(MostraChamados.clienteos);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Solução");

        jTextArea2.setText(MostraChamados.solucaoos);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel7.setText("Tempo:");

        jLabel9.setText("Horas");

        SpinnerDateModel model = new SpinnerDateModel();

        jLabel10.setText("Minutos");

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        TipoDAO h = new TipoDAO();
        resultado=h.ConsultarTipo();
        try {
            while (resultado.next()){
                jComboBox3.addItem(resultado.getString(1));
                jComboBox3.updateUI();
            }
        } catch (SQLException ex) {
            System.out.println(" Erro ao consultar empresa: ");
        }

        jLabel8.setText("Tipo de Chamado:");

        jCheckBox1.setText("Pago");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(21, 21, 21)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTextField1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .add(114, 114, 114)
                .add(jLabel4)
                .add(36, 36, 36)
                .add(jComboBox2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 178, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(46, 46, 46)
                .add(jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(59, 59, 59))
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(jLabel6)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                            .add(jLabel3)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                            .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 136, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(235, 235, 235))
                        .add(jScrollPane2)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 427, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jLabel5))
                    .add(jLabel7)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jSpinner1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(jLabel9)
                        .add(18, 18, 18)
                        .add(jSpinner2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 51, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel10)
                        .add(82, 82, 82)
                        .add(jCheckBox1))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(102, 102, 102)
                        .add(jButton1))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel8)
                        .add(28, 28, 28)
                        .add(jComboBox3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 143, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(24, 24, 24)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel2)
                        .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jLabel4)
                        .add(jComboBox2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jLabel5)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel6)
                .add(18, 18, 18)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jLabel7)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jSpinner1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jSpinner2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel9)
                    .add(jLabel10)
                    .add(jCheckBox1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel8)
                    .add(jComboBox3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Chamado", jPanel1);

        jLabel11.setText("Equipamentos utilizados:");

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

        TableColumn sportColumn = jTable1.getColumnModel().getColumn(3);
        JTextField text = new JMoneyField();
        sportColumn.setCellEditor(new DefaultCellEditor(text));
        TableColumn clvlrvnd = jTable1.getColumnModel().getColumn(2);
        JTextField text2 = new JMoneyField();
        clvlrvnd.setCellEditor(new DefaultCellEditor(text2));
        jScrollPane3.setViewportView(jTable1);

        jButton2.setText("Adicionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Remover");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Salvar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

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
        jTable2.setAutoCreateRowSorter(true);
        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
        Tabelas t1 = new Tabelas();
        t1.ItensDisponiveis(modelo);
        jScrollPane4.setViewportView(jTable2);

        jLabel12.setText("Equipamentos em estoque:");

        jLabel13.setText("Pesquisa:");

        jLabel14.setText("Valor Total: ");

        jLabel15.setText("R$ 0,00");

        jLabel16.setText("Lucro Liquido:");

        jLabel17.setText("R$ 0,00");

        jButton6.setText("Pesquisar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 441, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jPanel2Layout.createSequentialGroup()
                                    .add(jLabel11)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(jButton5))))
                        .add(jPanel2Layout.createSequentialGroup()
                            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(jPanel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .add(jLabel16))
                                .add(jPanel2Layout.createSequentialGroup()
                                    .add(72, 72, 72)
                                    .add(jButton4)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(jLabel14)))
                            .add(18, 18, 18)
                            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jLabel15)
                                .add(jLabel17))))
                    .add(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel12)
                            .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 441, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jLabel13)
                                .add(18, 18, 18)
                                .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 192, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(jButton6))
                            .add(jButton2))))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel11)
                    .add(jButton5))
                .add(18, 18, 18)
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 138, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton4)
                    .add(jLabel14)
                    .add(jLabel15))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel16)
                    .add(jLabel17))
                .add(11, 11, 11)
                .add(jLabel12)
                .add(19, 19, 19)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel13)
                    .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton6))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 138, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jButton2)
                .add(129, 129, 129))
        );

        jTabbedPane1.addTab("Equipamentos", jPanel2);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Editar Chamado");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 618, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTabbedPane1)
                .add(3, 3, 3))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
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
            Chamado c = new Chamado();
            ChamadoDAO cdao = new ChamadoDAO();
            c.setValor_equipamentos(vlreq);
            c.setLucro_equipamentos(lceq);
            c.setId_ocorrencia(Long.parseLong(MostraChamados.numeroos));
            cdao.ValoresChamado(c);
            }
            
        }else{
            SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd"); //você pode usar outras máscaras
            java.util.Date y=new java.util.Date();
            Date date2 = new Date(0000-00-00);
            String data = sdf1.format(y);
            Item item = new Item();
            for (int i = 0, rows = jTable1.getRowCount(); i < rows; i++)  {
                String valorvenda = (String)jTable1.getValueAt(i,3);
                item.setData_venda(date2.valueOf(data));
                item.setId_ocorrencia(Long.parseLong(MostraChamados.numeroos));
                item.setValor_venda(valorvenda);
                item.setId_item((Long.parseLong((String)jTable1.getValueAt(i, 0))));
                item.setStatus_item(3l);
                ItemDAO dao = new ItemDAO();
                dao.AtualizaItem(item);
            }
            calculatotal();
            Chamado c = new Chamado();
            ChamadoDAO cdao = new ChamadoDAO();
            c.setValor_equipamentos(vlreq);
            c.setLucro_equipamentos(lceq);
            c.setId_ocorrencia(Long.parseLong(MostraChamados.numeroos));
            cdao.ValoresChamado(c);
            
            jButton1ActionPerformed(evt);          
            t.TelaInicio();

        }

    }//GEN-LAST:event_jButton5ActionPerformed

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
        
        calculatotal();
        Chamado c = new Chamado();
        ChamadoDAO cdao = new ChamadoDAO();
        c.setValor_equipamentos(vlreq);
        c.setLucro_equipamentos(lceq);
        c.setId_ocorrencia(Long.parseLong(MostraChamados.numeroos));
        cdao.ValoresChamado(c);
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
        Chamado chamados = new Chamado();
        Dialogos d = new Dialogos();
        chamados.setId_ocorrencia(Long.parseLong(jTextField1.getText()));
        chamados.setOcorrencia(jTextArea1.getText());
        chamados.setNome_empresa(jComboBox1.getSelectedItem().toString());
        chamados.setNome_status(jComboBox2.getSelectedItem().toString());
        chamados.setSolucao(jTextArea2.getText());
        chamados.setId_usuario(login.idusuariologado);
        Integer valora,valorb;
        Float total;
        BigDecimal totalt;
        String tt,desl;
        //Assentamento assentamentos = new Assentamento();
        //assentamentos.setId_ocorrencia(Long.parseLong(jTextField1.getText()));
        //assentamentos.setAssentamento(jTextArea2.getText());
        if ((jTextArea1.getText().isEmpty() ||jTextArea2.getText().isEmpty() ) ) {
            d.MensagemErro(1);
        }
        else {
            if ((chamados.getNome_status().equals("Finalizado"))){
                if ((jSpinner1.getValue().equals("0") ||jComboBox3.getSelectedItem().equals(""))){
                    d.MensagemErro(3);
                }
                else{
                    chamados.setNome_tipo(jComboBox3.getSelectedItem().toString());
                    valora=(Integer)jSpinner1.getValue();
                    valorb=(Integer)jSpinner2.getValue();
                    total= (float)valora + (float)(valorb/60);
                    chamados.setValor(total);
                    ChamadoDAO dao = new ChamadoDAO();
                    try {
                        tt=dao.ValorChamado(chamados);
                        desl=dao.ValorDeslocamento(chamados);
                        
                        chamados.setValor_total(InvertePontos.converteVirgula(tt));
                        chamados.setValor_deslocamento(InvertePontos.converteVirgula(desl));
                    } catch (SQLException ex) {
                        d.MensagemErro(1, ex);
                    }
                    chamados.setPago(jCheckBox1.isSelected());
                    dao.AlteraChamado(chamados);
                    d.MensagemSucesso(2);
                    t.TelaInicio();

                }

            }
            else{
                ChamadoDAO dao = new ChamadoDAO();
                dao.AlteraChamado(chamados);
                d.MensagemSucesso(2);
                t.TelaInicio();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Chamado chamados = new Chamado();
        chamados.setId_ocorrencia(Long.parseLong(jTextField1.getText()));
        String idos = jTextField1.getText();
        try {
            VerChamado relatest= new VerChamado(chamados);
        } catch (IOException ex) {
            Logger.getLogger(ModificaChamado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();   
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
        jTable2.setRowSorter(sorter);
        String text = jTextField3.getText();
        if (text.length() == 0) {
          sorter.setRowFilter(null);
        } else {
          sorter.setRowFilter(RowFilter.regexFilter(text));
        }
      
    }//GEN-LAST:event_jButton6ActionPerformed
    
    public void calculatotal(){
        Currency curr = Currency.getInstance("BRL");       
        Money total = new Money(new BigDecimal("0"),curr);
        Money total2 = new Money(new BigDecimal("0"),curr);
        String tprod;
        
        for (int i = 0, rows = jTable1.getRowCount(); i < rows; i++)  {  
            String preco = (String)jTable1.getValueAt(i,3);
            String custo = (String)jTable1.getValueAt(i,2);
            preco=InvertePontos.convertePonto(preco);
            custo=InvertePontos.convertePonto(custo);   
            BigDecimal dinheiro2 = new BigDecimal(custo);
            BigDecimal dinheiro = new BigDecimal(preco);
            Money valor = new Money(dinheiro,curr);
            Money valor2 = new Money(dinheiro2,curr);
            total=total.plus(valor);
            total2=total2.plus(valor2);
            tprod=total.toStringsemSimbolo();
        }   
            total2=total.minus(total2);
            
            vlreq= total.toStringsemSimbolo();
            lceq=total2.toStringsemSimbolo();
            vlreq=InvertePontos.converteVirgula(vlreq);
            lceq=InvertePontos.converteVirgula(lceq);
       
            jLabel15.setText(vlreq); 
            jLabel17.setText(lceq); 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
