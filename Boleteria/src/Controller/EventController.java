/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import ENTITY.Event;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Robert Granados
 */
public class EventController {
    
    private List<Event> eventos;
    private final String filePath = "eventos.json";  // Ruta del archivo JSON
    private ObjectMapper objectMapper;               // Para la serialización/deserialización de JSON

    // Constructor: carga los eventos desde el archivo JSON
    public EventController() {
        objectMapper = new ObjectMapper();
        eventos = cargarEventos();  // Cargar la lista de eventos al inicio
    }

    // Carga eventos desde el archivo JSON
    private List<Event> cargarEventos() {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                return objectMapper.readValue(file, new TypeReference<List<Event>>() {});
            } else {
                return new ArrayList<>();  // Si no hay archivo, devuelve una lista vacía
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();  // En caso de error, también devuelve una lista vacía
        }
    }

    // Guarda la lista de eventos en el archivo JSON
    private void guardarEventos() {
        try {
            objectMapper.writeValue(new File(filePath), eventos);
        } catch (IOException e) {
            e.printStackTrace();  // Manejo de excepciones en caso de fallo
        }
    }

    // Crea un nuevo evento y lo guarda
    public void crearEvento(Event evento) {
        int nuevoId = generarNuevoIdEvento();  // Generar un ID único para el nuevo evento
        evento.setId(nuevoId);  // Asignar el ID al nuevo evento
        eventos.add(evento);  // Añadir el evento a la lista
        guardarEventos();  // Guardar los cambios en el archivo JSON
    }

    // Genera un nuevo ID para un evento
    private int generarNuevoIdEvento() {
        if (eventos.isEmpty()) {  // Si la lista de eventos está vacía, el primer ID será 1
            return 1;
        }
        // Encuentra el mayor ID existente en la lista de eventos y asigna el siguiente
        int maxId = eventos.stream()
                           .mapToInt(Event::getId)
                           .max()
                           .orElse(0);
        return maxId + 1;
    }

    // Lee todos los eventos
    public List<Event> leerEventos() {
        return eventos;
    }

    // Lee un evento específico por ID
    public Event leerEvento(int id) {
        for (Event evento : eventos) {
            if (evento.getId() == id) {
                return evento;  // Retorna el evento si encuentra el ID
            }
        }
        return null;  // Si no se encuentra el evento, retorna null
    }

    // Actualiza un evento existente
    public void actualizarEvento(Event eventoActualizado) {
        for (int i = 0; i < eventos.size(); i++) {
            if (eventos.get(i).getId() == eventoActualizado.getId()) {
                eventos.set(i, eventoActualizado);  // Reemplaza el evento en la lista
                guardarEventos();  // Guarda los cambios en el archivo JSON
                return;
            }
        }
    }

    // Elimina un evento por su ID
    public void eliminarEvento(int id) {
        eventos.removeIf(evento -> evento.getId() == id);  // Elimina el evento si coincide el ID
        guardarEventos();  // Guarda los cambios tras la eliminación
    }

    // Método para validar si un evento existe por nombre y fecha
    public Event validarEvento(String nombre, String fecha) {
        for (Event evento : eventos) {
            if (evento.getName().equalsIgnoreCase(nombre) && evento.getDate().equals(fecha)) {
                return evento;  // Retorna el evento si coincide el nombre y la fecha
            }
        }
        return null;  // Si no se encuentra el evento, retorna null
    }
    
    
    
    
    public synchronized boolean buyTicket(int eventId, int numberOfTicketsToBuy, String creditCardNumber) {
        

        

        for (Event event : eventos) {
            if (event.getId() == eventId) {
                if (event.getNumberTickets() >= numberOfTicketsToBuy) {
                    // Descontar los tiquetes
                    event.setNumberTickets(event.getNumberTickets() - numberOfTicketsToBuy);
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
    
     
    
}
