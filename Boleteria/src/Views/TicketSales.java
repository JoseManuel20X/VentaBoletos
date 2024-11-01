package Views;

import Controller.BuyTickect;
import Controller.CRUDCliente;
import Controller.EventController;
import Controller.UsuarioCRUD;
import ENTITY.ClaseUsuario;
import ENTITY.Event;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Robert Granados
 */
public class TicketSales extends javax.swing.JFrame {
  private UsuarioCRUD usuarioCrud;
    private DefaultTableModel modelo;
    private EventController gestionEventos;

    public TicketSales() {
        initComponents();

        // Inicialización de CRUDCliente primero y luego UsuarioCRUD
        CRUDCliente clienteCRUD = new CRUDCliente(null); // Pasamos null temporalmente
        this.usuarioCrud = new UsuarioCRUD(clienteCRUD);
        clienteCRUD.setUsuarioCrud(this.usuarioCrud); // Establecemos la referencia en CRUDCliente

        this.gestionEventos = new EventController();

        // Verificar que tbEventosDispo está correctamente inicializado antes de asignar el modelo
        if (tbEventosDispo != null) {
            String[] nombreColumnas = new String[]{"ID", "Nombre", "Fecha"};
            this.modelo = new NonEditableTableModel(nombreColumnas, 0);
            this.tbEventosDispo.setModel(modelo);
        } else {
            System.err.println("Error: tbEventosDispo no está inicializado.");
        }

        // Cargar datos en la tabla
        cargarDatosEnTabla();
    }

    // Clase interna que extiende DefaultTableModel para hacer la tabla no editable
    private class NonEditableTableModel extends DefaultTableModel {
        public NonEditableTableModel(Object[] columnNames, int rowCount) {
            super(columnNames, rowCount);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Las celdas no son editables
        }
    }

    private void buscarEventoSeleccionadoEnTabla() {
        int selectedRow = this.tbEventosDispo.getSelectedRow();  // Obtiene la fila seleccionada en la tabla
        if (selectedRow != -1) {  // Verifica que haya una fila seleccionada
            int idEvento = (int) tbEventosDispo.getValueAt(selectedRow, 0);  // Suponiendo que la primera columna es el ID
            Event evento = gestionEventos.leerEvento(idEvento);  // Busca el evento por ID
            if (evento != null) {
                DETAILS_EVENT detallesEventFrame = new DETAILS_EVENT();
                detallesEventFrame.mostrarDetallesEvento(evento); // Muestra los detalles en el nuevo frame
                detallesEventFrame.setVisible(true); // Muestra la ventana de detalles
                detallesEventFrame.setResizable(false);
                detallesEventFrame.setLocationRelativeTo(null);
            } else {
                // Manejo de error si no se encuentra el evento
                JOptionPane.showMessageDialog(this, "Evento no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Método para cargar los datos en la tabla sin el campo ID
    private void cargarDatosEnTabla() {
        List<Event> eventos = gestionEventos.leerEventos();
        System.out.println("Eventos en GUI: " + eventos);
        
        if (eventos != null && !eventos.isEmpty()) {
            for (Event evento : eventos) {
                Object[] fila = new Object[]{
                    evento.getId(),
                    evento.getName(),
                    evento.getDate(),
                    evento.getEnclosure(),
                    evento.getPrice(),
                    evento.getNumberTickets(),
                    evento.getDescription()
                };
                modelo.addRow(fila);
            }
        }
    }

    private void actualizarTabla() {
        this.modelo.setRowCount(0);
        List<Event> eventos = this.gestionEventos.leerEventos();

        if (eventos != null) {
            for (Event evento : eventos) {
                this.modelo.addRow(new Object[]{
                    evento.getId(),
                    evento.getName(),
                    evento.getDate(),
                    evento.getEnclosure(),
                    evento.getPrice(),
                    evento.getNumberTickets(),
                    evento.getDescription()
                });
            }
        } 
    }

    // Método para agregar un nuevo evento a la tabla
    private void agregarEvento(Event nuevoEvento) {
        gestionEventos.crearEvento(nuevoEvento);
        Object[] fila = new Object[]{
            nuevoEvento.getId(),
            nuevoEvento.getName(),
            nuevoEvento.getDate(),
            nuevoEvento.getEnclosure(),
            nuevoEvento.getPrice(),
            nuevoEvento.getNumberTickets(),
            nuevoEvento.getDescription()
        };
        modelo.addRow(fila);
    }

    private void buscarEventoSeleccionadoEnTablaParaComprar() {
        int selectedRow = this.tbEventosDispo.getSelectedRow();
        if (selectedRow != -1) {
            int idEvento = (int) tbEventosDispo.getValueAt(selectedRow, 0);
            Event evento = gestionEventos.leerEvento(idEvento);

            if (evento != null) {
                ClaseUsuario usuarioActual = usuarioCrud.obtenerUsuarioActual(); // Obtiene el usuario actual
                BuyTickects buyTickects = new BuyTickects(evento, usuarioActual, new BuyTickect(gestionEventos));
                buyTickects.setVisible(true);
                buyTickects.setResizable(false);
                buyTickects.setLocationRelativeTo(null);
            } else {
                JOptionPane.showMessageDialog(this, "Evento no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Eventos Disponibles");

        btnSalir.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Buscar por");

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Fecha:");

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Evento:");

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Recinto:");

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

        btnDetalles.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnDetalles.setForeground(new java.awt.Color(0, 0, 0));
        btnDetalles.setText("Ver  Detalles");
        btnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesActionPerformed(evt);
            }
        });

        btnIniciarSeción.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnIniciarSeción.setForeground(new java.awt.Color(0, 0, 0));
        btnIniciarSeción.setText("Iniciar Seción");
        btnIniciarSeción.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSeciónActionPerformed(evt);
            }
        });

        btnRegistrarse.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnRegistrarse.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });

        btnComprar.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnComprar.setForeground(new java.awt.Color(0, 0, 0));
        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRecinto, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnDetalles)
                .addGap(32, 32, 32)
                .addComponent(btnIniciarSeción)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnComprar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtRecinto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnDetalles)
                    .addComponent(btnIniciarSeción)
                    .addComponent(btnRegistrarse)
                    .addComponent(btnComprar))
                .addGap(29, 29, 29))
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
        CRUDCliente crudcliente = new CRUDCliente(usuarioCrud);
        Registro registro = new Registro(crudcliente);
        registro.setVisible(true);
        registro.setResizable(false);
        registro.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        buscarEventoSeleccionadoEnTablaParaComprar();
    }//GEN-LAST:event_btnComprarActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnDetalles;
    private javax.swing.JButton btnIniciarSeción;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbEventosDispo;
    private javax.swing.JTextField txtEvento;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtRecinto;
    // End of variables declaration//GEN-END:variables
}
