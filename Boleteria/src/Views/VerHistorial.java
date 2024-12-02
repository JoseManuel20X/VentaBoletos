package Views;

import Controller.HistorialDAO;
import ENTITY.Historial;
import javax.swing.*;
import java.awt.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author Robert Granados
 */
public class VerHistorial {
    private JFrame frame;
    private JTable table;
    private HistorialDAO crudHistorial;
    private int idCliente;

    public VerHistorial(HistorialDAO crudHistorial, int idCliente) {
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

        // Crear botón de exportar a PDF
        JButton exportarPDFButton = new JButton("Exportar a PDF");
        exportarPDFButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportarAPDF();
            }
        });
        frame.add(exportarPDFButton, BorderLayout.SOUTH);
    }

    private void actualizarTabla() {
        String[] columnas = {"ID Historial", "Nombre Evento", "Correo Cliente", "ID Cliente", "Cantidad"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);

        try {
            // Cargar datos filtrados directamente desde el método de HistorialDAO
            List<Historial> historiales = crudHistorial.leerHistoriales(idCliente);

            for (Historial historial : historiales) {
                Object[] fila = {
                    historial.getIdHistorial(),
                    historial.getNombreevent(),
                    historial.getCorreoCliente(),
                    historial.getidcliente(),
                    historial.getCantidad()
                };
                model.addRow(fila);
            }

            // Asignar el modelo a la tabla
            table.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Error al cargar datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exportarAPDF() {
        try {
            Document document = new Document();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar PDF");

            int userSelection = fileChooser.showSaveDialog(frame);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath() + ".pdf";
                PdfWriter.getInstance(document, new FileOutputStream(filePath));

                document.open();
                document.add(new Paragraph("Historial de Compras", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK)));
                document.add(new Paragraph(" "));

                // Crear tabla para el PDF
                PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
                pdfTable.setWidthPercentage(100);
                pdfTable.setSpacingBefore(10f);
                pdfTable.setSpacingAfter(10f);

                // Añadir encabezados de tabla
                for (int i = 0; i < table.getColumnCount(); i++) {
                    PdfPCell header = new PdfPCell(new Phrase(table.getColumnName(i)));
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    pdfTable.addCell(header);
                }

                // Añadir filas de la tabla
                for (int row = 0; row < table.getRowCount(); row++) {
                    for (int col = 0; col < table.getColumnCount(); col++) {
                        pdfTable.addCell(table.getValueAt(row, col).toString());
                    }
                }

                document.add(pdfTable);
                document.close();

                JOptionPane.showMessageDialog(frame, "PDF exportado correctamente a:\n" + filePath);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error al exportar PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrar() {
        frame.setVisible(true);
    }
}