/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                       TOPICOS AVANZADOS DE PROGRAMACION "B"
:*
:*                   SEMESTRE: AGO-DIC/2021    HORA: 17-18 HRS
:*
:*             Clase que presenta la Interfaz Grafica de un Bean
:*        
:*  Archivo     : JSeleccionBean.java
:*  Autor       : Victor Manuel Torres Vega    17130071
:*  Fecha       : 10/nov/2021
:*  Compilador  : JDK 11 + Netbeans 
:*  Descripci�n : Esta clase, genera la interfaz grafica de 2 listas un boton
:*                y un dialogo de movimientos, permitiendo mover elementos
:*                entre las 2 listas.
:*                
:*  Ultima modif:
:*  Fecha       Modific�                              Motivo
:*========================================================================================== 
:*  10/nov/2021 17130071 Victor Manuel Torres Vega    Agregado de prológo.
:*  
:*------------------------------------------------------------------------------------------*/
package mx.tecnm.tap.beans;

import javax.swing.AbstractListModel;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author luxxo
 */
public class JSeleccionBean extends javax.swing.JPanel {

    /**
     * Creates new form JSeleccionBean
     */
//--------------------------------------------------------------------------------------    
   //creamos los modelos para poder manipular las listas
   private DefaultListModel <String> modeloDisp = new DefaultListModel  () ;
   private DefaultListModel <String> modeloSelec = new DefaultListModel () ;

//--------------------------------------------------------------------------------------   
   //enteros para la seleccion de evento
   public static final int SELECCIONADOS_UNO =1;
   public static final int SELECCIONADOS_TODOS = 2;
   public static final int DESELECCIONADOS_UNO = 3;
   public static final int DESELECCIONADOS_TODOS = 4;
   
   
   private ArrayList <SeleccionListener> seleccionListeners = new ArrayList<> ();
//---------------------------------------------------------------------------------- 
   
   
   
    public JSeleccionBean ( ) {
        initComponents ( );
        
        //Establecemos los modelos predefinidos en las listas
        jListDisponibles.setModel   ( modeloDisp ) ;
        jListSeleccionados.setModel ( modeloSelec ) ;
        
    }
    
    
//----------------------------------------------------------------------------------
    
    public void addSeleccionListener ( SeleccionListener listener )
    {
        seleccionListeners.add ( listener ) ;
    }
//----------------------------------------------------------------------------------
    
    public void removeSeleccionListener ( SeleccionListener listener )
    {
        seleccionListeners.remove ( listener ) ;
    }
//----------------------------------------------------------------------------------
    
    private void fireSeleccionEvent ( SeleccionEvent evt )
    {
        for( SeleccionListener listener : seleccionListeners )
            listener.seleccionRealizada ( evt ) ;
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItAcercaDe = new javax.swing.JMenuItem();
        jLabelTituloDisponibles = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListDisponibles = new javax.swing.JList<>();
        jButSeleccionarUno = new javax.swing.JButton();
        jButDeseleccionarUno = new javax.swing.JButton();
        jButSeleccionarTodos = new javax.swing.JButton();
        jButDeseleccionarTodos = new javax.swing.JButton();
        jLabTotalDisponibles = new javax.swing.JLabel();
        jLabLeyenTotDisponibles = new javax.swing.JLabel();
        jLabTituloSeleccionados = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListSeleccionados = new javax.swing.JList<>();
        jLabTotalSeleccionados = new javax.swing.JLabel();
        jLabLeyenTotSeleccionados = new javax.swing.JLabel();

        jMenuItAcercaDe.setText("Acerca De...");
        jMenuItAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItAcercaDeActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItAcercaDe);

        setComponentPopupMenu(jPopupMenu1);

        jLabelTituloDisponibles.setText("Disponibles:");

        jListDisponibles.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Chicharito", "Carlos Vela", "Gio Dos Santos", "Chucky Lozano" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListDisponibles.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListDisponibles.setSelectedIndex(1);
        jScrollPane1.setViewportView(jListDisponibles);

