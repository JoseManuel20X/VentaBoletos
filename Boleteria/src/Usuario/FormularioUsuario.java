package Usuario;

import javax.swing.JOptionPane;

public class FormularioUsuario extends javax.swing.JDialog {
    // Variable para almacenar el estado de confirmación.
private boolean confirmar;

// Instancia de UsuarioCRUD para gestionar operaciones con usuarios.
private UsuarioCRUD gestionUsuario;

// Constructor para agregar un nuevo usuario.
public FormularioUsuario(java.awt.Frame parent, boolean modal, UsuarioCRUD gestionUsuario) {
    super(parent, modal); // Llama al constructor de la clase base (JDialog) con los parámetros especificados.
    this.gestionUsuario = gestionUsuario; // Inicializa la instancia de gestionUsuario
    initComponents(); // Inicializa los componentes de la interfaz gráfica.  
    // Configura la ventana para que sea visible, no redimensionable, y centrada en la pantalla.
    this.setVisible(true);
    this.setResizable(false);
    this.setLocationRelativeTo(null);
}

// Método para obtener el estado de confirmación.
public boolean confirmacion() {
    return this.confirmar; // Retorna el estado de la variable confirmar.
}

// Método para validar que el texto ingresado para el ID de rol sea un número entre 1 y 3.
private boolean validarIDRol(String texto) {
    if (texto == null || texto.isEmpty()) {
        return false; // Retorna false si el texto es nulo o está vacío.
    }
    try {
        int rolId = Integer.parseInt(texto); // Intenta convertir el texto a un entero.
        return rolId >= 1 && rolId <= 2; // Retorna true si el ID está en el rango válido (1-3).
    } catch (NumberFormatException e) {
        return false; // Retorna false si ocurre una excepción al convertir el texto a entero.
    }
}

// Método para validar que ninguno de los campos de texto esté vacío.
private boolean validarEspaciosVacios() {
    return !txtCorreo.getText().trim().isEmpty() && // Retorna true si el campo de correo no está vacío.
           !txtContraseña.getText().trim().isEmpty() && // Retorna true si el campo de contraseña no está vacío.
           !txtID_rol.getText().trim().isEmpty(); // Retorna true si el campo de ID de rol no está vacío.
}

// Método para crear un objeto ClaseUsuario basado en los datos ingresados en el formulario.
public ClaseUsuario consultarUsuario() {
    // Verifica que todos los campos estén completos antes de crear el usuario.
    if (!validarEspaciosVacios()) {
        // Muestra un mensaje de error si alguno de los campos está vacío.
        JOptionPane.showMessageDialog(this, "Todos los campos deben ser completados.", "Error", JOptionPane.ERROR_MESSAGE);
        return null; // Retorna null si hay campos vacíos.
    }

    // Crea un nuevo objeto ClaseUsuario.
    ClaseUsuario usuarioConsultado = new ClaseUsuario();
    usuarioConsultado.setCorreo(this.txtCorreo.getText()); // Establece el correo en el objeto usuario.
    usuarioConsultado.setContrasena(this.txtContraseña.getText()); // Establece la contraseña en el objeto usuario.

    // Obtiene y valida el ID de rol.
    String textoIDRol = this.txtID_rol.getText();
    if (!validarIDRol(textoIDRol)) {
        // Muestra un mensaje de error si el ID de rol no es válido.
        JOptionPane.showMessageDialog(this, "El ID de rol debe ser un número entero entre 1 y 3.", "Error", JOptionPane.ERROR_MESSAGE);
        return null; // Retorna null si el ID de rol no es válido.
    }
    usuarioConsultado.setRolId(Integer.parseInt(textoIDRol)); // Establece el ID de rol en el objeto usuario.

    return usuarioConsultado; // Retorna el objeto usuario creado.
}

private boolean soloLetrasNumerosArroba(String texto) {
    boolean contieneArroba = false;

    // Verifica cada carácter del texto
    for (char c : texto.toCharArray()) {
        if (Character.isLetter(c) || Character.isDigit(c) || c == '.') {
            continue;
        } else if (c == '@') {
            if (contieneArroba) {
                // Si ya se encontró una arroba, retorna false (solo se permite una arroba)
                return false;
            }
            contieneArroba = true;
        } else {
            // Si el carácter no es ni letra, ni número, ni arroba, retorna false
            return false;
        }
    }
    return true;
}   
    
    private boolean soloContraseña(String texto) {
    // Verifica la longitud del texto
    if (texto.length() < 8 || texto.length() > 16) {
        return false;
    }

    // Verifica si el texto contiene solo letras y dígitos
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
        txtContraseña = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        lblAgregar = new javax.swing.JLabel();
        lblContraseña1 = new javax.swing.JLabel();
        txtID_rol = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo.setText("Correo:");
        jPanel1.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 59, -1, -1));

        lblContraseña.setForeground(new java.awt.Color(255, 255, 255));
        lblContraseña.setText("Contraseña:");
        jPanel1.add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 108, -1, -1));
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 104, 160, -1));

        btnGuardar.setText("Guardar Usuario");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 171, -1, -1));

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 171, -1, -1));

        lblAgregar.setForeground(new java.awt.Color(255, 255, 255));
        lblAgregar.setText("Agregar Usuario");
        jPanel1.add(lblAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 6, -1, -1));

        lblContraseña1.setForeground(new java.awt.Color(255, 255, 255));
        lblContraseña1.setText("Asigne el rol");
        jPanel1.add(lblContraseña1, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 137, -1, -1));
        jPanel1.add(txtID_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 133, 20, -1));
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 55, 160, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID ROL");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 6, 81, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("1 = Administrador");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 34, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("2 = Operador ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 59, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Usuarios.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 200));

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
    ClaseUsuario nuevoUsuario = consultarUsuario();
    if (nuevoUsuario != null) {
        
        String correo = txtCorreo.getText();
        String contraseña = new String(txtContraseña.getText());
        
        if (!soloLetrasNumerosArroba(correo)) {
        JOptionPane.showMessageDialog(this, "El correo solo debe contener numeros y letras y una arroba.");
        return;
    }   
    if (!soloContraseña(contraseña)) {
        JOptionPane.showMessageDialog(this, "La contraseña solo debe contener numeros y letras, entre 8 y 16 digitos.");
        return;
    }        
        gestionUsuario.agregarUsuario(nuevoUsuario);
        JOptionPane.showMessageDialog(this, "Usuario agregado exitosamente.");
        this.dispose();
    }
    confirmar = true;
    dispose();                       
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
       dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblContraseña1;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtID_rol;
    // End of variables declaration//GEN-END:variables
}