/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import dao.EmpresaDAO;
import dao.AreaDAO;
import dao.ChamadoDAO;
import dao.StatusDAO;
import gui.componentes.Dialogos;
import java.awt.CardLayout;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Empresa;
import modelo.Area;
import modelo.Chamado;
import modelo.Status;
import relatorios.VerChamado;
/**
 *
 * @author felipe
 */
public class MostraRelatorios extends javax.swing.JPanel {
    private ResultSet resultado;
    private ResultSet resultado2;
    public static String numeroos;
     public static String clienteos;
     public static String areaos;
     public static String descricaoos;
     public static Long nros; 
    Dialogos d = new Dialogos();
    public MostraRelatorios() {
        initComponents();
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        buttonGroup2.add(jRadioButton1);
        buttonGroup2.add(jRadioButton2);
        buttonGroup2.add(jRadioButton3);
        buttonGroup2.add(jRadioButton4);
        buttonGroup2.add(jRadioButton5);
        buttonGroup2.add(jRadioButton6);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Busca Chamados");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        EmpresaDAO f = new EmpresaDAO();
        resultado=f.ConsultarEmpresa();
        try {
            while (resultado.next()){
                jComboBox1.addItem(resultado.getString(1));
                jComboBox1.updateUI();
            }
        } catch (SQLException ex) {
            System.out.println(" Erro ao consultar empresa: ");
        }

        jButton1.setText("Localizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OS", "Ocorrencia", "Cliente", "Status", "Data Abertura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setAutoCreateRowSorter(true);
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getColumn(0).setResizable(false);

        jButton2.setText("Visualizar Chamado");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jRadioButton1.setText("Buscar todas O.S.");

        jRadioButton2.setText("Buscar todas O.S. do mês atual");

        jRadioButton3.setText("Buscar todas O.S de um mês específico");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setText("Buscar todas O.S de um cliente");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jLabel3.setText("OS: 0 ");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2013", "2014", "2015", "2016", "2017" }));

        jRadioButton5.setText("Buscar todas O.S de um cliente em um mês especifico");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jRadioButton6.setText("Buscar O.S. por número");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jRadioButton6)
                                    .addGap(50, 50, 50)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jRadioButton5)
                                .addComponent(jLabel1)
                                .addComponent(jRadioButton1)
                                .addComponent(jRadioButton2)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jRadioButton3)
                                    .addGap(29, 29, 29)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jRadioButton4)
                                    .addGap(57, 57, 57)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton2)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton6)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel3))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ChamadoDAO f = new ChamadoDAO(); 
        Chamado chamado = new Chamado();
        DefaultTableModel modelo2 = (DefaultTableModel) jTable2.getModel();
        if (jRadioButton1.isSelected() ==false &&  jRadioButton2.isSelected() ==false && jRadioButton3.isSelected()  ==false && jRadioButton4.isSelected() ==false && jRadioButton5.isSelected() ==false && jRadioButton6.isSelected() ==false) {
            d.MensagemErro(13);
        }else {
            if (jRadioButton1.isSelected()){
                resultado=f.BuscaTodasOS();
            }
            if (jRadioButton2.isSelected()){
                SimpleDateFormat formatter = new SimpleDateFormat( "yyyy" );  
                String ano = formatter.format( new java.util.Date() );    
                SimpleDateFormat fmt = new SimpleDateFormat( "MM" );  
                String mes = fmt.format( new java.util.Date() );   
                chamado.setMes(mes);
                chamado.setAno(ano);
                resultado=f.BuscaOSMes(chamado);
            }
            if (jRadioButton3.isSelected()){
               chamado.setMes(jComboBox2.getSelectedItem().toString());
               chamado.setAno(jComboBox3.getSelectedItem().toString());
               resultado=f.BuscaOSMes(chamado);
               
            }
            if (jRadioButton4.isSelected()){
              chamado.setNome_empresa(jComboBox1.getSelectedItem().toString());
              resultado=f.BuscaOSCliente(chamado);
            } 
            if (jRadioButton5.isSelected()){
              chamado.setMes(jComboBox2.getSelectedItem().toString());
              chamado.setAno(jComboBox3.getSelectedItem().toString());
              chamado.setNome_empresa(jComboBox1.getSelectedItem().toString());
               resultado=f.BuscaOSMesCliente(chamado);
            } 
            if (jRadioButton6.isSelected()){
              chamado.setId_ocorrencia(Long.parseLong(jTextField1.getText()));
               resultado=f.BuscaOSNumero(chamado);
            } 
            while (modelo2.getRowCount()>0){
            modelo2.removeRow(0);
            }
            try {  
                while (resultado.next()){  
                    modelo2.addRow(new String [] {resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getString(5)});  
                }  
            } catch (SQLException ex) {  
                System.out.println(" Erro ao adicionar linha: "); 
            }
        
        }
        jLabel3.setText("OS:" + jTable2.getRowCount());

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        Chamado chamados = new Chamado();
        int selectedRowIndex = jTable2.getSelectedRow();
        int selectedColumnIndex = jTable2.getSelectedColumn();
        chamados.setId_ocorrencia(Long.parseLong((String) jTable2.getValueAt(selectedRowIndex, 0)));
        
        try {
            VerChamado relatest= new VerChamado(chamados);
        } catch (IOException ex) {
            Logger.getLogger(ModificaChamado.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