        jButSeleccionarUno.setText(">");
        jButSeleccionarUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButSeleccionarUnoActionPerformed(evt);
            }
        });

        jButDeseleccionarUno.setText("<");
        jButDeseleccionarUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButDeseleccionarUnoActionPerformed(evt);
            }
        });

        jButSeleccionarTodos.setText(">>");
        jButSeleccionarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButSeleccionarTodosActionPerformed(evt);
            }
        });

        jButDeseleccionarTodos.setText("<<");
        jButDeseleccionarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButDeseleccionarTodosActionPerformed(evt);
            }
        });

        jLabTotalDisponibles.setText("4");

        jLabLeyenTotDisponibles.setText("Disponibles");

        jLabTituloSeleccionados.setText("Seleccionados:");

        jListSeleccionados.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Cepillo Peralta", "Pony Ruiz", "Luis Hernandez" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListSeleccionados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListSeleccionados.setSelectedIndex(2);
        jScrollPane2.setViewportView(jListSeleccionados);

        jLabTotalSeleccionados.setText("3");

        jLabLeyenTotSeleccionados.setText("seleccionados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTituloDisponibles)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabTotalDisponibles)
                                .addGap(18, 18, 18)
                                .addComponent(jLabLeyenTotDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButSeleccionarUno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButDeseleccionarUno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButSeleccionarTodos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(jButDeseleccionarTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabTituloSeleccionados)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabTotalSeleccionados)
                                .addGap(18, 18, 18)
                                .addComponent(jLabLeyenTotSeleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTituloDisponibles)
                    .addComponent(jLabTituloSeleccionados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButSeleccionarUno)
                        .addGap(18, 18, 18)
                        .addComponent(jButDeseleccionarUno)
                        .addGap(23, 23, 23)
                        .addComponent(jButSeleccionarTodos)
                        .addGap(26, 26, 26)
                        .addComponent(jButDeseleccionarTodos))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabTotalDisponibles)
                    .addComponent(jLabLeyenTotDisponibles)
                    .addComponent(jLabTotalSeleccionados)
                    .addComponent(jLabLeyenTotSeleccionados))
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
//----------------------------------------------------------------------------------
    private void jButSeleccionarUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButSeleccionarUnoActionPerformed
       
        //obtenemos el elemento y lo guardamos en la variable
        String elemento = modeloDisp.getElementAt ( this.jListDisponibles.getSelectedIndex ( ) );
        
        //obtenemos el index definido y lo guardamos como entero
        int indice = jListDisponibles.getSelectedIndex () ;
        
        //si el entero es menor que uno, hacer proceso
        if( indice != -1 )
        {
            //guardamos, eliminamos elemento y lo cambiamos a la otra lista, actualizamos el contador.
            String element = modeloDisp.getElementAt    ( indice );
            modeloDisp.removeElementAt                  ( indice );
            modeloSelec.addElement                      ( element );
            this.jLabTotalDisponibles.setText           ( modeloDisp.getSize ( ) + "" );
            this.jLabTotalSeleccionados.setText         ( modeloSelec.getSize( ) + "" );
        }
        //Crear = inicializar al EventObject para disparar el evento;
        SeleccionEvent evento = new SeleccionEvent ( SELECCIONADOS_UNO , new String [] { elemento } );
      
        //disparamos el evento
        fireSeleccionEvent ( evento );
    }//GEN-LAST:event_jButSeleccionarUnoActionPerformed
//----------------------------------------------------------------------------------
    private void jMenuItAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItAcercaDeActionPerformed
        
            JOptionPane.showMessageDialog( this, "Tecnologico Nacional de México campus La Laguna \n "
                + "[ISC] Topicos Avanzados de Programación \n \n"
                + "JSeleccionBean v1.0 \n\n"
                + "Autor: \n "
                + "17130071 Victor Manuel Torres Vega \n\n"
                + "(C) Derechos Reservados 2021", "Acerca de...", JOptionPane.INFORMATION_MESSAGE );

         
          
    }//GEN-LAST:event_jMenuItAcercaDeActionPerformed
//--------------------------------------------------------------------------------------
    private void jButDeseleccionarUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButDeseleccionarUnoActionPerformed
        //obtenemos el elemento y lo guardamos en la variable
        String elemento = modeloDisp.getElementAt ( this.jListSeleccionados.getSelectedIndex ( ) );
        //obtenemos el index definido y lo guardamos como entero
        int indice = jListSeleccionados.getSelectedIndex ( );
        //si el entero es menor que uno, hacer proceso
        if( indice != -1 )
        {
            //guardamos, eliminamos elemento y lo cambiamos a la otra lista, actualizamos el contador.
            String element = modeloSelec.getElementAt   ( indice );
            modeloSelec.removeElementAt                 ( indice );
            modeloDisp.addElement                       ( element );
            this.jLabTotalDisponibles.setText           ( modeloDisp.getSize ( ) + "" );
            this.jLabTotalSeleccionados.setText         ( modeloSelec.getSize ( ) + "" );
        }
        //Crear = inicializar al EventObject para disparar el evento;
        SeleccionEvent evento = new SeleccionEvent ( DESELECCIONADOS_UNO , new String [] { elemento } );
      //disparamos el evento
       fireSeleccionEvent ( evento );
    }//GEN-LAST:event_jButDeseleccionarUnoActionPerformed
