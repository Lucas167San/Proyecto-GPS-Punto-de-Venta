/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package app.pvgps.inventario;

import app.pvgps.inventario.ModuloProductosDialog;
import app.pvgps.modelo.ModuloProductos;
import app.pvgps.principal.JFramePrincipal;
import static app.pvgps.principal.JFramePrincipal.PRODUCTOS_ACTUALIZA_DATOS;
import static app.pvgps.principal.JFramePrincipal.PRODUCTOS_ELIMINAR_POR_CODIGO;
import static app.pvgps.principal.JFramePrincipal.PRODUCTOS_INSERTA_NUEVO;
import static app.pvgps.principal.JFramePrincipal.PRODUCTOS_POR_COD_BARRAS;
import static app.pvgps.principal.JFramePrincipal.PRODUCTOS_TODOS_POR_NOMBRE;
import static app.pvgps.principal.JFramePrincipal.PRODUCTOS_TODOS_SIN_ORDEN;
import static app.pvgps.principal.JFramePrincipal.TIT_MOD_PROD;
import static app.pvgps.principal.ModuloModifProducto.PRODUCTOS_ELIMINAR_POR_CODIGO;
import static app.pvgps.principal.ModuloModifProducto.PRODUCTOS_INSERTA_NUEVO;
import static app.pvgps.principal.ModuloModifProducto.PRODUCTOS_TODOS_POR_NOMBRE;
import static app.pvgps.principal.ModuloModifProducto.PRODUCTOS_TODOS_SIN_ORDEN;
import static app.pvgps.principal.ModuloModifProducto.TIT_MOD_PROD;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mx.tecnm.tap.jdbc.EjecutorSQL;
public class ModuloProdBajosDeInv extends javax.swing.JDialog {

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
    private String              moduloActual;
    private int                 totRegistros;
    private Vector<String>      vecNombresColumnas;
    private Vector<String>      vecNombresColumnasBD;
    private Vector<String>      vecTiposColumnas;
    private DefaultTableModel   dtmPrincipal;
    private Properties          propConsultasSQL;
    public ModuloProdBajosDeInv(java.awt.Frame parent, ModuloProductos producto) {
        super(parent, true);
        initComponents();
        frmPrincipal = (JFramePrincipal) parent;
            prepararSentenciasSQL();
            prepararVista(TIT_MOD_PROD);
            String sql = propConsultasSQL.getProperty( PRODUCTOS_TODOS_POR_NOMBRE );
            desplegarRegistros(sql, null);
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVenta = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Console", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRODUCTOS BAJOS DE INVENTARIO");

        jTableVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo de barras", "Descripci??n del producto", "Precio Venta", "Inventario", "Inv. Minimo", "Departamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableVenta);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel2.setText("A continuaci??n se muestran un listado con productos con inventario debajo de su minimo:");

        jButImprimir.setText("Imprimir Productos Bajos de Inventario");
        jButImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButImprimir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButImprimir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButImprimirActionPerformed
        try {
            jTableVenta.print();
        } catch (PrinterException ex) {
            Logger.getLogger(ModuloProdBajosDeInv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButImprimirActionPerformed
public void prepararVista( String modulo )
    {   
        moduloActual = modulo;
        determinarNombresColumnas                   ( modulo );
        
        dtmPrincipal = new DefaultTableModel( vecNombresColumnas, 0 );
        this.jTableVenta.setModel ( dtmPrincipal );
    }
    
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
         
       //String valor = jTabLista.getValueAt(jTabLista.getSelectedRow(), 0)+"";
                    propConsultasSQL = new Properties ( );

//                    propConsultasSQL.put    (PRODUCTOS_POR_COD_BARRAS, 
//                                            "SELECT * FROM PRODUCTOS WHERE COD_BARRAS = '"+valor+"'");
                    
                    propConsultasSQL.put (   PRODUCTOS_TODOS_POR_NOMBRE,
                                             "SELECT * FROM PRODUCTOS WHERE PROD_EXISTENCIA < 7 ORDER BY "
                                                     + "PROD_EXISTENCIA ASC" );
                    
                    propConsultasSQL.put (   PRODUCTOS_TODOS_SIN_ORDEN,
                                             "SELECT * FROM PRODUCTOS" );
                    
                    propConsultasSQL.put (   PRODUCTOS_ELIMINAR_POR_CODIGO,
                                             "DELETE FROM PRODUCTOS WHERE COD_BARRAS = ?" );

//                    propConsultasSQL.put(    PRODUCTOS_ACTUALIZA_DATOS,
//                                             "UPDATE PRODUCTOS SET DESCRIPCION = ?, PRECIO = ?, "
//                                           + "IMPORTE = ?, PROD_EXISTENCIA = ? WHERE COD_BARRAS = '"+valor+"'");
                    
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
                
            this.jTableVenta.setModel ( dtmPrincipal );

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
            java.util.logging.Logger.getLogger(ModuloProdBajosDeInv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModuloProdBajosDeInv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModuloProdBajosDeInv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModuloProdBajosDeInv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModuloProdBajosDeInv dialog = new ModuloProdBajosDeInv(new javax.swing.JFrame(), null);
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
    private javax.swing.JButton jButImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVenta;
    // End of variables declaration//GEN-END:variables
}
