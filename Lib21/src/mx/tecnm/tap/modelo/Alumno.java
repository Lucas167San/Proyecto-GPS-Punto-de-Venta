/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                       TOPICOS AVANZADOS DE PROGRAMACION "B"
:*
:*                   SEMESTRE: AGO-DIC/2021    HORA: 17-18 HRS
:*
:*                              clase POJO Alumno
:*        
:*  Archivo     : Alumno.java
:*  Autor       : Victor Manuel Torres Vega    17130071
:*  Fecha       : 23/nov/2021
:*  Compilador  : JDK 11 + Netbeans 
:*  Descripci�n : Esta clase permite obtener objetos alumnos para manipulacion de los mismos
:*                u obtencion de datos de la clase Alumno.
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


public class Alumno {
//-----------------------------------------------------------------------------------------------
        private String  matricula;
        private String  nombre;
        private String  apellidos;
        private int     edad;
        private float   promedio;
//-----------------------------------------------------------------------------------------------
    public Alumno(String matricula, String nombre, String apellidos, int edad, float promedio) {
        this.matricula      = matricula;
        this.nombre         = nombre;
        this.apellidos      = apellidos;
        this.edad           = edad;
        this.promedio       = promedio;
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
    public String getNombre() {
        return nombre;
    }
//-----------------------------------------------------------------------------------------------
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
//-----------------------------------------------------------------------------------------------
    public String getApellidos() {
        return apellidos;
    }
//-----------------------------------------------------------------------------------------------
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
//-----------------------------------------------------------------------------------------------
    public int getEdad() {
        return edad;
    }
//-----------------------------------------------------------------------------------------------
    public void setEdad(int edad) {
        this.edad = edad;
    }
//-----------------------------------------------------------------------------------------------
    public float getPromedio() {
        return promedio;
    }
//-----------------------------------------------------------------------------------------------
    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }
//-----------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return nombre + " " + apellidos; 
    }
//-----------------------------------------------------------------------------------------------    
     
 
    
    
    
}
