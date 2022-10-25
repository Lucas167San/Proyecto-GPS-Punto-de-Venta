/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                       TOPICOS AVANZADOS DE PROGRAMACION "B"
:*
:*                   SEMESTRE: AGO-DIC/2021    HORA: 17-18 HRS
:*
:*                  Clase que presenta seleccion de eventos
:*        
:*  Archivo     : SeleccionEvent.java
:*  Autor       : Victor Manuel Torres Vega    17130071
:*  Fecha       : 10/nov/2021
:*  Compilador  : JDK 11 + Netbeans 
:*  Descripci�n : Esta clase, genera eventos. de la SeleccionEvent
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

public class SeleccionEvent {
    private int movimiento;
    private String [] elementos;
//--------------------------------------------------------------------------------------
    public SeleccionEvent ( int movimiento, String[] elementos ) {
        this.movimiento = movimiento;
        this.elementos = elementos;
    }
//--------------------------------------------------------------------------------------
    public int getMovimiento ( ) {
        return movimiento;
    }
//--------------------------------------------------------------------------------------
    public void setMovimiento ( int movimiento ) {
        this.movimiento = movimiento;
    }
//--------------------------------------------------------------------------------------
    public String[] getElementos ( ) {
        return elementos;
    }
//--------------------------------------------------------------------------------------
    public void setElementos ( String[] elementos ) {
        this.elementos = elementos;
    }
//--------------------------------------------------------------------------------------    
     
}
