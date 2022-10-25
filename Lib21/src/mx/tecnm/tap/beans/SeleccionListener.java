/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                       TOPICOS AVANZADOS DE PROGRAMACION "B"
:*
:*                   SEMESTRE: AGO-DIC/2021    HORA: 17-18 HRS
:*
:*                  Clase que presenta la escucha de seleccion
:*        
:*  Archivo     : SeleccionListener.java
:*  Autor       : Victor Manuel Torres Vega    17130071
:*  Fecha       : 10/nov/2021
:*  Compilador  : JDK 11 + Netbeans 
:*  Descripci�n : Esta clase, solamente espera la interaccion de SeleccionEvent.java
:*  Ultima modif:
:*  Fecha       Modific�                              Motivo
:*========================================================================================== 
:*  10/nov/2021 17130071 Victor Manuel Torres Vega    Agregado de prológo.
:*  
:*------------------------------------------------------------------------------------------*/
package mx.tecnm.tap.beans;

/**
 *
 * @author luxxo
 */
//--------------------------------------------------------------------------------------
public interface SeleccionListener{
    public void seleccionRealizada( SeleccionEvent evt);

}
//--------------------------------------------------------------------------------------