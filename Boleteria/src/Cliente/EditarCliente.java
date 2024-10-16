/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Cliente;

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
    
    private boolean soloLetrasEspacio(String texto) {
    for (char c : texto.toCharArray()) {
        if (!Character.isLetter(c) && c != ' ') {
            return false;
        }
    }
    return true;
    }
  
    private boolean soloNumerosEdad(String texto) {
    for (char c : texto.toCharArray()) {
        if (!Character.isDigit(c)) {
            return false;
        }
    }
    int edad;
    try {
        edad = Integer.parseInt(texto);
    } catch (NumberFormatException e) {
        return false;
    }
        return edad >= 0 && edad <= 115;
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
    
    private boolean soloLetrasNumerosEspacio(String texto) {
    for (char c : texto.toCharArray()) {
        if (!Character.isLetter(c) && !Character.isDigit(c) && c != ' ') {
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
    
    private boolean soloGenero(String texto) {
    if (texto.length() == 1) {
        char c = texto.charAt(0);
        return c == 'M' || c == 'F';
    }
    return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCorreo = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        lblEditar = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        txtApellido1 = new javax.swing.JTextField();
        lblTelefono1 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblEdad = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido2 = new javax.swing.JTextField();
        txtSexo = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblApellido1 = new javax.swing.JLabel();
        lblApellido2 = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtPais = new javax.swing.JTextField();
        lblPaís = new javax.swing.JLabel();

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

        lblCorreo.setText("Correo:");

        lblContraseña.setText("Contraseña");

        lblTelefono1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTelefono1.setText("Dirección:");

        lblEdad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblEdad.setText("Edad:");

        lblTelefono.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTelefono.setText("Teléfono:");

        txtApellido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellido2ActionPerformed(evt);
            }
        });

        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNombre.setText("Nombre:");

        lblApellido1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblApellido1.setText("Primer Apellido:");

        lblApellido2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblApellido2.setText("Segundo Apellido:");

        lblSexo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblSexo.setText("Sexo:");

        lblPaís.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblPaís.setText("País de origen:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(lblEditar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(lblNombre)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtApellido1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblApellido2)
                                    .addComponent(lblApellido1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTelefono)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblEdad)
                                    .addComponent(lblSexo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTelefono1)
                                    .addComponent(lblCorreo)
                                    .addComponent(lblContraseña))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtContraseña, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblPaís)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnCerrar)))
                        .addGap(3, 3, 3)))
                .addContainerGap(30, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido1)
                    .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido2)
                    .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEdad)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono1)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCorreo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContraseña))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPaís)
                    .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCerrar))
                .addContainerGap(21, Short.MAX_VALUE))
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
        // TODO add your handling code here:
        try {
            String nombre = txtNombre.getText();
            String apellido1 = txtApellido1.getText();
            String apellido2 = txtApellido2.getText();
            String sexo = txtSexo.getText();
            String edad = txtEdad.getText();
            String telefono = txtTelefono.getText();
            String direccion = txtDireccion.getText();
            String correo = this.txtCorreo.getText();  // Obtener los datos del formulario
            String contraseña = this.txtContraseña.getText();
            String pais = txtPais.getText();
       
    if (!soloLetras(nombre)) {
        JOptionPane.showMessageDialog(this, "El nombre solo debe contener letras.");
        return;
    }
    
    if (!soloLetras(apellido1)) {
        JOptionPane.showMessageDialog(this, "El apellido solo debe contener letras.");
        return;
    }
    
    if (!soloLetras(apellido2)) {
        JOptionPane.showMessageDialog(this, "El apellido solo debe contener letras.");
        return;
    }
    
    if (!soloGenero(sexo)) {
        JOptionPane.showMessageDialog(this, "El sexo solo se debe ingresar con M o F.");
        return;
    }
    
    if (!soloLetrasNumerosEspacio(direccion)) {
        JOptionPane.showMessageDialog(this, "La direccion solo debe contener letras y numeros.");
        return;
    }
    
    if (!soloNumerosEdad(edad)) {
        JOptionPane.showMessageDialog(this, "La edad solo debe contener numeros, el rango permitido es de 0-115.");
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
    
    if (!soloLetrasEspacio(pais)) {
        JOptionPane.showMessageDialog(this, "El pais solo debe contener letras.");
        return;
    }

            int edadCast = Integer.parseInt(edad);
            int telefonoCast = Integer.parseInt(telefono);

            if (correo.isEmpty() || contraseña.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (this.cliente != null) {            
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
        this.setVisible(false);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtApellido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellido2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellido2ActionPerformed

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblApellido2;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEditar;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPaís;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefono1;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtSexo;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
