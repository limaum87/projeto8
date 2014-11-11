/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import dao.EmpresaDAO;
import dao.AreaDAO;
import dao.ChamadoDAO;
import dao.UsuarioDAO;
import static gui.home.cards;
import java.awt.CardLayout;
import java.sql.*;
import javax.swing.JOptionPane;
import modelo.Empresa;
import modelo.Area;
import modelo.Chamado;
import modelo.Usuario;

public class NovoChamado extends javax.swing.JPanel {
private ResultSet resultado;
private ResultSet resultado2;
private ResultSet resultado3;
    /**
     * Creates new form AdicionaChamado
     */
    public NovoChamado() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 400));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Novo Chamado");

        jLabel2.setText("Área");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        AreaDAO g = new AreaDAO();
        resultado2=g.ConsultarArea();
        try {
            while (resultado2.next()){
                jComboBox1.addItem(resultado2.getString(1));
                jComboBox1.updateUI();
            }
        } catch (SQLException ex) {
            System.out.println(" Erro ao consultar area: ");
        }
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Cliente");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        EmpresaDAO f = new EmpresaDAO();
        resultado=f.ConsultarEmpresa();
        try {
            while (resultado.next()){
                jComboBox2.addItem(resultado.getString(1));
                jComboBox2.updateUI();
            }
        } catch (SQLException ex) {
            System.out.println(" Erro ao consultar empresa: ");
        }
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Problema:");

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        UsuarioDAO h = new UsuarioDAO();
        resultado3=h.ConsultarUsuario();
        try {
            while (resultado3.next()){
                jComboBox3.addItem(resultado3.getString(1));
                jComboBox3.updateUI();
            }
        } catch (SQLException ex) {
            System.out.println(" Erro ao consultar usuario: ");
        }
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel5.setText("Encaminhar para o usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(36, 36, 36)
                                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(357, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addContainerGap(48, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
       Empresa empresas = new Empresa();
       empresas.setNome_empresa(jComboBox2.getSelectedItem().toString());
       Area area = new Area();
       area.setNome_area(jComboBox1.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String idf=null;
        Chamado chamados = new Chamado();
        chamados.setOcorrencia(jTextArea1.getText());
        chamados.setNome_empresa(jComboBox2.getSelectedItem().toString());
        chamados.setNome_area(jComboBox1.getSelectedItem().toString());
        if ((jTextArea1.getText().isEmpty()) ) {
            JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
        }
        else {
            if (jComboBox3.getSelectedItem().equals("")){
                ChamadoDAO dao = new ChamadoDAO();
                dao.NovoChamado(chamados);
                JOptionPane.showMessageDialog(null, "Chamado inserido com sucesso! ");
                MostraChamados vwchm = new MostraChamados();
                cards.add(vwchm, "Mostra Chamado");
                CardLayout layout2 = (CardLayout) (cards.getLayout());
                layout2.show(cards, "Mostra Chamado");
            }
            else
            {
                chamados.setNome_usuario(jComboBox3.getSelectedItem().toString());
                UsuarioDAO h = new UsuarioDAO();
                Usuario usuario = new Usuario();
                usuario.setEmail(login.getUsuariologado());
                chamados.setId_usuario(h.ConsultaId(usuario));
                ChamadoDAO dao = new ChamadoDAO();
                dao.ChamadoEncaminhado(chamados);
                JOptionPane.showMessageDialog(null, "Chamado inserido com sucesso! ");   
                MostraChamados vwchm = new MostraChamados();
                cards.add(vwchm, "Mostra Chamado");
                CardLayout layout2 = (CardLayout) (cards.getLayout());
                layout2.show(cards, "Mostra Chamado");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
