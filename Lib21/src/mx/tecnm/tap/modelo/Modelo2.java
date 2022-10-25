/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                       TOPICOS AVANZADOS DE PROGRAMACION "B"
:*
:*                   SEMESTRE: AGO-DIC/2021    HORA: 17-18 HRS
:*
:*                              clase POJO Modelo2
:*        
:*  Archivo     : Modelo2.java
:*  Autor       : Victor Manuel Torres Vega    17130071
:*  Fecha       : 23/nov/2021
:*  Compilador  : JDK 11 + Netbeans 
:*  Descripci�n : Esta clase permite obtener hederar de la clase Materias su constructor
:*                para la manipulacion de datos del boton modulo2
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
public class Modelo2 extends Materias{
    
//-----------------------------------------------------------------------------------------------
    public Modelo2(String idmateria, String materia, int creditos) {
        super(idmateria, materia, creditos);
    }
//-----------------------------------------------------------------------------------------------
}
