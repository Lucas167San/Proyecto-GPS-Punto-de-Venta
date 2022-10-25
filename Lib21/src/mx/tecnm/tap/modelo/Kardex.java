/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                       TOPICOS AVANZADOS DE PROGRAMACION "B"
:*
:*                   SEMESTRE: AGO-DIC/2021    HORA: 17-18 HRS
:*
:*                              clase POJO Kardex
:*        
:*  Archivo     : Kardex.java
:*  Autor       : Victor Manuel Torres Vega    17130071
:*  Fecha       : 23/nov/2021
:*  Compilador  : JDK 11 + Netbeans 
:*  Descripci�n : Esta clase permite obtener objetos kardex para manipulacion de los mismos
:*                u obtencion de datos de la clase Kardex.
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
public class Kardex {
    
    private int         idcalific;
    private String      matricula;
    private String      idmateria;
    private String      periodo;
    private int         calificacion;
//-----------------------------------------------------------------------------------------------
    
    public Kardex(int idcalific, String matricula, String idmateria, String periodo, int calificacion) {
        this.idcalific = idcalific;
        this.matricula = matricula;
        this.idmateria = idmateria;
        this.periodo = periodo;
        this.calificacion = calificacion;
    }

//-----------------------------------------------------------------------------------------------  
    
    public int getIdcalific() {
        return idcalific;
    }

//-----------------------------------------------------------------------------------------------    
    
    public void setIdcalific(int idcalific) {
        this.idcalific = idcalific;
    }

//-----------------------------------------------------------------------------------------------    
    
    public String getMatricula() {
        return matricula;
    }

//-----------------------------------------------------------------------------------------------    
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

//-----------------------------------------------------------------------------------------------    
    
    public String getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(String idmateria) {
        this.idmateria = idmateria;
    }

//-----------------------------------------------------------------------------------------------
    
    public String getPeriodo() {
        return periodo;
    }

//-----------------------------------------------------------------------------------------------
    
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

//-----------------------------------------------------------------------------------------------    
    
    public int getCalificacion() {
        return calificacion;
    }

//-----------------------------------------------------------------------------------------------    
    
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

//-----------------------------------------------------------------------------------------------    
    
    @Override
    public String toString() {
        return "Kardex{" + "idcalific=" + idcalific + ", matricula=" + matricula + ", idmateria=" + idmateria + ", periodo=" + periodo + ", calificacion=" + calificacion + '}';
    }
    
//-----------------------------------------------------------------------------------------------
    
    
}
