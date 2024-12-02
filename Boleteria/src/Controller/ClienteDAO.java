package Controller;

import ENTITY.Cliente;
import MODELS.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Robert Granados
 */
public class ClienteDAO {
    private final Connection connection;

    public ClienteDAO() {
        // Obtener la conexión del Singleton
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    // Método para crear un cliente
    public void crearCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (nombre, correo, contraseña) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getCorreo());
            stmt.setString(3, cliente.getContraseña());
            stmt.executeUpdate();

            // Obtener el ID generado
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    cliente.setId(generatedKeys.getInt(1));
                }
            }
            System.out.println("Cliente creado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear el cliente: " + e.getMessage());
            throw e;
        }
    }

    // Método para obtener todos los clientes
    public List<Cliente> leerClientes() throws SQLException {
        String sql = "SELECT * FROM clientes";
        List<Cliente> clientes = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clientes.add(new Cliente(rs.getInt("idCliente"), rs.getString("nombre"), rs.getString("correo"), rs.getString("contraseña")));
            }
        } catch (SQLException e) {
            System.out.println("Error al leer los clientes: " + e.getMessage());
            throw e;
        }
        return clientes;
    }

    // Método para obtener un cliente por ID
    public Cliente leerCliente(int id) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("correo"), rs.getString("contraseña"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al leer el cliente: " + e.getMessage());
            throw e;
        }
        return null;
    }

    // Método para actualizar un cliente
    public void actualizarCliente(Cliente clienteActualizado) throws SQLException {
        String sql = "UPDATE clientes SET nombre = ?, correo = ?, contraseña = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, clienteActualizado.getNombre());
            stmt.setString(2, clienteActualizado.getCorreo());
            stmt.setString(3, clienteActualizado.getContraseña());
            stmt.setInt(4, clienteActualizado.getidCliente());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cliente actualizado correctamente.");
            } else {
                System.out.println("No se encontró un cliente con el ID proporcionado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el cliente: " + e.getMessage());
            throw e;
        }
    }

    // Método para eliminar un cliente
    public void eliminarCliente(int id) throws SQLException {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Cliente eliminado correctamente.");
            } else {
                System.out.println("No se encontró un cliente con el ID proporcionado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el cliente: " + e.getMessage());
            throw e;
        }
    }

    // Método para validar un cliente por correo y contraseña
    public Cliente validar(String correo, String contrasena) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE correo = ? AND contraseña = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, correo);
            stmt.setString(2, contrasena);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(rs.getInt("idCliente"), rs.getString("nombre"), rs.getString("correo"), rs.getString("contraseña"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al validar el cliente: " + e.getMessage());
            throw e;
        }
        return null;
    }
}