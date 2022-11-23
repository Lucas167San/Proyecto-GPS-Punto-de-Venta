/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package app.pvgps.principal;

import app.pvgps.inventario.ModuloProductosDialog;
import app.pvgps.modelo.ModuloProductos;
import static app.pvgps.principal.JFramePrincipal.PRODUCTOS_ACTUALIZA_DATOS;
import static app.pvgps.principal.JFramePrincipal.PRODUCTOS_ELIMINAR_POR_CODIGO;
import static app.pvgps.principal.JFramePrincipal.PRODUCTOS_INSERTA_NUEVO;
import static app.pvgps.principal.JFramePrincipal.PRODUCTOS_POR_COD_BARRAS;
import static app.pvgps.principal.JFramePrincipal.PRODUCTOS_TODOS_POR_NOMBRE;
import static app.pvgps.principal.JFramePrincipal.PRODUCTOS_TODOS_SIN_ORDEN;
import static app.pvgps.principal.JFramePrincipal.TIT_MOD_PROD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mx.tecnm.tap.jdbc.EjecutorSQL;

/**
 *
 * @author luxxo
 */
public class ModuloModifProducto extends javax.swing.JDialog {

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
    
    public ModuloModifProducto(java.awt.Frame parent, ModuloProductos producto) {
        super(parent, true);     
        initComponents();
            frmPrincipal = (JFramePrincipal) parent;
            prepararSentenciasSQL();
            prepararVista(TIT_MOD_PROD);
            String sql = propConsultasSQL.getProperty( PRODUCTOS_TODOS_SIN_ORDEN );
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTabLista = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabLista.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTabLista);

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(273, 273, 273))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
//            prepararVista(TIT_MOD_PROD);
//            String sql = propConsultasSQL.getProperty( PRODUCTOS_TODOS_SIN_ORDEN );
//            desplegarRegistros(sql, null);
            
            int pos = jTabLista.getSelectedRow();
            
            //String codigo = JOptionPane.showInputDialog(this, "Ingrese el producto a modificar", "Modificar", JOptionPane.QUESTION_MESSAGE);
            
            String  cod_barras    = jTabLista.getValueAt( pos, 0 ).toString ();
            String  descripcion      = jTabLista.getValueAt( pos, 1 ).toString ();
            double  precio    =   Double.parseDouble(jTabLista.getValueAt( pos, 2 ).toString ());
            double  importe         = Double.parseDouble(jTabLista.getValueAt( pos, 3 ).toString () );
            int     prod_existencia     = Integer.parseInt(jTabLista.getValueAt( pos, 4 ).toString () );
            
            ModuloProductos modelo = new ModuloProductos ( cod_barras, descripcion, precio, importe, prod_existencia);
        
            ModuloProductosDialog dialog = new ModuloProductosDialog(frmPrincipal,modelo);
            dialog.setVisible(true);
            
            prepararVista(TIT_MOD_PROD);
            String sql = propConsultasSQL.getProperty( PRODUCTOS_TODOS_SIN_ORDEN );
            desplegarRegistros(sql, null);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void prepararVista( String modulo )
    {   
        moduloActual = modulo;
        determinarNombresColumnas                   ( modulo );
        
        dtmPrincipal = new DefaultTableModel( vecNombresColumnas, 0 );
        this.jTabLista.setModel ( dtmPrincipal );
    }
    
    public void determinarNombresColumnas( String modulo )
    {
        vecNombresColumnas      = new Vector<String>    ( );
        vecNombresColumnasBD    = new Vector<String>    ( );
        vecTiposColumnas        = new Vector<String>    ( );    
        
        if( modulo.equals( TIT_MOD_PROD ) )
        {
            vecNombresColumnas.add( "Codigo de Barras" );
            vecNombresColumnas.add( "Descripción" );
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
                                             "SELECT * FROM PRODUCTOS ORDER BY DESCRIPCION" );
                    
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
                
            this.jTabLista.setModel ( dtmPrincipal );

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
    
    @SuppressWarnings("unchecked")
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
            java.util.logging.Logger.getLogger(ModuloModifProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModuloModifProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModuloModifProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModuloModifProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModuloModifProducto dialog = new ModuloModifProducto(new javax.swing.JFrame(), null);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabLista;
    // End of variables declaration//GEN-END:variables
    public String getModuloActual() {
        return moduloActual;
    }
//-------------------------------------------------------------------------------------------- 
    public void setModuloActual(String moduloActual) {
        this.moduloActual = moduloActual;
    }
//-------------------------------------------------------------------------------------------- 
    public Vector<String> getVecNombresColumnas() {
        return vecNombresColumnas;
    }
//-------------------------------------------------------------------------------------------- 
    public void setVecNombresColumnas(Vector<String> vecNombresColumnas) {
        this.vecNombresColumnas = vecNombresColumnas;
    }
//-------------------------------------------------------------------------------------------- 
    public Vector<String> getVecNombresColumnasBD() {
        return vecNombresColumnasBD;
    }
//-------------------------------------------------------------------------------------------- 
    public void setVecNombresColumnasBD(Vector<String> vecNombresColumnasBD) {
        this.vecNombresColumnasBD = vecNombresColumnasBD;
    }
//-------------------------------------------------------------------------------------------- 
    public Vector<String> getVecTiposColumnas() {
        return vecTiposColumnas;
    }
//-------------------------------------------------------------------------------------------- 
    public void setVecTiposColumnas(Vector<String> vecTiposColumnas) {
        this.vecTiposColumnas = vecTiposColumnas;
    }
//-------------------------------------------------------------------------------------------- 
    public Properties getPropConsultasSQL() {
        return propConsultasSQL;
    }
//-------------------------------------------------------------------------------------------- 
    public void setPropConsultasSQL(Properties propConsultasSQL) {
        this.propConsultasSQL = propConsultasSQL;
    }
//-------------------------------------------------------------------------------------------- 

//    public JButton getJButAgregarProducto() {
//        return jButAgregarProducto;
//    }
}

