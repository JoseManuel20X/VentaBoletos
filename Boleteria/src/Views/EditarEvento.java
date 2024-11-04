/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Controller.EventController;
import ENTITY.Event;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author Robert Granados
 */
public class EditarEvento extends javax.swing.JFrame {

    private EventController gestionEventos;
    private Event event;
    
    public EditarEvento(GUIEvent parent, boolean modal, Event evento, EventController gestionEventos1) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.event = evento;
        this.gestionEventos = gestionEventos1;

        if (this.event == null) {
            JOptionPane.showMessageDialog(this, "El evento no está disponible para edición.", "Error", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        } else {
            cargarDatosEvento();
            this.setVisible(true);
        }
    }
    
    private void cargarDatosEvento() {
        txtEnclosure.setText(event.getEnclosure());
        txtFecha.setText(event.getDate());
        txtNombre.setText(event.getName());
        txtPrecio.setText(String.valueOf((int) event.getPrice()));
        txtTickects.setText(String.valueOf(event.getNumberTickets()));
        txtDescripción.setText(event.getDescription());
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

    private void guardarEvento() {
        String enclosure = txtEnclosure.getText().trim();
        String fecha = txtFecha.getText().trim();
        String nombre = txtNombre.getText().trim();
        String precioTexto = txtPrecio.getText().trim();
        String ticketsTexto = txtTickects.getText().trim();
        String descripcion = txtDescripción.getText().trim();

        // Verificar campos vacíos
        if (nombre.isEmpty() || fecha.isEmpty() || enclosure.isEmpty() || precioTexto.isEmpty() || ticketsTexto.isEmpty() || descripcion.isEmpty()) {
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
        if (!soloNumeros(precioTexto)) {
            JOptionPane.showMessageDialog(this, "El precio solo puede contener numeros.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validar tickets
        if (!soloNumeros(ticketsTexto)) {
            JOptionPane.showMessageDialog(this, "El número de tickets solo puede contener numeros.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validar descripcion
        if (!soloLetras(descripcion)) {
            JOptionPane.showMessageDialog(this, "La descripcion solo puede contener letras.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Guardar evento
        event.setName(nombre);
        event.setDate(fecha);
        event.setEnclosure(enclosure);
        event.setDescription(descripcion);

        // Convertir precio y tickets a números
        event.setPrice(Integer.parseInt(precioTexto));
        event.setNumberTickets(Integer.parseInt(ticketsTexto));

        if (gestionEventos.actualizarEvento(event)) {
            JOptionPane.showMessageDialog(this, "Evento actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar el evento.", "Error", JOptionPane.ERROR_MESSAGE);
        }
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        txtEnclosure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnclosureActionPerformed(evt);
            }
        });

        lblEnclosure.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        lblEnclosure.setForeground(new java.awt.Color(0, 0, 0));
        lblEnclosure.setText("Enclosure");

        lblNombre.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(0, 0, 0));
        lblNombre.setText("Nombre:");

        lblHora.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        lblHora.setForeground(new java.awt.Color(0, 0, 0));
        lblHora.setText("Descripción:");

        btnGuardar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setText("Guardar ");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCerrar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(0, 0, 0));
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        lblFecha.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(0, 0, 0));
        lblFecha.setText("Fecha:");

        lblHora1.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        lblHora1.setForeground(new java.awt.Color(0, 0, 0));
        lblHora1.setText("Precio:");

        txtDescripción.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripciónActionPerformed(evt);
            }
        });

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        txtTickects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTickectsActionPerformed(evt);
            }
        });

        lblHora2.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        lblHora2.setForeground(new java.awt.Color(0, 0, 0));
        lblHora2.setText("Tickects:");

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Editar Evento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblFecha)
                        .addGap(22, 22, 22)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblNombre)
                        .addGap(12, 12, 12)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblHora1)
                        .addGap(20, 20, 20)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblHora2)
                        .addGap(10, 10, 10)
                        .addComponent(txtTickects, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblHora)
                        .addGap(10, 10, 10)
                        .addComponent(txtDescripción, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblEnclosure)
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtEnclosure, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblEnclosure))
                    .addComponent(txtEnclosure, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblFecha))
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblNombre))
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHora1)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblHora2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTickects, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripción, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
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

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtEnclosureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnclosureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnclosureActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarEvento();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtDescripciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripciónActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripciónActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtTickectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTickectsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTickectsActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
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
