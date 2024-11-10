package Usuario;

import Controller.UsuarioCRUD;
import ENTITY.ClaseUsuario;
import Views.EditarUsuario;
import Controller.CRUDCliente;
import Views.Registro;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.event.DocumentListener;

/**
 * Autor: alexledezma
 */

public class GUIUsuario extends javax.swing.JFrame {
private DefaultTableModel modelo;
private CRUDCliente clienteCRUD;
private UsuarioCRUD usuarioCrud;
private UsuarioCRUD gestionUsuario;

// Constructor de la clase GUIUsuario que inicializa la interfaz gráfica.
public GUIUsuario() {
    initComponents(); // Inicializa los componentes de la interfaz gráfica.
    this.gestionUsuario = new UsuarioCRUD(clienteCRUD); // Crea una instancia de UsuarioCRUD para gestionar los usuarios.  
    // Define los nombres de las columnas de la tabla.
    String[] nombreColumnas = new String[]{"ID", "Correo", "Contraseña", "Rol_ID"};
    // Crea un modelo de tabla no editable con los nombres de las columnas especificados.
    this.modelo = new NonEditableTableModel(nombreColumnas, 0);
    // Asigna el modelo de tabla a la tabla visual (tbUsuarios).
    this.tbUsuarios.setModel(modelo);   
    cargarDatosEnTabla(); // Carga los datos de los usuarios en la tabla.
    agregarBusqueda(); // Configura la funcionalidad de búsqueda filtrada.   
    // Configura la ventana para que sea visible, no redimensionable y centrada en la pantalla.
    this.setVisible(true);
    this.setResizable(false);
    this.setLocationRelativeTo(null);
}

// Retorna el modelo de tabla actual.
public DefaultTableModel getTableModel() {
    return this.modelo; // Retorna la instancia del modelo de tabla.
}

// Clase interna que extiende DefaultTableModel para hacer la tabla no editable.
private class NonEditableTableModel extends DefaultTableModel {
    // Constructor que llama al constructor de la superclase DefaultTableModel.
    public NonEditableTableModel(Object[] columnNames, int rowCount) {
        super(columnNames, rowCount);
    }