//--------------------------------------------------------------------------------------
    private void jButSeleccionarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButSeleccionarTodosActionPerformed
        //creamos variable elemento y la inicializamos en null
        String elemento = null;
        //condicional si no esta vacio
        if ( modeloDisp.getSize ( ) > 0 )
        {
            //guardamos el elemento en la cadena, en tal posicion.
            //y lo pasamos al otro lado y asi hasta que termine el ciclo
            for ( int i = 0; i < modeloDisp.getSize ( ); i++ ) {
               elemento = modeloDisp.getElementAt   ( i );
                modeloSelec.addElement              ( elemento );
               
            }
            
            //eliminamos los elementos que ibamos a vaciar
            modeloDisp.removeAllElements ( );
            //actualizamos contador
            jLabTotalDisponibles.setText ( modeloDisp.getSize ( ) + "" );
            jLabTotalSeleccionados.setText( modeloSelec.getSize ( ) + "" );
            
        }
        
        
        //Crear = inicializar al EventObject para disparar el evento;
        SeleccionEvent evento = new SeleccionEvent ( SELECCIONADOS_TODOS , this.getElementosSeleccionados ( ) );
        
        //Disparamos el evento
        fireSeleccionEvent ( evento );
    }//GEN-LAST:event_jButSeleccionarTodosActionPerformed
//--------------------------------------------------------------------------------------
    private void jButDeseleccionarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButDeseleccionarTodosActionPerformed
       //creamos variable elemento y la inicializamos en null
        String elemento = null;
        //condicional si no esta vacio
        if( modeloSelec.getSize ( ) > 0 )
        {
            //guardamos el elemento en la cadena, en tal posicion.
            //y lo pasamos al otro lado y asi hasta que termine el ciclo
            for ( int i = 0; i < modeloSelec.getSize ( ); i++ ) {
               elemento = modeloSelec.getElementAt   ( i );
                modeloDisp.addElement                ( elemento );
            }
            //eliminamos los elementos que ibamos a vaciar
            modeloSelec.removeAllElements ( );
            //actualizamos contador
            jLabTotalDisponibles.setText   ( modeloDisp.getSize ( ) + "" );
            jLabTotalSeleccionados.setText ( modeloSelec.getSize ( ) + "" );
            
        }
        //Crear = inicializar al EventObject para disparar el evento;
        SeleccionEvent evento = new SeleccionEvent ( DESELECCIONADOS_TODOS , this.getElementosDisponibles ( ) );
      
        //Disparamos el evento
        fireSeleccionEvent ( evento );
    }//GEN-LAST:event_jButDeseleccionarTodosActionPerformed
//--------------------------------------------------------------------------------------
    public void cambiarModelo( JList listaFuente , ListModel modeloPasado , DefaultListModel modeloNuevo )
    {
        modeloNuevo.removeAllElements ( );
        for ( int i = 0; i < modeloPasado.getSize ( ); i++ ) {
            modeloNuevo.addElement ( modeloPasado.getElementAt ( i ) );
        }
        
        listaFuente.setModel ( modeloNuevo );
    }
//--------------------------------------------------------------------------------------
    
    
//----------------------------------------------------------------------------------
    public void setTituloDisponibles ( String tituloDisponible )
    {
        this.jLabelTituloDisponibles.setText ( tituloDisponible );
    }
//----------------------------------------------------------------------------------    
    public String getTituloDisponibles ( )
    {
        return this.jLabelTituloDisponibles.getText ( );
    }
//----------------------------------------------------------------------------------    
    public void setTituloSeleccionados ( String tituloSeleccionados )
    {
        this.jLabTituloSeleccionados.setText ( tituloSeleccionados );
    }
//----------------------------------------------------------------------------------    
    public String getTituloSeleccionados ( )
    {
        return this.jLabTituloSeleccionados.getText ( );
    }
//----------------------------------------------------------------------------------    
    public void setButSeleccionarUno ( String leyenda )
    {
        this.jButSeleccionarUno.setText ( leyenda );
    }
//----------------------------------------------------------------------------------    
    public String getButSeleccionarUno ( )
    {
     return this.jButSeleccionarUno.getText ( );
    }
//----------------------------------------------------------------------------------    
    public void setButSeleccionarTodos ( String leyenda )
    {
        this.jButSeleccionarTodos.setText ( leyenda );
    }
//----------------------------------------------------------------------------------    
    public String getButSeleccionarTodos ( )
    {
     return this.jButSeleccionarTodos.getText ( );
    }
