/*------------------------------------------------------------------------------------------
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                       TOPICOS AVANZADOS DE PROGRAMACION  
:*
:*                   SEMESTRE: Ago-Dic/2020    HORA: 17-18 HRS
:*
:*          Clase con metodo que permite ajustar el ancho y alto de una imagen
:*              
:*        
:*  Archivo     : Imagenes.java
:*  Autor       : Ing. Fernando Gil
:*  Fecha       : 04/10/2020
:*  Compilador  : JAVA J2SE v1.8.0
:*  Descripción : El metodo estatico escalarImagen () es el más adecuado de usar para 
:*                ajustar el ancho y alto de la imagen de un objeto Icon. 
:*                El metodo recibe 3 argumentos: el objeto Icon y el ancho y alto al que
:*                se desea ajustar. El metodo devuelve un objeto Icon con la imagen ya
:*                redimensionada.
:*  
:*  Ultima modif:
:*  Fecha       Modific?             Motivo
:*========================================================================================== 
:*  04/10/2020  F.Gil           -Actualizar informacion del prologo.
:*------------------------------------------------------------------------------------------*/ 

package mx.tecnm.tap.util;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Imagenes {

    //------------------------------------------------------------------------------------------------------------
	
    public static Image getScaledImage ( Image srcImg, int w, int h )  {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }

    //------------------------------------------------------------------------------------------------------------
	
    public static Icon escalarImagen  ( Icon srcImg, int w, int h ) {
        Image img =  ( (ImageIcon) srcImg ).getImage ();
        img = getScaledImage ( img, w, h );
        return new ImageIcon ( img );
    }
	
    //------------------------------------------------------------------------------------------------------------
}
