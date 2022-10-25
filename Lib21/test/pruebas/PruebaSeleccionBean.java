/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                       TOPICOS AVANZADOS DE PROGRAMACION "B"
:*
:*                   SEMESTRE: AGO-DIC/2021    HORA: 17-18 HRS
:*
:*             Clase que presenta la Interfaz Grafica del JSeleccionBean personalizado para santos.
:*        
:*  Archivo     : BeanSantosFrame.java
:*  Autor       : Victor Manuel Torres Vega    17130071
:*  Fecha       : 10/nov/2021
:*  Compilador  : JDK 11 + Netbeans 
:*  Descripci�n : Esta clase, genera la interfaz grafica de 2 listas un boton
:*                y un dialogo de movimientos, permitiendo mover elementos
:*                entre las 2 listas y mostrar los elementos en un dialogo correspondiente
:*                esta interfaz grafica esta diseñada en un bean por lo que no hace falta
:*                crearla, solamente reutilizar el bean para poder modificarlo.
:*  Ultima modif:
:*  Fecha       Modific�                              Motivo
:*========================================================================================== 
:*  10/nov/2021 17130071 Victor Manuel Torres Vega    Agregado de prológo.
:*  
:*------------------------------------------------------------------------------------------*/
package pruebas;

import java.util.Arrays;
import javax.swing.JOptionPane;
import mx.tecnm.tap.beans.JSeleccionBean;
import mx.tecnm.tap.beans.SeleccionEvent;
import mx.tecnm.tap.beans.SeleccionListener;

/**
 *
 * @author luxxo
 */
public class PruebaSeleccionBean extends javax.swing.JFrame implements SeleccionListener{

    /**
     * Creates new form pruebaSeleccionBeanFrame
     */
//----------------------------------------------------------------------------------
    public PruebaSeleccionBean() {
        initComponents();
        
        //Registrar frame como listener del jSeleccionBean
        this.jSeleccionBean1.addSeleccionListener( this );
    }
//----------------------------------------------------------------------------------
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButAceptar = new javax.swing.JButton();
        jSeleccionBean1 = new mx.tecnm.tap.beans.JSeleccionBean();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDisparo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Oficina Almada");

        jButAceptar.setText("Aceptar");
        jButAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButAceptarActionPerformed(evt);
            }
        });

        jSeleccionBean1.setColorFondo(new java.awt.Color(51, 255, 51));
        jSeleccionBean1.setListaDisponibles(new javax.swing.AbstractListModel() {
            String[] strings = { "Carlos Acevedo", "Manuel Lajud", "Joel García", "Ismael Govea", "Jhonathan Díaz", "Felix Torres", "Hugo Rodriguez", "Matheus Doria", "Alan Cervantes", "Juan Otero", "Carlos Orrantia", "Diego Valdes", "Fernando Gorriaran", "David Andrade", "Braian Lozano", "Ulises Rivas", "Jose Avila", "Ronaldo Prieto", "Andres Ibargüen", "Jesus Isijara", "Alesio Da Cruz", "Jesus Ocejo", "Eduardo Aguirre", "Ignacio Jeraldinho", "Eduar Preciado" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jSeleccionBean1.setLeyendaTotalSeleccionados("0");

        jTextAreaDisparo.setEditable(false);
        jTextAreaDisparo.setBackground(new java.awt.Color(0, 0, 0));
        jTextAreaDisparo.setColumns(20);
        jTextAreaDisparo.setFont(new java.awt.Font("Lucida Sans", 1, 13)); // NOI18N
        jTextAreaDisparo.setForeground(new java.awt.Color(0, 255, 0));
        jTextAreaDisparo.setLineWrap(true);
        jTextAreaDisparo.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDisparo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButAceptar)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeleccionBean1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeleccionBean1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
//----------------------------------------------------------------------------------
    
    
    private void jButAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButAceptarActionPerformed

        //Tomamos como titulo guerreros disponibles y el contador
        String disponibles = "Guerreros Disponibles: " + this.jSeleccionBean1.getTotalDisponibles() 
                + "\n\n";
        //en el ciclo agregamos y formateamos la variable disponibles y le vamos agregando conforme el ciclo va
        //avanzando
        for (int i = 0; i < jSeleccionBean1.getElementosDisponibles().length; i++) {
            disponibles += String.format(this.jSeleccionBean1.getElementosDisponibles()[i]+"\n",
                    i, jSeleccionBean1.getElementosDisponibles()[i]);
        }
        
        
        //Tomamos como titulo guerreros disponibles y el contador
        String seleccionados = "Guerreros Seleccionados: " + this.jSeleccionBean1.getTotalSeleccionados() 
                + "\n\n";
        
        //en el ciclo agregamos y formateamos la variable disponibles y le vamos agregando conforme el ciclo va
        //avanzando
        for (int i = 0; i < jSeleccionBean1.getElementosSeleccionados().length; i++) {
            seleccionados += String.format(this.jSeleccionBean1.getElementosSeleccionados()[i]+"\n",
                    i, jSeleccionBean1.getElementosSeleccionados()[i]);
        }
        
        //mostramos lo que almacenamos en las variable
        JOptionPane.showMessageDialog(this, disponibles,"Santos Laguna Informa:", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(this, seleccionados, "Santos Laguna Informa:", JOptionPane.INFORMATION_MESSAGE);
            
    }//GEN-LAST:event_jButAceptarActionPerformed
//----------------------------------------------------------------------------------
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
            java.util.logging.Logger.getLogger(PruebaSeleccionBean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PruebaSeleccionBean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PruebaSeleccionBean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PruebaSeleccionBean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PruebaSeleccionBean().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButAceptar;
    private javax.swing.JScrollPane jScrollPane1;
    private mx.tecnm.tap.beans.JSeleccionBean jSeleccionBean1;
    private javax.swing.JTextArea jTextAreaDisparo;
    // End of variables declaration//GEN-END:variables
//----------------------------------------------------------------------------------
    @Override
    public void seleccionRealizada(SeleccionEvent evt) {
        if( evt.getMovimiento() == JSeleccionBean.SELECCIONADOS_UNO)
        {
            this.jTextAreaDisparo.setText("Se selecciono 1 elemento: " + evt.getElementos()[0]);
        }
        
        if(evt.getMovimiento() == JSeleccionBean.DESELECCIONADOS_UNO)
        {
            this.jTextAreaDisparo.setText("Se Deselecciono 1 elemento: " + evt.getElementos()[0]);
        }
        
        if(evt.getMovimiento() == JSeleccionBean.SELECCIONADOS_TODOS)
        {
            this.jTextAreaDisparo.setText("");
            this.jTextAreaDisparo.setText("Se seleccionaron todos los elementos: \n\n");
            for (int i = 0; i < evt.getElementos().length; i++) {                
            jTextAreaDisparo.append (evt.getElementos()[i]+"\n");
            }
            this.jTextAreaDisparo.setCaretPosition(0);
            
        }
        
        if(evt.getMovimiento() == JSeleccionBean.DESELECCIONADOS_TODOS)
        {
            this.jTextAreaDisparo.setText("");
            this.jTextAreaDisparo.setText("Se Deseleccionaron todos los elementos: \n\n");
            for (int i = 0; i < evt.getElementos().length; i++) {                
            jTextAreaDisparo.append (evt.getElementos()[i]+"\n");
            }
            this.jTextAreaDisparo.setCaretPosition(0);
        }
    }
//----------------------------------------------------------------------------------    
}
