   
package Conexiones;

/**
 *
 * @author Grupo 6
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;



 public class ConexionSQL {
    public  String Nombre = "jdbc:sqlserver://DESKTOP-7TC5HRI:1433;databaseName=SIDIM;user=sa;password=javier1;";
    public  Connection conexion;
    public  Statement sentencia;

    public Statement getSentencia() {
        return sentencia;
    }

    public  void hacerConexion(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");                        
            conexion = DriverManager.getConnection(Nombre);
            sentencia = conexion.createStatement();
            System.out.println("Conexión exitosa");
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Clase no encontrada","Excepcion Capa Datos",0);
        }catch(SQLException qE){
            JOptionPane.showMessageDialog(null,qE.getMessage(),"Excepcion Capa Datos - Conexión - HacerConexion",0);
        }
    }

     public  void cerrarConexion(){
        try{
            sentencia.close();
            conexion.close();
            System.out.println("Conexión cerrada");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.toString(),"Excepcion Capa Datos - Conexión - CerrarConexion",0);
        }
    }
 }
