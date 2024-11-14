package ENTITY;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Historial {

    @JsonProperty("nombreevent")
    private String nombreevent;

    @JsonProperty("correoCliente")
    private String correoCliente;

    @JsonProperty("idcliente")
    private int idcliente;

    @JsonProperty("idHistorial")
    private int idHistorial;

    @JsonProperty("cantidad")
    private int cantidad;

    // Constructor sin parámetros
    public Historial() {
    }

    // Constructor con parámetros
    public Historial(String nombreevent, String correoCliente, int idcliente, int idHistorial, int cantidad) {
        this.nombreevent = nombreevent;
        this.correoCliente = correoCliente;
        this.idcliente = idcliente;
        this.idHistorial = idHistorial;
        this.cantidad = cantidad;
    }

    // Getters y setters
    public String getNombreevent() {
        return nombreevent;
    }

    public void setNombreevent(String nombreevent) {
        this.nombreevent = nombreevent;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}