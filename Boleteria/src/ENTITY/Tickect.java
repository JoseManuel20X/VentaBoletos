
package ENTITY;

import ENTITY.ClaseUsuario;

/**
 *
 * @author Robert Granados
 */
public class Tickect {
    private ClaseUsuario usuario;
    private Event evento;
    private int cantidad;

    public Tickect(ClaseUsuario usuario, Event evento, int cantidad) {
        this.usuario = usuario;
        this.evento = evento;
        this.cantidad = cantidad;
    }

    public ClaseUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(ClaseUsuario usuario) {
        this.usuario = usuario;
    }

    public Event getEvento() {
        return evento;
    }

    public void setEvento(Event evento) {
        this.evento = evento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
