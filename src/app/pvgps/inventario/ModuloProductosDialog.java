/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package app.pvgps.inventario;

import app.pvgps.modelo.ModuloProductos;
import app.pvgps.principal.JFramePrincipal;
import app.pvgps.principal.ModuloModifProducto;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import mx.tecnm.tap.jdbc.EjecutorSQL;

/**
 *
 * @author luxxo
 */
public class ModuloProductosDialog extends javax.swing.JDialog {

     private JFramePrincipal    frmPrincipal;
     private ModuloModifProducto modif;
     private ModuloProductos    modelo;
     private String             accion;
     private Vector<String>     vecTiposColumnas;
     private String             sql;
    
    public ModuloProductosDialog(java.awt.Frame parent, ModuloProductos modelo) {
        super(parent, true);
        initComponents();

        jTextDepartamento.setVisible(false);
        jLabel7.setVisible(false);
        jSpinCantMinima.setVisible(false);
        
        
        frmPrincipal = (JFramePrincipal) parent;
        this.modelo = modelo;
        vecTiposColumnas = frmPrincipal.getVecTiposColumnas();
        //vecTiposColumnas2 = modif.getVecTiposColumnas();
        
        accion = ( modelo == null)? JFramePrincipal.NUEVO_PROD : ModuloModifProducto.EDITAR_PROD;
        setTitle(accion);
        
        
        
        inicializarFormulario();
    }
    
