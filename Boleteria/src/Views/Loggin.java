
package Views;
import Controller.BuyTicketFacade;
import Controller.CRUDCliente;
import ENTITY.Cliente;
import Controller.UsuarioCRUD;
import javax.swing.JOptionPane;
import main.Admin;
import ENTITY.ClaseRol;
import ENTITY.ClaseUsuario;
import Controller.BuyTicketFacade;
import ENTITY.ClaseUsuario;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 *
 * @author Manuel
 */
public class Loggin extends javax.swing.JFrame {
    private ClaseRol roles;
    private UsuarioCRUD usuarioCrud;
     private BuyTicketFacade buyTicketController; // Controlador de compra de tickets
    private ClaseUsuario usuarioActual; // Usuario actual
    //FondoPanel fondo=new FondoPanel();
    
    // Variable estática para verificar el estado de autenticación
    public static boolean usuarioAutenticado = false;
    
public Loggin() {
    this.buyTicketController = buyTicketController;
        this.usuarioActual = usuarioActual;
        initComponents();
        this.roles = new ClaseRol(buyTicketController, usuarioActual);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
       // this.setContentPane(fondo);
    }

    private boolean validarCampos() {
        boolean estado = false;
        if (!this.txtCorreo.getText().isBlank() && !this.txtContraseña.getText().isBlank()) {
            estado = true;
        } else {
            JOptionPane.showMessageDialog(this, "Debe colocar un correo y contraseña para ingresar", "Alguno de los dos campos está vacío", JOptionPane.ERROR_MESSAGE);
        }
        return estado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCorreo = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        lblContraseña = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblCorreo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnRegistrarse = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnRecuperarContraseña = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 200, 30));

        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        getContentPane().add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 200, 30));

        lblContraseña.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblContraseña.setText("Contraseña:");
        getContentPane().add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 110, 40));

        btnIngresar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnIngresar.setText("INGRESAR");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCorreo.setBackground(new java.awt.Color(255, 255, 255));
        lblCorreo.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        lblCorreo.setText("Correo:");
        jPanel1.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 82, 69, -1));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 18)); // NOI18N
        jLabel2.setText("Bienvenido a la boleteria");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, 39));

        btnSalir.setBackground(new java.awt.Color(255, 0, 0));
        btnSalir.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 81, -1));

        btnRegistrarse.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnRegistrarse.setText("REGISTRARSE");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        jLabel1.setText("¿No estas  registrado?");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 252, -1, -1));

        btnRecuperarContraseña.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnRecuperarContraseña.setText("Recuperar contraseña");
        btnRecuperarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecuperarContraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(btnRecuperarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FondoBonito.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 350));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed

    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
     // Validar campos de correo y contraseña
    if (!validarCampos()) {
        return; // Sale del método si los campos no son válidos.
    }

    String correo = txtCorreo.getText();
    String contraseña = new String(txtContraseña.getPassword());

    // Credenciales del administrador
    String adminEmail = "admin@saico.com";
    String adminPassword = "admin123";

    // Instancia CRUD para el cliente
    CRUDCliente crudCliente = new CRUDCliente();
    Cliente cliente = crudCliente.validar(correo, contraseña);

    // Autenticación del administrador
    if (correo.equals(adminEmail) && contraseña.equals(adminPassword)) {
        JOptionPane.showMessageDialog(this, "Ingreso exitoso como Administrador", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
        // Configuración del usuario administrador como usuario actual
        usuarioAutenticado = true;
        ClaseUsuario adminUsuario = new ClaseUsuario(); // Crear usuario administrador
        adminUsuario.setCorreo(adminEmail);
        adminUsuario.setRolId(1); // Asignar ID de rol para administrador (puedes ajustar según tu lógica)

        this.usuarioActual = adminUsuario; // Asigna el usuario administrador como usuario actual en sesión

        // Abre la ventana de administración
        Admin adminWindow = new Admin(buyTicketController, usuarioActual);
        adminWindow.setVisible(true);
        adminWindow.setResizable(false);
        adminWindow.setLocationRelativeTo(null);
        this.dispose(); // Cierra la ventana de login

    } else if (cliente != null) { // Si es un cliente válido
        JOptionPane.showMessageDialog(this, "Ingreso exitoso como Cliente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
        // Configuración del usuario cliente como usuario actual
        usuarioAutenticado = true;
        this.usuarioActual = new ClaseUsuario(cliente.getId(), cliente.getCorreo(), cliente.getContraseña(), 3); // RolId 3 para clientes
        roles.iniciarSesion(correo, contraseña, cliente);

        // Abre la ventana de ventas de boletos
        TicketSales log = new TicketSales();
        log.setVisible(true);
        log.setResizable(false);
        log.setLocationRelativeTo(null);
        this.dispose(); // Cierra la ventana de login

    } else {
        // Mensaje de error si las credenciales son incorrectas
        JOptionPane.showMessageDialog(this, "Correo o contraseña incorrectos.", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
    }                                       
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        CRUDCliente crudcliente = new CRUDCliente();
        Registro registro = new Registro(crudcliente);
        registro.setVisible(true);
        registro.setResizable(false);
        registro.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
        TicketSales ticket = new TicketSales();
        ticket.setVisible(true);
        ticket.setResizable(false);
        ticket.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRecuperarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecuperarContraseñaActionPerformed
        // Instancia de la ventana de recuperación de contraseña
        RecuperarContreaseña recuperarVentana = new RecuperarContreaseña();

        // Configuración de la ventana de recuperación
        recuperarVentana.setVisible(true);
        recuperarVentana.setResizable(false);
        recuperarVentana.setLocationRelativeTo(null); // Centra la ventana
    }//GEN-LAST:event_btnRecuperarContraseñaActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRecuperarContraseña;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
    /**
    class FondoPanel extends JPanel{
        private Image imagen;
        
        //@Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("/Images/Portada.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }*/
    
}
