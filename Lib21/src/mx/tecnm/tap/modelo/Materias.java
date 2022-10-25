/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                       TOPICOS AVANZADOS DE PROGRAMACION "B"
:*
:*                   SEMESTRE: AGO-DIC/2021    HORA: 17-18 HRS
:*
:*                              clase POJO Materias
:*        
:*  Archivo     : Alumno.java
:*  Autor       : Victor Manuel Torres Vega    17130071
:*  Fecha       : 23/nov/2021
:*  Compilador  : JDK 11 + Netbeans 
:*  Descripci�n : Esta clase permite obtener objetos materias para manipulacion de los mismos
:*                u obtencion de datos de la clase Materias.
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

//-----------------------------------------------------------------------------------------------


public class Materias {
        
        private String      idmateria;
        private String      materia;
        private int         creditos;
        
        
//-----------------------------------------------------------------------------------------------
         
    public Materias(String idmateria, String materia, int creditos) {
        this.idmateria = idmateria;
        this.materia = materia;
        this.creditos = creditos;
    }
    
//-----------------------------------------------------------------------------------------------

    public String getIdmateria() {
        return idmateria;
    }
    
//-----------------------------------------------------------------------------------------------

    public void setIdmateria(String idmateria) {
        this.idmateria = idmateria;
    }
    
//-----------------------------------------------------------------------------------------------

    public String getMateria() {
        return materia;
    }
    
//-----------------------------------------------------------------------------------------------

    public void setMateria(String materia) {
        this.materia = materia;
    }
    
//-----------------------------------------------------------------------------------------------

    public int getCreditos() {
        return creditos;
    }
    
//-----------------------------------------------------------------------------------------------

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    
//-----------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return idmateria + " " + materia;
    }
    
//-----------------------------------------------------------------------------------------------
    
        
        
    
}
