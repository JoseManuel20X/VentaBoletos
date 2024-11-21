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

    public VerHistorial(Controller.CRUDHistorial crudHistorial, int idCliente) {
        this.crudHistorial = crudHistorial; // Asignar instancia pasada por parámetro
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

        // Cargar datos filtrados directamente desde el método de CRUDHistorial
        List<Historial> historiales = crudHistorial.cargarHistoriales(idCliente);

        for (Historial historial : historiales) {
            Object[] fila = {
                historial.getIdHistorial(),
                historial.getNombreevent(),
                historial.getCorreoCliente(),
                historial.getIdcliente(),
                historial.getCantidad()
            };
            model.addRow(fila);
        }

        // Asignar el modelo a la tabla
        table.setModel(model);
    }

    public void mostrar() {
        frame.setVisible(true);
    }
}
