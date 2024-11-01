package Controller;

import ENTITY.Event;
import ENTITY.Tickect;
import ENTITY.ClaseUsuario;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Manuel
 */
public class BuyTickect {
     private List<Tickect> historial = new ArrayList<>();
    private EventController eventoController;

    public BuyTickect(EventController eventoController) {
        this.eventoController = eventoController;
    }

    // Método para realizar la compra de tickets
    public synchronized boolean comprarTique(ClaseUsuario usuario, int idEvento, int cantidad, String numeroTarjeta) {
        Event evento = eventoController.leerEvento(idEvento);

        if (evento != null && evento.getNumberTickets() >= cantidad) {
            evento.setNumberTickets(evento.getNumberTickets() - cantidad);
            eventoController.actualizarEvento(evento);

            // Crear ticket y agregarlo al historial
            Tickect tique = new Tickect(usuario, evento, cantidad);
            historial.add(tique);

            // Confirmación de la compra
            System.out.println("Compra realizada. Tickets restantes: " + evento.getNumberTickets());
            return true;
        }
        System.out.println("Compra fallida: No hay suficientes tickets disponibles o el evento no existe.");
        return false;
    }

    // Método para ver el historial de compras de un usuario
    public List<Tickect> verHistorialCompras(ClaseUsuario usuario) {
        return historial.stream()
                        .filter(t -> t.getUsuario().equals(usuario))
                        .collect(Collectors.toList());
    }
}
