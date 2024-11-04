package Controller;

import ENTITY.Cliente;
import ENTITY.ClaseUsuario; // Asegúrate de importar ClaseUsuario
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @autor Robert Granados
 */
public class CRUDCliente {
   private List<Cliente> clientes;
    private final String filePath = "clientes.json";
    private ObjectMapper objectMapper;
    private UsuarioCRUD usuarioCrud;

    public CRUDCliente(UsuarioCRUD usuarioCrud) {
        this.usuarioCrud = usuarioCrud;
        objectMapper = new ObjectMapper();
        clientes = cargarClientes();
    }
    
    public void setUsuarioCrud(UsuarioCRUD usuarioCrud) {
        this.usuarioCrud = usuarioCrud;
    }
     
    public UsuarioCRUD getUsuarioCrud() {
        if (usuarioCrud == null) {
            usuarioCrud = new UsuarioCRUD(this);
        }
        return usuarioCrud;
    }
    
    public Cliente obtenerClienteActual(ClaseUsuario usuario) {
    if (usuario == null) {
        return null; // Manejo de caso nulo
    }
    int clienteId = usuario.getId();
    for (Cliente cliente : clientes) {
        if (cliente.getId() == clienteId) {
            return cliente;
        }
    }
    return null;
}

    private List<Cliente> cargarClientes() {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                return objectMapper.readValue(file, new TypeReference<List<Cliente>>() {});
            } else {
                return new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void guardarClientes() {
        try {
            objectMapper.writeValue(new File(filePath), clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crearCliente(Cliente cliente) {
        int nuevoId = generarNuevoIdCliente();
        cliente.setId(nuevoId);
        clientes.add(cliente);
        guardarClientes();
    }


    private int generarNuevoIdCliente() {
    if (clientes.isEmpty()) { //Si la lista de clientes está vacía, el primer ID será 1
        return 1;
    }
    int maxId = clientes.stream() //Encuentra el mayor ID existente en la lista de clientes
                        .mapToInt(Cliente::getId)
                        .max()
                        .orElse(0);
    return maxId + 1;
    }
    
    public List<Cliente> leerClientes() {
        return clientes;
    }

    public Cliente leerCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public void actualizarCliente(Cliente clienteActualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == clienteActualizado.getId()) {
                clientes.set(i, clienteActualizado);
                guardarClientes();
                return;
            }
        }
    }

    private void actualizarIds() {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            cliente.setId(i + 1); 
        }
        guardarClientes();
    }

    public void eliminarCliente(int id, boolean desdeUsuario) {
    for (int i = 0; i < clientes.size(); i++) {
        if (clientes.get(i).getId() == id) {
            clientes.remove(i);
            break;
        }
    }
    guardarClientes();

    if (!desdeUsuario) {
        
        UsuarioCRUD usuarioCRUD = getUsuarioCrud();

        usuarioCRUD.eliminarUsuario(id, true);// Elimina el usuario asociado con el mismo ID
      }
    }
   
    public Cliente validar(String correo, String contrasena) {
        for (Cliente cliente : clientes) {
            if (cliente.getCorreo().equalsIgnoreCase(correo) && cliente.getContraseña().equals(contrasena)) {
                return cliente;
            }
        }
        return null;
    }
}

