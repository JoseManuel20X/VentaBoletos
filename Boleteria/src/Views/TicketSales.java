package Views;

import Controller.BuyTicketFacade;
import Controller.CRUDCliente;
import Controller.EventController;
import Controller.UsuarioCRUD;
import ENTITY.ClaseUsuario;
import ENTITY.Event;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class TicketSales extends javax.swing.JFrame {
    private TableRowSorter<DefaultTableModel> trs;
    private DefaultTableModel modelo;
    private BuyTicketFacade buyTicketFacade;
    private ClaseUsuario usuarioActual;
    private EventController gestionEventos;

    public TicketSales() {
        initComponents();
        inicializarControladores();
        inicializarTabla();
        cargarDatosEnTabla();
    }

    private void inicializarControladores() {
        CRUDCliente clienteCRUD = new CRUDCliente();
        UsuarioCRUD usuarioCrud = new UsuarioCRUD(clienteCRUD);
        clienteCRUD.setUsuarioCrud(usuarioCrud);

        gestionEventos = new EventController();
        this.buyTicketFacade = new BuyTicketFacade(gestionEventos);
        this.usuarioActual = usuarioCrud.obtenerUsuarioActual();
    }

    private void inicializarTabla() {
        if (tbEventosDispo != null) {
            String[] nombreColumnas = {"ID", "Nombre", "Fecha", "Recinto"};
            this.modelo = new NonEditableTableModel(nombreColumnas, 0);
            this.tbEventosDispo.setModel(modelo);
        } else {
            JOptionPane.showMessageDialog(this, "Error: tbEventosDispo no está inicializado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private class NonEditableTableModel extends DefaultTableModel {
        public NonEditableTableModel(Object[] columnNames, int rowCount) {
            super(columnNames, rowCount);
        }
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    private void buscarEventoSeleccionadoEnTabla() {
        int selectedRow = this.tbEventosDispo.getSelectedRow();
        if (selectedRow != -1) {
            int idEvento = (int) tbEventosDispo.getValueAt(selectedRow, 0);
            Event evento = gestionEventos.leerEvento(idEvento);
            if (evento != null) {
                DETAILS_EVENT detallesEventFrame = new DETAILS_EVENT();
                detallesEventFrame.mostrarDetallesEvento(evento);
                detallesEventFrame.setVisible(true);
                detallesEventFrame.setResizable(false);
                detallesEventFrame.setLocationRelativeTo(null);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Evento no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void cargarDatosEnTabla() {
        List<Event> eventos = buyTicketFacade.obtenerEventosDisponibles();
        if (eventos != null && !eventos.isEmpty()) {
            for (Event evento : eventos) {
                Object[] fila = {
                    evento.getId(),
                    evento.getName(),
                    evento.getDate(),
                    evento.getEnclosure()
                };
                modelo.addRow(fila);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay eventos disponibles.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEvento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtRecinto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEventosDispo = new javax.swing.JTable();
        btnDetalles = new javax.swing.JButton();
        btnIniciarSeción = new javax.swing.JButton();
        btnRegistrarse = new javax.swing.JButton();
        btnComprar = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Eventos Disponibles");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 0, -1, 40));

        btnSalir.setBackground(new java.awt.Color(255, 0, 51));
        btnSalir.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(687, 404, -1, 25));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar por");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 69, -1, -1));

        txtFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaKeyTyped(evt);
            }
        });
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 70, 104, -1));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 69, -1, -1));

        txtEvento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEventoKeyTyped(evt);
            }
        });
        jPanel1.add(txtEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 70, 104, -1));

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Evento:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 69, -1, -1));

        txtRecinto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRecintoKeyTyped(evt);
            }
        });
        jPanel1.add(txtRecinto, new org.netbeans.lib.awtextra.AbsoluteConstraints(669, 70, 104, -1));

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Recinto:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 69, -1, -1));

        tbEventosDispo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbEventosDispo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 139, 767, 246));

        btnDetalles.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnDetalles.setText("Ver  Detalles");
        btnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesActionPerformed(evt);
            }
        });
        jPanel1.add(btnDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 406, -1, -1));

        btnIniciarSeción.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnIniciarSeción.setText("Iniciar Sesión");
        btnIniciarSeción.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSeciónActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciarSeción, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 406, -1, -1));

        btnRegistrarse.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 406, -1, -1));

        btnComprar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });
        jPanel1.add(btnComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 406, -1, -1));

        btnHistorial.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnHistorial.setText("Ver mi Lista de Compras");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });
        jPanel1.add(btnHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 403, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fondo Principal.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 460));

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

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(WIDTH);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesActionPerformed
        buscarEventoSeleccionadoEnTabla();
        
        
    }//GEN-LAST:event_btnDetallesActionPerformed

    private void btnIniciarSeciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSeciónActionPerformed
         Loggin log = new Loggin();
        log.setVisible(true);
        log.setResizable(false);
        log.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnIniciarSeciónActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        CRUDCliente crudCliente = new CRUDCliente();
        Registro registro = new Registro(crudCliente);
        registro.setVisible(true);
        registro.setResizable(false);
        registro.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        if (!Loggin.usuarioAutenticado) {
        JOptionPane.showMessageDialog(this, "Debes iniciar sesión para poder comprar boletos.");
        return;
    }

    int selectedRow = tbEventosDispo.getSelectedRow();
    if (selectedRow != -1) {
        // Obtener el ID del evento seleccionado en la tabla
        int idEvento = (int) tbEventosDispo.getValueAt(selectedRow, 0);
        Event evento = gestionEventos.leerEvento(idEvento);

        if (evento != null) {
            // Abrir la ventana de compra de tickets
            BuyTickects buyTickectsFrame = new BuyTickects(evento, usuarioActual, buyTicketFacade);
            buyTickectsFrame.setVisible(true);
            buyTickectsFrame.setResizable(false);
            buyTickectsFrame.setLocationRelativeTo(this);
        } else {
            JOptionPane.showMessageDialog(this, "Evento no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un evento para comprar boletos.");
    }
    }//GEN-LAST:event_btnComprarActionPerformed

    private void txtEventoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEventoKeyTyped
        txtEvento.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtEvento.getText(), 1));
            } 
        });
        
        trs = new TableRowSorter(modelo);
        tbEventosDispo.setRowSorter(trs);
    }//GEN-LAST:event_txtEventoKeyTyped

    private void txtFechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyTyped
        txtFecha.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtFecha.getText(), 2));
            } 
        });
        
        trs = new TableRowSorter(modelo);
        tbEventosDispo.setRowSorter(trs);
    }//GEN-LAST:event_txtFechaKeyTyped

    private void txtRecintoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecintoKeyTyped
        txtRecinto.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtRecinto.getText(), 3));
            } 
        });
        
        trs = new TableRowSorter(modelo);
        tbEventosDispo.setRowSorter(trs);
    }//GEN-LAST:event_txtRecintoKeyTyped

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
      if (usuarioActual != null && buyTicketFacade != null) {
            ViewPurchaseHistory historialCompraFrame = new ViewPurchaseHistory(buyTicketFacade, usuarioActual);
            historialCompraFrame.setVisible(true);
            historialCompraFrame.setResizable(false);
            historialCompraFrame.setLocationRelativeTo(this);
        } else {
            JOptionPane.showMessageDialog(this, "Error: usuario o controlador no inicializado.");
        }
    
    }//GEN-LAST:event_btnHistorialActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnDetalles;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnIniciarSeción;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbEventosDispo;
    private javax.swing.JTextField txtEvento;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtRecinto;
    // End of variables declaration//GEN-END:variables
}
