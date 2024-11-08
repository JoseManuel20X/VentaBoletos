package Views;

import Controller.BuyTickect;
import ENTITY.ClaseUsuario;
import ENTITY.Event;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;

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
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Comprar Tickeckts");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 14, -1, -1));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cantidad:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 71, -1, -1));

        cbxCantidad.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        cbxCantidad.setForeground(new java.awt.Color(0, 0, 0));
        cbxCantidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cbxCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCantidadActionPerformed(evt);
            }
        });
        jPanel1.add(cbxCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 77, 123, -1));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Evento:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 128, -1, -1));

        txtEventoResumen.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        txtEventoResumen.setEnabled(false);
        txtEventoResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEventoResumenActionPerformed(evt);
            }
        });
        jPanel1.add(txtEventoResumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 134, 123, -1));

        txtTotalResumen.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        txtTotalResumen.setEnabled(false);
        txtTotalResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalResumenActionPerformed(evt);
            }
        });
        jPanel1.add(txtTotalResumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 191, 123, -1));

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 185, -1, -1));

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Número de Tarjeta:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 241, -1, -1));

        txtTarjeta.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        txtTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTarjetaActionPerformed(evt);
            }
        });
        jPanel1.add(txtTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 242, 123, -1));

        btnComprar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });
        jPanel1.add(btnComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 298, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 298, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Compra3.jpg"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 470));

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
            // Detalles de la compra
            String detallesCompra = "Compra realizada con éxito.\n\n"
                    + "Detalles de la Compra:\n"
                    + "Evento: " + eventoSeleccionado.getName() + "\n"
                    + "Cantidad de tickets: " + cantidad + "\n"
                    + "Precio unitario: " + eventoSeleccionado.getPrice() + "\n"
                    + "Total: " + (eventoSeleccionado.getPrice() * cantidad) + "\n"
                    + "Número de tarjeta: **** **** **** " + numeroTarjeta.substring(12) + "\n";

            // Mostrar mensaje de confirmación
            int opcion = JOptionPane.showOptionDialog(this, detallesCompra + "\n¿Desea descargar el recibo?",
                    "Confirmación de Compra",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null, new String[]{"Descargar PDF", "Cerrar"}, "Descargar PDF");

            if (opcion == JOptionPane.YES_OPTION) {
                exportarPDF(detallesCompra); // Llamar al método para descargar el recibo
            }

            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No hay suficientes tickets disponibles o el evento no existe.");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnComprarActionPerformed
    
    private void exportarPDF(String detallesCompra) {
        Document document = new Document();
        try {
            // Crear el PDF en la ruta especificada
            String rutaPDF = "ReciboCompra.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(rutaPDF));
            document.open();

            // Título del recibo
            Paragraph titulo = new Paragraph("Recibo de Compra de usuario ");
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);

            // Espacio
            document.add(new Paragraph(" "));

            // Detalles de la compra
            Paragraph detalles = new Paragraph(detallesCompra);
            detalles.setAlignment(Element.ALIGN_LEFT);
            document.add(detalles);

            // Cerrar el documento
            document.close();

            // Mostrar mensaje de éxito y abrir el PDF para vista previa
            JOptionPane.showMessageDialog(this, "Recibo PDF generado exitosamente.");
            java.awt.Desktop.getDesktop().open(new java.io.File(rutaPDF));

        } catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(this, "Error al generar el recibo PDF.");
            e.printStackTrace();
        }
    }
    
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEventoResumen;
    private javax.swing.JTextField txtTarjeta;
    private javax.swing.JTextField txtTotalResumen;
    // End of variables declaration//GEN-END:variables
}
