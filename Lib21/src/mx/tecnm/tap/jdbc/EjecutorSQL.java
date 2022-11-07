/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                       TOPICOS AVANZADOS DE PROGRAMACION "B"
:*
:*                   SEMESTRE: AGO-DIC/2021    HORA: 17-18 HRS
:*
:*              Clase que realiza la ejecucion de datos planos o parametrizados
:*        
:*  Archivo     : EjecutorSQL.java
:*  Autor       : Victor Manuel Torres Vega    17130071
:*  Fecha       : 17/nov/2021
:*  Compilador  : JDK 11 + Netbeans 
:*  Descripci�n : Esta clase genera la ejecucion de datos planos u parametrizados
:*                de la base de datos.
:*  Ultima modif:
:*  Fecha       Modific�                              Motivo
:*========================================================================================== 
:*  17/nov/2021 17130071 Victor Manuel Torres Vega    Agregado de prológo.
:*  22/nov/2022 17130071 Victor Manuel Torres Vega    Implementacion de nuevos metodos para sintetizar.
:*                                                    el codigo.
:*  25/nov/2022 17130071 Victor Manuel Torres Vega    Implementado sqlEjecutar para un solo argumento.
:*------------------------------------------------------------------------------------------*/
package mx.tecnm.tap.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mx.tecnm.tap.jdbc.ConexionDB;
/**
 *
 * @author luxxo
 */
public class EjecutorSQL {

    public static final String INT      = "int";
    public static final String FLOAT    = "float";
    public static final String STRING   = "string";
    public static final String DOUBLE   = "double";

//--------------------------------------------------------------------------------------------

    public static ResultSet sqlQuery (String sql) throws SQLException
    {
        return sqlQuery ( sql , null );
    }
//-------------------------------------------------------------------------------------------- 
    public static ResultSet sqlQuery ( String sql,  Object [][] args ) throws SQLException
    {
        
        
        PreparedStatement ps = ConexionDB.getInstancia ( ).getConexion ( )
                                                      .prepareStatement ( sql );
        
       // prepararArgumentos( ps,args );
        
        return ps.executeQuery ( );
    }
//-------------------------------------------------------------------------------------------- 

    public static int sqlEjecutar(String sql, Object [][] args) throws SQLException
    {
        PreparedStatement ps = ConexionDB.getInstancia ( ).getConexion ( )
                                                      .prepareStatement ( sql );
        
        prepararArgumentos ( ps , args );
        
        return ps.executeUpdate();
    }
//----------------------------------------------------------------------------------------
    
    public static int sqlEjecutar(String sql) throws SQLException
    {
        return sqlEjecutar ( sql, null );
    }
    
//-------------------------------------------------------------------------------------------- 

    public static void prepararArgumentos (PreparedStatement ps, Object [][] args) throws SQLException
    {
        final int TIPO = 0;
        final int VALOR = 1;
        
       //Verificar si se debe realizar la sustitucion de parametros o argumentos.
        if( args != null )
        {
            int numArg = 1;
         
            for ( Object [] arg : args )
            {
                switch ( arg [TIPO].toString( ) )
                {
                    case INT      : ps.setInt (  
                            numArg, 
                            Integer.parseInt( arg [ VALOR ].toString( ) ) 
                            );
                        break;
                    case FLOAT    : ps.setFloat( 
                                                   numArg,
                                                   Float.parseFloat (arg [ VALOR ].toString( ))
                                                  );
                    break;
                    case STRING   : ps.setString ( numArg , arg [ VALOR ].toString( ) );
                    break;
                    
                    case DOUBLE   : ps.setDouble(
                                                    numArg, 
                                                    Double.parseDouble(arg [VALOR].toString())
                                                  );
                    break;
                }
                numArg++;
            }
        }
    }
//----------------------------------------------------------------------------------------    
}
