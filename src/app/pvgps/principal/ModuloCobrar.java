/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package app.pvgps.principal;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author luxxo
 */
public class ModuloCobrar extends javax.swing.JDialog {

    /**
     * Creates new form ModuloCobrar
     */
    JFramePrincipal frameP;
    
    public ModuloCobrar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        initComponents();
        jTextTotal.setEditable(false);
        frameP= (JFramePrincipal) parent;
        jTextPaysWith.requestFocus();
        jTextTotal.setText(frameP.getTotal());
    }
    
    public double cobrar(){
        
        return Math.abs(Double.parseDouble(jTextTotal.getText()+"") - Double.parseDouble(jTextPaysWith.getText()+""));
                
    }
    
    public String getChange (){
        return jLabChange.getText();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButCobrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextTotal = new javax.swing.JTextField();
        jTextPaysWith = new javax.swing.JTextField();
        jLabChange = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);

        jButCobrar.setText("F12 - COBRAR");
        jButCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButCobrarActionPerformed(evt);
            }
        });

        jLabel1.setText("TOTAL:");

        jLabel2.setText("PAGA CON:");

        jLabel3.setText("CAMBIO:");

        jTextTotal.setFont(new java.awt.Font("Lucida Console", 3, 18)); // NOI18N
        jTextTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTotalActionPerformed(evt);
            }
        });

        jTextPaysWith.setFont(new java.awt.Font("Lucida Console", 3, 18)); // NOI18N
        jTextPaysWith.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextPaysWithFocusLost(evt);
            }
        });
        jTextPaysWith.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPaysWithActionPerformed(evt);
            }
        });
        jTextPaysWith.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextPaysWithKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPaysWithKeyTyped(evt);
            }
        });

        jLabChange.setBackground(new java.awt.Color(51, 255, 51));
        jLabChange.setFont(new java.awt.Font("Lucida Console", 3, 18)); // NOI18N
        jLabChange.setText("0.00");
        jLabChange.setOpaque(true);

        jLabel5.setFont(new java.awt.Font("Lucida Console", 3, 18)); // NOI18N
        jLabel5.setText("COBRAR");

        jButCancelar.setText("ESC - CANCELAR");
        jButCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButCancelarActionPerformed(evt);
            }
        });
        jButCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButCancelarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jButCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabChange, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jTextPaysWith)
                            .addComponent(jTextTotal)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jButCancelar)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextPaysWith, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabChange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3)
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButCobrar, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(jButCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTotalActionPerformed

    private void jTextPaysWithKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPaysWithKeyPressed
        
    }//GEN-LAST:event_jTextPaysWithKeyPressed

    private void jTextPaysWithKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPaysWithKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPaysWithKeyTyped

    private void jTextPaysWithFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextPaysWithFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPaysWithFocusLost

    private void jTextPaysWithActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPaysWithActionPerformed
        // TODO add your handling code here:
        try{
        jLabChange.setText("$"+cobrar()+"");
        jButCobrar.doClick();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(this, "Verifique campos");
            jLabChange.setText("");
            jTextPaysWith.setText("");
        }
    }//GEN-LAST:event_jTextPaysWithActionPerformed

    private void jButCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButCobrarActionPerformed
        // TODO add your handling code here:
        if(Double.parseDouble(jTextPaysWith.getText()) < Double.parseDouble(jTextTotal.getText())){
            jLabChange.setText("$-"+cobrar());
            JOptionPane.showMessageDialog(this, "Monto menor al TOTAL");
        }else{
        frameP.setChange(cobrar()+"");
        this.dispose();
        JOptionPane.showMessageDialog(this, "Cambio: $"+cobrar()+" MXN", "Cobrar", JOptionPane.INFORMATION_MESSAGE);
        setCobrado(true);
        }
    }//GEN-LAST:event_jButCobrarActionPerformed

    private void jButCancelarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButCancelarKeyTyped

    }//GEN-LAST:event_jButCancelarKeyTyped

    private void jButCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        setCobrado(false);
    }//GEN-LAST:event_jButCancelarActionPerformed
    
    private boolean cobrado;
    public boolean getCobrado(){
        return cobrado;
    }
    public boolean setCobrado (boolean esCobrado){
        return cobrado = esCobrado;
    }
    
    
    
    
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Motif".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModuloCobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModuloCobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModuloCobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModuloCobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModuloCobrar dialog = new ModuloCobrar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButCancelar;
    private javax.swing.JButton jButCobrar;
    private javax.swing.JLabel jLabChange;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextPaysWith;
    private javax.swing.JTextField jTextTotal;
    // End of variables declaration//GEN-END:variables
}