    @Override
    // Método que indica que las celdas no son editables.
    public boolean isCellEditable(int row, int column) {
        return false; // Retorna false para que las celdas no sean editables.
    }
}

// Método para cargar los datos de los usuarios en la tabla.
private void cargarDatosEnTabla() {
    // Obtiene la lista de usuarios desde la instancia de UsuarioCRUD.
    List<ClaseUsuario> usuarios = gestionUsuario.obtenerUsuarios();
    System.out.println("Usuarios en GUI: " + usuarios); // Imprime los usuarios obtenidos para depuración.
    
    if (usuarios != null && !usuarios.isEmpty()) { // Verifica si la lista de usuarios no es nula y no está vacía.
        for (ClaseUsuario usuario : usuarios) { // Recorre la lista de usuarios.
            // Crea un array de objetos con los datos del usuario.
            Object[] fila = new Object[]{
                usuario.getId(),
                usuario.getCorreo(),
                usuario.getContrasena(),
                usuario.getRolId()
            };
            // Añade la fila al modelo de tabla.
            modelo.addRow(fila);
        }
    } 
}

// Método para actualizar la tabla con los datos actuales de los usuarios.
private void actualizarTabla() {
    // Limpia el contenido actual de la tabla.
    this.modelo.setRowCount(0);
    // Obtiene la lista actualizada de usuarios desde el JSON.
    List<ClaseUsuario> usuarios = this.gestionUsuario.cargarUsuarios();
    
    if (usuarios != null) { // Verifica si la lista de usuarios no es nula.
        for (ClaseUsuario usuario : usuarios) { // Recorre la lista de usuarios.
            // Crea un array de objetos con los datos del usuario.
            this.modelo.addRow(new Object[]{
                usuario.getId(),
                usuario.getCorreo(),
                usuario.getContrasena(),
                usuario.getRolId()
            });
        }
    } 
}

// Método para eliminar un usuario seleccionado de la tabla.
private void eliminarUsuario() {
    // Obtiene la fila seleccionada en la tabla.
    int selectedRow = this.tbUsuarios.getSelectedRow();
    
    if (selectedRow != -1) { // Verifica si hay una fila seleccionada.
        // Obtiene el ID del usuario desde la fila seleccionada.
        int id = (int) modelo.getValueAt(selectedRow, 0);
        // Elimina el usuario usando el ID.
        gestionUsuario.eliminarUsuario(id, true);
        // Elimina la fila correspondiente en la tabla.
        modelo.removeRow(selectedRow);
    } else {
        // Muestra un mensaje de error si no se selecciona un usuario.
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un usuario para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// Método para agregar un nuevo usuario a la tabla.
public void agregarUsuario(ClaseUsuario nuevoUsuario) {
    // Agrega el nuevo usuario al archivo JSON.
    gestionUsuario.agregarUsuario(nuevoUsuario);
    // Crea un array de objetos con los datos del nuevo usuario.
    Object[] fila = new Object[]{
        nuevoUsuario.getId(),
        nuevoUsuario.getCorreo(),
        nuevoUsuario.getContrasena(),
        nuevoUsuario.getRolId()
    };
    // Añade la fila al modelo de tabla.
    modelo.addRow(fila);
}

// Método para editar un usuario seleccionado en la tabla.
private void editarUsuario() {
    // Obtiene la fila seleccionada en la tabla.
    int filaSeleccionada = this.tbUsuarios.getSelectedRow();
    
    if (filaSeleccionada != -1) { // Verifica si hay una fila seleccionada.
        // Obtiene el ID del usuario desde la fila seleccionada.
        int id = (int) this.tbUsuarios.getValueAt(filaSeleccionada, 0);
        // Obtiene el objeto Usuario correspondiente al ID.
        ClaseUsuario usuario = gestionUsuario.obtenerUsuario(id);
        
        if (usuario != null) { // Verifica si el usuario no es nulo.
            // Crea un JDialog para editar el usuario.
            EditarUsuario dialog = new EditarUsuario(this, true, usuario, gestionUsuario);
            dialog.setVisible(true); // Muestra el JDialog.
        } else {
            // Muestra un mensaje de error si no se encuentra el usuario.
            JOptionPane.showMessageDialog(this, "No se encontró el usuario seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        // Muestra un mensaje de advertencia si no se selecciona un usuario.
        JOptionPane.showMessageDialog(this, "Seleccione un usuario para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
}

// Método para configurar la funcionalidad de búsqueda filtrada.
private void agregarBusqueda() {
    // Agrega un DocumentListener al campo de búsqueda (txtBusqueda).
    txtBusqueda.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void changedUpdate(javax.swing.event.DocumentEvent e) {
            filtrarUsuarios(); // Filtra los usuarios cuando cambia el texto en el campo de búsqueda.
        }
        @Override
        public void removeUpdate(javax.swing.event.DocumentEvent e) {
            filtrarUsuarios(); // Filtra los usuarios cuando se elimina texto del campo de búsqueda.
        }
        @Override
        public void insertUpdate(javax.swing.event.DocumentEvent e) {
            filtrarUsuarios(); // Filtra los usuarios cuando se inserta texto en el campo de búsqueda.
        }
    });
}

// Método para filtrar los usuarios en la tabla según el texto de búsqueda.
private void filtrarUsuarios() {
    // Obtiene el texto de búsqueda y lo convierte a minúsculas.
    String filtro = txtBusqueda.getText().toLowerCase();
    // Limpia la tabla actual.
    modelo.setRowCount(0);
    // Obtiene la lista de usuarios.
    List<ClaseUsuario> usuarios = gestionUsuario.cargarUsuarios();
    
    if (usuarios != null) { // Verifica si la lista de usuarios no es nula.
        for (ClaseUsuario usuario : usuarios) { // Recorre la lista de usuarios.
            // Verifica si el correo del usuario contiene el texto de búsqueda.
            if (usuario.getCorreo().toLowerCase().contains(filtro)) {
                // Añade los datos del usuario a la tabla.
                modelo.addRow(new Object[]{
                    usuario.getId(),
                    usuario.getCorreo(),
                    usuario.getContrasena(),
                    usuario.getRolId()
                });
            }
        }
    }
}

// Método para abrir un formulario para agregar un nuevo usuario.
private void formu() {
    FormularioUsuario form = new FormularioUsuario(this, true, gestionUsuario);
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
        // TODO add your handling code here:
        this.formu();
        this.actualizarTabla();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        this.eliminarUsuario();
        this.actualizarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        this.editarUsuario();
        this.actualizarTabla();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
       CRUDCliente crudcliente = new CRUDCliente();
        Registro registro = new Registro(crudcliente);  
        registro.setVisible(true);
        registro.setResizable(false);
        registro.setLocationRelativeTo(null);
       this.actualizarTabla();
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