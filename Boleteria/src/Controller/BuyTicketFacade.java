package Controller;

import ENTITY.Event;
import ENTITY.Tickect;
import ENTITY.ClaseUsuario;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BuyTicketFacade {
    private EventController eventoController;
    private List<Tickect> historial;

    public BuyTicketFacade(EventController eventoController) {
        this.eventoController = eventoController;
        this.historial = new ArrayList<>();
    }

    public boolean comprarTique(ClaseUsuario usuario, int idEvento, int cantidad, String numeroTarjeta) {
        return eventoController.buyTicket(idEvento, cantidad, numeroTarjeta);
    }

    public List<Tickect> verHistorialCompras(ClaseUsuario usuario) {
        return historial.stream()
                        .filter(t -> t.getUsuario().equals(usuario))
                        .collect(Collectors.toList());
    }

    // Método para obtener todos los eventos disponibles
    public List<Event> obtenerEventosDisponibles() {
        return eventoController.leerEventos();
    }

    // Método para obtener un evento por su ID
    public Event obtenerEventoPorId(int idEvento) {
        return eventoController.leerEvento(idEvento);
    }

    private boolean verificarEventoExiste(Event evento) {
        return evento != null;
    }

    private boolean verificarDisponibilidadBoletos(Event evento, int cantidad) {
        return evento.getNumberTickets() >= cantidad;
    }

    private boolean completarCompra(ClaseUsuario usuario, Event evento, int cantidad) {
        evento.setNumberTickets(evento.getNumberTickets() - cantidad);
        eventoController.actualizarEvento(evento);

        Tickect tique = new Tickect(usuario, evento, cantidad);
        historial.add(tique);

        System.out.println("Compra realizada. Tickets restantes: " + evento.getNumberTickets());
        return true;
    }
}