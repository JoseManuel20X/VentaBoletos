

package ENTITY;

/**
 *
 * @author Manuel
 */

public class ClaseUsuario {
   private int id; // ID único del usuario.
    private String correo; // Correo electrónico del usuario.
    private String contrasena; // Contraseña del usuario.
    private int rolId; // ID del rol asignado al usuario.

    // Constructor sin argumentos para permitir la deserialización desde JSON u otros formatos.
    public ClaseUsuario() {
    }

    // Constructor con argumentos para inicializar todos los atributos del usuario.
    public ClaseUsuario(int id, String correo, String contrasena, int rolId) {
        this.id = id; // Establece el ID del usuario.
        this.correo = correo; // Establece el correo del usuario.
        this.contrasena = contrasena; // Establece la contraseña del usuario.
        this.rolId = rolId; // Establece el ID del rol del usuario.
    }

    // Obtiene el ID del usuario.
    public int getId() {
        return id;
    }

    // Establece el ID del usuario.
    public void setId(int id) {
        this.id = id;
    }

    // Obtiene el correo del usuario.
    public String getCorreo() {
        return correo;
    }

    // Establece el correo del usuario.
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Obtiene la contraseña del usuario.
    public String getContrasena() {
        return contrasena;
    }

    // Establece la contraseña del usuario.
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // Obtiene el ID del rol del usuario.
    public int getRolId() {
        return rolId;
    }

    // Establece el ID del rol del usuario.
    public void setRolId(int rolId) {
        this.rolId = rolId;
    }
    
    
    
    
    
    
    
    
    
    
    
    
  
}

