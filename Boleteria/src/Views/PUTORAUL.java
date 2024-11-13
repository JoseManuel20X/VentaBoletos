
package Views;

import Controller.CRUDHistorial;
import ENTITY.Historial;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Manuel
 */
public class PUTORAUL extends javax.swing.JFrame {

    private String correoCliente;

    public PUTORAUL(String correo) {
        this.correoCliente = correo;
        initComponents();
        cargarHistorialCliente(correo);
    }

    private void cargarHistorialCliente(String correo) {
    DefaultTableModel model = (DefaultTableModel) tbDetail.getModel();
    model.setRowCount(0); // Limpia la tabla antes de cargar los datos
    // Llama al método de búsqueda en CRUDHistorial para obtener el historial según el correo
    CRUDHistorial crudHistorial = new CRUDHistorial();
    List<Historial> historialCompras = crudHistorial.buscarHistorialPorCorreoCliente(correo);

    for (Historial compra : historialCompras) {
        model.addRow(new Object[]{compra.getIdHistorial(), compra.getNombreevent(), compra.getCantidad(), compra.getIdcliente(),compra.getCorreoCliente()});
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetail = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 57, 791, 186));

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbDetail;
    // End of variables declaration//GEN-END:variables
}
