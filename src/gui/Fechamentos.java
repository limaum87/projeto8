
package gui;

import dao.ChamadoDAO;
import dao.EmpresaDAO;
import dao.FechamentoDAO;
import dao.ItemDAO;
import dao.MensalidadeDAO;
import dao.NfOperacaoDAO;
import dao.NotaFiscalDAO;
import dao.PagamentoPFDAO;
import dao.ParcelaDAO;
import dao.VendaDAO;
import externo.DateCellRenderer;
import externo.InvertePontos;
import externo.JMoneyField;
import externo.Money;
import gui.componentes.Tabelas;
import gui.componentes.Dialogos;
import gui.componentes.Combo;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import modelo.Fechamento;
import modelo.Chamado;
import modelo.Dinheiro;
import modelo.Item;
import gui.componentes.BoletoBancario;
import static gui.home.cards;
import java.awt.CardLayout;
import java.io.FileWriter;
import java.math.RoundingMode;
import java.sql.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import modelo.Data;
import modelo.Empresa;
import modelo.NfOperacao;
import modelo.NotaFiscal;
import modelo.PagamentoPF;
import modelo.Parcela;
import modelo.Venda;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.renderer.DefaultTableRenderer;
import org.jdesktop.swingx.renderer.FormatStringValue;
import org.jdesktop.swingx.renderer.StringValue;
import org.jdesktop.swingx.table.DatePickerCellEditor;
import relatorios.Etiquetas;
import relatorios.ImprimeMensalidades;
import relatorios.Imprimenf;
import relatorios.MultiplosChamados;
import relatorios.Notatexto;
import relatorios.VerChamado;





public class Fechamentos extends javax.swing.JPanel {

    int sda=3;
    String fechamento;
    String teste2;
    
    public Fechamentos() {
        initComponents();
    }
        
