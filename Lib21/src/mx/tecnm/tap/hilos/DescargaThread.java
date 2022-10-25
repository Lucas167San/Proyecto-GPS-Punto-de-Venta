/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                       TOPICOS AVANZADOS DE PROGRAMACION "B"
:*
:*                   SEMESTRE: AGO-DIC/2021    HORA: 17-18 HRS
:*
:*             Clase hilo que permite la descarga de archivos de la web
:*        
:*  Archivo     : DescargaThread.java
:*  Autor       : Gerardo Daniel Vazquez Zapata 19130982
                  Victor Manuel Torres Vega     17130071
:*  Fecha       : 09/dic/2021
:*  Compilador  : JDK 11 + Netbeans 
:*  Descripci�n : Esta clase permite la validacion de archivo a descargar
                  permitiendole tambien, hacer la descarga, por medio de hilos.
                  Permite la multiDescarga de archivos si el usuario asi lo desea.
:*  Ultima modif:
:*  Fecha       Modific�                              Motivo
:*========================================================================================== 
:*  09/dic/2021 17130071 Victor Manuel Torres Vega      Agregado de prológo, Implementacion de aplicacion
:*  09/dic/2021 19130982 Gerardo Daniel Vazquez Zapata  Implementacion de aplicacion, Calidad de codigo
:*------------------------------------------------------------------------------------------*/
package mx.tecnm.tap.hilos;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


    public class DescargaThread extends Thread {
    public  URLConnection   conexion;
            String          url; //direccion url destino
            String          nomAr; //nombre archivo destino
    
            String          dirDes; //directorio destino
    
//---------------------------------------------------------------------------------------------        
    public DescargaThread ( ) {
        super ( ) ;
    }
//---------------------------------------------------------------------------------------------   
    public DescargaThread ( String nomAr, String url, String dirDes ){
        super ( nomAr );
        this.nomAr  = nomAr;
        this.url    = url;
        this.dirDes = dirDes;
    }
//---------------------------------------------------------------------------------------------    
    @Override
    public void run ( ){
            
                try {
                    File destino = new File( dirDes );

                if ( !destino.exists ( ) )
                    if  ( !destino.mkdir ( ) )
                    return; // no se pudo crear la carpeta de destino

                File file = new File ( dirDes + nomAr );


                try {
                
                conexion = new URL ( url ).openConnection ( );
                conexion.connect    ( );
                System.out.println  ( "\n Empezando descarga: \n" );
                System.out.println  ( ">> URL: "    + url );
                System.out.println  ( ">> Nombre: " + nomAr );
                System.out.println  ( ">> tamaño: " + conexion.getContentLength ( ) + " bytes" );
                
                InputStream in = conexion.getInputStream ( ) ;
                OutputStream out = new FileOutputStream ( file );
                
                
                int b = 0;
                int p = 0;
                while ( b != -1 ) {
                b =  in.read ( ) ;
                 
                if ( b != -1 )
                out.write ( b );
                }
                
                out.close ( );
                in.close  ( );
                
                JOptionPane.showMessageDialog ( null, "Archivo, Descargado!!" );
                
                
                } catch  ( MalformedURLException e ) {
                System.out.println ( "la url: " + url + " no es valida!" );
                } catch  ( IOException e ) {
                e.printStackTrace ( ) ;
            }
                    Thread.sleep ( 50 );
                } catch ( InterruptedException ex ) {
                    Logger.getLogger(DescargaThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
//---------------------------------------------------------------------------------------------
    
   

 
    }
