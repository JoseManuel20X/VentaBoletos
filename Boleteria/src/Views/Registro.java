package Views;

import Controller.CRUDCliente;
import ENTITY.Cliente;
import ENTITY.ClaseUsuario;
import Controller.UsuarioCRUD;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel
 */
public class Registro extends javax.swing.JFrame {
    private CRUDCliente crudcliente;
    private UsuarioCRUD usuarioCrud;

    public Registro(CRUDCliente crudcliente) {
        initComponents();
        this.crudcliente = new CRUDCliente(usuarioCrud);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
 //c
private boolean validarEspaciosVacios() {
    return !this.txtCorreo.getText().trim().isEmpty() && this.txtContraseña.getPassword().length > 0;
}

public void agregarUsuarioDesdeRegistro() {
    if (!validarEspaciosVacios()) {
        JOptionPane.showMessageDialog(this, "Todos los campos deben ser completados.", "Error", JOptionPane.ERROR_MESSAGE);
        return; 
    }
    String correo = this.txtCorreo.getText();
    String contrasena = new String(this.txtContraseña.getPassword());
    ClaseUsuario nuevoUsuario = new ClaseUsuario();
    nuevoUsuario.setCorreo(correo); // Establece el correo en el objeto usuario.
    nuevoUsuario.setContrasena(contrasena); // Establece la contraseña en el objeto usuario.
    nuevoUsuario.setRolId(3); // Establece el ID de rol predeterminado.
    UsuarioCRUD usuarioCRUD = new UsuarioCRUD(crudcliente);
    int nuevoId = usuarioCRUD.generarNuevoId();
    nuevoUsuario.setId(nuevoId);
    usuarioCRUD.agregarUsuario(nuevoUsuario);
    JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente.");
    this.txtCorreo.setText("");
    this.txtContraseña.setText("");
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
        lblMensaje = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        txtContraseña = new javax.swing.JPasswordField();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        lblMensaje.setBackground(new java.awt.Color(0, 0, 0));
        lblMensaje.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(0, 0, 0));
        lblMensaje.setText("Registro de Cliente");

        lblNombre.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(0, 0, 0));
        lblNombre.setText("Nombre:");

        lblCorreo.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(0, 0, 0));
        lblCorreo.setText("Correo:");

        lblContraseña.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        lblContraseña.setForeground(new java.awt.Color(0, 0, 0));
        lblContraseña.setText("Contraseña:");

        btnConfirmar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(0, 0, 0));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCorreo, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblContraseña, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCorreo)
                                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnConfirmar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(lblMensaje)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblMensaje)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCorreo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContraseña))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnCancelar))
                .addContainerGap(23, Short.MAX_VALUE))
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

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if (!validarCampos()) {
            return;
        }
        String nombre = txtNombre.getText();
        String correo = txtCorreo.getText();
        String contraseña = new String(txtContraseña.getPassword());
        
        if (crudcliente.validar(correo, contraseña)!=null ) {
            JOptionPane.showMessageDialog(this, "El correo ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);
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
        Cliente nuevoCliente = new Cliente(1,nombre, correo, contraseña);
        crudcliente.crearCliente(nuevoCliente);
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