//----------------------------------------------------------------------------------    
    public void setButDesSeleccionarUno ( String leyenda )
    {
       this.jButDeseleccionarUno.setText ( leyenda );
    }
//----------------------------------------------------------------------------------    
    public String getButDesSeleccionarUno ( )
    {
        return this.jButDeseleccionarUno.getText ( );
    }
//----------------------------------------------------------------------------------    
    public void setButDesSeleccionarTodos ( String leyenda )
    {
        this.jButDeseleccionarTodos.setText ( leyenda );
    }
//----------------------------------------------------------------------------------    
    public String getButDesSeleccionarTodos ( )
    {
     return this.jButDeseleccionarTodos.getText ( );
    }
//----------------------------------------------------------------------------------    
    public void setListaDisponibles ( ListModel disponibles )
    {
        cambiarModelo ( jListDisponibles , disponibles , modeloDisp );
        jLabTotalDisponibles.setText ( jListDisponibles.getModel ( ).getSize ( ) + "" );
        if ( jListDisponibles.getModel ( ).getSize ( ) > 0 )
        jListDisponibles.setSelectedIndex ( 0 );
    }
//----------------------------------------------------------------------------------    
    public ListModel getListaDisponibles ( )
    {
        return jListDisponibles.getModel ( );
    }
//----------------------------------------------------------------------------------    
    public void setListaSeleccionados ( ListModel seleccionados )
    {
        cambiarModelo ( jListSeleccionados , seleccionados , modeloSelec );
        jLabTotalSeleccionados.setText ( jListSeleccionados.getModel ( ).getSize ( ) + "" );
        if( jListSeleccionados.getModel ( ).getSize ( ) > 0 )
            jListSeleccionados.setSelectedIndex ( 0 );
    }
//----------------------------------------------------------------------------------    
    public ListModel getListaSeleccionados ( )
    {
        return jListSeleccionados.getModel ( );
    }
//----------------------------------------------------------------------------------        
    
    public void setLeyendaTotalDisponibles ( String leyenda )
    {
        this.jLabLeyenTotDisponibles.setText ( leyenda );
    }
//----------------------------------------------------------------------------------    
    public String getLeyendaTotalDisponibles ( )
    {
        return this.jLabLeyenTotDisponibles.getText ( );
    }
//----------------------------------------------------------------------------------    
    public void setLeyendaTotalSeleccionados ( String leyenda )
    {
        this.jLabTotalSeleccionados.setText ( leyenda );
    }
//----------------------------------------------------------------------------------    
    public String getLeyendaTotalSeleccionados ( )
    {
        return this.jLabTotalSeleccionados.getText ( );
    }
//----------------------------------------------------------------------------------    
    public void setColorFondo ( Color color )
    {
        this.setBackground ( color );
    }
//----------------------------------------------------------------------------------    
    public Color getColorFondo ( )
    {
        return this.getBackground ( );
    }
//----------------------------------------------------------------------------------    
    public int getTotalDisponibles ( )
    {
        return modeloDisp.getSize ( );
    }
//----------------------------------------------------------------------------------    
    public int getTotalSeleccionados ( )
    {
        return modeloSelec.getSize ( );
    }
//----------------------------------------------------------------------------------    
    public String [] getElementosDisponibles ( )
    {
        String [] elementos = new String[ getTotalDisponibles ( ) ];
        
        for ( int i = 0; i < getTotalDisponibles ( ); i++ ) {
            elementos[ i ] = modeloDisp.getElementAt ( i );
        }
        return elementos;
    }
//----------------------------------------------------------------------------------    
     public String [] getElementosSeleccionados ( )
    {
        String [] elementos = new String [ getTotalSeleccionados ( ) ];
        
        for (int i = 0; i < getTotalSeleccionados ( ); i++) {
            elementos[ i ] = modeloSelec.getElementAt ( i );
        }
        return elementos;
    }
//----------------------------------------------------------------------------------
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButDeseleccionarTodos;
    private javax.swing.JButton jButDeseleccionarUno;
    private javax.swing.JButton jButSeleccionarTodos;
    private javax.swing.JButton jButSeleccionarUno;
    private javax.swing.JLabel jLabLeyenTotDisponibles;
    private javax.swing.JLabel jLabLeyenTotSeleccionados;
    private javax.swing.JLabel jLabTituloSeleccionados;
    private javax.swing.JLabel jLabTotalDisponibles;
    private javax.swing.JLabel jLabTotalSeleccionados;
    private javax.swing.JLabel jLabelTituloDisponibles;
    private javax.swing.JList<String> jListDisponibles;
    private javax.swing.JList<String> jListSeleccionados;
    private javax.swing.JMenuItem jMenuItAcercaDe;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    
}
