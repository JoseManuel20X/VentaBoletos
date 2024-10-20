/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Models.Event;
import Models.Tickect;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Robert Granados
 */
public class BuyTickect {
    private List<Tickect> historial = new ArrayList<>();
    private EventController eventoController;
    
   /** public synchronized boolean comprarTique(Usuario usuario, String nombreEvento, int cantidad) {
        Event evento = eventoController.buscarEvento(nombreEvento);
        
        if (evento != null && evento.getTiquesDisponibles() >= cantidad) {
            evento.setTiquesDisponibles(evento.getTiquesDisponibles() - cantidad);
            Tickect tique = new Tickect(usuario, evento, cantidad);
            historial.add(tique);
            return true;
        }
        return false;
    }

    public List<Tickect> verHistorialCompras(Usuario usuario) {
        return historial.stream()
                        .filter(t -> t.getUsuario().equals(usuario))
                        .collect(Collectors.toList());
    }*/
}
