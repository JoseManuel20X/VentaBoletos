/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Views;


import Models.ClaseUsuario;
import Usuario.UsuarioCRUD;
import javax.swing.JOptionPane;

/**
 *
 * @author alexledezma
 */

public class EditarUsuario extends javax.swing.JDialog {
   private ClaseUsuario usuario; // Objeto que representa al usuario a editar.
   private UsuarioCRUD gestionUsuario; // Instancia para gestionar usuarios.

    // Constructor de la clase EditarUsuario.
    public EditarUsuario(java.awt.Frame parent, boolean modal, ClaseUsuario usuario, UsuarioCRUD gestionUsuario) {
        super(parent, modal); // Llama al constructor de la superclase JDialog.
        initComponents(); // Inicializa los componentes de la interfaz gráfica.
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.usuario = usuario; // Asigna el usuario recibido al campo de instancia.
        this.gestionUsuario = gestionUsuario; // Asigna el gestionUsuario recibido al campo de instancia.
        if (this.usuario == null) { // Verifica si el usuario es nulo.
            // Muestra un mensaje de error y cierra el diálogo si no hay usuario.
            JOptionPane.showMessageDialog(this, "El usuario no está disponible para edición.", "Error", JOptionPane.ERROR_MESSAGE);
            this.dispose(); // Cierra el JDialog.
        } else {
            // Si el usuario no es nulo, carga los datos en los campos de texto.
            txtCorreo.setText(usuario.getCorreo());
            txtContraseña.setText(usuario.getContrasena());
        }
    }

    private boolean validarIDRol(String texto) {
        if (texto == null || texto.isEmpty()) {
            return false; // El texto es nulo o vacío, no es válido.
        }
        try {
            // Intenta convertir el texto a un entero.
            int rolId = Integer.parseInt(texto);
            // Verifica si el entero está en el rango permitido (1 a 3).
            return rolId >= 1 && rolId <= 3;
        } catch (NumberFormatException e) {
            // La conversión falló, el texto no es un número entero válido.
            return false;
        }
    }

    private boolean soloLetrasNumerosArroba(String texto) {
    boolean contieneArroba = false;
    for (char c : texto.toCharArray()) {
        if (Character.isLetter(c) || Character.isDigit(c) || c == '.') {
            continue;
        } else if (c == '@') {
            if (contieneArroba) {
                return false;
            }
            contieneArroba = true;
        } else {
            return false;
        }
      }
      return true;
    }   
    
    private boolean soloContraseña(String texto) {
    if (texto.length() < 8 || texto.length() > 16) {
        return false;
    }
    for (char c : texto.toCharArray()) {
        if (!Character.isLetterOrDigit(c)) {
            return false;
        }
    }
    return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCorreo = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        lblEditar = new javax.swing.JLabel();
        txtIDrol = new javax.swing.JTextField();
        lblContraseña1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo.setText("Correo");
        jPanel1.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 69, -1, -1));

        lblContraseña.setForeground(new java.awt.Color(255, 255, 255));
        lblContraseña.setText("Contraseña");
        jPanel1.add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 126, -1, -1));
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 65, 160, -1));
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 122, 160, -1));

        btnGuardar.setText("Guardar Cambios");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 250, -1, -1));

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 250, -1, -1));

        lblEditar.setForeground(new java.awt.Color(255, 255, 255));
        lblEditar.setText("Editar Usuario");
        jPanel1.add(lblEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 15, -1, -1));
        jPanel1.add(txtIDrol, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 183, 160, -1));

        lblContraseña1.setForeground(new java.awt.Color(255, 255, 255));
        lblContraseña1.setText("ID del rol");
        jPanel1.add(lblContraseña1, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 187, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Usuarios.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 310));

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
        try {
    String correo = this.txtCorreo.getText();  // Obtener los datos del formulario
    String contrasena = this.txtContraseña.getText();
    String textoIDRol = this.txtIDrol.getText(); // Obtener el ID de rol del formulario
    if (correo.isEmpty() || contrasena.isEmpty() || textoIDRol.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    if (!soloLetrasNumerosArroba(correo)) {
        JOptionPane.showMessageDialog(this, "El correo solo debe contener numeros y letras y una arroba.");
        return;
    }
    
    if (!soloContraseña(contrasena)) {
        JOptionPane.showMessageDialog(this, "La contraseña solo debe contener numeros y letras, entre 8 y 16 digitos.");
        return;
    }

    if (!validarIDRol(textoIDRol)) {
        JOptionPane.showMessageDialog(this, "El ID de rol debe ser un número entero entre 1 y 3.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int rolId = Integer.parseInt(textoIDRol);

    if (this.usuario != null) {  // Verifica que el usuario no sea nulo
        this.usuario.setCorreo(correo); // Actualiza los datos del usuario
        this.usuario.setContrasena(contrasena);
        this.usuario.setRolId(rolId); // Actualiza el ID de rol del usuario
        gestionUsuario.actualizarUsuario(this.usuario);  // Actualiza el usuario en la gestión
        JOptionPane.showMessageDialog(this, "Usuario actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE); // Muestra mensaje de éxito y cierra el diálogo
        this.dispose(); // Cierra el JDialog
    } else {
        JOptionPane.showMessageDialog(this, "El usuario a editar no está disponible.", "Error", JOptionPane.ERROR_MESSAGE);
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Error al actualizar el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCerrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblContraseña1;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblEditar;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtIDrol;
    // End of variables declaration//GEN-END:variables
}
