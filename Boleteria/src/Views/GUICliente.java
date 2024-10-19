package Views;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import Cliente.CRUDCliente;
import Cliente.CRUDCliente;
import Models.Cliente;
import Models.Cliente;
import Views.EditarCliente;
import Views.Registro;
import Usuario.UsuarioCRUD;
import java.awt.event.KeyAdapter;// Importa la clase KeyAdapter, que es un adaptador abstracto para recibir eventos de teclado. 
import java.awt.event.KeyEvent;// Importa la clase KeyEvent, que encapsula información sobre un evento de teclado.
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.table.TableRowSorter;// Importa la clase TableRowSorter, que se utiliza para ordenar y filtrar las filas de una JTable. 

public class GUICliente extends javax.swing.JFrame {
    TableRowSorter trs;
    private DefaultTableModel tableModel;
    private CRUDCliente clienteCRUD;
    private Cliente cliente;
    private UsuarioCRUD usuarioCrud;

    public GUICliente() {
        initComponents();
        this.clienteCRUD = new CRUDCliente(usuarioCrud); 
        initTable(); 
        actualizarTabla();  
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    
    private void initTable() {
    tableModel = new DefaultTableModel(
        new Object[][]{}, 
        new String[]{
            "ID", "Nombre", "Correo", "Contraseña"
        }
    );
    jTable1.setModel(tableModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        lblClientes = new javax.swing.JLabel();
        lblBusqueda = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, -1, -1));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, -1, -1));

        lblClientes.setForeground(new java.awt.Color(255, 255, 255));
        lblClientes.setText("Clientes");
        jPanel1.add(lblClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        lblBusqueda.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        lblBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        lblBusqueda.setText("Búsqueda Filtrada");
        jPanel1.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyTyped(evt);
            }
        });
        jPanel1.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 339, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 840, 160));

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, 67, 38));

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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
     CRUDCliente crudcliente = new CRUDCliente(usuarioCrud);
        Registro registro = new Registro(crudcliente);
        registro.setVisible(true);
        registro.setResizable(false);
        registro.setLocationRelativeTo(null);
       this.actualizarTabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
      this.eliminarCliente();
      this.actualizarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.editarCliente();
        this.actualizarTabla();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped
       txtBusqueda.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBusqueda.getText(), 2));
            } 
        });
        
        trs = new TableRowSorter(tableModel);
        jTable1.setRowSorter(trs);
    }//GEN-LAST:event_txtBusquedaKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void actualizarTabla() {
        tableModel.setRowCount(0); 
        List<Cliente> clientes = clienteCRUD.leerClientes();
        for (Cliente cliente : clientes) {
            tableModel.addRow(new Object[]{
                 cliente.getId(), cliente.getNombre(),
                 cliente.getCorreo(), cliente.getContraseña()
            });
        }
    }
    
    private void eliminarCliente() {
    int selectedRow = this.jTable1.getSelectedRow();
    if (selectedRow != -1) { 
        int id = (int) tableModel.getValueAt(selectedRow, 0);
        clienteCRUD.eliminarCliente(id, true);
        tableModel.removeRow(selectedRow);
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un cliente para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void agregarCliente(Cliente cliente) {
    clienteCRUD.crearCliente(cliente);
    Object[] fila = new Object[]{
        cliente.getId(), cliente.getNombre(),
                 cliente.getCorreo(), cliente.getContraseña()
        };
    tableModel.addRow(fila);
    }

    private void editarCliente() {
        int filaSeleccionada = this.jTable1.getSelectedRow();
        if (filaSeleccionada != -1) { 
            int id = (int) this.jTable1.getValueAt(filaSeleccionada, 0);
            Cliente cliente = clienteCRUD.leerCliente(id);
            if (cliente != null) { 
                EditarCliente dialog = new EditarCliente(this, true, cliente, clienteCRUD);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el usuario seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblClientes;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
