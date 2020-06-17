 
package Datos;
 
public class Cliente {

    private int vIDAlumno;
    private String vNombre;
    private int vEdad;
  

    public void setIDAlumno(int idalu) {
        vIDAlumno = idalu;
    }

    public void setNombre(String N) {
        vNombre = N;
    }

    public void setEdad(int eda) {
        vEdad = eda;
    }

   
    public int getIDAlumno() {
        return vIDAlumno;
    }

    public String getNombre() {
        return vNombre;
    }

    public int getEdad() {
        return vEdad;
    }
 
}
