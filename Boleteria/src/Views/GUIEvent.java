package Views;


import Controller.EventDAO;
import ENTITY.Event;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Manuel
 */

public class GUIEvent extends javax.swing.JFrame {
    private DefaultTableModel modelo;
    private EventDAO gestionEventos;
    
    public GUIEvent() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.gestionEventos = new EventDAO();

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

     private void cargarDatosEnTabla() throws SQLException {
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
     
     private void actualizarTabla() throws SQLException {
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

    private void agregarEvento(Event nuevoEvento) throws SQLException {
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

    private void eliminarEvento() throws SQLException {
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
    int filaSeleccionada = tbEventos.getSelectedRow();

    // Verificar si se seleccionó una fila
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un evento para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        // Obtener el ID del evento seleccionado
        int id = (int) tbEventos.getValueAt(filaSeleccionada, 0);
        Event evento = gestionEventos.leerEvento(id);

        // Validar si se encontró el evento
        if (evento == null) {
            JOptionPane.showMessageDialog(this, "No se encontró el evento seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear y mostrar el diálogo de edición
        EditarEvento dialog = new EditarEvento(evento, gestionEventos);
        dialog.setVisible(true);

        // Refrescar la tabla tras la edición
        actualizarTabla();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Ocurrió un error al intentar editar el evento: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void agregarBusqueda() {
        txtBusqueda.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                try {
                    filtrarEventos();
                } catch (SQLException ex) {
                    Logger.getLogger(GUIEvent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                try {
                    filtrarEventos();
                } catch (SQLException ex) {
                    Logger.getLogger(GUIEvent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                try {
                    filtrarEventos();
                } catch (SQLException ex) {
                    Logger.getLogger(GUIEvent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void filtrarEventos() throws SQLException {
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
       // Crear una instancia de EventDAO (suponiendo que ya la tienes en tu código)
    EventDAO gestionEventos = new EventDAO();

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
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        lblBusqueda = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 640, 170));

        btnAgregar.setBackground(new java.awt.Color(0, 255, 0));
        btnAgregar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, -1));

        btnEditar.setBackground(new java.awt.Color(51, 255, 0));
        btnEditar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 0, 0));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, -1, -1));

        lblBusqueda.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        lblBusqueda.setForeground(new java.awt.Color(0, 0, 0));
        lblBusqueda.setText("Búsqueda Filtrada");
        jPanel1.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));
        jPanel1.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 339, -1));

        btnSalir.setBackground(new java.awt.Color(255, 0, 0));
        btnSalir.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 89, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FondoBonito.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 360));

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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        this.formu();
        try {
            this.actualizarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(GUIEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            // TODO add your handling code here:
            this.eliminarEvento();
        } catch (SQLException ex) {
            Logger.getLogger(GUIEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.actualizarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(GUIEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.editarEvento();
        try {
            this.actualizarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(GUIEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JTable tbEventos;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
