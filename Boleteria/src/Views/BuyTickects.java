package Views;

import Controller.BuyTickect;
import Controller.EventController;
import ENTITY.ClaseUsuario;
import ENTITY.Event;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel
 */
public class BuyTickects extends javax.swing.JFrame {
private Event eventoSeleccionado;
    private BuyTickect buyTickect;
    private ClaseUsuario usuarioActual;

    public BuyTickects(Event evento, ClaseUsuario usuario, BuyTickect buyTickect) {
        initComponents();
        this.eventoSeleccionado = evento;
        this.usuarioActual = usuario;
        this.buyTickect = buyTickect;

        mostrarDetallesEvento(evento);
    }

    // Muestra los detalles del evento seleccionado en los campos de texto
    public void mostrarDetallesEvento(Event evento) {
        txtEventoResumen.setText(evento.getName());
        txtTotalResumen.setText(String.valueOf(evento.getPrice()));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxCantidad = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtEventoResumen = new javax.swing.JTextField();
        txtTotalResumen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTarjeta = new javax.swing.JTextField();
        btnComprar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel1.setText("Comprar Tickeckts");

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel2.setText("Cantidad:");

        cbxCantidad.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        cbxCantidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cbxCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCantidadActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel3.setText("Evento:");

        txtEventoResumen.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        txtEventoResumen.setEnabled(false);
        txtEventoResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEventoResumenActionPerformed(evt);
            }
        });

        txtTotalResumen.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        txtTotalResumen.setEnabled(false);
        txtTotalResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalResumenActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel4.setText("Total:");

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 18)); // NOI18N
        jLabel5.setText("Número de Tarjeta:");

        txtTarjeta.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        txtTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTarjetaActionPerformed(evt);
            }
        });

        btnComprar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
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
                        .addGap(112, 112, 112)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(107, 107, 107)
                            .addComponent(btnComprar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(60, 60, 60)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel5)))
                            .addGap(41, 41, 41)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtEventoResumen)
                                .addComponent(cbxCantidad, 0, 123, Short.MAX_VALUE)
                                .addComponent(txtTotalResumen)
                                .addComponent(txtTarjeta)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEventoResumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTotalResumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComprar)
                    .addComponent(btnCancelar))
                .addGap(124, 124, 124))
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

    private void txtEventoResumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEventoResumenActionPerformed
        
    }//GEN-LAST:event_txtEventoResumenActionPerformed

    private void txtTotalResumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalResumenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalResumenActionPerformed

    private void txtTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTarjetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTarjetaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        int cantidad = Integer.parseInt(cbxCantidad.getSelectedItem().toString());
        String numeroTarjeta = txtTarjeta.getText();

        if (numeroTarjeta.isEmpty() || numeroTarjeta.length() != 16) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número de tarjeta válido de 16 dígitos.");
            return;
            }

        boolean compraExitosa = buyTickect.comprarTique(usuarioActual, eventoSeleccionado.getId(), cantidad, numeroTarjeta);
        if (compraExitosa) {
            JOptionPane.showMessageDialog(this, "Compra realizada con éxito.");
            dispose();
            }else {
            JOptionPane.showMessageDialog(this, "No hay suficientes tickets disponibles o el evento no existe.");
            }        // TODO add your handling code here:
    }//GEN-LAST:event_btnComprarActionPerformed

    private void cbxCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCantidadActionPerformed
        // Obtener el precio unitario del evento
        double precioUnitario = eventoSeleccionado.getPrice();

        // Obtener la cantidad seleccionada en el combo box
        int cantidad = Integer.parseInt(cbxCantidad.getSelectedItem().toString());

        // Calcular el total y actualizar el campo de texto txtTotalResumen
        double total = precioUnitario * cantidad;
        txtTotalResumen.setText(String.valueOf(total));
    }//GEN-LAST:event_cbxCantidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnComprar;
    private javax.swing.JComboBox<String> cbxCantidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEventoResumen;
    private javax.swing.JTextField txtTarjeta;
    private javax.swing.JTextField txtTotalResumen;
    // End of variables declaration//GEN-END:variables
}
