package Views;

import Controller.ClienteDAO;
import Controller.UsuarioDAO;
import ENTITY.ClaseUsuario;
import ENTITY.Cliente;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Registro extends javax.swing.JFrame {
    private ClienteDAO crudcliente;

    public Registro(ClienteDAO crudcliente) {
        initComponents();
        this.crudcliente = crudcliente; // Usa la instancia recibida
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    private boolean validarEspaciosVacios() {
        return !this.txtCorreo.getText().trim().isEmpty() && this.txtContraseña.getPassword().length > 0;
    }

    public void agregarUsuarioDesdeRegistro() {
        if (!validarEspaciosVacios()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben ser completados.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String correo = this.txtCorreo.getText().trim();
        String contrasena = new String(this.txtContraseña.getPassword());

        // Validar el formato del correo electrónico
        if (!validarCorreo(correo)) {
            JOptionPane.showMessageDialog(this, "El correo no tiene un formato válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar la contraseña
        if (!soloContraseña(contrasena)) {
            JOptionPane.showMessageDialog(this, "La contraseña debe tener entre 8 y 16 caracteres alfanuméricos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Crear un nuevo usuario
            ClaseUsuario nuevoUsuario = new ClaseUsuario();
            nuevoUsuario.setCorreo(correo);
            nuevoUsuario.setContrasena(contrasena);
            nuevoUsuario.setRolId(3); // Rol predeterminado para clientes

            // Crear instancia de UsuarioDAO y registrar al usuario
            UsuarioDAO usuarioCRUD = new UsuarioDAO(crudcliente);
            usuarioCRUD.agregarUsuario(nuevoUsuario);

            JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente.");
            this.txtCorreo.setText("");
            this.txtContraseña.setText("");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean soloContraseña(String texto) {
        return texto.length() >= 8 && texto.length() <= 16 && texto.chars().allMatch(Character::isLetterOrDigit);
    }

    private boolean validarCorreo(String correo) {
        return correo.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
    }
    
    private boolean soloLetras(String texto) {
    return texto.matches("^[a-zA-ZÁÉÍÓÚáéíóúñÑ\\s]+$");
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblMensaje = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        txtContraseña = new javax.swing.JPasswordField();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMensaje.setBackground(new java.awt.Color(0, 0, 0));
        lblMensaje.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(255, 255, 255));
        lblMensaje.setText("Registro de Cliente");
        jPanel1.add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 24, -1, -1));

        lblNombre.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre:");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 95, -1, -1));

        lblCorreo.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo.setText("Correo:");
        jPanel1.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 123, -1, -1));

        lblContraseña.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        lblContraseña.setForeground(new java.awt.Color(255, 255, 255));
        lblContraseña.setText("Contraseña:");
        jPanel1.add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 151, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 92, 187, -1));
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 120, 187, -1));

        btnConfirmar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 188, -1, -1));
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 148, 187, -1));

        btnCancelar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnCancelarStateChanged(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 188, 87, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/desktop-wallpaper-fingerprint-digital-fingerprint.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 230));

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

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if (!validarCampos()) {
            return;
        }
        String nombre = txtNombre.getText();
        String correo = txtCorreo.getText();
        String contraseña = new String(txtContraseña.getPassword());
        
        try {
            if (crudcliente.validar(correo, contraseña)!=null ) {
                JOptionPane.showMessageDialog(this, "El correo ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    if (!soloLetras(nombre)) {
        JOptionPane.showMessageDialog(this, "El nombre solo debe contener letras.");
        return;
    }
    
    
    if (!validarCorreo(correo)) {
        JOptionPane.showMessageDialog(this, "El correo solo debe contener numeros y letras y una arroba.");
        return;
    }
    
    if (!soloContraseña(contraseña)) {
        JOptionPane.showMessageDialog(this, "La contraseña solo debe contener numeros y letras, entre 8 y 16 digitos.");
        return;
    }
        Cliente nuevoCliente = new Cliente(1,nombre, correo, contraseña);
        try {
            crudcliente.crearCliente(nuevoCliente);
        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "Se a registrado correctamente el cliente", "Registrado correctamente", JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);
     agregarUsuarioDesdeRegistro();
     this.dispose();
      TicketSales log = new TicketSales();
        log.setVisible(true);
        log.setResizable(false);
        log.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnCancelarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnCancelarStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarStateChanged

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
      this.dispose();
        TicketSales ticket = new TicketSales();
        ticket.setVisible(true);
        ticket.setResizable(false);
        ticket.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCancelarActionPerformed

   private boolean validarCampos() {
    boolean estado = true;

    // Verifica que ningún campo esté vacío
    if (this.txtCorreo.getText().isBlank() || 
        this.txtContraseña.getText().isBlank() || 
        this.txtNombre.getText().isBlank()) {        
        JOptionPane.showMessageDialog(this, "Debe rellenar todos los campos con la información correspondiente", "No se pudo registrar al usuario correctamente", JOptionPane.ERROR_MESSAGE);
        estado = false;
    }
    return estado; 
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