    private void inicializarFormulario()
    {
        if (accion.equals(JFramePrincipal.NUEVO_PROD))
        {
            jCheckInventarioSINO.setVisible(false);
            jTextCodBarras.requestFocus();
        }else if (accion.equals(ModuloModifProducto.EDITAR_PROD))
        {
            jLabTitutlo.setText(ModuloModifProducto.EDITAR_PROD);
            jCheckInventarioSINO.setVisible(false);
            jTextCodBarras.setText(modelo.getCodBarras());
            jTextDescripcion.setText(modelo.getDescripcion());
            jTextPrecioCosto.setText(modelo.getPrecio()+"");
            jTextPrecioVenta.setText(modelo.getImporte()+"");
            jSpinCantActual.setValue(modelo.getExistencia());
            
            jTextCodBarras.setEditable(false);
        }
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCheckInventarioSINO = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButGuardarProd = new javax.swing.JButton();
        jButCancelar = new javax.swing.JButton();
        jSpinCantMinima = new javax.swing.JSpinner();
        jSpinCantActual = new javax.swing.JSpinner();
        jTextCodBarras = new javax.swing.JTextField();
        jTextDescripcion = new javax.swing.JTextField();
        jTextPrecioCosto = new javax.swing.JTextField();
        jTextPrecioVenta = new javax.swing.JTextField();
        jTextDepartamento = new javax.swing.JTextField();
        jLabTitutlo = new javax.swing.JLabel();

        jLabel1.setText("Codigo de Barras");

        jLabel2.setText("Descripción");

        jLabel3.setText("Precio Costo");

        jLabel4.setText("Precio Venta");

        jLabel5.setText("Departamento");

        jCheckInventarioSINO.setText("Este producto Utiliza Inventario ");

        jLabel6.setText("Cantidad Actual");

        jLabel7.setText("Minimo");

        jButGuardarProd.setText("Guardar Producto");
        jButGuardarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButGuardarProdActionPerformed(evt);
            }
        });

        jButCancelar.setText("Cancelar");
        jButCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButCancelarActionPerformed(evt);
            }
        });

        jTextCodBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCodBarrasActionPerformed(evt);
            }
        });

        jLabTitutlo.setFont(new java.awt.Font("Lucida Console", 3, 24)); // NOI18N
        jLabTitutlo.setForeground(new java.awt.Color(0, 0, 204));
        jLabTitutlo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabTitutlo.setText("NUEVO PRODUCTO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCheckInventarioSINO)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSpinCantActual, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                                            .addComponent(jSpinCantMinima))
                                        .addComponent(jButGuardarProd)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextCodBarras)
                                        .addComponent(jTextDescripcion)
                                        .addComponent(jTextPrecioCosto)
                                        .addComponent(jTextPrecioVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addComponent(jTextDepartamento))))
                            .addComponent(jButCancelar))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addComponent(jLabTitutlo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabTitutlo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextCodBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextPrecioCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCheckInventarioSINO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jSpinCantActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jSpinCantMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButGuardarProd)
                    .addComponent(jButCancelar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
@SuppressWarnings("unchecked")
    private void jButGuardarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButGuardarProdActionPerformed
        // TODO add your handling code here:
        Object [][] args = null;
        String mensaje = "";
        
       if ( validarDatos () == false )
            return;
       
        if (accion.equals(JFramePrincipal.NUEVO_PROD))
        {
            
            mensaje = "Se a agregado el nuevo producto";
            sql = frmPrincipal.getPropConsultasSQL().getProperty(JFramePrincipal.PRODUCTOS_INSERTA_NUEVO);
            
            args = new Object[][] { 
                              { vecTiposColumnas.elementAt( 0 ), modelo.getCodBarras() },
                              { vecTiposColumnas.elementAt( 1 ), modelo.getDescripcion   () },
                              { vecTiposColumnas.elementAt( 2 ), modelo.getPrecio() },
                              { vecTiposColumnas.elementAt( 3 ), modelo.getImporte()},
                              { vecTiposColumnas.elementAt( 4 ), modelo.getExistencia()},
                                  };
        } else if ( accion.equals( ModuloModifProducto.EDITAR_PROD ) )
        {
            vecTiposColumnas        = new Vector<String>    ( ); 
            
            vecTiposColumnas.add     ( EjecutorSQL.STRING);
            vecTiposColumnas.add     ( EjecutorSQL.STRING);
            vecTiposColumnas.add     ( EjecutorSQL.FLOAT);
            vecTiposColumnas.add     ( EjecutorSQL.FLOAT);
            vecTiposColumnas.add     ( EjecutorSQL.INT);
            mensaje = "El registro ha sido actualizado.";
            
            sql =     "UPDATE PRODUCTOS SET DESCRIPCION = ?, PRECIO = ?, IMPORTE = ?, PROD_EXISTENCIA = ? "
                    + "WHERE COD_BARRAS = '"+modelo.getCodBarras()+"'";
            args = new Object[][] {              
                              //{ vecTiposColumnas.elementAt( 0 ), modelo.getCodBarras() },
                              { vecTiposColumnas.elementAt( 1 ), modelo.getDescripcion()},
                              { vecTiposColumnas.elementAt( 2 ), modelo.getPrecio() },
                              { vecTiposColumnas.elementAt( 3 ), modelo.getImporte() },
                              { vecTiposColumnas.elementAt( 4 ), modelo.getExistencia() }
                              
                                  };
        }
        try {
             int registros = EjecutorSQL.sqlEjecutar( sql , args );
             if ( registros == 1 )
             {
                 
                 JOptionPane.showMessageDialog(this, mensaje, 
                                                accion, 
                                                JOptionPane.INFORMATION_MESSAGE);
               
             }
         } catch ( SQLException ex ) {
             dialogoMensaje( ex.toString() ); 
         }
          dispose(); 
    }//GEN-LAST:event_jButGuardarProdActionPerformed

    private void jButCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButCancelarActionPerformed

    private void jTextCodBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCodBarrasActionPerformed
        // TODO add your handling code here:
        jTextDescripcion.requestFocus();
    }//GEN-LAST:event_jTextCodBarrasActionPerformed

    private boolean validarDatos()
        {
            String cod_barras =  jTextCodBarras.getText ();
            if( cod_barras.trim ().equals( "" ) )
            {
                dialogoMensaje( "No se permite un valor en blanco" );
                jTextCodBarras.requestFocus ();
                return false;
            }
            
            String descripcion   =  jTextDescripcion.getText ();
            if( descripcion.trim ().equals( "" ) )
            {
                dialogoMensaje( "No se permite un valor en blanco" );
                jTextDescripcion.requestFocus ();
                return false; 
            }
            
            double precio_costo = 0;
            try{
                precio_costo = Double.parseDouble(jTextPrecioCosto.getText()+"");
            }catch (NumberFormatException ex){
                dialogoMensaje( "No se permite un valor en blanco" );
                jTextPrecioCosto.requestFocus ();
                return false; 
            }
            {
                
            }
            
            double importe = 0;
            try{
                
                   importe      =  Double.parseDouble( jTextPrecioVenta.getText()+"");
            } catch ( NumberFormatException ex )
            {
                dialogoMensaje ( "Debe capturar un valor numerico valido" );
                jTextPrecioVenta.requestFocus ();
                return false;
            }
            
            int prod_existencia;
            try{
            
                prod_existencia = Integer.parseInt( jSpinCantActual.getValue().toString());
                
            }catch ( NumberFormatException ex ){
                dialogoMensaje ( "Debe capturar un valor numerico valido"); 
                jSpinCantActual.requestFocus();
                return false;
            }
            
            modelo = new ModuloProductos(cod_barras, descripcion, precio_costo, importe, prod_existencia );
            return true;
            
        }
    
    private void dialogoMensaje( String mensaje )
        {
            JOptionPane.showMessageDialog( this, mensaje, "Error", JOptionPane.ERROR_MESSAGE );
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModuloProductosDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModuloProductosDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModuloProductosDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModuloProductosDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModuloProductosDialog dialog = new ModuloProductosDialog(new javax.swing.JFrame(), null);
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
    private javax.swing.JButton jButGuardarProd;
    private javax.swing.JCheckBox jCheckInventarioSINO;
    private javax.swing.JLabel jLabTitutlo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSpinner jSpinCantActual;
    private javax.swing.JSpinner jSpinCantMinima;
    private javax.swing.JTextField jTextCodBarras;
    private javax.swing.JTextField jTextDepartamento;
    private javax.swing.JTextField jTextDescripcion;
    private javax.swing.JTextField jTextPrecioCosto;
    private javax.swing.JTextField jTextPrecioVenta;
    // End of variables declaration//GEN-END:variables
}
