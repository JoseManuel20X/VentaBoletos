
package Views;
import Controller.BuyTicketFacade;
import ENTITY.ClaseUsuario;
import ENTITY.Tickect;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
/**
 *
 * @author Manuel
 */
public class ViewPurchaseHistory extends javax.swing.JFrame {
      private BuyTicketFacade buyTicketController; // Controlador de compras
    private ClaseUsuario usuarioActual; // Usuario actual

    public ViewPurchaseHistory(BuyTicketFacade buyTicketController, ClaseUsuario usuarioActual) {
        this.buyTicketController = buyTicketController;
        this.usuarioActual = usuarioActual;

        initComponents();  // Llama al initComponents() generado automáticamente
        cargarHistorialCompras();  // Cargar el historial de compras al abrir la ventana
    }

 private void cargarHistorialCompras() {
    DefaultTableModel modeloTabla = (DefaultTableModel) tbDetail.getModel();
    modeloTabla.setRowCount(0); // Limpiar datos previos

    if (buyTicketController != null) {
        // Obtener historial de compras del usuario actual
        List<Tickect> historialCompras = buyTicketController.verHistorialCompras(usuarioActual);

        if (historialCompras != null && !historialCompras.isEmpty()) {
            for (Tickect tique : historialCompras) {
                Object[] fila = new Object[]{
                    tique.getEvento().getId(),
                    tique.getEvento().getName(),
                    tique.getEvento().getDate(),
                    tique.getCantidad(),
                    tique.getEvento().getPrice() * tique.getCantidad()
                };
                modeloTabla.addRow(fila);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay historial de compras para este usuario.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    } else {
        System.out.println("Error: El controlador de compra (buyTicketController) es nulo.");
        JOptionPane.showMessageDialog(this, "No se puede cargar el historial de compras. El controlador es nulo.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetail = new javax.swing.JTable();
        btnsalir = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbDetail);

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsalir;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbDetail;
    // End of variables declaration//GEN-END:variables
}
