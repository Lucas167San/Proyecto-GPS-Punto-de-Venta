/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app.pvgps.principal;

import app.pvgps.inventario.ModuloProductosDialog;
import app.pvgps.inventario.ModuloModificarEliminar;
import app.pvgps.inventario.ModuloInventario;
import app.pvgps.inventario.ModuloProdBajosDeInv;
import app.pvgps.modelo.ModuloProductos;
import app.pvgps.modelo.Producto;
import app.pvgps.sesion.JDialogAutorizar;
import app.pvgps.sesion.JDialogCancelaciones;
import app.pvgps.sesion.JFrameIniciarSesion;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mx.tecnm.tap.extras.AcercaDeDialog;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JRootPane;
import mx.tecnm.tap.jdbc.ConexionDB;
import mx.tecnm.tap.jdbc.EjecutorSQL;
import mx.tecnm.tap.jdbc.*;

/**
 *
 * @author luxxo
 */
public class JFramePrincipal extends javax.swing.JFrame {
    DefaultTableModel modelo;
   
    public static final String TIT_FRAME                        = "Punto de Venta";
    public static final String TIT_INICIO                       = "Sistema de ventas EMAV";
    public static final String TIT_MOD_PROD                     = "Producto";
    
    public static final String PRODUCTOS_TODOS_POR_NOMBRE       = "productos_todos_por_nombre";
    public static final String PRODUCTOS_TODOS_SIN_ORDEN        = "productos_todos_sin_orden";
    public static final String PRODUCTOS_POR_COD_BARRAS         = "productos_por_cod_barras";
    public static final String PRODUCTOS_ELIMINAR_POR_CODIGO    = "productos_eliminar_por_codigo";
    public static final String PRODUCTOS_ACTUALIZA_DATOS        = "productos_actualiza_datos";
    public static final String PRODUCTOS_INSERTA_NUEVO          = "productos_inserta_nuevo";
    
    public static final String NUEVO_PROD                       = "Nuevo";
    public static final String EDITAR_PROD                      = "Editar";

    private String              moduloActual;
    private int                 totRegistros;
    private Vector<String>      vecNombresColumnas;
    private Vector<String>      vecNombresColumnasBD;
    private Vector<String>      vecTiposColumnas;
    private DefaultTableModel   dtmPrincipal;
    private Properties          propConsultasSQL;
    @SuppressWarnings("unchecked")
    private ArrayList<Producto> array = new ArrayList();
    private ModuloProductos modulo;
    
