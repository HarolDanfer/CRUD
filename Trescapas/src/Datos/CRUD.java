
package Datos;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.Statement;
import javax.swing.JOptionPane;

public class CRUD {
    public static Connection cn; //variable conexion
    public static CallableStatement stmt; // variable sentencia prepreparada. CRUD
  
    public  Connection ConexionOpen(){
             try{
                 String controlador="com.microsoft.sqlserver.jdbc.SQLServerDriver";
                 Class.forName(controlador);
            }
             catch(ClassNotFoundException e){
             JOptionPane.showMessageDialog(null,"Error al cargar controlador");
            }  
             try{ 
                 cn=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-PO3F4D3\\SQLEXPRESS:1433;databaseName=EJERCICIO;Integratedsecurity=true;");
            }
             catch(SQLException e){
               JOptionPane.showMessageDialog(null,"Error al realizar la conexion");
            }  
        return cn;
    }

    public void IngresarAlumno(Connection cn,int id, String n, int ed){

         try{
               stmt = cn.prepareCall("{call sp_IngresarAlumnos(?,?,?)}");
                stmt.setInt(1,id);
                stmt.setString(2, n);
                stmt.setInt(3, ed);
                stmt.execute();
                stmt.close();

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Error al agregar en la tabla Alumnos"); 
        }

     }
     public void ModificarAlumno(Connection cn,int id, String n, int ed){

         try{
                stmt = cn.prepareCall("{call sp_ActualizarAlumnos(?,?,?)}");
                stmt.setInt(1, id);
                stmt.setString(2, n);
                stmt.setInt(3, ed);
                stmt.execute();
                stmt.close();

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Error al modificar en la tabla Alumnos"); 
        }

     }
    public void EliminarAlumno(Connection cn,int id){

         try{
                  stmt = cn.prepareCall("{call sp_EliminarAlumnos(?)}");
                   stmt.setInt(1,id);
                stmt.execute ();
                stmt.close();

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Error al ELIMINAR en la tabla Alumnos"); 
        }

     }
     
public ResultSet MostrarDatos(Connection con) throws SQLException{
     ResultSet rs;
    stmt=cn.prepareCall("{call sp_MostrarAlumnos()}"); 
    rs=stmt.executeQuery();
return rs;
}

}
