/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Views;

import Controller.ClienteDAO;
import ENTITY.Cliente;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel
 */
public class EditarCliente extends javax.swing.JDialog {
    private ClienteDAO clienteCRUD;
    private Cliente cliente;
  
    public EditarCliente(java.awt.Frame parent, boolean modal,Cliente cliente, ClienteDAO clienteCRUD) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.cliente=cliente;
        this.clienteCRUD=clienteCRUD;
        
        if (this.cliente == null) { 
            JOptionPane.showMessageDialog(this, "El usuario no está disponible para edición.", "Error", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        } else {
            txtNombre.setText(cliente.getNombre());
            txtCorreo.setText(cliente.getCorreo());
            txtContraseña.setText(cliente.getContraseña());
            this.setVisible(true);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
        }
    }
    
    private boolean soloLetras(String texto) {
    for (char c : texto.toCharArray()) {
        if (!Character.isLetter(c)) {
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
    return contieneArroba;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCorreo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        lblEditar = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 114, 185, -1));

        btnGuardar.setBackground(new java.awt.Color(51, 255, 51));
        btnGuardar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setText("Guardar Cambios");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 221, -1, -1));

        btnCerrar.setBackground(new java.awt.Color(255, 0, 0));
        btnCerrar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(0, 0, 0));
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 221, -1, -1));

        lblEditar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 18)); // NOI18N
        lblEditar.setForeground(new java.awt.Color(0, 0, 0));
        lblEditar.setText("Editar Cliente");
        jPanel1.add(lblEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 22, -1, -1));

        lblCorreo.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(0, 0, 0));
        lblCorreo.setText("Correo:");
        jPanel1.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 117, -1, -1));

        lblContraseña.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        lblContraseña.setForeground(new java.awt.Color(0, 0, 0));
        lblContraseña.setText("Contraseña");
        jPanel1.add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 168, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 61, 187, -1));

        lblNombre.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(0, 0, 0));
        lblNombre.setText("Nombre:");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 64, -1, -1));
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 165, 185, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FondoBonito.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 350, 280));

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
        String nombre = txtNombre.getText();
        String correo = txtCorreo.getText();
        String contraseña = new String(txtContraseña.getPassword());

    // Verificar campos vacíos
    if (nombre.isEmpty() || correo.isEmpty() || contraseña.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (!soloLetras(nombre)) {
        JOptionPane.showMessageDialog(this, "El nombre solo debe contener letras.");
        return;
    }

    if (!soloLetrasNumerosArroba(correo)) {
        JOptionPane.showMessageDialog(this, "El correo solo debe contener numeros y letras y una arroba.");
        return;
    }
    
    if (!soloContraseña(contraseña)) {
        JOptionPane.showMessageDialog(this, "La contraseña solo debe contener numeros y letras, entre 8 y 16 digitos.");
        return;
    }

            if (this.cliente != null) {
                this.cliente.setNombre(nombre);
                this.cliente.setCorreo(correo);
                this.cliente.setContraseña(contraseña);
                clienteCRUD.actualizarCliente(this.cliente);
                JOptionPane.showMessageDialog(this, "Usuario actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE); // Muestra mensaje de éxito y cierra el diálogo
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "El usuario a editar no está disponible.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblEditar;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}