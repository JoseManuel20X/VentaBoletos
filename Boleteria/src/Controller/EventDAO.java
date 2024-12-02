package Controller;

import ENTITY.Event;
import MODELS.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {

    private final Connection connection;

    public EventDAO() {
        // Obtener la conexión del Singleton
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    // Método para agregar un evento
    public void crearEvento(Event evento) throws SQLException {
        String sql = "INSERT INTO eventos (nombre, descripcion, fecha, enclosure, price, numero_tiquetes) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, evento.getName());
            stmt.setString(2, evento.getDescription());
            stmt.setString(3, evento.getDate());
            stmt.setString(4, evento.getEnclosure());
            stmt.setDouble(5, evento.getPrice());
            stmt.setInt(6, evento.getNumberTickets());
            stmt.executeUpdate();

            // Obtener el ID generado
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    evento.setId(generatedKeys.getInt(1));
                }
            }

            System.out.println("Evento agregado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al agregar el evento: " + e.getMessage());
            throw e;
        }
    }

    // Método para obtener todos los eventos
    public List<Event> leerEventos() throws SQLException {
        String sql = "SELECT * FROM eventos";
        List<Event> eventos = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                eventos.add(new Event(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("fecha"),
                        rs.getString("enclosure"),
                        rs.getDouble("price"),
                        rs.getInt("numero_tiquetes"),
                        rs.getString("descripcion")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los eventos: " + e.getMessage());
            throw e;
        }
        return eventos;
    }

    // Método para obtener un evento por ID
    public Event leerEvento(int id) throws SQLException {
        String sql = "SELECT * FROM eventos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Event(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("fecha"),
                            rs.getString("enclosure"),
                            rs.getDouble("price"),
                            rs.getInt("numero_tiquetes"),
                            rs.getString("descripcion")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el evento: " + e.getMessage());
            throw e;
        }
        return null;
    }

    // Método para actualizar un evento
    public void actualizarEvento(Event eventoActualizado) throws SQLException {
        String sql = "UPDATE eventos SET nombre = ?, descripcion = ?, fecha = ?, enclosure = ?, price = ?, numero_tiquetes = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, eventoActualizado.getName());
            stmt.setString(2, eventoActualizado.getDescription());
            stmt.setString(3, eventoActualizado.getDate());
            stmt.setString(4, eventoActualizado.getEnclosure());
            stmt.setDouble(5, eventoActualizado.getPrice());
            stmt.setInt(6, eventoActualizado.getNumberTickets());
            stmt.setInt(7, eventoActualizado.getId());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Evento actualizado correctamente.");
            } else {
                System.out.println("No se encontró un evento con el ID proporcionado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el evento: " + e.getMessage());
            throw e;
        }
    }

    // Método para eliminar un evento
    public void eliminarEvento(int id) throws SQLException {
        String sql = "DELETE FROM eventos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Evento eliminado correctamente.");
            } else {
                System.out.println("No se encontró un evento con el ID proporcionado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el evento: " + e.getMessage());
            throw e;
        }
    }

    // Método para comprar boletos
    public synchronized boolean buyTicket(int eventId, int numberOfTicketsToBuy) throws SQLException {
        String sql = "SELECT numero_tiquetes FROM eventos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, eventId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int ticketsAvailable = rs.getInt("numero_tiquetes");
                    if (ticketsAvailable >= numberOfTicketsToBuy) {
                        String updateSql = "UPDATE eventos SET numero_tiquetes = numero_tiquetes - ? WHERE id = ?";
                        try (PreparedStatement updateStmt = connection.prepareStatement(updateSql)) {
                            updateStmt.setInt(1, numberOfTicketsToBuy);
                            updateStmt.setInt(2, eventId);
                            updateStmt.executeUpdate();
                            System.out.println("Compra exitosa! Quedan " + (ticketsAvailable - numberOfTicketsToBuy) + " tiquetes.");
                            return true;
                        }
                    } else {
                        System.out.println("No hay suficientes tiquetes disponibles.");
                        return false;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al comprar boletos: " + e.getMessage());
            throw e;
        }
        System.out.println("Evento no encontrado.");
        return false;
    }
}