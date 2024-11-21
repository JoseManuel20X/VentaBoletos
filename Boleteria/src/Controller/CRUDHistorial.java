
package Controller;

import ENTITY.Historial;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Manuel
 */
public class CRUDHistorial {
    private ObjectMapper objectMapper;

    // Constructor
    public CRUDHistorial() {
        objectMapper = new ObjectMapper();
    }

    // Generar la ruta del archivo de historial para un usuario específico
    private String getUserFilePath(int idCliente) {
        return "historial_" + idCliente + ".json";
    }

    // Cargar historiales de un usuario específico
    public List<Historial> cargarHistoriales(int idCliente) {
        String filePath = getUserFilePath(idCliente);
        try {
            File file = new File(filePath);
            if (file.exists()) {
                return objectMapper.readValue(file, new TypeReference<List<Historial>>() {});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(); // Si no hay archivo, retorna lista vacía
    }

    // Guardar historiales para un usuario específico
    private void guardarHistoriales(int idCliente, List<Historial> historiales) {
        String filePath = getUserFilePath(idCliente);
        try {
            objectMapper.writeValue(new File(filePath), historiales);
        } catch (IOException e) {
            System.err.println("Error al guardar el historial: " + e.getMessage());
        }
    }

    // Crear un nuevo historial para un usuario
    public void crearHistorial(int idCliente, Historial historial) {
        List<Historial> historialesUsuario = cargarHistoriales(idCliente);
        int nuevoId = generarNuevoIdHistorial(historialesUsuario);
        historial.setIdHistorial(nuevoId);
        historialesUsuario.add(historial);
        guardarHistoriales(idCliente, historialesUsuario);
    }

    // Generar un nuevo ID único para un usuario específico
    private int generarNuevoIdHistorial(List<Historial> historialesUsuario) {
        if (historialesUsuario.isEmpty()) {
            return 1; // Si la lista está vacía, el primer ID será 1
        }
        return historialesUsuario.stream()
                         .mapToInt(Historial::getIdHistorial)
                         .max()
                         .orElse(0) + 1;
    }

    // Leer historiales de un usuario
    public List<Historial> leerHistoriales(int idCliente) {
        return cargarHistoriales(idCliente);
    }

    // Leer un historial específico de un usuario por ID
    public Historial leerHistorial(int idCliente, int idHistorial) {
        List<Historial> historialesUsuario = cargarHistoriales(idCliente);
        for (Historial historial : historialesUsuario) {
            if (historial.getIdHistorial() == idHistorial) {
                return historial;
            }
        }
        return null;
    }

    // Actualizar un historial de un usuario
    public void actualizarHistorial(int idCliente, Historial historialActualizado) {
        List<Historial> historialesUsuario = cargarHistoriales(idCliente);
        for (int i = 0; i < historialesUsuario.size(); i++) {
            if (historialesUsuario.get(i).getIdHistorial() == historialActualizado.getIdHistorial()) {
                historialesUsuario.set(i, historialActualizado);
                guardarHistoriales(idCliente, historialesUsuario);
                return;
            }
        }
    }

    // Eliminar un historial por ID de un usuario
    public void eliminarHistorial(int idCliente, int idHistorial) {
        List<Historial> historialesUsuario = cargarHistoriales(idCliente);
        historialesUsuario.removeIf(historial -> historial.getIdHistorial() == idHistorial);
        guardarHistoriales(idCliente, historialesUsuario);
    }
}

