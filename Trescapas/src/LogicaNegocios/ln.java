 
package LogicaNegocios;
import Datos.CRUD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

 
public class ln {

public void NuevoAlumno(int id, String n, int ed){
    CRUD ingreso=new CRUD();
    Connection con=ingreso.ConexionOpen();
    ingreso.IngresarAlumno(con,id,n,ed); 
}

public void EditarAlumno(int id, String n, int ed){
    CRUD editar=new CRUD();
    Connection con=editar.ConexionOpen();
    editar.ModificarAlumno(con,id,n,ed);
}
public void EliminaAlumno(int id){
    CRUD eliminar=new CRUD();
    Connection con=eliminar.ConexionOpen();
    eliminar.EliminarAlumno(con,id);
}
public ResultSet ConsultarAlumno(){
    CRUD mostrar=new CRUD();
    ResultSet rs = null;
    Connection con=mostrar.ConexionOpen();
    try{
        rs=mostrar.MostrarDatos(con);          
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error al consultar la tabla Alumno"); 
    }
 return rs; 
}
}

