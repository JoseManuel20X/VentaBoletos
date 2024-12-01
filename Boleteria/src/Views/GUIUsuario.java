package Views;

import Controller.UsuarioDAO;
import ENTITY.ClaseUsuario;
import Views.EditarUsuario;
import Controller.ClienteDAO;
import Views.Registro;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.event.DocumentListener;

/**
 * Autor: Manuel
 */

public class GUIUsuario extends javax.swing.JFrame {
private DefaultTableModel modelo;
    private ClienteDAO clienteDAO;
    private UsuarioDAO gestionUsuario;
    private UsuarioDAO usuarioDAO;

    // Constructor de la clase GUIUsuario que inicializa la interfaz gráfica.
    public GUIUsuario() throws SQLException {
        initComponents();
        // Inicialización de DAOs
        this.clienteDAO = new ClienteDAO();
        this.usuarioDAO = new UsuarioDAO(clienteDAO);
        
        // Configuración de la tabla
        String[] nombreColumnas = new String[]{"ID", "Correo", "Contraseña", "Rol_ID"};
        this.modelo = new NonEditableTableModel(nombreColumnas, 0);
        this.tbUsuarios.setModel(modelo);

        // Cargar datos en la tabla y configurar búsqueda
        cargarDatosEnTabla();
        agregarBusqueda();

        // Configuración de la ventana
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    private class NonEditableTableModel extends DefaultTableModel {
        public NonEditableTableModel(Object[] columnNames, int rowCount) {
            super(columnNames, rowCount);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    // Método para cargar los datos de los usuarios en la tabla.
    private void cargarDatosEnTabla() {
        try {
            List<ClaseUsuario> usuarios = usuarioDAO.obtenerUsuarios();
            modelo.setRowCount(0); // Limpia la tabla antes de cargar nuevos datos.
            for (ClaseUsuario usuario : usuarios) {
                modelo.addRow(new Object[]{
                    usuario.getId(),
                    usuario.getCorreo(),
                    usuario.getContrasena(),
                    usuario.getRolId()
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los usuarios: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar un usuario seleccionado de la tabla.
    private void eliminarUsuario() {
        int selectedRow = tbUsuarios.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) modelo.getValueAt(selectedRow, 0);
            try {
                usuarioDAO.eliminarUsuario(id);
                modelo.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un usuario para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para agregar un nuevo usuario a la tabla.
    public void agregarUsuario(ClaseUsuario nuevoUsuario) {
        try {
            usuarioDAO.agregarUsuario(nuevoUsuario);
            modelo.addRow(new Object[]{
                nuevoUsuario.getId(),
                nuevoUsuario.getCorreo(),
                nuevoUsuario.getContrasena(),
                nuevoUsuario.getRolId()
            });
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al agregar el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para configurar la funcionalidad de búsqueda filtrada.
    private void agregarBusqueda() {
        txtBusqueda.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                filtrarUsuarios();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                filtrarUsuarios();
            }

            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                filtrarUsuarios();
            }
        });
    }

    // Método para filtrar los usuarios en la tabla según el texto de búsqueda.
    private void filtrarUsuarios() {
        String filtro = txtBusqueda.getText().toLowerCase();
        modelo.setRowCount(0);
        try {
            List<ClaseUsuario> usuarios = usuarioDAO.obtenerUsuarios();
            for (ClaseUsuario usuario : usuarios) {
                if (usuario.getCorreo().toLowerCase().contains(filtro)) {
                    modelo.addRow(new Object[]{
                        usuario.getId(),
                        usuario.getCorreo(),
                        usuario.getContrasena(),
                        usuario.getRolId()
                    });
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al filtrar los usuarios: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    
    private void actualizarTabla() {
    try {
        modelo.setRowCount(0); // Limpiar las filas actuales de la tabla.
        
        // Obtener la lista actualizada de usuarios desde el DAO.
        List<ClaseUsuario> usuarios = gestionUsuario.obtenerUsuarios(); 
        
        if (usuarios != null && !usuarios.isEmpty()) {
            for (ClaseUsuario usuario : usuarios) {
                // Agregar cada usuario al modelo de la tabla.
                modelo.addRow(new Object[]{
                    usuario.getId(),
                    usuario.getCorreo(),
                    usuario.getContrasena(),
                    usuario.getRolId()
                });
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al actualizar la tabla: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    
    private void editarUsuario() {
    // Obtener la fila seleccionada en la tabla.
    int filaSeleccionada = this.tbUsuarios.getSelectedRow();

    if (filaSeleccionada != -1) {
        try {
            // Obtener el ID del usuario desde la fila seleccionada.
            int id = (int) this.tbUsuarios.getValueAt(filaSeleccionada, 0);

            // Obtener el usuario correspondiente al ID.
            ClaseUsuario usuario = gestionUsuario.obtenerUsuario(id);

            if (usuario != null) {
                // Crear y mostrar el cuadro de diálogo de edición.
                EditarUsuario dialog = new EditarUsuario(this, true, usuario, gestionUsuario);
                dialog.setVisible(true); // Mostrar el diálogo.
                
                // Actualizar la tabla después de la edición.
                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el usuario seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al editar el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un usuario para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
}
    
    
private void formu() {
    try {
        // Crear y abrir un formulario de usuario (suponiendo que FormularioUsuario está correctamente implementado).
        FormularioUsuario form = new FormularioUsuario(this, true, gestionUsuario); 
        form.setVisible(true); // Mostrar el formulario de manera modal.
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al abrir el formulario de usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        lblUsuarios = new javax.swing.JLabel();
        lblBusqueda = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbUsuarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 121, 525, 160));

        btnGuardar.setText("Agregar personal");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 91, 150, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 91, -1, -1));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 91, -1, -1));

        lblUsuarios.setText("Usuarios");
        jPanel1.add(lblUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        lblBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        lblBusqueda.setText("Búsqueda Filtrada");
        jPanel1.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 55, -1, -1));
        jPanel1.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 51, 390, -1));

        btnSalir.setBackground(new java.awt.Color(255, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 6, 105, 39));

        btnCliente.setText("Agregar cliente");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 91, 150, -1));

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
         try {
        this.formu(); // Abre el formulario para agregar un nuevo usuario.
        this.actualizarTabla(); // Actualiza la tabla con los datos más recientes.
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
        this.eliminarUsuario(); // Llama al método para eliminar el usuario seleccionado.
        this.actualizarTabla(); // Actualiza la tabla después de eliminar.
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
          try {
        this.editarUsuario(); // Abre el editor de usuario para el seleccionado.
        this.actualizarTabla(); // Actualiza la tabla después de editar.
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al editar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
       try {
        ClienteDAO crudcliente = new ClienteDAO(); // Crea una instancia del DAO de cliente.
        Registro registro = new Registro(crudcliente); // Abre el formulario de registro.
        registro.setVisible(true);
        registro.setResizable(false);
        registro.setLocationRelativeTo(null);
        this.actualizarTabla(); // Actualiza la tabla después de abrir el formulario de registro.
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al acceder al módulo de clientes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnClienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblUsuarios;
    private javax.swing.JTable tbUsuarios;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}