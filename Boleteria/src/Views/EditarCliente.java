/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Views;

import Controller.CRUDCliente;
import ENTITY.Cliente;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel
 */
public class EditarCliente extends javax.swing.JDialog {
    private CRUDCliente clienteCRUD;
    private Cliente cliente;
  
    public EditarCliente(java.awt.Frame parent, boolean modal,Cliente cliente, CRUDCliente clienteCRUD) {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnGuardar.setText("Guardar Cambios");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        lblEditar.setText("Editar Cliente");

        lblCorreo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCorreo.setText("Correo:");

        lblContraseña.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblContraseña.setText("Contraseña");

        lblNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNombre.setText("Nombre:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(lblEditar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCorreo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblContraseña)
                            .addComponent(lblNombre))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(btnCerrar))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtContraseña, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))))
                    .addComponent(btnGuardar))
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblEditar)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCorreo))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContraseña)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCerrar))
                .addContainerGap(63, Short.MAX_VALUE))
        );

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