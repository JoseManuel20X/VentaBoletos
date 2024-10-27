
package main;

import Usuario.GUIUsuario;
import Views.GUICliente;
import Views.Loggin;
import Views.GUIEvent;
import Views.TicketSales;
/**
 *
 * @author Manuel
 */
public class Admin extends javax.swing.JFrame {
    
    public Admin() {
        initComponents();
    }

    private void GUIUsuario() {
        GUIUsuario Usu = new GUIUsuario();
        Usu.setVisible(true);
        Usu.setResizable(false);
        Usu.setLocationRelativeTo(null);
    }
    private void TicketSales() {
        TicketSales Usu = new TicketSales();
       Usu.setVisible(true);
        Usu.setResizable(false);
        Usu.setLocationRelativeTo(null);
    }
    private void GUIEvent() {
        GUIEvent Usu = new GUIEvent();
       Usu.setVisible(true);
        Usu.setResizable(false);
        Usu.setLocationRelativeTo(null);
    }
    private void GUIClientes() {
        GUICliente cliente = new GUICliente();
       cliente.setVisible(true);
        cliente.setResizable(false);
        cliente.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnUsuario = new javax.swing.JButton();
        btnEventos = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnCliente1 = new javax.swing.JButton();
        btnTicket = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUsuario.setBackground(new java.awt.Color(153, 153, 153));
        btnUsuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnUsuario.setText("Usuario");
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 117, 37));

        btnEventos.setBackground(new java.awt.Color(102, 102, 102));
        btnEventos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnEventos.setText("Eventos");
        btnEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEventosActionPerformed(evt);
            }
        });
        jPanel1.add(btnEventos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 114, 42));

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 74, 41));

        btnCliente1.setBackground(new java.awt.Color(102, 102, 102));
        btnCliente1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnCliente1.setText("Cliente");
        btnCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliente1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 114, 42));

        btnTicket.setBackground(new java.awt.Color(102, 102, 102));
        btnTicket.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnTicket.setText("Ticket");
        btnTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTicketActionPerformed(evt);
            }
        });
        jPanel1.add(btnTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 114, 42));

        jLabel1.setText("ADMIN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       /** Loggin log = new Loggin();
        log.setVisible(true);
        log.setResizable(false);
        log.setLocationRelativeTo(null);
        dispose();
        */
       System.exit(WIDTH);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEventosActionPerformed
       GUIEvent();
    }//GEN-LAST:event_btnEventosActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        GUIUsuario();
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliente1ActionPerformed
        GUIClientes();
    }//GEN-LAST:event_btnCliente1ActionPerformed

    private void btnTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTicketActionPerformed
        TicketSales();
    }//GEN-LAST:event_btnTicketActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliente1;
    private javax.swing.JButton btnEventos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTicket;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
