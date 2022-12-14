/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package app.pvgps.inventario;

import app.pvgps.modelo.ModuloProductos;
import app.pvgps.modelo.Producto;
import app.pvgps.principal.JFramePrincipal;
import static app.pvgps.principal.JFramePrincipal.PRODUCTOS_ACTUALIZA_DATOS;
import static app.pvgps.principal.JFramePrincipal.PRODUCTOS_ELIMINAR_POR_CODIGO;
import static app.pvgps.principal.JFramePrincipal.PRODUCTOS_INSERTA_NUEVO;
import static app.pvgps.principal.JFramePrincipal.PRODUCTOS_POR_COD_BARRAS;
import static app.pvgps.principal.JFramePrincipal.PRODUCTOS_TODOS_POR_NOMBRE;
import static app.pvgps.principal.JFramePrincipal.PRODUCTOS_TODOS_SIN_ORDEN;
import static app.pvgps.principal.JFramePrincipal.TIT_MOD_PROD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mx.tecnm.tap.jdbc.ConexionDB;
import mx.tecnm.tap.jdbc.EjecutorSQL;

/**
 *
 * @author luxxo
 */
public class ModuloInventario extends javax.swing.JDialog {

    DefaultTableModel modelo;
   
    public static final String TIT_FRAME                        = "Punto de Venta";
    public static final String TIT_INICIO                       = "Sistema de ventas EMAVIC";
    public static final String TIT_MOD_PROD                     = "Producto";
    
    public static final String PRODUCTOS_TODOS_POR_NOMBRE       = "productos_todos_por_nombre";
    public static final String PRODUCTOS_TODOS_SIN_ORDEN        = "productos_todos_sin_orden";
    public static final String PRODUCTOS_POR_COD_BARRAS         = "productos_por_cod_barras";
    public static final String PRODUCTOS_ELIMINAR_POR_CODIGO    = "productos_eliminar_por_codigo";
    public static final String PRODUCTOS_ACTUALIZA_DATOS        = "productos_actualiza_datos";
    public static final String PRODUCTOS_INSERTA_NUEVO          = "productos_inserta_nuevo";
    
    public static final String NUEVO_PROD                       = "Nuevo";
    public static final String EDITAR_PROD                      = "Editar";
    
    private JFramePrincipal    frmPrincipal;
    private EjecutorSQL        ejecutor;
    private String              moduloActual;
    private int                 totRegistros;
    private Vector<String>      vecNombresColumnas;
    private Vector<String>      vecNombresColumnasBD;
    private Vector<String>      vecTiposColumnas;
    private DefaultTableModel   dtmPrincipal;
    private Properties          propConsultasSQL;
    private ArrayList<Producto> array = new ArrayList<Producto>();
    
    protected void conexionBaseDatos()
    {
        ConexionDB.getInstancia().conectar("JAVADB",
                                           "", 
                                           "", 
                                           "PuntoDeVenta",
                                           "administrador", 
                                           "admin");
    }
    
