/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                       TOPICOS AVANZADOS DE PROGRAMACION "B"
:*
:*                   SEMESTRE: AGO-DIC/2021    HORA: 17-18 HRS
:*
:*                 Clase que realiza la conexion a la base de datos
:*        
:*  Archivo     : ConexionDB.java
:*  Autor       : Victor Manuel Torres Vega    17130071
:*  Fecha       : 17/nov/2021
:*  Compilador  : JDK 11 + Netbeans 
:*  Descripci�n : Esta clase genera la conexion a la base de datos y establece metodos
:*                para poder obtener informacion de la misma.
:*  Ultima modif:
:*  Fecha       Modific�                              Motivo
:*========================================================================================== 
:*  17/nov/2021 17130071 Victor Manuel Torres Vega    Agregado de prológo.
:*  22/nov/2021 17130071 Victor Manuel Torres Vega    Agregado de valores x default en tiempo de diseño
:*------------------------------------------------------------------------------------------*/
package mx.tecnm.tap.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
    
//---------------------------------------------------------------------------------------------------
public class ConexionDB {
 
    //declaramos nombres estaticos
    
    public static final String JAVADB = "Java DB";
    public static final String SQLSERVER = "SQL Server";
    public static final String MYSQL = "MySQL";
    public static final String ORACLEXE = "Oracle XE";
    public static final String ACCESS = "MS Access";
    
    //declaramos null la instancia
    private static ConexionDB instancia = null;
    
    //obtenemos una variable connection
    private Connection conexion;
//---------------------------------------------------------------------------------------------------
        //declaramos variables x default
        private static String driverJDBC = "org.apache.derby.jdbc.ClientDriver";
	private static String URLConexion = "";
        private static String servidor = "";
        private static String puerto = "";
        private static String baseDeDatos = "PuntoDeVenta";
	private static String Usuario = "administrador";
	private static String Contraseña = "admin";

//---------------------------------------------------------------------------------------------------      
    private ConexionDB()
    {
        
    }
//---------------------------------------------------------------------------------------------------
    //OBTENEMOS LA INSTANCIA y si no hay la declaramos
    public static ConexionDB getInstancia()
    {
         if(instancia == null)
         {
             instancia = new ConexionDB();
         }
         return instancia;
    }

//---------------------------------------------------------------------------------------------------
    //metodo que sirve para hacer la conexion a la base de datos
   
    public void conectar(String dbms,String servidor, String puerto,  
                         String bd, String usuario, String contraseña)
    {
        ConexionDB.servidor = "Java DB";
        ConexionDB.puerto = "";
        ConexionDB.baseDeDatos = bd;
        ConexionDB.Usuario = usuario;
        ConexionDB.Contraseña = contraseña;
        
            driverJDBC = "org.apache.derby.jdbc.ClientDriver";
            URLConexion = "jdbc:derby://localhost:1527/";
        
        //determinar el driver JDBC y la url de conexion
        if(dbms.equals              ( JAVADB ) )
        {
            
        } else
            if(dbms.equals          ( SQLSERVER ) )
            {
                
            }else if( dbms.equals   ( MYSQL ) )
            {
                
            }else if ( dbms.equals  ( ACCESS ) )
            {
                
            }else if ( dbms.equals  ( ORACLEXE ) )
            {
                
            }
        
         try {
            Class.forName(driverJDBC);
            conexion = DriverManager.getConnection( URLConexion + baseDeDatos, Usuario, Contraseña );
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
             System.out.println(ex);
        }
                
    }
//---------------------------------------------------------------------------------------------------

    public Connection getConexion()
    {
        return conexion;
    }
//---------------------------------------------------------------------------------------------------   
    public void desconectar()
    {
        if(conexion != null)
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
//---------------------------------------------------------------------------------------------------   
    public boolean conectado()
    {
        if (conexion != null)
            return true;
        else
            return false;
    }
//---------------------------------------------------------------------------------------------------
}
