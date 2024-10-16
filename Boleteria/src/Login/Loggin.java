
package Login;
import Cliente.CRUDCliente;
import Cliente.Cliente;
import Usuario.UsuarioCRUD;
import javax.swing.JOptionPane;
import main.Admin;
import rol.ClaseRol;
/**
 *
 * @author Manuel
 */
public class Loggin extends javax.swing.JFrame {
 private ClaseRol roles;
    private UsuarioCRUD usuarioCrud;
    
public Loggin() {
        initComponents();
        this.roles = new ClaseRol();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

 private boolean validarCampos() {
        boolean estado = false;
        if(!this.txtCorreo.getText().isBlank()||!this.txtContraseña.getText().isBlank()){
            estado = true;
        }else{
            JOptionPane.showMessageDialog(this, "Debe colocar un correo y contraseña para ingresar", "Alguno de los dos campos esta vacío", JOptionPane.ERROR_MESSAGE);
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
        btnRegistrarse = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblCorreo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        lblContraseña.setForeground(new java.awt.Color(153, 153, 153));
        lblContraseña.setText("Contraseña:");
        getContentPane().add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 110, 40));

        btnIngresar.setText("INGRESAR");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, -1));

        btnRegistrarse.setBackground(new java.awt.Color(51, 255, 51));
        btnRegistrarse.setText("REGISTRARSE");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jLabel1.setText("¿No estas  registrado?");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        lblCorreo.setBackground(new java.awt.Color(255, 255, 255));
        lblCorreo.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(102, 102, 102));
        lblCorreo.setText("Correo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(316, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblCorreo)
                .addContainerGap(293, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed

    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if (!validarCampos()) {
            return;
        }
        String Correo = txtCorreo.getText();
        String contraseña = new String(txtContraseña.getPassword());
        CRUDCliente crudCliente = new CRUDCliente(usuarioCrud);
        Cliente cliente = crudCliente.validar(Correo, contraseña);
        if (roles !=null){
            JOptionPane.showMessageDialog(this, "Ingreso exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            roles.iniciarSesion(Correo, contraseña, cliente);
            this.dispose();
        Admin log = new Admin();
        log.setVisible(true);
        log.setResizable(false);
        log.setLocationRelativeTo(null);
        } else {
            JOptionPane.showMessageDialog(this, "Correo o contraseña incorrectos.", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        CRUDCliente crudcliente = new CRUDCliente(usuarioCrud);
        Registro registro = new Registro(crudcliente);
        registro.setVisible(true);
        registro.setResizable(false);
        registro.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
