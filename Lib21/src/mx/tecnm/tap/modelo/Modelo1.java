/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                       TOPICOS AVANZADOS DE PROGRAMACION "B"
:*
:*                   SEMESTRE: AGO-DIC/2021    HORA: 17-18 HRS
:*
:*                              clase POJO Modelo1
:*        
:*  Archivo     : Modelo1.java
:*  Autor       : Victor Manuel Torres Vega    17130071
:*  Fecha       : 23/nov/2021
:*  Compilador  : JDK 11 + Netbeans 
:*  Descripci�n : Esta clase permite obtener hederar de la clase Alumno su constructor
:*                para la manipulacion de datos del boton modulo1
:*  Ultima modif:
:*  Fecha       Modific�                              Motivo
:*========================================================================================== 
:*  23/nov/2021 17130071 Victor Manuel Torres Vega    Agregado de prológo. y calidad de codigo
:*                                                    
:*------------------------------------------------------------------------------------------*/
package mx.tecnm.tap.modelo;

/**
 *
 * @author luxxo
 */
public class Modelo1 extends Alumno{
    
    
//-----------------------------------------------------------------------------------------------
    public Modelo1(String matricula, String nombre, String apellidos, int edad, float promedio) {
        super ( matricula, nombre, apellidos, edad, promedio );

    }
//-----------------------------------------------------------------------------------------------    
        
    
}
