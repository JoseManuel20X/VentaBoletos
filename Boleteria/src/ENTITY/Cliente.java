
package ENTITY;
//
/**
 *
 * @author Robert Granados
 */
public class Cliente {
    private int idCliente;
    private String nombre;
    private String correo, contraseña;
    public Cliente(int id, String nombre,String correo, String contraseña) {
        this.idCliente = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public Cliente() {
    }

    public int getidCliente() {
        return idCliente;
    }

    public void setId(int id) {
        this.idCliente = id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
}