    public ModuloInventario(java.awt.Frame parent, ModuloProductos modelo) {
        super(parent, true);
        conexionBaseDatos();
        initComponents();
        
//        frmPrincipal = (JFramePrincipal) parent;
        
        propConsultasSQL = new Properties ( );
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
        jTextCodBarras = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabDescripcion = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Codigo del producto");

        jTextCodBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCodBarrasActionPerformed(evt);
            }
        });

        jLabel2.setText("Descripcion");

        jLabel3.setText("Cantidad actual");

        jLabel4.setText("Cantidad");

        jButton1.setText("Agregar cantidad a inventario");

        jLabel5.setText("0.00");

        jLabDescripcion.setText("-");

        jLabel7.setFont(new java.awt.Font("Lucida Console", 3, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("AGREGAR INVENTARIO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextCodBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addComponent(jButton1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextCodBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextCodBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCodBarrasActionPerformed
        // TODO add your handling code here:
        ResultSet rs;
        String valor = jTextCodBarras.getText();
        String sql = "SELECT DESCRIPCION FROM PRODUCTOS WHERE COD_BARRAS = '"+valor+"'";
        
        try {
         
                rs = EjecutorSQL.sqlQuery(sql,null);
                jLabDescripcion.setText(crearDescripcionProducto(rs)+"");
                JOptionPane.showMessageDialog( this , "El registro ha sido eliminado ", "Eliminar",
                        JOptionPane.INFORMATION_MESSAGE );
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog( this, ex, "Error", JOptionPane.ERROR_MESSAGE );
        }
        
    }//GEN-LAST:event_jTextCodBarrasActionPerformed

     public void prepararVista( String modulo )
    {   
        moduloActual = modulo;
        determinarNombresColumnas                   ( modulo );
        
        dtmPrincipal = new DefaultTableModel( vecNombresColumnas, 0 );
       // this.jTableVenta.setModel ( dtmPrincipal );
    }
    @SuppressWarnings("unchecked")
    public void determinarNombresColumnas( String modulo )
    {
        vecNombresColumnas      = new Vector<String>    ( );
        vecNombresColumnasBD    = new Vector<String>    ( );
        vecTiposColumnas        = new Vector<String>    ( );    
        
        if( modulo.equals( TIT_MOD_PROD ) )
        {
            vecNombresColumnas.add( "Codigo de Barras" );
            vecNombresColumnas.add( "Descripci??n" );
            vecNombresColumnas.add( "Precio Venta" );
            vecNombresColumnas.add( "Importe" );
            vecNombresColumnas.add( "Existencia" );
            
            vecNombresColumnasBD.add ( "cod_barras" );
            vecNombresColumnasBD.add ( "descripcion" );
            vecNombresColumnasBD.add ( "precio" );
            vecNombresColumnasBD.add ( "importe" );
            vecNombresColumnasBD.add ( "prod_existencia" );
            
            
            
            vecTiposColumnas.add     ( EjecutorSQL.STRING);
            vecTiposColumnas.add     ( EjecutorSQL.STRING);
            vecTiposColumnas.add     ( EjecutorSQL.FLOAT);
            vecTiposColumnas.add     ( EjecutorSQL.FLOAT);
            vecTiposColumnas.add     ( EjecutorSQL.INT);
        
        }
    }
    
    
    
    public void prepararSentenciasSQL ( )
    {
        
       String valor = jTextCodBarras.getText();
                    propConsultasSQL = new Properties ( );

                    propConsultasSQL.put    (PRODUCTOS_POR_COD_BARRAS, 
                                            "SELECT * FROM PRODUCTOS WHERE COD_BARRAS = '"+valor+"'");
                    
                    propConsultasSQL.put (   PRODUCTOS_TODOS_POR_NOMBRE,
                                             "SELECT * FROM PRODUCTOS ORDER BY PROD_EXISTENCIA ASC" );
                    
                    propConsultasSQL.put (   PRODUCTOS_TODOS_SIN_ORDEN,
                                             "SELECT * FROM PRODUCTOS" );
                    
                    propConsultasSQL.put (   PRODUCTOS_ELIMINAR_POR_CODIGO,
                                             "DELETE FROM PRODUCTOS WHERE COD_BARRAS = ?" );

                    propConsultasSQL.put(    PRODUCTOS_ACTUALIZA_DATOS,
                                             "UPDATE PRODUCTOS SET DESCRIPCION = ?, PRECIO = ?, "
                                           + "IMPORTE = ?, PROD_EXISTENCIA = ? WHERE COD_BARRAS = '"+valor+"'");
                    
                    propConsultasSQL.put(    PRODUCTOS_INSERTA_NUEVO,
                                            "INSERT INTO PRODUCTOS VALUES ( ? , ? , ? , ? , ?)");
    }
    
     public void desplegarRegistros ( String sql, Object[][] args)
    {
        
        ResultSet rs;
        try
        {
            rs = EjecutorSQL.sqlQuery( sql, args );
            
            dtmPrincipal = new DefaultTableModel ( vecNombresColumnas , 0 );
            while( rs.next ( ) )
            {
                 Object[] fila = crearFila  ( rs );
                 dtmPrincipal.addRow ( fila );
            }
            
            rs.close ( );
                
//            this.jTableVenta.setModel ( dtmPrincipal );

            totRegistros = dtmPrincipal.getRowCount ( ) ;
            //this.jLabMensajes.setText( totRegistros + " Registros mostrados" );
            
        }catch( SQLException ex ){
            JOptionPane.showMessageDialog ( this, ex, "Error", JOptionPane.INFORMATION_MESSAGE );
        }
    }
     
     private Object [] crearFila ( ResultSet rs) throws SQLException
    {
        if( moduloActual.equals ( TIT_MOD_PROD ) )
        {
                 String cod_barras  = rs.getString      ("COD_BARRAS");
                 String descripcion = rs.getString      ( "Descripcion" );
                 double precio      = rs.getDouble      ("Precio");
                 //int  cantidad      = rs.getInt         ("Cantidad");
                 double importe     = rs.getDouble      ("Importe" );
                 int prod_existencia= rs.getInt         ("prod_existencia" );
                 Object[] fila = { cod_barras, descripcion, precio, importe, prod_existencia };
                 return fila;
        }else
            return null;
    }
     
    private String crearDescripcionProducto(ResultSet rs) throws SQLException{
        String descripcion = rs.getString("Descripcion");
        
        return descripcion;
        
    }
    
    private Object crearExistenciaProducto(ResultSet rs) throws SQLException{
     
        int prod_existencia= rs.getInt("prod_existencia");
        
        
        return prod_existencia;
    }
    
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
            java.util.logging.Logger.getLogger(ModuloInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModuloInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModuloInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModuloInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModuloInventario dialog = new ModuloInventario(new javax.swing.JFrame(), null);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabDescripcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextCodBarras;
    // End of variables declaration//GEN-END:variables
}
