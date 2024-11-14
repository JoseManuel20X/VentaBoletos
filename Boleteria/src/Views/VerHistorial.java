/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import Controller.CRUDHistorial;
import ENTITY.Historial;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 *
 * @author Robert Granados
 */
public class VerHistorial {
    private JFrame frame;
    private JTable table;
    private Controller.CRUDHistorial crudHistorial;
    private int idCliente;

    public VerHistorial(CRUDHistorial crudHistorial, int idCliente1) {
        this.crudHistorial = new Controller.CRUDHistorial(); 
        this.idCliente = idCliente;
        // Configuración del JFrame
        frame = new JFrame("Historial de Compras");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Configuración de la tabla
        table = new JTable();
        actualizarTabla(); 
        
        
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
    }

    private void actualizarTabla() {
        String[] columnas = {"ID Historial", "Nombre Evento", "Correo Cliente", "ID Cliente", "Cantidad"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);

        // Cargar y filtrar los datos del historial
        List<Historial> historiales = crudHistorial.leerHistoriales();
        for (Historial historial : historiales) {
            // Filtrar por el ID del cliente
            if (historial.getIdcliente() == idCliente) {
                Object[] fila = {
                    historial.getIdHistorial(),
                    historial.getNombreevent(),
                    historial.getCorreoCliente(),
                    historial.getIdcliente(),
                    historial.getCantidad()
                };
                model.addRow(fila);
            }
        }

        // Asignar el modelo a la tabla
        table.setModel(model);
    }

    public void mostrar() {
        frame.setVisible(true);
    }
}
