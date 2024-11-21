package Controller;

import ENTITY.Event;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EventController {

    private List<Event> eventos;
    private final String filePath = "eventos.json";
    private ObjectMapper objectMapper;

    public EventController() {
        objectMapper = new ObjectMapper();
        eventos = cargarEventos();
    }

    private List<Event> cargarEventos() {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                return objectMapper.readValue(file, new TypeReference<List<Event>>() {});
            } else {
                return new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    

    private void guardarEventos() {
        try {
            objectMapper.writeValue(new File(filePath), eventos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crearEvento(Event evento) {
        int nuevoId = generarNuevoIdEvento();
        evento.setId(nuevoId);
        eventos.add(evento);
        guardarEventos();
    }

    private int generarNuevoIdEvento() {
        return eventos.stream()
                      .mapToInt(Event::getId)
                      .max()
                      .orElse(0) + 1;
    }

    public List<Event> leerEventos() {
        return eventos;
    }

    public Event leerEvento(int id) {
        return eventos.stream()
                      .filter(e -> e.getId() == id)
                      .findFirst()
                      .orElse(null);
    }

    public boolean actualizarEvento(Event eventoActualizado) {
        for (int i = 0; i < eventos.size(); i++) {
            if (eventos.get(i).getId() == eventoActualizado.getId()) {
                eventos.set(i, eventoActualizado);
                guardarEventos();
                return true;
            }
        }
        return false;
    }

     public synchronized boolean buyTicket(int eventId, int numberOfTicketsToBuy, String creditCardNumber) {
        for (Event event : eventos) {
            if (event.getId() == eventId) {
                if (event.getNumberTickets() >= numberOfTicketsToBuy) {
                    event.setNumberTickets(event.getNumberTickets() - numberOfTicketsToBuy);
                    guardarEventos();  // Guarda los eventos actualizados
                    System.out.println("Compra exitosa! Quedan " + event.getNumberTickets() + " tiquetes.");
                    return true;
                } else {
                    System.out.println("No hay suficientes tiquetes disponibles.");
                    return false;
                }
            }
        }
        System.out.println("Evento no encontrado.");
        return false;
    }
     
    public boolean eliminarEvento(int id) {
    boolean eliminado = eventos.removeIf(event -> event.getId() == id);
    if (eliminado) {
        guardarEventos(); // Actualizar el archivo JSON después de eliminar
    }
    return eliminado;
}
}