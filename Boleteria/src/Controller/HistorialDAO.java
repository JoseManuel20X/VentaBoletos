package Controller;

import ENTITY.Historial;
import MODELS.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Manuel
 */
public class HistorialDAO {
    private final Connection connection;

    // Constructor que inicializa la conexión a la base de datos
    public HistorialDAO() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    // Crear un nuevo historial para un usuario
    public void crearHistorial(Historial historial) throws SQLException {
        String sql = "INSERT INTO historial (idCliente, nombreevent, correoCliente, cantidad) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, historial.getidcliente());
            stmt.setString(2, historial.getNombreevent());
            stmt.setString(3, historial.getCorreoCliente());
            stmt.setInt(4, historial.getCantidad());
            stmt.executeUpdate();

            // Obtener el ID generado automáticamente
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    historial.setIdHistorial(generatedKeys.getInt(1));
                }
            }
            System.out.println("Historial creado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al crear el historial: " + e.getMessage());
            throw e;
        }
    }

    // Leer todos los historiales de un usuario
    public List<Historial> leerHistoriales(int idCliente) throws SQLException {
        String sql = "SELECT * FROM historial WHERE idcliente = ?";
        List<Historial> historiales = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Historial historial = new Historial();
                    historial.setIdHistorial(rs.getInt("idHistorial"));
                    historial.setIdcliente(rs.getInt("idcliente"));
                    historial.setNombreevent(rs.getString("nombreevent"));
                    historial.setCorreoCliente(rs.getString("correoCliente"));
                    historial.setCantidad(rs.getInt("cantidad"));
                    historiales.add(historial);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al leer los historiales: " + e.getMessage());
            throw e;
        }
        return historiales;
    }

    // Leer un historial específico de un usuario
    public Historial leerHistorial(int idCliente, int idHistorial) throws SQLException {
        String sql = "SELECT * FROM historial WHERE idcliente = ? AND idHistorial = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            stmt.setInt(2, idHistorial);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Historial historial = new Historial();
                    historial.setIdHistorial(rs.getInt("idHistorial"));
                    historial.setIdcliente(rs.getInt("idcliente"));
                    historial.setNombreevent(rs.getString("nombreevent"));
                    historial.setCorreoCliente(rs.getString("correoCliente"));
                    historial.setCantidad(rs.getInt("cantidad"));
                    return historial;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al leer el historial: " + e.getMessage());
            throw e;
        }
        return null;
    }

    // Actualizar un historial
    public void actualizarHistorial(Historial historialActualizado) throws SQLException {
        String sql = "UPDATE historial SET nombreevent = ?, correoCliente = ?, cantidad = ? WHERE idcliente = ? AND idHistorial = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, historialActualizado.getNombreevent());
            stmt.setString(2, historialActualizado.getCorreoCliente());
            stmt.setInt(3, historialActualizado.getCantidad());
            stmt.setInt(4, historialActualizado.getidcliente());
            stmt.setInt(5, historialActualizado.getIdHistorial());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Historial actualizado correctamente.");
            } else {
                System.out.println("No se encontró un historial con los datos proporcionados.");
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar el historial: " + e.getMessage());
            throw e;
        }
    }

    // Eliminar un historial
    public void eliminarHistorial(int idCliente, int idHistorial) throws SQLException {
        String sql = "DELETE FROM historial WHERE idcliente = ? AND idHistorial = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            stmt.setInt(2, idHistorial);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Historial eliminado correctamente.");
            } else {
                System.out.println("No se encontró un historial con los datos proporcionados.");
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar el historial: " + e.getMessage());
            throw e;
        }
    }
}