    ModuloCobrar cobrar;
    String tot = "";
    Double subtotal = 0.0;
    Double ventasTotales = 0.0;
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("app/pvgps/iconos/iconoPestañas.png"));
        return retValue;
    }
    
    protected void conexionBaseDatos()
    {
        ConexionDB.getInstancia().conectar("JAVADB",
                                           "", 
                                           "", 
                                           "PuntoDeVenta",
                                           "administrador", 
                                           "admin");
        
    }
    
    @SuppressWarnings("unchecked")
    String user = "";
    public JFramePrincipal(String usuario) {
        conexionBaseDatos();
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        
        if(ConexionDB.getInstancia().conectado() && usuario.equals("admin")){
                user = usuario;
                JOptionPane.showMessageDialog(this, "Bienvenido admin",TIT_INICIO, JOptionPane.INFORMATION_MESSAGE);
                initComponents();
                this.setTitle(TIT_FRAME + " - Administrador");
                prepararSentenciasSQL ();
                jMenuClientes.setVisible(false);
                jMenuConfiguracion.setVisible(false);
            
        }else if (ConexionDB.getInstancia().conectado() && usuario.equals("empleado")){
            user = usuario;
            JOptionPane.showMessageDialog(this, "Bienvenido empleado",TIT_INICIO, JOptionPane.INFORMATION_MESSAGE);
            initComponents();
            
            jMenuClientes.setVisible(false);
            jMenuProductos.setVisible(false);
            jMenuConfiguracion.setVisible(false);
            jMenuCorte.setVisible(false);
            jMenuInventario.setVisible(false);
            this.setTitle(TIT_FRAME + " - Empleado");
                prepararSentenciasSQL ();
        }else {
            JOptionPane.showMessageDialog(this, "error en el inicio de sesion",TIT_INICIO,JOptionPane.ERROR_MESSAGE);
            ConexionDB.getInstancia().desconectar();
            System.exit(0);
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
        jTextCodigo = new javax.swing.JTextField();
        jButAgregarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVenta = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabTotProductos = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextTotal = new javax.swing.JTextField();
        jButCobrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabChange = new javax.swing.JLabel();
        jButEliminarProducto = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuPrint = new javax.swing.JMenuItem();
        jMenuLogOut = new javax.swing.JMenuItem();
        jMenuExit = new javax.swing.JMenuItem();
        jMenuClientes = new javax.swing.JMenu();
        jMenuProductos = new javax.swing.JMenu();
        jMenuNuevoProducto = new javax.swing.JMenuItem();
        jMenuModifProducto = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuInventario = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuConfiguracion = new javax.swing.JMenu();
        jMenuCorte = new javax.swing.JMenu();
        jMenuReporteGanancias = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuAbout = new javax.swing.JMenuItem();
        jMenuUserManual = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());

        jLabel1.setText("Codigo de producto:");

        jTextCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCodigoActionPerformed(evt);
            }
        });

        jButAgregarProducto.setText("Agregar Producto");
        jButAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButAgregarProductoActionPerformed(evt);
            }
        });

        jTableVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo de barras", "Descripción del producto", "Precio Venta", "Importe", "Existencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableVenta);
        if (jTableVenta.getColumnModel().getColumnCount() > 0) {
            jTableVenta.getColumnModel().getColumn(0).setPreferredWidth(150);
            jTableVenta.getColumnModel().getColumn(1).setPreferredWidth(300);
            jTableVenta.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        jLabel2.setText("TOTAL PRODUCTOS:");

        jLabTotProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabTotProductos.setText("0");

        jLabel5.setText("TOTAL:");

        jTextTotal.setEditable(false);
        jTextTotal.setBackground(new java.awt.Color(102, 255, 255));
        jTextTotal.setFont(new java.awt.Font("Calibri", 2, 36)); // NOI18N
        jTextTotal.setText("$0.00");
        jTextTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTotalActionPerformed(evt);
            }
        });

        jButCobrar.setText("F12 - COBRAR");
        jButCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButCobrarActionPerformed(evt);
            }
        });

        jLabel3.setText("Cambio:");

        jLabChange.setFont(new java.awt.Font("Lucida Console", 3, 18)); // NOI18N
        jLabChange.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabChange.setText("$0.00");

        jButEliminarProducto.setText("Eliminar Producto");
        jButEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButEliminarProductoActionPerformed(evt);
            }
        });

        jMenu1.setText("Archivo");

        jMenuPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/pvgps/iconos/imprimir.png"))); // NOI18N
        jMenuPrint.setText("Imprimir");
        jMenuPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPrintActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuPrint);

        jMenuLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/pvgps/iconos/inicio.png"))); // NOI18N
        jMenuLogOut.setText(" Cerrar Sesión.");
        jMenuLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuLogOutActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuLogOut);

        jMenuExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/pvgps/iconos/salir.png"))); // NOI18N
        jMenuExit.setText(" Salir");
        jMenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuExitActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuExit);

        jMenuBar1.add(jMenu1);

        jMenuClientes.setText("Clientes");
        jMenuBar1.add(jMenuClientes);

        jMenuProductos.setText("Productos");

        jMenuNuevoProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/pvgps/iconos/nuevo.png"))); // NOI18N
        jMenuNuevoProducto.setText("Nuevo Producto");
        jMenuNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNuevoProductoActionPerformed(evt);
            }
        });
        jMenuProductos.add(jMenuNuevoProducto);

        jMenuModifProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/pvgps/iconos/editar.png"))); // NOI18N
        jMenuModifProducto.setText("Modificar Producto");
        jMenuModifProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuModifProductoActionPerformed(evt);
            }
        });
        jMenuProductos.add(jMenuModifProducto);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/pvgps/iconos/trash.png"))); // NOI18N
        jMenuItem3.setText("Eliminar Producto");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuProductos.add(jMenuItem3);

        jMenuBar1.add(jMenuProductos);

        jMenuInventario.setText("Inventario");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/pvgps/iconos/inventario.png"))); // NOI18N
        jMenuItem4.setText("Agregar a inventario");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenuInventario.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/pvgps/iconos/inventario.png"))); // NOI18N
        jMenuItem5.setText("Ajustes de inventario");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenuInventario.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/pvgps/iconos/inventario.png"))); // NOI18N
        jMenuItem6.setText("Productos Bajos de Inventario");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenuInventario.add(jMenuItem6);

        jMenuBar1.add(jMenuInventario);

        jMenuConfiguracion.setText("Configuración");
        jMenuBar1.add(jMenuConfiguracion);

        jMenuCorte.setText("Corte");

        jMenuReporteGanancias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/pvgps/iconos/corte.png"))); // NOI18N
        jMenuReporteGanancias.setText("Hacer corte");
        jMenuReporteGanancias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuReporteGananciasActionPerformed(evt);
            }
        });
        jMenuCorte.add(jMenuReporteGanancias);

        jMenuBar1.add(jMenuCorte);

        jMenu7.setText("Ayuda");

        jMenuAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/pvgps/iconos/informacion.png"))); // NOI18N
        jMenuAbout.setText("Acerca de...");
        jMenuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAboutActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuAbout);

        jMenuUserManual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/pvgps/iconos/manual.png"))); // NOI18N
        jMenuUserManual.setText("Manual de usuario");
        jMenuUserManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUserManualActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuUserManual);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButAgregarProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButEliminarProducto)
                        .addGap(0, 26, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabTotProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabChange, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButAgregarProducto)
                    .addComponent(jButEliminarProducto))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabTotProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabChange, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCodigoActionPerformed
        // TODO add your handling code here:
        
        jButAgregarProducto.doClick();
        
    }//GEN-LAST:event_jTextCodigoActionPerformed

    private void jButAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButAgregarProductoActionPerformed
        // TODO add your handling code here:   
        try{
        Double total = 0.0;
        prepararSentenciasSQL();
        prepararVista(TIT_MOD_PROD);
        String sql = propConsultasSQL.getProperty( PRODUCTOS_POR_COD_BARRAS );
        desplegarRegistros(sql, null);
        
        array.add(new Producto  (dtmPrincipal.getValueAt(0, 0)+"",
                                dtmPrincipal.getValueAt(0, 1)+"",
                                Double.parseDouble(dtmPrincipal.getValueAt(0, 2)+""),
                                Double.parseDouble(dtmPrincipal.getValueAt(0, 3)+""),
                                Integer.parseInt(dtmPrincipal.getValueAt(0, 4)+"")
                                ));
        
        modelo = new DefaultTableModel(vecNombresColumnas, array.size());
        jTableVenta.setModel(modelo);
        jTextCodigo.setText("");
        jLabTotProductos.setText(array.size()+"");
        
        modelo.setRowCount(array.size());
        modelo.setColumnCount(5);
        
        for (int j = 0; j < array.size(); j++) {
            modelo.setValueAt(array.get(j).getCodBarras(), j, 0);
            modelo.setValueAt(array.get(j).getDescripcion(), j, 1);
            modelo.setValueAt(array.get(j).getPrecio(), j, 2);
            modelo.setValueAt(array.get(j).getImporte(), j, 3);
            modelo.setValueAt(array.get(j).getExistencia(), j, 4);
           
            total += array.get(j).getPrecio();
        }
        
        subtotal = total;
        jTextTotal.setText(total+"");
        setTotal(total+"");

        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Producto no encontrado.", "Producto", JOptionPane.ERROR_MESSAGE);
        }    
        
        
    }//GEN-LAST:event_jButAgregarProductoActionPerformed

    private void jMenuPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPrintActionPerformed

        try {
            jTableVenta.print();
        } catch (PrinterException ex) {
            Logger.getLogger(JFramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuPrintActionPerformed

    private void jMenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuExitActionPerformed
        JDialogAutorizar dialog = new JDialogAutorizar(this,true);
        if(user.equals("admin")){
        ConexionDB.getInstancia().desconectar();
        System.exit(0);
        }else if(user.equals("empleado") ){
            JOptionPane.showMessageDialog(this, "Sonrie. Llame a su supervisor para cerrar la sesión");
            jMenuReporteGanancias.doClick();
            dialog.setVisible(true);
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuExitActionPerformed

    private void jMenuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAboutActionPerformed
        AcercaDeDialog dialog = new AcercaDeDialog( this , true );
        
        dialog.setNombreApp                 ( "Punto de Venta" );
        dialog.setVersionApp                ( "Versión 1.0" );
        dialog.setVisible ( true );
    }//GEN-LAST:event_jMenuAboutActionPerformed

    private void jMenuNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNuevoProductoActionPerformed
       
        prepararVista(TIT_MOD_PROD);
        String sql = propConsultasSQL.getProperty( PRODUCTOS_POR_COD_BARRAS );
        desplegarRegistros(sql, null);
        ModuloProductosDialog dialog = new ModuloProductosDialog(this,null);
        
        dialog.setVisible(true);
        
    }//GEN-LAST:event_jMenuNuevoProductoActionPerformed

    private void jMenuModifProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuModifProductoActionPerformed
        // TODO add your handling code here:
  
        ModuloModifProducto dialog = new ModuloModifProducto(this,null);
        dialog.setTitle("Inventario");
        dialog.setVisible(true);
        
    }//GEN-LAST:event_jMenuModifProductoActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        ModuloModificarEliminar dialog = new ModuloModificarEliminar(this,true);
        
        
        dialog.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
