/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                       TOPICOS AVANZADOS DE PROGRAMACION "B"
:*
:*                   SEMESTRE: AGO-DIC/2021    HORA: 17-18 HRS
:*
:*             Clase que presenta la Interfaz Grafica de un acerca de.
:*        
:*  Archivo     : AcercaDeDialog.java
:*  Autor       : Victor Manuel Torres Vega    17130071
:*  Fecha       : 05/oct/2021
:*  Compilador  : JDK 11 + Netbeans 
:*  Descripci�n : Esta clase genera la interfaz grafica del acercaDe, permite una
                  insercion de datos correspondientes a la version, integrantes adicionales
                  titulo de aplicacion
:*  Ultima modif:
:*  Fecha       Modific�                              Motivo
:*========================================================================================== 
:*  01/oct/2021 17130071 Victor Manuel Torres Vega    Agregado de prológo.
:*  05/oct/2021 17130071 Victor Manuel Torres Vega    Actualización de acercaDe
:*------------------------------------------------------------------------------------------*/
package mx.tecnm.tap.extras;

import javax.swing.Icon;
import javax.swing.JLabel;
import mx.tecnm.tap.util.Imagenes;
/**
 *
 * @author luxxo
 */
public class AcercaDeDialog extends javax.swing.JDialog {

    /**
     * Creates new form AcercaDeDialog
     */
    
//---------------------------------------------------------------------------------------------
    public AcercaDeDialog( java.awt.Frame parent, boolean modal ) {
        super( parent, modal );
        initComponents( );
        
        //Ajustar dimensiones de logos
      Icon logoTecnm =  Imagenes.escalarImagen( jLabTecNm.getIcon ( ), 
                                                jLabTecNm.getWidth ( ), 
                                                jLabTecNm.getHeight ( ) );
        
      Icon logoTecLag = Imagenes.escalarImagen( jLabItla.getIcon ( ),
                                                jLabItla.getWidth ( ), 
                                                jLabItla.getHeight ( ) );
      
      jLabTecNm.setIcon ( logoTecnm );
      jLabItla.setIcon ( logoTecLag );
      
      
    }
//---------------------------------------------------------------------------------------------   
    public AcercaDeDialog ( java.awt.Frame parent, boolean modal, String nombreApp, String versionApp )
    {
        this( parent, modal );
        this.jLabNombreApp.setText ( nombreApp );
        this.jLabVersiónApp.setText ( versionApp );
    }
//---------------------------------------------------------------------------------------------    
    public void setNombreApp ( String nombreApp )
    {
        jLabNombreApp.setText( nombreApp );
    }
//---------------------------------------------------------------------------------------------    
    public String getNombreApp ( )
    {
        return jLabNombreApp.getText ( ) ;
    }
//---------------------------------------------------------------------------------------------    
    public void setVersionApp( String versionApp )
    {
        jLabVersiónApp.setText ( versionApp );
    }
//---------------------------------------------------------------------------------------------   
    public String getVersionApp ( )
    {
        return jLabVersiónApp.getText ( ) ;
    }
//---------------------------------------------------------------------------------------------
    public String getjLblIntegranteAdicional () {
        return jLblIntegranteAdicional.getText ();
    }
//---------------------------------------------------------------------------------------------
    public void setjLblIntegranteAdicional( String IntegranteAdicional ) {
        this.jLblIntegranteAdicional.setText( IntegranteAdicional );
    }
//---------------------------------------------------------------------------------------------
    public String getjLblNoControl () {
        return jLblNoControl.getText ( );
    }
//---------------------------------------------------------------------------------------------
    public void setjLblNoControl ( String NoControl ) {
        this.jLblNoControl.setText( NoControl );
    }
//---------------------------------------------------------------------------------------------
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabTecNm = new javax.swing.JLabel();
        jLabItla = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabNombreApp = new javax.swing.JLabel();
        jLabVersiónApp = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLblIntegranteAdicional = new javax.swing.JLabel();
        jLblNoControl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acerca de");

        jLabTecNm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logos/logo_TecNm.png"))); // NOI18N
        jLabTecNm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabItla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logos/logo_itla.gif"))); // NOI18N
        jLabItla.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TECNOLÓGICO NACIONAL DE MÉXICO");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("INSTITUTO TÉCNOLOGICO DE LA LAGUNA");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("INGENIERÍA EN SISTEMAS COMPUTACIONALES");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Gestión de Proyectos de Software");

        jLabNombreApp.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabNombreApp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabNombreApp.setText("Nombre de la Aplicación");

        jLabVersiónApp.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabVersiónApp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabVersiónApp.setText("Ver. 0.0");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("(C) Derechos Reservados 2022");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(jLblIntegranteAdicional, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLblNoControl, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabItla, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabTecNm, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabNombreApp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabVersiónApp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabTecNm, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabItla, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabNombreApp)
                        .addGap(18, 18, 18)
                        .addComponent(jLabVersiónApp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblNoControl, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblIntegranteAdicional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AcercaDeDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AcercaDeDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AcercaDeDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AcercaDeDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AcercaDeDialog dialog = new AcercaDeDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabItla;
    private javax.swing.JLabel jLabNombreApp;
    private javax.swing.JLabel jLabTecNm;
    private javax.swing.JLabel jLabVersiónApp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLblIntegranteAdicional;
    private javax.swing.JLabel jLblNoControl;
    // End of variables declaration//GEN-END:variables
}
