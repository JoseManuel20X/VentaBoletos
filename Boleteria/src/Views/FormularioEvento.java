package Views;

import Controller.EventDAO;
import ENTITY.Event;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul
 */

public class FormularioEvento extends javax.swing.JDialog {
 // Variable para almacenar el estado de confirmación.
    private boolean confirmar;

    // Instancia de EventDAO para gestionar operaciones con eventos.
    private EventDAO gestionEventos;

    // ID del evento que se está editando o consultando.
    private int eventoId;

    // Constructor para crear o editar un evento.
    public FormularioEvento(java.awt.Frame parent, boolean modal, EventDAO gestionEventos) {
        super(parent, modal); // Llama al constructor de la clase base (JDialog).
        this.gestionEventos = gestionEventos; // Inicializa el controlador de eventos.
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    // Devuelve el estado de confirmación.
    public boolean confirmacion() {
        return this.confirmar;
    }
    
    
    private boolean soloLetras(String texto) {
        for (char c : texto.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }

    
    private boolean validarFecha(String fechaTexto) {
        try {
            LocalDate.parse(fechaTexto);
            return true;
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto. El formato correcto es: AAAA-MM-DD. Ejemplo : 2006-10-08 ", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    
    private boolean soloNumeros(String texto) {
        for (char c : texto.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtEnclosure = new javax.swing.JTextField();
        lblEnclosure = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        lblFecha = new javax.swing.JLabel();
        lblHora1 = new javax.swing.JLabel();
        txtDescripción = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtTickects = new javax.swing.JTextField();
        lblHora2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 160, 30));

        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 160, 30));

        txtEnclosure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnclosureActionPerformed(evt);
            }
        });
        jPanel1.add(txtEnclosure, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 160, 30));

        lblEnclosure.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        lblEnclosure.setForeground(new java.awt.Color(255, 255, 255));
        lblEnclosure.setText("Enclosure:");
        jPanel1.add(lblEnclosure, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 84, -1, 10));

        lblNombre.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre:");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        lblHora.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setText("Descripción:");
        jPanel1.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, 20));

        btnGuardar.setBackground(new java.awt.Color(51, 255, 51));
        btnGuardar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setText("Guardar ");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 87, 50));

        btnCerrar.setBackground(new java.awt.Color(255, 0, 0));
        btnCerrar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(0, 0, 0));
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, 84, 50));

        lblFecha.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("Fecha:");
        jPanel1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        lblHora1.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        lblHora1.setForeground(new java.awt.Color(255, 255, 255));
        lblHora1.setText("Precio:");
        jPanel1.add(lblHora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        txtDescripción.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripciónActionPerformed(evt);
            }
        });
        jPanel1.add(txtDescripción, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 160, 30));

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 160, 30));

        txtTickects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTickectsActionPerformed(evt);
            }
        });
        jPanel1.add(txtTickects, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 160, 30));

        lblHora2.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        lblHora2.setForeground(new java.awt.Color(255, 255, 255));
        lblHora2.setText("Tickects:");
        jPanel1.add(lblHora2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, 20));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel1.setText("Agendar Evento");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fondo Registro.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 480));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        String enclosure = txtEnclosure.getText();
        String fecha = txtFecha.getText();
        String nombre = txtNombre.getText();
        String precio = txtPrecio.getText();
        String tickects = txtTickects.getText();
        String descripción = txtDescripción.getText();

        // Verificar campos vacíos
        if (nombre.isEmpty() || fecha.isEmpty() || enclosure.isEmpty() || precio.isEmpty() || tickects.isEmpty() || descripción.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validar recinto
        if (!soloLetras(enclosure)) {
            JOptionPane.showMessageDialog(this, "El Recinto solo puede contener letras.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validar fecha
        if (!validarFecha(fecha)) {
            return; // Ya se muestra el mensaje dentro de validarFecha
        }

        // Validar solo letras para el nombre
        if (!soloLetras(nombre)) {
            JOptionPane.showMessageDialog(this, "El nombre solo puede contener letras", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar precio
        if (!soloNumeros(precio)) {
            JOptionPane.showMessageDialog(this, "El precio solo puede contener numeros.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar tickets
        if (!soloNumeros(tickects)) {
            JOptionPane.showMessageDialog(this, "El número de tickets solo puede contener numeros.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar descripcion
        if (!soloLetras(descripción)) {
            JOptionPane.showMessageDialog(this, "La descripcion solo puede contener letras.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Convertir el precio y tickets a numeros
        int tickectsCast = Integer.parseInt(tickects);
        double precioCast = Double.parseDouble(precio);

        // Crear el nuevo evento
        Event nuevoEvent = new Event(1, nombre, fecha, enclosure, precioCast, tickectsCast, descripción);
        try {
            gestionEventos.crearEvento(nuevoEvent);
        } catch (SQLException ex) {
            Logger.getLogger(FormularioEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "Se ha registrado correctamente el Evento", "Registrado correctamente", JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtEnclosureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnclosureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnclosureActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtDescripciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripciónActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripciónActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtTickectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTickectsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTickectsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEnclosure;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblHora1;
    private javax.swing.JLabel lblHora2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtDescripción;
    private javax.swing.JTextField txtEnclosure;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTickects;
    // End of variables declaration//GEN-END:variables

    private boolean validarCampos() {
        boolean estado = false;
        if(!this.txtEnclosure.getText().isBlank()||!this.txtFecha.getText().isBlank()||!this.txtNombre.getText().isBlank()||!this.txtPrecio.getText().isBlank()||!this.txtTickects.getText().isBlank()||!this.txtDescripción.getText().isBlank()){
            estado = true;
        }else{
            JOptionPane.showMessageDialog(this, "Debe rellenar todos los campos con la información correspondiente", "No se pudo registrar el evento correctamente", JOptionPane.ERROR_MESSAGE);
        }
        return estado;
    }
    
}