        Dialogos d = new Dialogos();
        String vlreq,lceq;
        Dinheiro mensalidades = new Dinheiro();
        Dinheiro deslocamento = new Dinheiro();
        Dinheiro servico = new Dinheiro();
        Dinheiro pecas = new Dinheiro();
        Dinheiro lucropc = new Dinheiro();
        Dinheiro total_os = new Dinheiro();
        Dinheiro sm_deslocamento = new Dinheiro();
        Dinheiro sm_servico = new Dinheiro();
        Dinheiro sm_pecas = new Dinheiro();
        Dinheiro sm_lucropc = new Dinheiro();
        Dinheiro sm_total_os = new Dinheiro();
        Dinheiro total_srv = new Dinheiro();
        Dinheiro total_liq = new Dinheiro();
        Dinheiro total_bru = new Dinheiro();
        Dinheiro sm_deslocamentoe = new Dinheiro();
        Dinheiro sm_servicoe = new Dinheiro();
        Dinheiro sm_pecase = new Dinheiro();
        Dinheiro total_brue = new Dinheiro();
        Dinheiro totalovlucro = new Dinheiro();
        Dinheiro totalovbruto = new Dinheiro();
        Dinheiro total_servmens = new Dinheiro();
        Fechamento fs1 = new Fechamento();
        Data dt = new Data();
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jLabel57 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jButton21 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jButton20 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jButton25 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jLabel7.setText("jLabel7");

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel1.setText("Fechamentos");

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
                    Combo c = new Combo();
                    c.ListaFechamentos(jComboBox1);
                }
                if (sourceTabbedPane.getSelectedIndex()==5){
                    Combo c = new Combo();
                    c.ListaEmpresaFechamento(jComboBox3,fs1);
                }
                if (sourceTabbedPane.getSelectedIndex()==6){
                    DefaultTableModel modelo = (DefaultTableModel) jTable8.getModel();
                    modelo.setRowCount(0);
                    jTextField2.setText("");

                }
                if (sourceTabbedPane.getSelectedIndex()==9){
                    Combo c = new Combo();
                    c.ListaFechamentos(jComboBox2);
                }
                if (sourceTabbedPane.getSelectedIndex()==7){
                    Combo c = new Combo();
                    c.ListaNotaFechamento(jComboBox6, fs1);
                }

                if (sourceTabbedPane.getSelectedIndex()==8){
                    DefaultTableModel modelo = (DefaultTableModel) jTable11.getModel();
                    modelo.setRowCount(0);
                    Tabelas t = new Tabelas();
                    Fechamento s = new Fechamento();
                    s.setNome_fechamento(fechamento);
                    t.EmpresasFechamento(modelo,s);
                }
            }

        };
        jTabbedPane1.addChangeListener(changeListener);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jButton1.setText("Remover");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OS", "Empresa", "Problema", "Data de Abertura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoCreateRowSorter(true);
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setText("Selecione as OS");

        jLabel2.setText("Nome Fechamento:");

        jButton2.setText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Carregar OS e OV");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel25.setText("Mes de Referência:");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        jLabel57.setText("Selecione as OV");

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OV", "Empresa", "Valor", "Data de Abertura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane13.setViewportView(jTable9);

        jButton21.setText("Remover");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(29, 29, 29)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel25))
                                    .addComponent(jButton3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addContainerGap(558, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel57)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 13, Short.MAX_VALUE)
                .addComponent(jButton2))
        );

        jTabbedPane1.addTab("Novo", jPanel1);

        jPanel3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel3FocusGained(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OS", "Cliente", "Problema", "Tempo", "Tipo Atendimento", "Serviços", "Deslocamento", "Equipamentos", "Lucro Equipamentos", "Total Atendimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setAutoCreateRowSorter(true);
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getColumn(0).setResizable(false);
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(8);
        jTable2.getColumnModel().getColumn(3).setResizable(false);
        jTable2.getColumnModel().getColumn(3).setPreferredWidth(8);
        jTable2.getColumnModel().getColumn(5).setPreferredWidth(20);
        jTable2.getColumnModel().getColumn(6).setPreferredWidth(20);
        jTable2.getColumnModel().getColumn(7).setPreferredWidth(20);
        jTable2.getColumnModel().getColumn(8).setPreferredWidth(20);

        jPanel7.setPreferredSize(new java.awt.Dimension(800, 300));

        jLabel12.setText("OS");

        jLabel13.setText("Cliente");

        jLabel14.setText("Tipo de Atendimento");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane7.setViewportView(jTextArea3);

        jLabel15.setText("Problema");

        jLabel16.setText("Solução");

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane8.setViewportView(jTextArea4);

        jLabel17.setText("Tempo:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel13)
                        .addGap(36, 36, 36)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel7);

        jTabbedPane2.addTab("Ordem de Serviço", jScrollPane4);

        jButton9.setText("Salvar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable5.setAutoCreateRowSorter(true);
        jScrollPane6.setViewportView(jTable5);

        jLabel29.setText("Adicionar Equipamento:");

        jButton10.setText("Adicionar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Remover Item");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton11)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jButton9)
                        .addGap(257, 257, 257))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jButton10)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton10)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jScrollPane10.setViewportView(jPanel12);

        jTabbedPane2.addTab("Equipamentos", jScrollPane10);

        jLabel4.setText("Selecione o Fechamento:");

        jButton5.setText("OK");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setText("Visualizar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Salvar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addGap(902, 902, 902))
                            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 136, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4)
                        .addGap(35, 35, 35)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8)
                        .addGap(16, 16, 16)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton8)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addGap(28, 28, 28)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Modificar", jPanel3);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Serviço", "Valor"
            }
        ));
        jTable4.setAutoCreateRowSorter(true);
        jScrollPane5.setViewportView(jTable4);

        jLabel26.setText("Mensalidades:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addContainerGap(518, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(410, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mensalidades", jPanel11);

        jLabel73.setText("Ordens de Venda");

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Cliente", "Valor Liquido", "Valor Bruto"
            }
        ));
        jTable10.setAutoCreateRowSorter(true);
        jScrollPane14.setViewportView(jTable10);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel73)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(518, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel73)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(455, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ordens Venda", jPanel14);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Serviços"));

        jLabel5.setText("Total Serviços:");

        jLabel8.setText("Total Deslocamentos:");

        jLabel9.setText("Total Mensalidades:");

        jLabel10.setText("Total Serviços:");

        jLabel23.setText("R$ 0,00");

        jLabel24.setText("R$ 0,00");

        jLabel31.setText("R$ 0,00");

        jLabel32.setText("R$ 0,00");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel32))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(jLabel24))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel31)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel24))
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel31))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel32))
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Vendas"));

        jLabel11.setText("Total Lucro Vendas :");

        jLabel18.setText("Total Bruto Vendas :");

        jLabel33.setText("R$ 0,00");

        jLabel34.setText("R$ 0,00");

        jLabel58.setText("Vendas Diretas (OV)");

        jLabel68.setText("Vendas  (OS)");

        jLabel69.setText("Total Bruto Vendas :");

        jLabel70.setText("R$ 0,00");

        jLabel71.setText("R$ 0,00");

        jLabel72.setText("Total Lucro Vendas :");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel18))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58)
                            .addComponent(jLabel68)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel72)
                                    .addComponent(jLabel69))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel71)
                                    .addComponent(jLabel70, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel68)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel34))
                .addGap(20, 20, 20)
                .addComponent(jLabel58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(jLabel71))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(jLabel70))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Total"));

        jLabel20.setText("Total Fechamento Liquido:");

        jLabel19.setText("Total Fechamento Bruto:");

        jLabel35.setText("R$ 0,00");

        jLabel36.setText("R$ 0,00");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36))
                .addGap(27, 27, 27))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel36))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(519, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(217, 217, 217))
        );

        jTabbedPane1.addTab("Resumo", jPanel5);

        jLabel21.setText("Seleciona a Empresa:");

        jLabel22.setText("Valor Serviços:");

        jLabel27.setText("Valor Deslocamentos:");

        jLabel28.setText("Valor Peças:");

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jButton12.setText("OK");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Gerar Nota Fiscal");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel30.setText("R$ 0,00");

        jLabel37.setText("R$ 0,00");

        jLabel38.setText("R$ 0,00");

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OS", "Cliente", "Problema", "Tempo", "Tipo Atendimento", "Serviços", "Deslocamento", "Equipamentos", "Lucro Equipamentos", "Total Atendimento", "Pago"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable6.setAutoCreateRowSorter(true);
        jScrollPane9.setViewportView(jTable6);
        jTable6.getColumnModel().getColumn(0).setResizable(false);
        jTable6.getColumnModel().getColumn(0).setPreferredWidth(8);
        jTable6.getColumnModel().getColumn(3).setResizable(false);
        jTable6.getColumnModel().getColumn(3).setPreferredWidth(8);
        jTable6.getColumnModel().getColumn(5).setPreferredWidth(20);
        jTable6.getColumnModel().getColumn(6).setPreferredWidth(20);
        jTable6.getColumnModel().getColumn(7).setPreferredWidth(20);
        jTable6.getColumnModel().getColumn(8).setPreferredWidth(20);
        jTable6.getColumnModel().getColumn(10).setPreferredWidth(8);

        jLabel41.setText("Total:");

        jLabel42.setText("R$ 0,00");

        jLabel43.setText("Mensalidades:");

        jLabel44.setText("Ordens de Serviço:");

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Serviço", "Valor"
            }
        ));
        jTable7.setAutoCreateRowSorter(true);
        jScrollPane11.setViewportView(jTable7);

        jLabel39.setText("Valor Mensalidades:");

        jLabel40.setText("R$ 0,00");

        jButton14.setText("Gerar Boleto");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("Imprimir OS");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Imprimir Mensalidades");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(32, 32, 32)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(jButton12))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel28)
                                            .addComponent(jLabel27)
                                            .addComponent(jLabel22))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel30)
                                            .addComponent(jLabel38)
                                            .addComponent(jLabel37)
                                            .addComponent(jLabel40)))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(159, 159, 159)
                                        .addComponent(jLabel42))
                                    .addComponent(jLabel41)
                                    .addComponent(jLabel43)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel39)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jButton13)
                                        .addGap(25, 25, 25)
                                        .addComponent(jButton14)
                                        .addGap(25, 25, 25)
                                        .addComponent(jButton15)
                                        .addGap(25, 25, 25)
                                        .addComponent(jButton16)))))
                        .addGap(0, 459, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12))
                .addGap(18, 18, 18)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel28))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel38)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(jLabel41))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton13)
                            .addComponent(jButton14)
                            .addComponent(jButton15)
                            .addComponent(jButton16)))
                    .addComponent(jLabel40))
                .addGap(96, 96, 96))
        );

        jTabbedPane1.addTab("Empresa", jPanel9);

        jLabel45.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        jLabel45.setText("Bairro:");

        jLabel46.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        jLabel46.setText("Endereço:");

        jLabel47.setText(" ");

        jLabel48.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        jLabel48.setText("CNPJ/ CPF:");

        jLabel49.setText(" ");

        jLabel50.setText(" ");

        jLabel51.setText(" ");

        jLabel52.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        jLabel52.setText("Empresa:");

        jLabel53.setText(" ");

        jLabel54.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        jLabel54.setText("Razão Social:");

        jLabel55.setText(" ");

        jLabel56.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        jLabel56.setText("Municipio:");

        jLabel59.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        jLabel59.setText("Número de  Parcelas:");

        jLabel60.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        jLabel60.setText("Valor:");

        jLabel61.setText(" ");

        jLabel63.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        jLabel63.setText("Natureza da Operação:");

        jButton17.setText("Imprimir");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel64.setText("Nota Fiscal Saida");

        jLabel65.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        jLabel65.setText("CFOP:");

        jLabel66.setText(" ");

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

        jButton20.setText("OK");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton23.setText("Apenas Pagamento");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel56)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel46)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel54)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel52)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel63)
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel48)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel59)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField2))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel60)
                                        .addGap(54, 54, 54)
                                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jButton20)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jButton17)
                        .addGap(39, 39, 39)
                        .addComponent(jButton23)))
                .addContainerGap(492, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel64)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel63)
                            .addComponent(jLabel65)
                            .addComponent(jLabel66)
                            .addComponent(jLabel61))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel52)
                            .addComponent(jLabel53))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(jLabel50)
                            .addComponent(jLabel48))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(jLabel49)
                            .addComponent(jLabel45)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel47)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(jLabel55))
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17)
                    .addComponent(jButton23))
                .addGap(184, 184, 184))
        );

        jTabbedPane1.addTab("Vencimentos", jPanel4);

        jLabel67.setText("Número da Nota:");

        jButton18.setText("Cancelar Nota");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setText("Visualizar Nota");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton24.setText("Imprimir nota");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel67)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addComponent(jButton19)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton24)
                .addContainerGap(714, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton18)
                    .addComponent(jButton19)
                    .addComponent(jButton24))
                .addContainerGap(624, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ver / Cancela Nota", jPanel13);

        jLabel74.setText("Selecione as empresas que deseja imprimir a etiqueta:");

        jLabel75.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel75.setText("Imprimir Etiquetas");

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Imprimir"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableColumn table = jTable11.getColumnModel().getColumn(1);
        JCheckBox checkbox = new JCheckBox();
        table.setCellEditor(new DefaultCellEditor(checkbox));
        jScrollPane15.setViewportView(jTable11);
        jTable11.getColumnModel().getColumn(0).setResizable(false);
        jTable11.getColumnModel().getColumn(1).setMinWidth(80);
        jTable11.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTable11.getColumnModel().getColumn(1).setMaxWidth(80);

        jButton25.setText("Imprimir");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton25)
                    .addComponent(jLabel75)
                    .addComponent(jLabel74)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(655, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel75)
                .addGap(29, 29, 29)
                .addComponent(jLabel74)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton25)
                .addContainerGap(330, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Etiquetas", jPanel15);

        jLabel6.setText("Selecione o Fechamento:");

        jButton4.setText("Remover Fechamento");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setText("Finalizar Fechamento");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(51, 51, 51)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(754, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(jButton6)
                    .addContainerGap(939, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jButton4)
                .addContainerGap(567, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(135, 135, 135)
                    .addComponent(jButton6)
                    .addContainerGap(562, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Finalizar/ Remover", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jPanel3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel3FocusGained

    }//GEN-LAST:event_jPanel3FocusGained

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Chamado c = new Chamado();
        ChamadoDAO cd = new ChamadoDAO();
        Dialogos d = new Dialogos();
        Integer linha= jTable2.getSelectedRow();
        c.setId_ocorrencia(Long.parseLong(jTable2.getValueAt(linha, 0).toString()));
        c.setValor_total(jTable2.getValueAt(linha, 5).toString());
        c.setValor_deslocamento(jTable2.getValueAt(linha, 6).toString());
        cd.AlteraValores(c);
        d.MensagemSucesso(11);
        jButton5ActionPerformed(evt);
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Chamado c = new Chamado();
        ChamadoDAO cd = new ChamadoDAO();
        Item item = new Item();
        ItemDAO itemdao = new ItemDAO();
        Tabelas t = new Tabelas();
        ResultSet resultado;
        int linha = jTable2.getSelectedRow();
        c.setId_ocorrencia(Long.parseLong(jTable2.getValueAt(linha, 0).toString()));
        resultado=cd.BuscaChamado(c);
        try {
            while (resultado.next()){
                jTextField4.setText(resultado.getString(1));
                jTextField5.setText(resultado.getString(2));
                jTextField7.setText(resultado.getString(3));
                jTextArea3.setText(resultado.getString(4));
                jTextArea4.setText(resultado.getString(5));
                jTextField6.setText(resultado.getString(6));
            }
        } catch (SQLException ex) {
            System.out.println(" Erro ao recuperar Chamado: ");
        }

        DefaultTableModel modelo = (DefaultTableModel) jTable3.getModel();
        modelo.setRowCount(0);
        t.ItensOS(modelo,c);
        TableColumn clvlrun = jTable3.getColumnModel().getColumn(3);
        JTextField text = new JMoneyField();
        clvlrun.setCellEditor(new DefaultCellEditor(text));
        modelo = (DefaultTableModel) jTable5.getModel();    
        modelo.setRowCount(0);
        Tabelas t1 = new Tabelas();
        t1.ItensDisponiveis(modelo);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        Tabelas t = new Tabelas();
        Fechamento fs = new Fechamento();
        FechamentoDAO fd = new FechamentoDAO();
        Combo c = new Combo();
        fechamento=jComboBox1.getSelectedItem().toString();
        fs.setNome_fechamento(jComboBox1.getSelectedItem().toString());
        fs1.setNome_fechamento(jComboBox1.getSelectedItem().toString());
        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
        modelo.setRowCount(0);
        t.OSFechamento(modelo,fs);
        TableColumn clvlrun = jTable2.getColumnModel().getColumn(5);
        JTextField text = new JMoneyField();
        clvlrun.setCellEditor(new DefaultCellEditor(text));
        clvlrun = jTable2.getColumnModel().getColumn(6);
        text = new JMoneyField();
        clvlrun.setCellEditor(new DefaultCellEditor(text));
        DefaultTableModel modelo2 = modelo2= (DefaultTableModel) jTable4.getModel();
        modelo2.setRowCount(0);
        t.MensalidadesFechamento(modelo2,fs);
        DefaultTableModel modelo3= (DefaultTableModel) jTable10.getModel();
        modelo3.setRowCount(0);
        t.OVFechamento(modelo3,fs);
        CalculaFechamento();
        fs.setValor_servicos(sm_servico.getDinheiro());
        fs.setValor_deslocamento(sm_deslocamento.getDinheiro());
        fs.setValor_venda_bruto(sm_pecas.getDinheiro());
        fs.setValor_venda_liquido(sm_lucropc.getDinheiro());
        fs.setValor_mensalidades(mensalidades.getDinheiro());
        fs.setValor_total_servicos(total_srv.getDinheiro());
        fs.setValor_total_liquido(total_liq.getDinheiro());
        fs.setValor_total_bruto(total_bru.getDinheiro());
        fs.setValor_ov_liquido(totalovlucro.getDinheiro());
        fs.setValor_ov_bruto(totalovbruto.getDinheiro());
        fd.ValoresFechamento(fs);
        
        
        

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ChamadoDAO os = new ChamadoDAO();
        os.ChamadosFinalizados();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        Tabelas t = new Tabelas();
        t.OSFinalizadas(modelo);
        DefaultTableModel modelo2 = (DefaultTableModel) jTable9.getModel();
        modelo2.setRowCount(0);
        t.OVFinalizadas(modelo2);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ResultSet resultado;
        FechamentoDAO fd = new FechamentoDAO();
        Fechamento f = new Fechamento();
        Tabelas t = new Tabelas();
        Dialogos d = new Dialogos();
        Chamado c = new Chamado();
        ChamadoDAO cd = new ChamadoDAO();
        Venda v = new Venda();
        VendaDAO vd = new VendaDAO();
        Integer m = null;
        Long nrfch= null;
        Integer nst =1;
        Integer rs =jTable1.getRowCount();
        Integer rv =jTable9.getRowCount();
        if (rs==0||jTextField1.getText().isEmpty())  {
            if (rs==0){
                d.MensagemErro(5);
            }else
            d.MensagemErro(6);
        }
        else{
            String mes = jComboBox5.getSelectedItem().toString();
            m=t.Mesparanumero(mes);
            f.setNome_fechamento(jTextField1.getText());
            f.setMes_referencia(m);
            resultado=fd.NovoFechamento(f);
            try {
                while (resultado.next()){
                    nrfch=(resultado.getLong(1));
                }
            } catch (SQLException ex) {
                System.out.println(" Erro ao retornar id_fechamento ");
            }
            for (int i = 0, rows = jTable1.getRowCount(); i < rows; i++)  {
                c.setId_ocorrencia(Long.parseLong(jTable1.getValueAt(i, 0).toString()));
                c.setId_fechamento(nrfch);
                cd.AssociaFechamento(c);
            }
            if (rs>0){
            for (int i = 0, rows = jTable9.getRowCount(); i < rows; i++)  {
                v.setId_venda(Long.parseLong(jTable9.getValueAt(i, 0).toString()));
                v.setId_fechamento(nrfch);
                vd.AssociaFechamento(v);
            }
            }
            
            d.MensagemSucesso(3);
            jTabbedPane1.setSelectedIndex(1);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();
        modelo.removeRow(selectedRowIndex);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        Item items = new Item();
        int selectedRowIndex = jTable5.getSelectedRow();
        items.setId_item((Long.parseLong((String)jTable5.getValueAt(selectedRowIndex, 0))));
        items.setId_usuario(login.getIdusuariologado());
        ItemDAO dao = new ItemDAO();
        dao.ReservaItem(items);
        DefaultTableModel tableModel = (DefaultTableModel) jTable3.getModel();
        tableModel.setRowCount(0);
        Tabelas t = new Tabelas();
        selectedRowIndex = jTable2.getSelectedRow();
        System.out.println("as"+Long.parseLong((String)jTable2.getValueAt(selectedRowIndex, 0)));
        items.setId_ocorrencia((Long.parseLong((String)jTable2.getValueAt(selectedRowIndex, 0))));
        t.ResUtil(tableModel,items);
        tableModel = (DefaultTableModel) jTable5.getModel();
        tableModel.setRowCount(0);
        t.ItensDisponiveis(tableModel);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int erro = 0;
        int itens = jTable3.getRowCount();
        int selectedRowIndex = jTable2.getSelectedRow();
        for (int i = 0, rows = jTable3.getRowCount(); i < rows; i++)  {
            if ((jTable3.getValueAt(i, 0)==null)||(jTable3.getValueAt(i, 1)==null)||(jTable3.getValueAt(i, 2)==null)||(jTable3.getValueAt(i, 3)==null) ){
                erro++;
            }
        }
        if ( erro>0 || itens==0) {
            
            if (erro>0){
                d.MensagemErro(1);
            }
            if (itens==0){
            CalculaTotal();
            Chamado c = new Chamado();
            ChamadoDAO cdao = new ChamadoDAO();
            c.setValor_equipamentos(vlreq);
            c.setLucro_equipamentos(lceq);
            c.setId_ocorrencia((Long.parseLong((String)jTable2.getValueAt(selectedRowIndex, 0))));
            cdao.ValoresChamado(c);
            jButton5ActionPerformed(evt);  
            }
        }else{
            SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd"); //você pode usar outras máscaras
            java.util.Date y=new java.util.Date();
            Date date2 = new Date(0000-00-00);
            String data = sdf1.format(y);
            Item item = new Item();
            for (int i = 0, rows = jTable3.getRowCount(); i < rows; i++)  {
                String valorvenda = (String)jTable3.getValueAt(i,3);
                item.setData_venda(date2.valueOf(data));
                item.setId_ocorrencia((Long.parseLong((String)jTextField4.getText())));
                item.setValor_venda(valorvenda);
                item.setId_item((Long.parseLong((String)jTable3.getValueAt(i, 0))));
                item.setStatus_item(3l);
                ItemDAO dao = new ItemDAO();
                dao.AtualizaItem(item);
            }
            CalculaTotal();
            Chamado c = new Chamado();
            ChamadoDAO cdao = new ChamadoDAO();
            c.setValor_equipamentos(vlreq);
            c.setLucro_equipamentos(lceq);
            c.setId_ocorrencia((Long.parseLong((String)jTable2.getValueAt(selectedRowIndex, 0))));
            cdao.ValoresChamado(c);
            jButton5ActionPerformed(evt);   
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        Item itema = new Item();
        int selectedRowIndex = jTable3.getSelectedRow();
        itema.setId_item((Long.parseLong((String)jTable3.getValueAt(selectedRowIndex, 0))));
        ItemDAO dao = new ItemDAO();
        dao.LiberaItem(itema);
        DefaultTableModel tableModel = (DefaultTableModel) jTable3.getModel();
        tableModel.setRowCount(0);
        Tabelas t = new Tabelas();
        t.ResUtil(tableModel);
        tableModel = (DefaultTableModel) jTable5.getModel();
        tableModel.setRowCount(0);
        t.ItensDisponiveis(tableModel);
        CalculaTotal();
        Chamado c = new Chamado();
        ChamadoDAO cdao = new ChamadoDAO();
        c.setValor_equipamentos(vlreq);
        c.setLucro_equipamentos(lceq);
        c.setId_ocorrencia(Long.parseLong(MostraChamados.numeroos));
        cdao.ValoresChamado(c);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        Tabelas t = new Tabelas();
        Fechamento fs = new Fechamento();
        FechamentoDAO fd = new FechamentoDAO();
        MensalidadeDAO md = new MensalidadeDAO();
        Combo c = new Combo();
        fs.setNome_empresa(jComboBox3.getSelectedItem().toString());
        fs.setNome_fechamento(fs1.getNome_fechamento());
        DefaultTableModel modelo = (DefaultTableModel) jTable6.getModel();
        modelo.setRowCount(0);
        t.OSEmpresa(modelo,fs);
        DefaultTableModel modelo2 = (DefaultTableModel) jTable7.getModel();
        modelo2.setRowCount(0);
        t.MensalidadesEmpresa(modelo2,fs);
        CalculaFechamentoEmpresa();
        NotaFiscalDAO nf = new NotaFiscalDAO();
        nf.ExisteNota(fs);
        fd.EstaPago(fs);
        md.ExisteMensalidade(fs);
        
        
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        BoletoBancario b = new BoletoBancario();
        b.NovoBoleto();

                
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        int os = jTable6.getRowCount();
        if (os== 0 ){
            d.MensagemErro(8);
        }else{
        Fechamento fs = new Fechamento();
        fs.setNome_empresa(jComboBox3.getSelectedItem().toString());
        fs.setNome_fechamento(fechamento);
            try {
                MultiplosChamados relatest= new MultiplosChamados(fs);
            } catch (IOException ex) {
                d.MensagemErro(1, ex);
                Logger.getLogger(Fechamentos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        Boolean contemitem;
        
        fs1.setNome_empresa(jComboBox3.getSelectedItem().toString());
        fs1.setVlr_total(total_bru);
        fs1.setValor_servicos(total_srv.DinheirosemSimbolo());
        fs1.setValor_venda_bruto(sm_pecas.getDinheiro());
        contemitem=sm_pecas.maiorqzero();
        if (contemitem == true){
            fs1.setTipo_fechamento(2l);
        }else
            fs1.setTipo_fechamento(1l);
        GeraNotafiscal(fs1);
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        Boolean vazio=false; 
        NotaFiscal nf = new NotaFiscal();
        NotaFiscalDAO nfdao = new NotaFiscalDAO();
        Parcela p = new Parcela();
        ParcelaDAO pdao = new ParcelaDAO();
        ResultSet itensnota;
        
        Long idnota=null;
        
        for (int i = 0, rows = jTable8.getRowCount(); i < rows; i++)  { 
            if (jTable8.getValueAt(i,0).toString()==""){
                vazio=true;
            }
        }
        if (vazio==true){
            d.MensagemErro(10);
        }else{
            SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd"); //você pode usar outras máscaras
            java.util.Date y=new java.util.Date();
            java.sql.Date data3 = null;
            String date2;
            Date dNow = new Date(0000-00-00);
            SimpleDateFormat ft = new SimpleDateFormat ("hh:mm:ss");
            String data = sdf1.format(y);
            String hora = ft.format(y);
            
            nf.setData_emissao(data);
            nf.setData_saida(data);
            nf.setHora_saida(hora);
            nf.setId_cfop(fs1.getTipo_fechamento());
            nf.setNome_empresa(fs1.getNome_empresa());
            nf.setValor_nota(fs1.getVlr_total().DinheirosemSimbolo());
            nf.setValor_servicos(fs1.getValor_servicos());
            nf.setValor_produtos(fs1.getValor_venda_bruto());
            nf.setNome_fechamento(fechamento);
            idnota=nfdao.GeraNota(nf);
            
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
            if (fs1.getTipo_fechamento() == 2l){
               GeraItensNota(nf);
            }
            
            Imprimenf relatest= new Imprimenf(nf);
            
        }
            
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        SimpleDateFormat sv1 = new SimpleDateFormat("dd/MM/yyyy");
        TableColumn dateColumn = jTable8.getColumnModel().getColumn(0);
        DatePickerCellEditor a = new DatePickerCellEditor();
        a.setFormats(sv1);
        dateColumn.setCellEditor(a);
        
        StringValue sv = new FormatStringValue(new SimpleDateFormat("dd/MM/yyyy"));
        TableCellRenderer r = new DefaultTableRenderer(sv);
        dateColumn.setCellRenderer(r);
        java.util.Date b = a.getCellEditorValue();
        
        
        if (jTextField2.getText()==null){
            d.MensagemErro(9);
        } else{
        fs1.setParcelas(jTextField2.getText());
        fs1.setVlr_total(total_bru);
        CalculaParcelas(fs1);
        
        
        }
        
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTable9.getModel();
        int selectedRowIndex = jTable9.getSelectedRow();
        modelo.removeRow(selectedRowIndex);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        NotaFiscal nf = new NotaFiscal();
        Long idnota = Long.parseLong(jComboBox6.getSelectedItem().toString());
        nf.setId_nota(idnota);
        Imprimenf relatest= new Imprimenf(nf);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        int os = jTable7.getRowCount();
        if (os== 0 ){
            d.MensagemErro(8);
        }else{
        Fechamento fs = new Fechamento();
        fs.setNome_empresa(jComboBox3.getSelectedItem().toString());
        fs.setNome_fechamento(fechamento);
        try {
                ImprimeMensalidades relatest= new ImprimeMensalidades(fs);
            } catch (IOException ex) {
                d.MensagemErro(1, ex);
                Logger.getLogger(Fechamentos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Fechamento f= new Fechamento();
        FechamentoDAO fd = new FechamentoDAO(); 
        f.setNome_fechamento(jComboBox2.getSelectedItem().toString());
        fd.FinalizaFechamento(f);
        d.MensagemSucesso(17);
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Fechamento f= new Fechamento();
        FechamentoDAO fd = new FechamentoDAO(); 
        f.setNome_fechamento(jComboBox2.getSelectedItem().toString());
        Boolean t =d.MensagemCerteza();
        if (t==true){
            try{
                fd.RemoveFechamento(f);
            }catch(Exception u){
                d.MensagemErro(1,u);
                System.out.println(" Erro ao finalizar fechamentos: "+u); 
            }
            d.MensagemSucesso(18);
            jTabbedPane1.setSelectedIndex(0);

            
        }else{
            
        }
            
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        Boolean vazio=false; 
        NotaFiscal nf = new NotaFiscal();
        NotaFiscalDAO nfdao = new NotaFiscalDAO();
        PagamentoPF p = new PagamentoPF();
        PagamentoPFDAO pdao = new PagamentoPFDAO();
        ResultSet itensnota;
        
        Long idnota=null;
        for (int i = 0, rows = jTable8.getRowCount(); i < rows; i++)  { 
                p.setNome_empresa(jComboBox3.getSelectedItem().toString());
                p.setNome_fechamento(fechamento);
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
                pdao.Novopagamento(p);
                d.MensagemSucesso(i);
            }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        NotaFiscal nf = new NotaFiscal();
        Notatexto nt = new Notatexto();
        nf.setId_nota(Long.parseLong(jComboBox6.getSelectedItem().toString()));
        nt.GeraTXT(nf);
        boolean resp = d.MensagemImprimir();
        if (resp==true){
            String command = "lp -d EPSON-FX /tmp/nota.a##";
            try {
            Process child = Runtime.getRuntime().exec(command);
        } catch (IOException ex) {
            Logger.getLogger(Fechamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
            d.MensagemSucesso(24);
        }
        
        
    
        
      
        
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        Empresa empresaexcluida = new Empresa();
        EmpresaDAO edao = new EmpresaDAO();
        Fechamento fs= new Fechamento();
        fs.setNome_fechamento(fechamento);
        for (int i = 0, rows = jTable11.getRowCount(); i < rows; i++)  { 
            Boolean e = false;
            if (jTable11.getValueAt(i,1).equals(e)){
                empresaexcluida.setNome_empresa(jTable11.getValueAt(i,0).toString());
                edao.RemoveListaEtiqueta(empresaexcluida);
                
            }
        }
        try {
                Etiquetas relatest= new Etiquetas(fs);
            } catch (IOException ex) {
                d.MensagemErro(1, ex);
                Logger.getLogger(Fechamentos.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed
     
    public void CalculaTotal(){
        Currency curr = Currency.getInstance("BRL");       
        Money total = new Money(new BigDecimal("0"),curr);
        Money total2 = new Money(new BigDecimal("0"),curr);
        String tprod;
        
        for (int i = 0, rows = jTable3.getRowCount(); i < rows; i++)  {  
            String preco = (String)jTable3.getValueAt(i,3);
            String custo = (String)jTable3.getValueAt(i,2);
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
        if (jTable3.getRowCount()==0){
            vlreq="0";
            lceq="0";
            
        }
            total2=total.minus(total2);
            
            vlreq= total.toStringsemSimbolo();
            lceq=total2.toStringsemSimbolo();
            vlreq=InvertePontos.converteVirgula(vlreq);
            lceq=InvertePontos.converteVirgula(lceq);
    }
    public void CalculaFechamento(){
        
        total_os.setDinheiro("0");
        sm_deslocamento.setDinheiro("0,00");
        sm_pecas.setDinheiro("0");
        sm_lucropc.setDinheiro("0");
        sm_total_os.setDinheiro("0");
        sm_servico.setDinheiro("0");
        
        
        for (int i = 0, rows = jTable2.getRowCount(); i < rows; i++)  { 

            if (jTable2.getValueAt(i,5)== null){
                jTable2.setValueAt(0,i,5);
            }
            if (jTable2.getValueAt(i,6)== null){
                jTable2.setValueAt(0,i,6);
            }
            if (jTable2.getValueAt(i,7)== null){
                jTable2.setValueAt(0,i,7);
            }
            if (jTable2.getValueAt(i,8)== null){
                jTable2.setValueAt(0,i,8);
            }
            servico.setDinheiro(jTable2.getValueAt(i,5).toString());
            deslocamento.setDinheiro(jTable2.getValueAt(i,6).toString());
            pecas.setDinheiro(jTable2.getValueAt(i,7).toString());
            lucropc.setDinheiro(jTable2.getValueAt(i,8).toString());
            total_os=servico.soma(deslocamento);
            total_os=total_os.soma(pecas);
            jTable2.setValueAt(total_os.getDinheirosimbolo(),i,9);
            
            sm_servico=sm_servico.soma(servico);
            sm_deslocamento=sm_deslocamento.soma(deslocamento);
            sm_pecas=sm_pecas.soma(pecas);
            sm_lucropc=sm_lucropc.soma(lucropc);
            sm_total_os=sm_total_os.soma(total_os);
        } 
        Dinheiro d = new Dinheiro();
        Dinheiro total= new Dinheiro();
        Dinheiro v = new Dinheiro();
        Dinheiro vl = new Dinheiro();
        totalovlucro.setDinheiro("0");
        totalovbruto.setDinheiro("0");
        total.setDinheiro("0");
        for (int i = 0, rows = jTable4.getRowCount(); i < rows; i++)  { 
             if (jTable4.getValueAt(i,2)== null){
                jTable4.setValueAt(0,i,2);
            }
            d.setDinheiro(jTable4.getValueAt(i,2).toString());
            total=total.soma(d);
        }
        
        for (int i = 0, rows = jTable10.getRowCount(); i < rows; i++)  { 
            vl.setDinheiro(jTable10.getValueAt(i,2).toString());
            v.setDinheiro(jTable10.getValueAt(i,3).toString());
            totalovlucro=totalovlucro.soma(vl);
            totalovbruto=totalovbruto.soma(v);
            
        }
        
        jLabel31.setText(total.getDinheirosimbolo());
        mensalidades=total;
        total_srv=mensalidades.soma(sm_deslocamento);
        total_srv=total_srv.soma(sm_servico);
        total_liq=total_srv.soma(sm_lucropc);
        total_liq=total_liq.soma(totalovlucro);
        total_bru=total_srv.soma(sm_pecas);
        total_bru=total_bru.soma(totalovbruto);
        jLabel34.setText(sm_pecas.getDinheirosimbolo());
        jLabel24.setText(sm_deslocamento.getDinheirosimbolo());
        jLabel23.setText(sm_servico.getDinheirosimbolo());
        jLabel33.setText(sm_lucropc.getDinheirosimbolo());
        jLabel32.setText(total_srv.getDinheirosimbolo());
        jLabel35.setText(total_liq.getDinheirosimbolo());
        jLabel36.setText(total_bru.getDinheirosimbolo());
        if (totalovbruto.maiorqzero()==false){
        jLabel70.setText("R$ 0,00");
        jLabel71.setText("R$ 0,00");
        }else{
        jLabel70.setText(totalovbruto.getDinheirosimbolo());
        jLabel71.setText(totalovlucro.getDinheirosimbolo());
        }
    }
    public void CalculaFechamentoEmpresa(){
        
        total_os = new Dinheiro();
        sm_deslocamento = new Dinheiro();
        sm_pecas = new Dinheiro();
        sm_lucropc = new Dinheiro();
        sm_total_os = new Dinheiro();
        sm_servico = new Dinheiro();
        total_srv = new Dinheiro();
        total_liq = new Dinheiro();
        total_bru = new Dinheiro();
        servico = new Dinheiro();
        deslocamento = new Dinheiro();
        pecas = new Dinheiro();
        total_os.setDinheiro("0");
        sm_deslocamento.setDinheiro("0");
        sm_pecas.setDinheiro("0");
        sm_lucropc.setDinheiro("0");
        sm_total_os.setDinheiro("0");
        sm_servico.setDinheiro("0");
        total_srv.setDinheiro("0");
        total_liq.setDinheiro("0");
        total_bru.setDinheiro("0");
        servico.setDinheiro("0");
        deslocamento.setDinheiro("0");
        pecas.setDinheiro("0");
        total_servmens.setDinheiro("0");
        System.out.println("pecas: "+sm_pecas.getDinheiro());
        for (int i = 0, rows = jTable6.getRowCount(); i < rows; i++)  { 

            if (jTable6.getValueAt(i,5)== null){
                jTable6.setValueAt(0,i,5);
            }
            if (jTable6.getValueAt(i,6)== null){
                jTable6.setValueAt(0,i,6);
            }
            if (jTable6.getValueAt(i,7)== null){
                jTable6.setValueAt(0,i,7);
            }
            if (jTable6.getValueAt(i,8)== null){
                jTable6.setValueAt(0,i,8);
            }
            servico.setDinheiro(jTable6.getValueAt(i,5).toString());
            deslocamento.setDinheiro(jTable6.getValueAt(i,6).toString());
            pecas.setDinheiro(jTable6.getValueAt(i,7).toString());
            lucropc.setDinheiro(jTable6.getValueAt(i,8).toString());
            total_os=servico.soma(deslocamento);
            total_os=total_os.soma(pecas);
            jTable6.setValueAt(total_os.getDinheirosimbolo(),i,9);
            
            sm_servico=sm_servico.soma(servico);
            sm_deslocamento=sm_deslocamento.soma(deslocamento);
            sm_pecas=sm_pecas.soma(pecas);
            sm_lucropc=sm_lucropc.soma(lucropc);
            sm_total_os=sm_total_os.soma(total_os);
        } 
        System.out.println("pecas: "+sm_pecas.getDinheiro());
        Dinheiro d = new Dinheiro();
        Dinheiro total= new Dinheiro();
        total.setDinheiro("0");
        for (int i = 0, rows = jTable7.getRowCount(); i < rows; i++)  { 
             if (jTable7.getValueAt(i,2)== null){
                jTable7.setValueAt(0,i,2);
            }
            d.setDinheiro(jTable7.getValueAt(i,2).toString());
            total=total.soma(d);
        }
        jLabel40.setText(total.getDinheirosimbolo());
        mensalidades=total;
        System.out.println("pecas: "+sm_pecas.getDinheiro()); 
        total_srv=mensalidades.soma(sm_deslocamento);
        total_srv=total_srv.soma(sm_servico);
        total_liq=total_srv.soma(sm_lucropc);
        total_bru=total_srv.soma(sm_pecas);
        jLabel38.setText(sm_pecas.getDinheirosimbolo());
        jLabel37.setText(sm_deslocamento.getDinheirosimbolo());
        jLabel30.setText(sm_servico.getDinheirosimbolo());
        jLabel42.setText(total_bru.getDinheirosimbolo());
        
        
    }
    private void CalculaMensalidades(){
        
                
            
    }
    private void GeraNotafiscal(Fechamento fs){
        ResultSet resultado,resultado2;
        EmpresaDAO ed = new EmpresaDAO();
        Empresa e = new Empresa();
        NfOperacao no = new NfOperacao();
        NfOperacaoDAO nod = new NfOperacaoDAO();
        e.setNome_empresa(fs.getNome_empresa().toString());
        resultado=ed.RetornaDados(e);
        try {  
                while (resultado.next()){  
                    jLabel50.setText(resultado.getString(3));  
                    jLabel51.setText(resultado.getString(4));
                    jLabel49.setText(resultado.getString(6)+" "+resultado.getString(7)+" "+resultado.getString(8));
                    jLabel47.setText(resultado.getString(9));
                    jLabel55.setText(resultado.getString(10));
                }
        }catch (SQLException ex) {  
                    System.out.println(" Erro ao consultar empresa: ");
                } 
        jLabel62.setText(fs.getVlr_total().getDinheirosimbolo());
        
        no.setId_operacao(fs.getTipo_fechamento());
        resultado2=nod.ConsultaOperacao(no);
        try {  
                while (resultado2.next()){  
                    jLabel66.setText(resultado2.getString(1));  
                    jLabel61.setText(resultado2.getString(2));
                
                }
        }catch (SQLException ex) {  
                    System.out.println(" Erro ao consultar tipo operacao ");
                } 
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
        itensnota=itd.MostraItemNota(nf);
        Integer size = 0;
        size= itd.ContaItemNota(nf);
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
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
