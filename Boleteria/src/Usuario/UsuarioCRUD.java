package Usuario;

import Cliente.CRUDCliente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioCRUD {
    // Lista para almacenar objetos de tipo ClaseUsuario.
    private List<ClaseUsuario> usuarios;

    // Ruta del archivo JSON donde se almacenarán los datos de los usuarios.
    private final String filePath = "usuarios.json";

    // Instancia de ObjectMapper para la conversión entre JSON y objetos Java.
    private ObjectMapper objectMapper;

    // Instancia del CRUD de clientes.
    private CRUDCliente clienteCRUD;

    // Constructor de la clase UsuarioCRUD.
    public UsuarioCRUD(CRUDCliente clienteCRUD) {
        this.clienteCRUD = clienteCRUD;
        objectMapper = new ObjectMapper();
        usuarios = cargarUsuarios();
    }
    
    // Método para inicializar CRUDCliente cuando sea necesario
    private CRUDCliente getClienteCRUD() {
        if (clienteCRUD == null) {
            clienteCRUD = new CRUDCliente(this);
        }
        return clienteCRUD;
    }

    // Método para cargar los usuarios desde el archivo JSON.
    public List<ClaseUsuario> cargarUsuarios() {
        try {
            // Crea un objeto File con la ruta especificada.
            File file = new File(filePath);
            // Verifica si el archivo existe.
            if (file.exists()) {
                // Lee el contenido del archivo JSON y lo convierte en una lista de ClaseUsuario.
                return objectMapper.readValue(file, new TypeReference<List<ClaseUsuario>>() {});
            } else {
                // Si el archivo no existe, retorna una lista vacía.
                return new ArrayList<>();
            }
        } catch (IOException e) {
            // Maneja excepciones de entrada/salida y muestra el error.
            e.printStackTrace();
            // Retorna una lista vacía en caso de error.
            return new ArrayList<>();
        }
    }

    // Método para guardar la lista de usuarios en el archivo JSON.
    private void guardarUsuarios() {
        try {
            // Escribe la lista de usuarios en el archivo JSON.
            objectMapper.writeValue(new File(filePath), usuarios);
        } catch (IOException e) {
            // Maneja excepciones de entrada/salida y muestra el error.
            e.printStackTrace();
        }
    }

    // Método para agregar un nuevo usuario a la lista.
    public void agregarUsuario(ClaseUsuario nuevoUsuario) {
        if (nuevoUsuario.getRolId() == 3) { // Cliente
            // Asigna el ID 1 al nuevo cliente y lo añade al inicio de la lista.
            nuevoUsuario.setId(1);
            usuarios.add(0, nuevoUsuario);

            // Actualiza los IDs de los usuarios existentes.
            actualizarIds();
        } else { 
            // Para otros roles, asigna un nuevo ID al final de la lista.
            nuevoUsuario.setId(generarNuevoId());
            usuarios.add(nuevoUsuario);
             actualizarIds();
        }

        // Guarda los cambios en el archivo JSON.
        guardarUsuarios();
    }

    // Método para generar un nuevo ID único para un usuario.
    public int generarNuevoId() {
        int maxId = 0;
        for (ClaseUsuario usuario : usuarios) {
            if (usuario.getId() > maxId) {
                maxId = usuario.getId();
            }
        }
        return maxId + 1;
    }

    // Método para obtener la lista completa de usuarios.
    public List<ClaseUsuario> obtenerUsuarios() {
        return usuarios;
    }

    // Método para obtener un usuario específico por su ID.
    public ClaseUsuario obtenerUsuario(int id) {
        for (ClaseUsuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    // Método para actualizar la información de un usuario existente.
    public void actualizarUsuario(ClaseUsuario usuarioActualizado) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == usuarioActualizado.getId()) {
                usuarios.set(i, usuarioActualizado);
                guardarUsuarios();
                return;
            }
        }
    }
    
    public void eliminarUsuario(int id, boolean desdeCliente) {
    // Elimina el usuario de la lista de usuarios
    for (int i = 0; i < usuarios.size(); i++) {
        if (usuarios.get(i).getId() == id) {
            usuarios.remove(i);
            break;
        }
    }
    // Guarda los cambios en el archivo JSON de usuarios.
    guardarUsuarios();
    // Si no estamos llamando desde eliminarCliente, entonces eliminar el cliente asociado.
    if (!desdeCliente) {
        // Obtén la instancia de CRUDCliente si aún no está inicializada.
        CRUDCliente clienteCRUD = getClienteCRUD();
        // Elimina el cliente asociado con el mismo ID
        clienteCRUD.eliminarCliente(id, true);  // Pasamos `true` para evitar llamada recursiva
      }
    }

    // Método privado para actualizar los IDs de los usuarios en la lista.
    private void actualizarIds() {
        for (int i = 0; i < usuarios.size(); i++) {
            ClaseUsuario usuario = usuarios.get(i);
            // Los IDs empiezan desde 2 porque el nuevo cliente tendrá el ID 1.
            if (i == 0) {
                usuario.setId(1);
            } else {
                usuario.setId(i + 1);
            }
        }
        guardarUsuarios();
    }

    public int obtenerCantidadUsuarios() {
        return usuarios.size();
    }

}
