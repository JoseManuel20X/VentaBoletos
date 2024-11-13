
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
 * 
 * @author Manuel
 */
public class CRUDHistorial {
    private List<Historial> historiales;
    private final String filePath = "historial.json";
    private ObjectMapper objectMapper;

    // Constructor
    public CRUDHistorial() {
        objectMapper = new ObjectMapper();
        historiales = cargarHistoriales();
    }

    private List<Historial> cargarHistoriales() {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                return objectMapper.readValue(file, new TypeReference<List<Historial>>() {});
            } else {
                return new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void guardarHistoriales() {
        try {
            objectMapper.writeValue(new File(filePath), historiales);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crearHistorial(Historial historial) {
        int nuevoId = generarNuevoIdHistorial();
        historial.setIdHistorial(nuevoId);
        historiales.add(historial);
        guardarHistoriales();
    }

    private int generarNuevoIdHistorial() {
        if (historiales.isEmpty()) {
            return 1; // Si la lista está vacía, el primer ID será 1
        }
        int maxId = historiales.stream()
                               .mapToInt(Historial::getIdHistorial)
                               .max()
                               .orElse(0);
        return maxId + 1;
    }

    public List<Historial> leerHistoriales() {
        return historiales;
    }

    public Historial leerHistorial(int idHistorial) {
        for (Historial historial : historiales) {
            if (historial.getIdHistorial() == idHistorial) {
                return historial;
            }
        }
        return null;
    }

    public void actualizarHistorial(Historial historialActualizado) {
        for (int i = 0; i < historiales.size(); i++) {
            if (historiales.get(i).getIdHistorial() == historialActualizado.getIdHistorial()) {
                historiales.set(i, historialActualizado);
                guardarHistoriales();
                return;
            }
        }
    }

    public void eliminarHistorial(int idHistorial) {
        historiales.removeIf(historial -> historial.getIdHistorial() == idHistorial);
        guardarHistoriales();
    }

   public List<Historial> buscarHistorialPorCorreoCliente(String correoCliente) {
    List<Historial> historialesEncontrados = new ArrayList<>();
    for (Historial historial : historiales) {
        if (historial.getCorreoCliente().equalsIgnoreCase(correoCliente)) {
            historialesEncontrados.add(historial);
        }
    }
    return historialesEncontrados;
}
}