//        ModuloInventario modinv = new ModuloInventario(this,null);
//        
//        modinv.setVisible(true);
        JOptionPane.showMessageDialog(this, "PROXIMAMENTE");
        
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
//        ModuloInventario modinv = new ModuloInventario(this,null);
//        
//        modinv.setVisible(true);
        
            JOptionPane.showMessageDialog(this, "PROXIMAMENTE");

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        ModuloProdBajosDeInv modulo = new ModuloProdBajosDeInv (this, null);
        
        modulo.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jButCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButCobrarActionPerformed
        cobrar = new ModuloCobrar(this, true);
        cobrar.setVisible(true);
        
        if(cobrar.getCobrado()){
        for (int i = 0; i < array.size(); i++) {
         String sql = "UPDATE PRODUCTOS SET PROD_EXISTENCIA = PROD_EXISTENCIA-1 "
                    + "WHERE COD_BARRAS = '"+array.get(i).getCodBarras()+"'";
        try {
             int registros = EjecutorSQL.sqlEjecutar( sql , null );
             if ( registros == array.size() )
             {
                
             }
          
         } catch ( SQLException ex ) {
             dialogoMensaje( ex.toString() ); 
         }
        }
        
        jTextTotal.setText("$0.00");
        ventasTotales += subtotal;
        subtotal = 0.00;
        prepararVista(TIT_MOD_PROD);
        array.removeAll(array);
        jTextCodigo.requestFocus();
        jLabChange.setText(cobrar.getChange());

        
        }
    }//GEN-LAST:event_jButCobrarActionPerformed

    private void jTextTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTotalActionPerformed

    private void jMenuLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuLogOutActionPerformed
        // TODO add your handling code here:
        JDialogAutorizar dialog = new JDialogAutorizar(this,true);
        JFrameIniciarSesion sesion = new JFrameIniciarSesion();
        if(user.equals("admin")){
        ConexionDB.getInstancia().desconectar();
        dispose();
        sesion.setVisible(true);
        } else if(user.equals("empleado") ){
            JOptionPane.showMessageDialog(this, "Sonrie. Llame a su supervisor para cerrar la sesión");
            jMenuReporteGanancias.doClick();
            dialog.setVisible(true);
        }
        
        
        
    }//GEN-LAST:event_jMenuLogOutActionPerformed

    private void jMenuReporteGananciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuReporteGananciasActionPerformed
        // TODO add your handling code here:
        
        JOptionPane.showMessageDialog(this, "VentasTotales en el dia: $"+ventasTotales);
        
    }//GEN-LAST:event_jMenuReporteGananciasActionPerformed

    private void jButEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButEliminarProductoActionPerformed
        // TODO add your handling code here:
        JDialogCancelaciones dialog = new JDialogCancelaciones(this,true);
        if(user.equals("empleado") ){
            JOptionPane.showMessageDialog(this, "Sonrie. Llame a su supervisor para Cancelación de producto");
            dialog.setVisible(true);
            
            if(dialog.isAutorizado()){
            int confirma = JOptionPane.showConfirmDialog(this, "Seguro que quieres borrar", "Mensaje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if(confirma == JOptionPane.YES_OPTION){
           try{
        Double total = 0.0;
        array.remove(jTableVenta.getSelectedRow());
        modelo = new DefaultTableModel(vecNombresColumnas, array.size());
        jTableVenta.setModel(modelo);
        jTextCodigo.setText("");
        jLabTotProductos.setText(array.size()+"");
        
        modelo.setRowCount(array.size());
        modelo.setColumnCount(5);
        
        for (int j = 0; j < array.size(); j++) {
            modelo.setValueAt(array.get(j).getCodBarras(), j, 0);
            modelo.setValueAt(array.get(j).getDescripcion(), j, 1);
            modelo.setValueAt(array.get(j).getPrecio(), j, 2);
            modelo.setValueAt(array.get(j).getImporte(), j, 3);
            modelo.setValueAt(array.get(j).getExistencia(), j, 4);
           
            total += array.get(j).getPrecio();
        }
        
        subtotal = total;
        jTextTotal.setText(total+"");
        setTotal(total+"");
        } catch(Exception ex){
            JOptionPane.showMessageDialog(this, "seleccione un producto");
          }
         }
        }
       }else if(user.equals("admin")){
            int confirma = JOptionPane.showConfirmDialog(this, "Seguro que quieres borrar", "Mensaje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if(confirma == JOptionPane.YES_OPTION){
           try{
        Double total = 0.0;
        array.remove(jTableVenta.getSelectedRow());
        modelo = new DefaultTableModel(vecNombresColumnas, array.size());
        jTableVenta.setModel(modelo);
        jTextCodigo.setText("");
        jLabTotProductos.setText(array.size()+"");
        
        modelo.setRowCount(array.size());
        modelo.setColumnCount(5);
        
        for (int j = 0; j < array.size(); j++) {
            modelo.setValueAt(array.get(j).getCodBarras(), j, 0);
            modelo.setValueAt(array.get(j).getDescripcion(), j, 1);
            modelo.setValueAt(array.get(j).getPrecio(), j, 2);
            modelo.setValueAt(array.get(j).getImporte(), j, 3);
            modelo.setValueAt(array.get(j).getExistencia(), j, 4);
           
            total += array.get(j).getPrecio();
        }
        
        subtotal = total;
        jTextTotal.setText(total+"");
        setTotal(total+"");
        } catch(Exception ex){
            JOptionPane.showMessageDialog(this, "seleccione un producto");
          }
         }
        }
        
        
    }//GEN-LAST:event_jButEliminarProductoActionPerformed

    private void jMenuUserManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUserManualActionPerformed
        // TODO add your handling code here:
        
        try {
        File myFile = new File("./src/app/pvgps/manual/MANUAL-DE-USUARIO-EMAV.pdf");
        Desktop.getDesktop().open(myFile);
    } catch (IOException ex) {
        // no application registered for PDFs
        JOptionPane.showMessageDialog(this, "Error al abrir el archivo");
    }
        
    }//GEN-LAST:event_jMenuUserManualActionPerformed
    
    public void setTotal(String total){
        tot = total;
    }
    
    public String getTotal(){
        return tot;
    }
    
    
    public void setChange(String cambio){
        jLabChange.setText(cambio);
    }
    
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
        
       String valor = jTextCodigo.getText();
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
     
     private boolean validarDatos()
        {
            for (int i = 0; i < array.size(); i++) {
                
            
            String cod_barras =  array.get(i).getCodBarras();
            
            
            String descripcion   =  array.get(i).getDescripcion();
            
            
            double precio_costo = array.get(i).getPrecio();
            
            double importe = array.get(i).getImporte();
            
            int prod_existencia = array.get(i).getExistencia();
            
            modulo = new ModuloProductos(cod_barras, descripcion, precio_costo, importe, prod_existencia );
            
            }
            return true;
        }
     
     private void dialogoMensaje( String mensaje )
        {
            JOptionPane.showMessageDialog( this, mensaje, "Error", JOptionPane.ERROR_MESSAGE );
        }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramePrincipal("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButAgregarProducto;
    private javax.swing.JButton jButCobrar;
    private javax.swing.JButton jButEliminarProducto;
    private javax.swing.JLabel jLabChange;
    private javax.swing.JLabel jLabTotProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuItem jMenuAbout;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuClientes;
    private javax.swing.JMenu jMenuConfiguracion;
    private javax.swing.JMenu jMenuCorte;
    private javax.swing.JMenuItem jMenuExit;
    private javax.swing.JMenu jMenuInventario;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuLogOut;
    private javax.swing.JMenuItem jMenuModifProducto;
    private javax.swing.JMenuItem jMenuNuevoProducto;
    private javax.swing.JMenuItem jMenuPrint;
    private javax.swing.JMenu jMenuProductos;
    private javax.swing.JMenuItem jMenuReporteGanancias;
    private javax.swing.JMenuItem jMenuUserManual;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVenta;
    private javax.swing.JTextField jTextCodigo;
    private javax.swing.JTextField jTextTotal;
    // End of variables declaration//GEN-END:variables
    //-------------------------------------------------------------------------------------------- 
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

    public JButton getJButAgregarProducto() {
        return jButAgregarProducto;
    }
    
    public JMenuItem getJMenuSalir(){
        return jMenuExit;
    }
    
    public JMenuItem getJMenuCorte(){
        return jMenuReporteGanancias;
    }   
    
}
