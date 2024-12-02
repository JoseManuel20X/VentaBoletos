package Controller;

import ENTITY.Event;
import ENTITY.Tickect;
import ENTITY.ClaseUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BuyTicketFacade {
    private EventDAO eventoController;
    private List<Tickect> historial;

    public BuyTicketFacade(EventDAO eventoController) {
        this.eventoController = eventoController;
        this.historial = new ArrayList<>();
    }

    public boolean comprarTique(ClaseUsuario usuario, int idEvento, int cantidad, String numeroTarjeta) throws SQLException {
        Event evento = obtenerEventoPorId(idEvento);
        
        // Verificar recursivamente la disponibilidad de boletos
        if (!verificarDisponibilidadBoletosRecursivo(evento, cantidad)) {
            System.out.println("No hay suficientes boletos disponibles.");
            return false;
        }
        
        // Completar la compra recursivamente
        return completarCompraRecursivo(usuario, evento, cantidad);
    }

    // Método recursivo para ver el historial de compras de un usuario
    public List<Tickect> verHistorialCompras(ClaseUsuario usuario) {
        return verHistorialRecursivo(historial, usuario, 0, new ArrayList<>());
    }
    
    // Método recursivo que filtra el historial
    private List<Tickect> verHistorialRecursivo(List<Tickect> historial, ClaseUsuario usuario, int index, List<Tickect> resultado) {
        if (index >= historial.size()) {
            return resultado;
        }
        
        if (historial.get(index).getUsuario().equals(usuario)) {
            resultado.add(historial.get(index));
        }
        
        return verHistorialRecursivo(historial, usuario, index + 1, resultado);
    }

    // Método para obtener todos los eventos disponibles
    public List<Event> obtenerEventosDisponibles() throws SQLException {
        return eventoController.leerEventos();
    }

    // Método para obtener un evento por su ID
    public Event obtenerEventoPorId(int idEvento) throws SQLException {
        return eventoController.leerEvento(idEvento);
    }

    private boolean verificarEventoExiste(Event evento) {
        return evento != null;
    }

    // Método recursivo para verificar la disponibilidad de boletos
    private boolean verificarDisponibilidadBoletosRecursivo(Event evento, int cantidad) {
        if (cantidad == 0) {
            return true; // Condición base: todos los boletos requeridos están disponibles
        }
        
        if (evento.getNumberTickets() <= 0) {
            return false; // Condición base: no hay boletos disponibles
        }
        
        evento.setNumberTickets(evento.getNumberTickets() - 1);
        return verificarDisponibilidadBoletosRecursivo(evento, cantidad - 1);
    }

    // Método recursivo para completar la compra
    private boolean completarCompraRecursivo(ClaseUsuario usuario, Event evento, int cantidad) throws SQLException {
        if (cantidad == 0) {
            // Condición base: todos los boletos han sido descontados
            Tickect tique = new Tickect(usuario, evento, cantidad);
            historial.add(tique);
            eventoController.actualizarEvento(evento);
            System.out.println("Compra completada. Tickets restantes: " + evento.getNumberTickets());
            return true;
        }
        
        // Descontar un boleto y llamar recursivamente
        evento.setNumberTickets(evento.getNumberTickets() - 1);
        return completarCompraRecursivo(usuario, evento, cantidad - 1);
    }
}