package Controller;

import ENTITY.ClaseUsuario;
import ENTITY.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private ClienteDAO clienteDAO;

    public UsuarioDAO(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public void setClienteDAO(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    // Método para agregar un nuevo usuario.
    public void agregarUsuario(ClaseUsuario nuevoUsuario) throws SQLException {
        if (nuevoUsuario.getRolId() == 3) { // Cliente
            Cliente nuevoCliente = new Cliente();
            nuevoCliente.setNombre(nuevoUsuario.getCorreo()); // Suponemos que nombre es igual a correo en este caso.
            nuevoCliente.setCorreo(nuevoUsuario.getCorreo());
            nuevoCliente.setContraseña(nuevoUsuario.getContrasena());
            
            clienteDAO.crearCliente(nuevoCliente); // Insertar en la base de datos.
            nuevoUsuario.setId(nuevoCliente.getId()); // Establecer el ID generado por la base de datos.
        } else {
            throw new UnsupportedOperationException("Solo se soporta la creación de clientes.");
        }
    }

    // Método para obtener todos los usuarios.
    public List<ClaseUsuario> obtenerUsuarios() throws SQLException {
        List<Cliente> clientes = clienteDAO.leerClientes();
        List<ClaseUsuario> usuarios = new ArrayList<>();
        
        for (Cliente cliente : clientes) {
            ClaseUsuario usuario = new ClaseUsuario();
            usuario.setId(cliente.getId());
            usuario.setCorreo(cliente.getCorreo());
            usuario.setContrasena(cliente.getContraseña());
            usuario.setRolId(3); // Asumimos que todos son clientes.
            usuarios.add(usuario);
        }
        return usuarios;
    }

    // Método para obtener un usuario por ID.
    public ClaseUsuario obtenerUsuario(int id) throws SQLException {
        Cliente cliente = clienteDAO.leerCliente(id);
        if (cliente != null) {
            ClaseUsuario usuario = new ClaseUsuario();
            usuario.setId(cliente.getId());
            usuario.setCorreo(cliente.getCorreo());
            usuario.setContrasena(cliente.getContraseña());
            usuario.setRolId(3); // Suponemos que todos son clientes.
            return usuario;
        }
        return null;
    }

    // Método para actualizar un usuario.
    public void actualizarUsuario(ClaseUsuario usuarioActualizado) throws SQLException {
        if (usuarioActualizado.getRolId() == 3) { // Cliente
            Cliente clienteActualizado = new Cliente();
            clienteActualizado.setId(usuarioActualizado.getId());
            clienteActualizado.setCorreo(usuarioActualizado.getCorreo());
            clienteActualizado.setContraseña(usuarioActualizado.getContrasena());

            clienteDAO.actualizarCliente(clienteActualizado); // Actualizar en la base de datos.
        } else {
            throw new UnsupportedOperationException("Solo se soporta la actualización de clientes.");
        }
    }

    // Método para eliminar un usuario.
    public void eliminarUsuario(int id) throws SQLException {
        clienteDAO.eliminarCliente(id); // Eliminar en la base de datos.
    }

    // Método para recuperar la contraseña por correo.
    public String recuperarContraseñaPorCorreo(String correo) throws SQLException {
        List<Cliente> clientes = clienteDAO.leerClientes();
        for (Cliente cliente : clientes) {
            if (cliente.getCorreo().equals(correo)) {
                return cliente.getContraseña();
            }
        }
        return null;
    }
}