/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                       TOPICOS AVANZADOS DE PROGRAMACION "B"
:*
:*                   SEMESTRE: AGO-DIC/2021    HORA: 17-18 HRS
:*
:*                      Clase para calcular operaciones matematicas comunes.
:*        
:*  Archivo     : Matematica.java
:*  Autor       : Victor Manuel Torres Vega     17130071
:*  Fecha       : 07/Sep/2021
:*  Compilador  : JDK 11 + Netbeans 
:*  Descripci�n : Clase que contiene funciones matematicas para calcular:
:*                1. Factorial
:*                2. Permutaciones
:*                3. Combinaciones
:*
:*              Nota: Tiene la limitante de que n debe ser menor de 25
:*                
:*
:*
:*  Ultima modif:
:*  Fecha       Modific�               Motivo
:*========================================================================================== 
:*  07/09/2021 17130071 Victor Torres  Adicion del prologo para la clase Matematica.  
:*------------------------------------------------------------------------------------------*/

package mx.tecnm.tap.calculos;



public class Matematica {
        
        
//------------------------------------------------------------------------------------------------
    //Formula Factorial
	public static long factorial( int n ) {
		long factorial = 1;
		 
            for ( int i = 1; i <= n; i++ )
                factorial *= i;
            
            
		return factorial;
	}
 //-----------------------------------------------------------------------------------------------
        //Formula Permutaciones
	public static int permutaciones(int n, int x) {
            
		 return ( int ) ( factorial (  n  )  /  factorial  (  n  -  x  ) ) ;
                 
	}
 //-----------------------------------------------------------------------------------------------
        //Formula Combinaciones
	public static int combinaciones(int n, int x) {
		
		 return ( int ) ( permutaciones (  n  ,  x  )  /  factorial  (  x  ));
	}
 //-----------------------------------------------------------------------------------------------
}