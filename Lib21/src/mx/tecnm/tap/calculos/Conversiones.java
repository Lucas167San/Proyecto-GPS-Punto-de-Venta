/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                       TOPICOS AVANZADOS DE PROGRAMACION "B"
:*
:*                   SEMESTRE: AGO-DIC/2021    HORA: 17-18 HRS
:*
:*                       Clase de Conversión de unidades.
:*        
:*  Archivo     : Conversiones.java
:*  Autor       : Victor Manuel Torres Vega     17130071
:*  Fecha       : 17/Sep/2021
:*  Compilador  : JDK 11 + Netbeans 
:*  Descripci�n : Clase Conversiones que implementa los siguientes metódos.
:*                1.- °C a °F
:*                2.- °F a °C
:*                3.- Yardas a Metros
:*                4.- Metros a Yardas
:*                5.- Libras a Kilos
:*                6.- Kilos a Libras
:*                7.- Decimal a Binario
:*                8.- Binario a Decimal
:*  Ultima modif:
:*  Fecha       Modific�                        Motivo
:*========================================================================================== 
:*  17/Sep/2021 Victor Manuel Torres Vega       Agregado de prologo y calidad de código.
:*------------------------------------------------------------------------------------------*/

package mx.tecnm.tap.calculos;

/**
 *
 * @author luxxo
 */
public class Conversiones {
    
//---------------------------------------------------------------------------------------------------------
        //valores estaticos.
    public static final float FACTOR_YARDA_METRO = 0.9144f;
    public static final float FACTOR_LIBRA_KG = 0.4536f;

//---------------------------------------------------------------------------------------------------------
        //Convierte centigrados a fahrenheit
    public static float centigrados_farenheit( float grados ){
         return  ( 9f / 5 * grados ) + 32; 
    }
//---------------------------------------------------------------------------------------------------------
        //Convierte fahrenheit a centigrados
    public static float fahrenheit_centrigrados( float grados )
    {
        return ( grados - 32 ) * ( 5f / 9 );
    }

//---------------------------------------------------------------------------------------------------------
    
        //Convierte de yardas a metros
    public static float yardas_metros( float yardas )
    {
        return yardas * FACTOR_YARDA_METRO;
    }
   
//---------------------------------------------------------------------------------------------------------
    
        //Convierte de metros a yardas
    public static float metros_yardas( float metros )
    {
        return metros / FACTOR_YARDA_METRO;
    }
//---------------------------------------------------------------------------------------------------------
    
        //Convierte de libras a kilos
    public static float libras_kilos ( float libras)
    {
        return libras * FACTOR_LIBRA_KG;
    }

//---------------------------------------------------------------------------------------------------------
    
        //Convierte de kilos a libras
    public static float kilos_libras ( float kilos)
    {
        return kilos / FACTOR_LIBRA_KG;
    }
    
//---------------------------------------------------------------------------------------------------------
   
        //Convierte de decimal a binario
    public static String decimal_binario( int decimal )
    {
    int binario = 0;
    int digito;
    final int DIVISOR = 2;
    for ( int i = decimal, j = 0; i > 0; i /= DIVISOR, j++ ) {
        digito = i % DIVISOR;
        binario += digito * Math.pow ( 10 , j );
    }
    return binario+"";
    }

//---------------------------------------------------------------------------------------------------------
    
        //Convierte de binario a decimal
    public static int binario_decimal ( String binario )
    {
        int decimal = 0;
    int digito;
    final int divisor = 10;
    for  ( int i = Integer.parseInt ( binario ), j = 0; i > 0; i /= divisor, j++ ) {
        digito = ( int ) ( i % divisor );
        if ( digito != 0 && digito != 1 ) {
            return -1;
        }
        decimal += digito * Math.pow ( 2, j );
    }
    return decimal;
    }

//---------------------------------------------------------------------------------------------------------
}
