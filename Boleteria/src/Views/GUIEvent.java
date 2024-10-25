package Views;


import Controller.EventController;
import ENTITY.Event;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Manuel
 */

public class GUIEvent extends javax.swing.JFrame {
    private DefaultTableModel modelo;
    private EventController gestionEventos;
    
    public GUIEvent() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.gestionEventos = new EventController();

        // Define los nombres de las columnas para la tabla de eventos
        String[] nombreColumnas = new String[]{"ID", "Nombre", "Fecha", "Recinto", "Precio","Tickets Disp","Descripción"};
        this.modelo = new NonEditableTableModel(nombreColumnas, 0);
        this.tbEventos.setModel(modelo);

        cargarDatosEnTabla();
        agregarBusqueda();
        this.setVisible(true);
    }

    // Retorna el modelo de tabla actual.
    public DefaultTableModel getTableModel() {
        return this.modelo; // Retorna la instancia del modelo de tabla.
    }

    // Clase interna que extiende DefaultTableModel para hacer la tabla no editable.
    private class NonEditableTableModel extends DefaultTableModel {
        public NonEditableTableModel(Object[] columnNames, int rowCount) {
            super(columnNames, rowCount);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Retorna false para que las celdas no sean editables.
        }
    }

     private void cargarDatosEnTabla() {
        List<Event> eventos = gestionEventos.leerEventos();
        System.out.println("Eventos en GUI: " + eventos );
        
        if (eventos != null && !eventos.isEmpty()) {
            for (Event evento : eventos) {
                Object[] fila = new Object[]{
                    evento.getId(),
                    evento.getName(),
                    evento.getDate(),
                    evento.getEnclosure(),
                    evento.getPrice(),
                    evento.getNumberTickets(),
                    evento.getDescription()
                };
                modelo.addRow(fila);
            }
        }
    }
     
     private void actualizarTabla() {
        this.modelo.setRowCount(0);
         List<Event> eventos = this.gestionEventos.leerEventos();

        if (eventos != null) {
            for (Event evento : eventos) {
                this.modelo.addRow(new Object[]{
                   evento.getId(),
                    evento.getName(),
                    evento.getDate(),
                    evento.getEnclosure(),
                    evento.getPrice(),
                    evento.getNumberTickets(),
                    evento.getDescription()
                });
            }
        } 
    }

    private void agregarEvento(Event nuevoEvento) {
        gestionEventos.crearEvento(nuevoEvento);
        Object[] fila = new Object[]{
            nuevoEvento.getId(),
            nuevoEvento.getName(),
            nuevoEvento.getDate(),
            nuevoEvento.getEnclosure(),
            nuevoEvento.getPrice(),
            nuevoEvento.getNumberTickets(),
            nuevoEvento.getDescription()
        };
        modelo.addRow(fila);
    }

    private void eliminarEvento() {
        int selectedRow = this.tbEventos.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) modelo.getValueAt(selectedRow, 0);
            gestionEventos.eliminarEvento(id);
            modelo.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un evento para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarEvento() {
        int filaSeleccionada = this.tbEventos.getSelectedRow();
        if (filaSeleccionada != -1) {
            int id = (int) this.tbEventos.getValueAt(filaSeleccionada, 0);
            Event evento = gestionEventos.leerEvento(id);
            if (evento != null) {
                EditarEvento dialog = new EditarEvento(this, true, evento, gestionEventos);
                dialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el evento seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un evento para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void agregarBusqueda() {
        txtBusqueda.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                filtrarEventos();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                filtrarEventos();
            }

            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                filtrarEventos();
            }
        });
    }

    private void filtrarEventos() {
        String filtro = txtBusqueda.getText().toLowerCase();
        modelo.setRowCount(0);
        List<Event> eventos = gestionEventos.leerEventos();

        if (eventos != null) {
            for (Event evento : eventos) {
                if (String.valueOf(evento.getId()).contains(filtro) ||
                    evento.getName().toLowerCase().contains(filtro) ||
                    evento.getDate().contains(filtro) ||
                    evento.getEnclosure().toLowerCase().contains(filtro)) {
                    modelo.addRow(new Object[]{
                        evento.getId(),
                        evento.getName(),
                        evento.getDate(),
                        evento.getEnclosure(),
                        evento.getPrice()
                    });
                }
            }
        }
    }
    
    
    private void formu() {
       // Crear una instancia de EventController (suponiendo que ya la tienes en tu código)
    EventController gestionEventos = new EventController();

    // Llamar al constructor de FormularioEvento con los parámetros correctos
    FormularioEvento form = new FormularioEvento(null, true, gestionEventos);
    form.setVisible(true);
    form.setResizable(false);
    form.setLocationRelativeTo(null);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEventos = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        lblBusqueda = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbEventos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 640, 170));

        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setText("Agregar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, -1, -1));

        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, -1, -1));

        btnEditar.setForeground(new java.awt.Color(0, 0, 0));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, -1, -1));

        lblBusqueda.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        lblBusqueda.setForeground(new java.awt.Color(0, 0, 0));
        lblBusqueda.setText("Búsqueda Filtrada");
        jPanel1.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));
        jPanel1.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 339, -1));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 89, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        this.formu();
        this.actualizarTabla();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        this.eliminarEvento();
        this.actualizarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JTable tbEventos;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
